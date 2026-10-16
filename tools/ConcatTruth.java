import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.io.*;
import java.util.*;
import java.util.jar.*;

/**
 * For every makeConcatWithConstants site, emit:
 *   class \t method \t ordinal \t line \t recipe \t args
 * where `args` are rendered as best-effort Java expressions.
 * Run with --orig <jar> and/or --new <classesDir>.
 * The recompiled classes carry a LineNumberTable, so `line` maps a site back to a
 * source line; the original's is stripped, so its line is -1.
 */
public class ConcatTruth {
    static Map<String, List<String[]>> DEC = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // args[0] = decoded TSV (class, method, desc, arg1, arg2, string) -- may be "-"
        if (args.length > 0 && !args[0].startsWith("--")) {
            try (BufferedReader r = new BufferedReader(new FileReader(args[0]))) {
                String l;
                while ((l = r.readLine()) != null) {
                    String[] p = l.split("\t", -1);
                    if (p.length >= 6) DEC.computeIfAbsent(p[0] + "::" + p[1] + "::" + p[2],
                            k -> new ArrayList<>()).add(p);
                }
            }
            args = Arrays.copyOfRange(args, 1, args.length);
        }
        boolean any = false;
        for (int i = 0; i + 1 < args.length; i += 2) {
            if (args[i].equals("--orig")) { System.out.println("#ORIG"); emit(args[i + 1], true); any = true; }
            if (args[i].equals("--new"))  { System.out.println("#NEW");  emit(args[i + 1], false); any = true; }
        }
        if (!any) System.err.println("usage: --orig <jar> [--new <dir>]");
    }

    static void emit(String path, boolean isJar) throws Exception {
        List<byte[]> classes = new ArrayList<>();
        List<String> names = new ArrayList<>();
        if (isJar) {
            try (JarFile jar = new JarFile(path)) {
                List<JarEntry> es = new ArrayList<>();
                for (Enumeration<JarEntry> e = jar.entries(); e.hasMoreElements(); ) es.add(e.nextElement());
                es.sort(Comparator.comparing(JarEntry::getName));
                for (JarEntry e : es) {
                    if (e.isDirectory() || !e.getName().endsWith(".class")) continue;
                    try (InputStream in = jar.getInputStream(e)) {
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        byte[] buf = new byte[65536];
                        int n;
                        while ((n = in.read(buf)) > 0) bos.write(buf, 0, n);
                        classes.add(bos.toByteArray());
                        names.add(e.getName().replace(".class", "").replace('/', '.'));
                    }
                }
            }
        } else {
            File root = new File(path);
            List<File> fs = new ArrayList<>();
            collect(root, fs);
            fs.sort(Comparator.comparing(File::getPath));
            for (File f : fs) {
                if (!f.getName().endsWith(".class")) continue;
                classes.add(java.nio.file.Files.readAllBytes(f.toPath()));
                String rel = root.toURI().relativize(f.toURI()).getPath();
                names.add(rel.replace(".class", "").replace('/', '.'));
            }
        }
        for (int ci = 0; ci < classes.size(); ci++) {
            ClassNode cn = new ClassNode();
            try { new ClassReader(classes.get(ci)).accept(cn, ClassReader.EXPAND_FRAMES); }
            catch (Throwable t) { continue; }
            String owner = names.get(ci);
            for (MethodNode m : cn.methods) {
                if (m.instructions == null) continue;
                List<AbstractInsnNode> insns = new ArrayList<>();
                for (AbstractInsnNode in = m.instructions.getFirst(); in != null; in = in.getNext())
                    if (in.getOpcode() >= 0) insns.add(in);
                Map<AbstractInsnNode, Integer> lineOf = new HashMap<>();
                int lastLine = -1;
                for (AbstractInsnNode n = m.instructions.getFirst(); n != null; n = n.getNext()) {
                    if (n instanceof LineNumberNode) lastLine = ((LineNumberNode) n).line;
                    else lineOf.put(n, lastLine);
                }
                List<Object> st = new ArrayList<>();
                Map<Integer, Object> locals = new HashMap<>();
                {   // seed parameters: the first (this +) args of the descriptor
                    int lv = 0;
                    if (m.access != Opcodes.ACC_STATIC) locals.put(lv++, "@THIS");
                    for (Type t : Type.getArgumentTypes(m.desc)) {
                        locals.put(lv++, "@P" + t.getSort() + lv);
                        lv += (t.getSize() == 2) ? 1 : 0;
                    }
                }
                int ordinal = 0;
                for (AbstractInsnNode in : insns) {
                    int op = in.getOpcode();
                    if (op >= Opcodes.ILOAD && op <= Opcodes.ALOAD) {
                        int v = ((VarInsnNode) in).var;
                        st.add(locals.containsKey(v) ? locals.get(v) : "@V" + v);
                    }
                    else if (op == Opcodes.SIPUSH || op == Opcodes.BIPUSH) st.add(((IntInsnNode) in).operand);
                    else if (op == Opcodes.ICONST_M1) st.add(-1);
                    else if (op >= Opcodes.ICONST_0 && op <= Opcodes.ICONST_5) st.add(op - Opcodes.ICONST_0);
                    else if (op == Opcodes.LDC) {
                            Object c = ((LdcInsnNode) in).cst;
                            st.add(c instanceof String ? new Lit((String) c) : c);
                        }
                    else if (op == Opcodes.GETSTATIC) {
                        FieldInsnNode fi = (FieldInsnNode) in;
                        if (fi.owner.equals("net/md_5/bungee/api/ChatColor")
                                || fi.owner.equals("org/bukkit/ChatColor")) {
                            st.add("ChatColor." + fi.name);
                        } else {
                            st.add("@" + simple(fi.owner) + "." + fi.name);
                        }
                    }
                    else if (op == Opcodes.INVOKEVIRTUAL || op == Opcodes.INVOKESPECIAL
                            || op == Opcodes.INVOKEINTERFACE) {
                        MethodInsnNode mi = (MethodInsnNode) in;
                        int na = Type.getArgumentTypes(mi.desc).length;
                        for (int i = 0; i < na + 1; i++) pop(st);
                        if (Type.getReturnType(mi.desc).getSort() != Type.VOID)
                            st.add("@" + simple(mi.owner) + "." + mi.name + "()");
                    } else if (op == Opcodes.INVOKESTATIC) {
                        MethodInsnNode mi = (MethodInsnNode) in;
                        int na = Type.getArgumentTypes(mi.desc).length;
                        boolean isCCof = mi.name.equals("of")
                                && (mi.owner.equals("net/md_5/bungee/api/ChatColor")
                                 || mi.owner.equals("org/bukkit/ChatColor"));
                        if (isCCof) {
                            Object hex = null;
                            for (int i = 0; i < na; i++) hex = pop(st);
                            st.add("ChatColor.of(" + render(hex) + ")");
                        } else if (mi.owner.equals("java/lang/String") && mi.name.equals("valueOf")) {
                            Object arg = null;
                            for (int i = 0; i < na; i++) arg = pop(st);
                            st.add("String.valueOf(" + render(arg) + ")");
                        } else if (mi.name.equals("a") && mi.desc.equals("(II)Ljava/lang/String;")) {
                            // Primary: what the forward simulation says is on the stack.
                            // (The two int pushes are often separated by unrelated calls,
                            //  so a backward scan alone picks up the wrong constants.)
                            if (System.getenv("CT_DEBUG") != null && owner.endsWith("239764x")
                                    && m.name.endsWith("239764a")) {
                                System.err.println("[dbg] before decoder, stack=" + st
                                        + "  prev=" + prevReal(in));
                            }
                            Object t1 = pop(st), t2 = pop(st);
                            int[] ia = null;
                            if (t1 instanceof Integer && t2 instanceof Integer)
                                ia = new int[] { (Integer) t2, (Integer) t1 };
                            if (ia == null) ia = decoderArgs(in);
                            st.add(ia == null ? "@DECODER?" : new Lit(lookup(owner, m.name, m.desc, ia[0], ia[1])));
                        } else {
                            for (int i = 0; i < na; i++) pop(st);
                            if (Type.getReturnType(mi.desc).getSort() != Type.VOID)
                                st.add("@" + simple(mi.owner) + "." + mi.name + "()");
                        }
                    } else if (op == Opcodes.INVOKEDYNAMIC) {
                        InvokeDynamicInsnNode indy = (InvokeDynamicInsnNode) in;
                        int na = Type.getArgumentTypes(indy.desc).length;
                        List<Object> as = new ArrayList<>();
                        for (int i = 0; i < na; i++) { Object v = pop(st); as.add(0, v); }
                        if (indy.bsm != null && "makeConcatWithConstants".equals(indy.bsm.getName())) {
                            String recipe = indy.bsmArgs != null && indy.bsmArgs.length > 0
                                    ? String.valueOf(indy.bsmArgs[0]) : "?";
                            int line = lineOf.getOrDefault(in, -1);
                            System.out.println(String.join("\t", owner, m.name, m.desc,
                                    String.valueOf(ordinal++), String.valueOf(line),
                                    esc(recipe), buildExpr(recipe, as)));
                        }
                        st.add("@INDY");
                    } else if (op == Opcodes.POP) pop(st);
                    else if (op >= Opcodes.ISTORE && op <= Opcodes.ASTORE)
                        locals.put(((VarInsnNode) in).var, pop(st));
                    else if (op == Opcodes.POP2) { pop(st); pop(st); }
                    else if (op == Opcodes.DUP) { if (!st.isEmpty()) st.add(st.get(st.size()-1)); }
                    else if (op == Opcodes.DUP_X1) {          // ...,v2,v1 -> ...,v1,v2,v1
                        if (st.size() >= 2) {
                            Object v1 = pop(st), v2 = pop(st);
                            st.add(v1); st.add(v2); st.add(v1);
                        }
                    }
                    else if (op == Opcodes.DUP_X2) {          // ...,v3,v2,v1 -> ...,v1,v3,v2,v1 (cat1)
                        if (st.size() >= 3) {
                            Object v1 = pop(st), v2 = pop(st), v3 = pop(st);
                            st.add(v1); st.add(v3); st.add(v2); st.add(v1);
                        } else if (st.size() == 2) {          // Form 2 (v2 cat2)
                            Object v1 = pop(st), v2 = pop(st);
                            st.add(v1); st.add(v2); st.add(v1);
                        }
                    }
                    else if (op == Opcodes.DUP2) {            // ...,v2,v1 -> ...,v2,v1,v2,v1 (cat1)
                        if (st.size() >= 2) {
                            Object v1 = pop(st), v2 = pop(st);
                            st.add(v2); st.add(v1); st.add(v2); st.add(v1);
                        } else if (st.size() == 1) {          // Form 2 (single cat2)
                            Object v1 = pop(st); st.add(v1); st.add(v1);
                        }
                    }
                    else if (op == Opcodes.DUP2_X1) {         // ...,v3,v2,v1 -> ...,v2,v1,v3,v2,v1
                        if (st.size() >= 3) {
                            Object v1 = pop(st), v2 = pop(st), v3 = pop(st);
                            st.add(v2); st.add(v1); st.add(v3); st.add(v2); st.add(v1);
                        }
                    }
                    else if (op == Opcodes.DUP2_X2) {         // ...,v4,v3,v2,v1 -> ...,v2,v1,v4,v3,v2,v1
                        if (st.size() >= 4) {
                            Object v1 = pop(st), v2 = pop(st), v3 = pop(st), v4 = pop(st);
                            st.add(v2); st.add(v1); st.add(v4); st.add(v3); st.add(v2); st.add(v1);
                        }
                    }
                    else if (op == Opcodes.SWAP) {
                        int n2 = st.size();
                        if (n2 >= 2) { Object t = st.get(n2 - 1); st.set(n2 - 1, st.get(n2 - 2)); st.set(n2 - 2, t); }
                    }
                    else if (op == Opcodes.GETFIELD) { pop(st); st.add("@F"); }
                    else if (op == Opcodes.NEW || op == Opcodes.NEWARRAY || op == Opcodes.ANEWARRAY
                            || op == Opcodes.ARRAYLENGTH || op == Opcodes.INSTANCEOF) st.add("@O");
                    else if (op >= Opcodes.IRETURN && op <= Opcodes.RETURN) st.clear();
                }
            }
        }
    }


    /** Render a value as a Java String literal (or pass through a placeholder). */

    /** A decoded string that is a Bukkit/Bungee ChatColor constant name is a code reference, not a literal. */
    static final java.util.regex.Pattern CC = java.util.regex.Pattern.compile("^[A-Z_0-9]+$");
    static Object chatColorName(String v) {
        if (v != null && v.length() > 1 && CC.matcher(v).matches() && CHATCOLORS.contains(v)) return "ChatColor." + v;
        return v;
    }
    static final java.util.Set<String> CHATCOLORS = new java.util.HashSet<>(java.util.Arrays.asList(
        "BLACK","DARK_BLUE","DARK_GREEN","DARK_AQUA","DARK_RED","DARK_PURPLE","GOLD","GRAY",
        "DARK_GRAY","BLUE","GREEN","AQUA","RED","LIGHT_PURPLE","YELLOW","WHITE",
        "MAGENTA","GOLD","RESET","WHITE","BOLD","ITALIC","UNDERLINE","STRIKETHROUGH","UNDERLINED",
        "BOLD_GRAY","DARK_GRAY","OBFUSCATED","MAGENTA","BOLD_GREEN","ITALIC_GRAY"));

    static String jstr(Object o) { return render(o); }

    static String javaLit(String v) {
        StringBuilder sb = new StringBuilder("\"");
        for (char c : v.toCharArray()) {
            switch (c) {
                case '"': sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                default:
                    if (c < 32 || c > 126) sb.append(String.format("\\u%04x", (int) c));
                    else sb.append(c);
            }
        }
        return sb.append('"').toString();
    }

    /** Interleave a makeConcatWithConstants recipe with its evaluated args. */
    static String buildExpr(String recipe, List<Object> as) {
        StringBuilder sb = new StringBuilder();
        StringBuilder lit = new StringBuilder();
        int ai = 0;
        for (int i = 0; i < recipe.length(); i++) {
            char c = recipe.charAt(i);
            if (c == '\u0001') {
                if (lit.length() > 0) { if (sb.length() > 0) sb.append(" + "); sb.append(javaLit(lit.toString())); lit.setLength(0); }
                if (sb.length() > 0) sb.append(" + ");
                sb.append(ai < as.size() ? render(as.get(ai++)) : "<MISSING>");
            } else {
                lit.append(c);
            }
        }
        if (lit.length() > 0) { if (sb.length() > 0) sb.append(" + "); sb.append(javaLit(lit.toString())); }
        while (ai < as.size()) { if (sb.length() > 0) sb.append(" + "); sb.append(render(as.get(ai++))); }
        return sb.toString();
    }

    /** A runtime String value (LDC constant or decoder result) vs. rendered Java code. */
    static final class Lit {
        final String v;
        Lit(String v) { this.v = v; }
        @Override public String toString() { return "Lit(" + v + ")"; }
    }

    /** Previous real instruction, skipping labels / line numbers / frames. */
    static AbstractInsnNode prevReal(AbstractInsnNode in) {
        AbstractInsnNode p = in.getPrevious();
        while (p != null && p.getOpcode() < 0) p = p.getPrevious();
        return p;
    }

    /** Constant int pushed by a real instruction, else null. */
    static Integer intConst(AbstractInsnNode in) {
        if (in == null) return null;
        int op = in.getOpcode();
        if (op == Opcodes.SIPUSH || op == Opcodes.BIPUSH) return ((IntInsnNode) in).operand;
        if (op == Opcodes.ICONST_M1) return -1;
        if (op >= Opcodes.ICONST_0 && op <= Opcodes.ICONST_5) return op - Opcodes.ICONST_0;
        return null;
    }

    /**
     * Resolve the two int args of an a(II)String decoder call. The two pushes are
     * not always adjacent (the obfuscator interleaves stores/loads), but since the
     * signature is (II)String only int pushes can produce them, so scan back for
     * the two most recent int pushes, aborting at control flow.
     */
    static int[] decoderArgs(AbstractInsnNode call) {
        int[] got = new int[2];
        int n = 0, steps = 0;
        for (AbstractInsnNode p = prevReal(call); p != null && n < 2 && steps < 40; p = prevReal(p)) {
            steps++;
            int op = p.getOpcode();
            if (p instanceof JumpInsnNode || p instanceof TableSwitchInsnNode
                    || p instanceof LookupSwitchInsnNode || op == Opcodes.ATHROW
                    || (op >= Opcodes.IRETURN && op <= Opcodes.RETURN)) return null;
            Integer c = intConst(p);
            if (c != null) got[n++] = c;
        }
        // got[0] is the SECOND arg (found first walking backwards); got[1] is the first.
        return n == 2 ? new int[] { got[1], got[0] } : null;
    }

    /** Plaintext for a decoder call, or a visible placeholder if unresolvable. */
    static String lookup(String owner, String mname, String mdesc, int a1, int a2) {
        List<String[]> rows = DEC.get(owner + "::" + mname + "::" + mdesc);
        if (rows != null) {
            for (String[] r : rows) {
                if (r[0].equals(owner) && r[1].equals(mname) && r[2].equals(mdesc)
                        && r[3].equals(String.valueOf(a1)) && r[4].equals(String.valueOf(a2)))
                    return r[5];
            }
        }
        return "@DEC(" + a1 + "," + a2 + ")";
    }

    static Object pop(List<Object> st) { return st.isEmpty() ? null : st.remove(st.size() - 1); }
    static String strOf(List<Object> st, int n) { return "?"; }
    static String simple(String internal) {
        String s = internal;
        int i = s.lastIndexOf('/');
        return i >= 0 ? s.substring(i + 1) : s;
    }
    static String fieldTail(String n) { return n; }

    static String render(Object o) {
        if (o == null) return "@UF";
        if (o instanceof Lit) {
            String t = ((Lit) o).v;
            Object cc = chatColorName(t);
            if (cc instanceof String && !cc.equals(t)) return (String) cc;  // ChatColor.X reference
            return javaLit(t);
        }
        if (o instanceof Integer) return o.toString();
        if (o instanceof Long) return o + "L";
        if (o instanceof String) return (String) o;                          // already Java code
        return String.valueOf(o);
    }


    static String esc(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '\u0001') sb.append("\\1");
            else if (c == '\n') sb.append("\\n");
            else if (c == '\r') sb.append("\\r");
            else if (c == '\t') sb.append("\\t");
            else if (c == '\\') sb.append("\\\\");
            else if (c < 32 || c > 126) sb.append(String.format("\\u%04x", (int) c));
            else sb.append(c);
        }
        return sb.toString();
    }

    static void collect(File d, List<File> out) {
        File[] ch = d.listFiles();
        if (ch == null) return;
        for (File f : ch) { if (f.isDirectory()) collect(f, out); else out.add(f); }
    }
}
