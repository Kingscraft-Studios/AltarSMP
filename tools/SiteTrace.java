import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * SiteTrace <jarOrDir> <classSuffix> <methodName> <concatIndex>
 * Dumps the instructions feeding the Nth makeConcatWithConstants in a method,
 * with constant-pool resolution for the string decoder calls.
 */
public class SiteTrace {
    public static void main(String[] a) throws Exception {
        List<byte[]> cs = new ArrayList<>();
        List<String> nm = new ArrayList<>();
        File root = new File(a[0]);
        if (root.isFile()) {
            try (java.util.zip.ZipFile z = new java.util.zip.ZipFile(root)) {
                List<String> es = new ArrayList<>();
                for (java.util.Enumeration<? extends java.util.zip.ZipEntry> e = z.entries(); e.hasMoreElements(); )
                    es.add(e.nextElement().getName());
                Collections.sort(es);
                for (String e : es) {
                    if (!e.endsWith(".class")) continue;
                    try (InputStream is = z.getInputStream(z.getEntry(e))) {
                        cs.add(is.readAllBytes());
                    }
                    nm.add(e.replace(".class", "").replace('/', '.'));
                }
            }
        } else {
            List<File> fs = new ArrayList<>();
            collect(root, fs);
            fs.sort(Comparator.comparing(File::getPath));
            for (File f : fs) {
                if (!f.getName().endsWith(".class")) continue;
                cs.add(Files.readAllBytes(f.toPath()));
                String rel = root.toURI().relativize(f.toURI()).getPath();
                nm.add(rel.replace(".class", "").replace('/', '.'));
            }
        }
        for (int ci = 0; ci < cs.size(); ci++) {
            if (!nm.get(ci).endsWith(a[1])) continue;
            ClassNode cn = new ClassNode();
            new ClassReader(cs.get(ci)).accept(cn, 0);
            for (MethodNode m : cn.methods) {
                if (!m.name.equals(a[2]) || m.instructions == null) continue;
                int seen = 0;
                for (AbstractInsnNode in = m.instructions.getFirst(); in != null; in = in.getNext()) {
                    if (in.getOpcode() != Opcodes.INVOKEDYNAMIC) continue;
                    InvokeDynamicInsnNode indy = (InvokeDynamicInsnNode) in;
                    if (indy.bsm == null || !"makeConcatWithConstants".equals(indy.bsm.getName())) continue;
                    if (seen++ != Integer.parseInt(a[3])) continue;
                    System.out.println("=== " + nm.get(ci) + "." + m.name + m.desc + "  concat#" + a[3] + " ===");
                    System.out.println("recipe: " + esc(String.valueOf(indy.bsmArgs[0])));
                    System.out.println("argtypes: " + indy.desc);
                    // print the 140 instructions before the indy
                    List<AbstractInsnNode> win = new ArrayList<>();
                    for (AbstractInsnNode p = in.getPrevious(); p != null && win.size() < 200; p = p.getPrevious())
                        if (p.getOpcode() >= 0) win.add(0, p);
                    for (AbstractInsnNode p : win) System.out.println("   " + txt(p));
                    System.out.println(">> " + txt(in));
                }
            }
        }
    }
    static String esc(String v) { return v.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t"); }
    static String txt(AbstractInsnNode in) {
        int op = in.getOpcode();
        StringBuilder sb = new StringBuilder(String.format("%4d %-14s", in.getOpcode(), names[op]));
        if (in instanceof IntInsnNode) sb.append(' ').append(((IntInsnNode) in).operand);
        else if (in instanceof VarInsnNode) sb.append(' ').append(((VarInsnNode) in).var);
        else if (in instanceof LdcInsnNode) {
            Object c = ((LdcInsnNode) in).cst;
            sb.append(' ').append(c instanceof String ? "\"" + esc((String) c).substring(0, Math.min(40, esc((String) c).length())) + "\"" : c);
        } else if (in instanceof MethodInsnNode) {
            MethodInsnNode mi = (MethodInsnNode) in;
            sb.append(' ').append(si(mi.owner)).append('.').append(mi.name).append(mi.desc);
        } else if (in instanceof FieldInsnNode) {
            FieldInsnNode fi = (FieldInsnNode) in;
            sb.append(' ').append(si(fi.owner)).append('.').append(fi.name);
        } else if (in instanceof TypeInsnNode) sb.append(' ').append(si(((TypeInsnNode) in).desc));
        else if (in instanceof InvokeDynamicInsnNode) {
            InvokeDynamicInsnNode id = (InvokeDynamicInsnNode) in;
            sb.append(' ').append(id.name).append(id.desc).append(" bsm=").append(id.bsm == null ? "?" : id.bsm.getName());
        } else if (in instanceof JumpInsnNode) sb.append(" -> ").append(((JumpInsnNode) in).label);
        return sb.toString();
    }
    static String si(String s) { return s.substring(s.lastIndexOf('/') + 1); }
    static void collect(File d, List<File> out) {
        File[] c = d.listFiles();
        if (c == null) return;
        for (File f : c) { if (f.isDirectory()) collect(f, out); else out.add(f); }
    }
    static final String[] names = new String[256];
    static {
        String[][] t = {
            {"0","NOP"},{"1","ACONST_NULL"},{"2","ICONST_M1"},{"3","ICONST_0"},{"4","ICONST_1"},{"5","ICONST_2"},
            {"6","ICONST_3"},{"7","ICONST_4"},{"8","ICONST_5"},{"9","LCONST_0"},{"10","LCONST_1"},{"11","FCONST_0"},
            {"12","FCONST_1"},{"13","FCONST_2"},{"14","DCONST_0"},{"15","DCONST_1"},{"16","BIPUSH"},{"17","SIPUSH"},
            {"18","LDC"},{"19","LDC_W"},{"20","LDC2_W"},{"21","ILOAD"},{"22","LLOAD"},{"23","FLOAD"},{"24","DLOAD"},
            {"25","ALOAD"},{"46","IALOAD"},{"47","LALOAD"},{"48","FALOAD"},{"49","DALOAD"},{"50","AALOAD"},{"51","BALOAD"},
            {"52","CALOAD"},{"53","SALOAD"},{"54","ISTORE"},{"55","LSTORE"},{"56","FSTORE"},{"57","DSTORE"},{"58","ASTORE"},
            {"79","IASTORE"},{"80","LASTORE"},{"81","FASTORE"},{"82","DASTORE"},{"83","AASTORE"},{"84","BASTORE"},{"85","CASTORE"},
            {"86","SASTORE"},{"87","POP"},{"88","POP2"},{"89","DUP"},{"90","DUP_X1"},{"91","DUP_X2"},{"92","DUP2"},
            {"93","DUP2_X1"},{"94","DUP2_X2"},{"95","SWAP"},{"96","IADD"},{"97","LADD"},{"98","FADD"},{"99","DADD"},
            {"100","ISUB"},{"101","LSUB"},{"102","FSUB"},{"103","DSUB"},{"104","IMUL"},{"105","LMUL"},{"106","FMUL"},
            {"107","DMUL"},{"108","IDIV"},{"109","LDIV"},{"110","FDIV"},{"111","DDIV"},{"112","IREM"},{"113","LREM"},
            {"114","FREM"},{"115","DREM"},{"116","INEG"},{"117","LNEG"},{"118","FNEG"},{"119","DNEG"},{"120","ISHL"},
            {"121","LSHL"},{"122","ISHR"},{"123","LSHR"},{"124","IUSHR"},{"125","LUSHR"},{"126","IAND"},{"127","LAND"},
            {"128","IOR"},{"129","LOR"},{"130","IXOR"},{"131","LXOR"},{"132","IINC"},{"133","I2L"},{"134","I2F"},{"135","I2D"},
            {"136","L2I"},{"137","L2F"},{"138","L2D"},{"139","F2I"},{"140","F2L"},{"141","F2D"},{"142","D2I"},{"143","D2L"},
            {"144","D2F"},{"145","I2B"},{"146","I2C"},{"147","I2S"},{"148","LCMP"},{"149","FCMPL"},{"150","FCMPG"},
            {"151","DCMPL"},{"152","DCMPG"},{"153","IFEQ"},{"154","IFNE"},{"155","IFLT"},{"156","IFGE"},{"157","IFGT"},
            {"158","IFLE"},{"159","IF_ICMPEQ"},{"160","IF_ICMPNE"},{"161","IF_ICMPLT"},{"162","IF_ICMPGE"},
            {"163","IF_ICMPGT"},{"164","IF_ICMPLE"},{"165","IF_ACMPEQ"},{"166","IF_ACMPNE"},{"167","GOTO"},
            {"168","JSR"},{"169","RET"},{"170","TABLESWITCH"},{"171","LOOKUPSWITCH"},{"172","IRETURN"},{"173","LRETURN"},
            {"174","FRETURN"},{"175","DRETURN"},{"176","ARETURN"},{"177","RETURN"},{"178","GETSTATIC"},{"179","PUTSTATIC"},
            {"180","GETFIELD"},{"181","PUTFIELD"},{"182","INVOKEVIRTUAL"},{"183","INVOKESPECIAL"},{"184","INVOKESTATIC"},
            {"185","INVOKEINTERFACE"},{"186","INVOKEDYNAMIC"},{"187","NEW"},{"188","NEWARRAY"},{"189","ANEWARRAY"},
            {"190","ARRAYLENGTH"},{"191","ATHROW"},{"192","CHECKCAST"},{"193","INSTANCEOF"},{"194","MONITORENTER"},
            {"195","MONITOREXIT"},{"196","WIDE"},{"197","MULTIANEWARRAY"},{"198","IFNULL"},{"199","IFNONNULL"},
            {"200","GOTO_W"},{"201","JSR_W"}
        };
        for (String[] x : t) names[Integer.parseInt(x[0])] = x[1];
    }
}
