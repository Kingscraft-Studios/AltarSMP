import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.io.*;
import java.util.*;
import java.util.jar.*;

/** Scans every class in the jar for invokestatic <decoder>(II)Ljava/lang/String; and reports
 *  the two constant arguments two ways so they can be cross-validated:
 *    SIM  = via int stack simulation (pops `this` for invokevirtual/special/interface)
 *    IMM  = via the two immediately-preceding constant pushes (how the obfuscator emits them)
 *  Only sites where both agree are reported as resolved. */
public class ScanCalls {
    public static void main(String[] args) throws Exception {
        String jarPath = args[0];
        String decName = args[1];
        String decDesc = args[2];
        try (JarFile jar = new JarFile(jarPath)) {
            List<JarEntry> entries = new ArrayList<>();
            for (Enumeration<JarEntry> es = jar.entries(); es.hasMoreElements(); )
                entries.add(es.nextElement());
            entries.sort(Comparator.comparing(JarEntry::getName));
            for (JarEntry e : entries) {
                if (e.isDirectory() || !e.getName().endsWith(".class")) continue;
                byte[] b;
                try (InputStream in = jar.getInputStream(e)) {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[65536];
                    int n;
                    while ((n = in.read(buf)) > 0) bos.write(buf, 0, n);
                    b = bos.toByteArray();
                }
                ClassNode cn = new ClassNode();
                try { new ClassReader(b).accept(cn, 0); } catch (Throwable t) { continue; }
                String owner = e.getName().replace(".class", "").replace('/', '.');
                for (MethodNode m : cn.methods) {
                    if (m.instructions == null) continue;
                    // real (non-label/line/frame) instruction list
                    List<AbstractInsnNode> insns = new ArrayList<>();
                    for (AbstractInsnNode in = m.instructions.getFirst(); in != null; in = in.getNext())
                        if (in.getOpcode() >= 0) insns.add(in);

                    List<Integer> st = new ArrayList<>();
                    Map<AbstractInsnNode, int[]> sim = new HashMap<>();
                    for (int k = 0; k < insns.size(); k++) {
                        AbstractInsnNode in = insns.get(k);
                        int op = in.getOpcode();
                        boolean pushedRef = false;
                        if (op == Opcodes.SIPUSH || op == Opcodes.BIPUSH) st.add(((IntInsnNode) in).operand);
                        else if (op == Opcodes.ICONST_M1) st.add(-1);
                        else if (op >= Opcodes.ICONST_0 && op <= Opcodes.ICONST_5) st.add(op - Opcodes.ICONST_0);
                        else if (op == Opcodes.LDC) {
                            Object c = ((LdcInsnNode) in).cst;
                            if (c instanceof Integer) st.add((Integer) c);
                            else if (c instanceof Long) st.add((int) (long) (Long) c);
                            else { st.add(null); pushedRef = true; }
                        } else if (op == Opcodes.LCONST_0) { st.add((int) 0L); }
                        else if (op == Opcodes.LCONST_1) { st.add((int) 1L); }
                        else if (op >= Opcodes.FCONST_0 && op <= Opcodes.FCONST_2) { st.add(null); }
                        else if (op == Opcodes.DCONST_0) { st.add((int) 0.0d); }
                        else if (op == Opcodes.DCONST_1) { st.add((int) 1.0d); }
                        else if (op >= Opcodes.ILOAD && op <= Opcodes.ALOAD) st.add(null);
                        else if (op >= Opcodes.ISTORE && op <= Opcodes.ASTORE) { if (!st.isEmpty()) st.remove(st.size()-1); }
                        else if (op == Opcodes.POP) { if (!st.isEmpty()) st.remove(st.size()-1); }
                        else if (op == Opcodes.POP2) { if (!st.isEmpty()) st.remove(st.size()-1); }
                        else if (op == Opcodes.DUP) { if (!st.isEmpty()) st.add(st.get(st.size()-1)); }
                        else if (op == Opcodes.DUP_X1) { st.add(null); }
                        else if (op == Opcodes.DUP2 || op == Opcodes.DUP2_X1 || op == Opcodes.SWAP) { st.add(null); }
                        else if (op >= Opcodes.IADD && op <= Opcodes.DREM) {
                            if (!st.isEmpty()) st.remove(st.size()-1);
                            if (!st.isEmpty()) st.remove(st.size()-1);
                            st.add(null);
                        } else if (op == Opcodes.INEG || op == Opcodes.I2L || op == Opcodes.I2F
                                || op == Opcodes.I2D || op == Opcodes.L2I || op == Opcodes.F2I
                                || op == Opcodes.D2I || op == Opcodes.I2B || op == Opcodes.I2C
                                || op == Opcodes.I2S || op == Opcodes.ARRAYLENGTH
                                || op == Opcodes.FCMPL || op == Opcodes.FCMPG || op == Opcodes.DCMPL
                                || op == Opcodes.DCMPG) { st.add(null); }
                        else if (op == Opcodes.NEW || op == Opcodes.NEWARRAY || op == Opcodes.ANEWARRAY) { st.add(null); }
                        else if (op >= Opcodes.IALOAD && op <= Opcodes.SALOAD) {
                            if (!st.isEmpty()) st.remove(st.size()-1);
                            if (!st.isEmpty()) st.remove(st.size()-1);
                            st.add(null);
                        } else if (op >= Opcodes.IASTORE && op <= Opcodes.SASTORE) {
                            for (int i = 0; i < 3; i++) if (!st.isEmpty()) st.remove(st.size()-1);
                        } else if (op == Opcodes.PUTSTATIC || op == Opcodes.PUTFIELD) {
                            int np = (op == Opcodes.PUTFIELD ? 2 : 1) + Type.getType(
                                    ((FieldInsnNode) in).desc).getSize();
                            for (int i = 0; i < np; i++) if (!st.isEmpty()) st.remove(st.size()-1);
                        } else if (op == Opcodes.GETSTATIC) {
                            int np = Type.getType(((FieldInsnNode) in).desc).getSize();
                            for (int i = 0; i < np; i++) st.add(null);
                        } else if (op == Opcodes.GETFIELD) {
                            if (!st.isEmpty()) st.remove(st.size()-1);
                            st.add(null);
                        } else if (op == Opcodes.INVOKESTATIC) {
                            MethodInsnNode mi = (MethodInsnNode) in;
                            int na = Type.getArgumentTypes(mi.desc).length;
                            int nr = Type.getReturnType(mi.desc).getSize();
                            boolean isDec = mi.name.equals(decName) && mi.desc.equals(decDesc);
                            if (isDec && na == 2) {
                                Integer a2 = null, a1 = null;
                                if (st.size() >= 2) {
                                    a2 = st.remove(st.size()-1);
                                    a1 = st.remove(st.size()-1);
                                }
                                for (int i = 0; i < nr; i++) st.add(null);
                                // IMM: two immediately-preceding constant pushes
                                Integer i1 = null, i2 = null;
                                AbstractInsnNode p1 = k >= 1 ? insns.get(k-1) : null;
                                AbstractInsnNode p2 = k >= 2 ? insns.get(k-2) : null;
                                Integer v1 = constOf(p1), v2 = constOf(p2);
                                if (p1 != null && p2 != null && v1 != null && v2 != null) {
                                    // p2 (earlier) is arg1, p1 (later) is arg2
                                    i1 = v2; i2 = v1;
                                }
                                String s1 = a1 == null ? "?" : a1.toString();
                                String s2 = a2 == null ? "?" : a2.toString();
                                String t1 = i1 == null ? "?" : i1.toString();
                                String t2 = i2 == null ? "?" : i2.toString();
                                System.out.println(String.join("\t", owner, m.name, m.desc,
                                        s1, s2, t1, t2, simAgree(a1,a2,i1,i2) ? "AGREE" : "CONFLICT"));
                                continue;
                            }
                            for (int i = 0; i < na; i++) if (!st.isEmpty()) st.remove(st.size()-1);
                            for (int i = 0; i < nr; i++) st.add(null);
                        } else if (op == Opcodes.INVOKEVIRTUAL || op == Opcodes.INVOKESPECIAL
                                || op == Opcodes.INVOKEINTERFACE) {
                            MethodInsnNode mi = (MethodInsnNode) in;
                            int na = Type.getArgumentTypes(mi.desc).length;
                            int nr = Type.getReturnType(mi.desc).getSize();
                            for (int i = 0; i < na + 1; i++) if (!st.isEmpty()) st.remove(st.size()-1);
                            for (int i = 0; i < nr; i++) st.add(null);
                        } else if (op >= Opcodes.IRETURN && op <= Opcodes.RETURN) st.clear();
                        else if (op == Opcodes.NOP || op == Opcodes.CHECKCAST || op == Opcodes.MONITORENTER
                                || op == Opcodes.MONITOREXIT || op == Opcodes.GOTO
                                || (op >= Opcodes.IFEQ && op <= Opcodes.IF_ACMPNE)) { /* no stack change */ }
                    }
                }
            }
        }
    }

    static boolean simAgree(Integer a1, Integer a2, Integer i1, Integer i2) {
        if (i1 == null || i2 == null) return false;
        if (a1 == null || a2 == null) return false;
        return a1.equals(i1) && a2.equals(i2);
    }

    static Integer constOf(AbstractInsnNode in) {
        if (in == null) return null;
        int op = in.getOpcode();
        if (op == Opcodes.SIPUSH || op == Opcodes.BIPUSH) return ((IntInsnNode) in).operand;
        if (op == Opcodes.ICONST_M1) return -1;
        if (op >= Opcodes.ICONST_0 && op <= Opcodes.ICONST_5) return op - Opcodes.ICONST_0;
        if (op == Opcodes.LDC) {
            Object c = ((LdcInsnNode) in).cst;
            if (c instanceof Integer) return (Integer) c;
        }
        return null;
    }
}
