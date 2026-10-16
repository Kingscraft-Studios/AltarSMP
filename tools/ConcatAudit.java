import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.io.*;
import java.util.*;
import java.util.jar.*;

/**
 * Computes the exact runtime value of every makeConcatWithConstants invokedynamic site,
 * for a jar (original) and/or a class dir (recompiled), and prints
 *   class \t method \t ordinal \t bsmIndex \t resultingString
 * The original's obfuscated string arguments are resolved from a TSV of pre-decoded
 * call sites produced by ScanCalls+DecodeAll (class, method, arg1, arg2, string),
 * consumed in program order.
 */
public class ConcatAudit {
    public static void main(String[] args) throws Exception {
        String decodedTsv = args[0];
        List<String[]> sites = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(decodedTsv))) {
            String l;
            while ((l = r.readLine()) != null) {
                String[] p = l.split("\t", -1);
                if (p.length >= 6) sites.add(p);
            }
        }
        Map<String, List<String[]>> byCM = new LinkedHashMap<>();
        for (String[] s : sites) byCM.computeIfAbsent(s[0] + "::" + s[1] + "::" + s[2], k -> new ArrayList<>()).add(s);

        System.out.println("=== ORIGINAL ===");
        audit(args.length > 1 ? args[1] : null, true, byCM);
        System.out.println("=== RECOMPILED ===");
        if (args.length > 2) audit(args[2], false, byCM);
    }

    static void audit(String path, boolean isJar, Map<String, List<String[]>> byCM) throws Exception {
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
            try { new ClassReader(classes.get(ci)).accept(cn, 0); } catch (Throwable t) { continue; }
            String owner = names.get(ci);
            for (MethodNode m : cn.methods) {
                if (m.instructions == null) continue;
                List<AbstractInsnNode> insns = new ArrayList<>();
                for (AbstractInsnNode in = m.instructions.getFirst(); in != null; in = in.getNext())
                    if (in.getOpcode() >= 0) insns.add(in);
                List<String[]> pending = byCM.get(owner + "::" + m.name + "::" + m.desc);
                int decPtr = 0;
                int ordinal = 0;
                List<Object> st = new ArrayList<>();
                for (AbstractInsnNode in : insns) {
                    int op = in.getOpcode();
                    if (op == Opcodes.SIPUSH || op == Opcodes.BIPUSH) st.add(((IntInsnNode) in).operand);
                    else if (op == Opcodes.ICONST_M1) st.add(-1);
                    else if (op >= Opcodes.ICONST_0 && op <= Opcodes.ICONST_5) st.add(op - Opcodes.ICONST_0);
                    else if (op == Opcodes.LDC) st.add(((LdcInsnNode) in).cst);
                    else if (op == Opcodes.GETSTATIC) {
                        FieldInsnNode fi = (FieldInsnNode) in;
                        String s = modelStatic(fi.owner, fi.name);
                        st.add(s != null ? s : "GS:" + fi.owner + "." + fi.name);
                    }
                    else if (op == Opcodes.INVOKEVIRTUAL || op == Opcodes.INVOKESPECIAL
                            || op == Opcodes.INVOKEINTERFACE) {
                        MethodInsnNode mi = (MethodInsnNode) in;
                        int na = Type.getArgumentTypes(mi.desc).length;
                        List<Object> as = new ArrayList<>();
                        for (int i = 0; i < na; i++) as.add(0, st.isEmpty() ? "<UNDERFLOW>" : st.remove(st.size()-1));
                        if (!st.isEmpty()) st.remove(st.size()-1);
                        String id = modelIdentity(mi.owner, mi.name, mi.desc, as);
                        st.add(id != null ? id : mi.owner + "." + mi.name + mi.desc);
                    } else if (op == Opcodes.INVOKESTATIC) {
                        MethodInsnNode mi = (MethodInsnNode) in;
                        int na = Type.getArgumentTypes(mi.desc).length;
                        if (mi.name.equals("a") && mi.desc.equals("(II)Ljava/lang/String;")) {
                            Integer a2 = null, a1 = null;
                            if (st.size() >= 2) { Object o2 = st.remove(st.size()-1); Object o1 = st.remove(st.size()-1);
                                a2 = (o2 instanceof Integer) ? (Integer) o2 : null;
                                a1 = (o1 instanceof Integer) ? (Integer) o1 : null; }
                            String val = "?";
                            if (pending != null && a1 != null && a2 != null) {
                                for (String[] row : pending) {
                                    if (!row[0].equals(owner) || !row[1].equals(m.name) || !row[2].equals(m.desc)) continue;
                                    if (row[3].equals(a1.toString()) && row[4].equals(a2.toString())) { val = row[5]; break; }
                                }
                            }
                            st.add(val);
                        } else {
                            List<Object> as = new ArrayList<>();
                            for (int i = 0; i < na; i++) as.add(0, st.isEmpty() ? "<UNDERFLOW>" : st.remove(st.size()-1));
                            String v = modelStaticCall(mi.owner, mi.name, mi.desc, as);
                            st.add(v != null ? v : mi.owner + "." + mi.name + mi.desc);
                        }
                    } else if (op == Opcodes.INVOKEDYNAMIC) {
                        InvokeDynamicInsnNode indy = (InvokeDynamicInsnNode) in;
                        int na = Type.getArgumentTypes(indy.desc).length;
                        List<Object> args = new ArrayList<>();
                        for (int i = 0; i < na; i++) args.add(0, st.isEmpty() ? "<UNDERFLOW>" : st.remove(st.size()-1));
                        if (indy.bsm != null && "makeConcatWithConstants".equals(indy.bsm.getName())) {
                            String recipe = String.valueOf(indy.bsmArgs != null && indy.bsmArgs.length > 0 ? indy.bsmArgs[0] : "?");
                            String out = apply(recipe, args);
                            System.out.println(String.join("\t", owner, m.name,
                                    String.valueOf(ordinal++), "0", out));
                        }
                        st.add("INDY:" + indy.name);
                    } else if (op == Opcodes.POP) { if (!st.isEmpty()) st.remove(st.size()-1); }
                    else if (op == Opcodes.DUP) { if (!st.isEmpty()) st.add(st.get(st.size()-1)); }
                    else if (op == Opcodes.GETFIELD) { if (!st.isEmpty()) st.remove(st.size()-1); st.add("F"); }
                    else if (op == Opcodes.NEW || op == Opcodes.NEWARRAY || op == Opcodes.ANEWARRAY
                            || op == Opcodes.ARRAYLENGTH || op == Opcodes.INSTANCEOF) st.add("O");
                    else if (op >= Opcodes.IRETURN && op <= Opcodes.RETURN) st.clear();
                }
            }
        }
    }


    /** bungee ChatColor static fields -> their "§x" rendering. */
    static String modelStatic(String owner, String name) {
        if (!owner.equals("net/md_5/bungee/api/ChatColor")) return null;
        if (name.startsWith("§")) return name;
        if (name.length() == 1 || (name.length() > 1 && isPlainColorName(name))) {
            return "\u00a7" + name.toLowerCase();
        }
        return null;
    }

    static boolean isPlainColorName(String n) {
        switch (n.toUpperCase()) {
            case "BLACK": case "DARK_BLUE": case "DARK_GREEN": case "DARK_AQUA":
            case "DARK_RED": case "DARK_PURPLE": case "GOLD": case "GRAY":
            case "DARK_GRAY": case "BLUE": case "GREEN": case "AQUA":
            case "RED": case "LIGHT_PURPLE": case "YELLOW": case "WHITE":
            case "MAGENTA": case "BOLD": case "STRIKETHROUGH": case "UNDERLINE":
            case "ITALIC": case "RESET":
                return true;
            default: return false;
        }
    }

    /** instance calls we can evaluate exactly */
    static String modelIdentity(String owner, String name, String desc, List<Object> as) {
        if (owner.equals("net/md_5/bungee/api/ChatColor") && name.equals("toString")
                && desc.equals("()Ljava/lang/String;")) {
            return as.isEmpty() ? null : String.valueOf(as.get(0));
        }
        if (owner.equals("java/lang/String") && name.equals("toString")
                && desc.equals("()Ljava/lang/String;")) {
            return as.isEmpty() ? null : String.valueOf(as.get(0));
        }
        if (owner.equals("java/lang/Object") && name.equals("toString")
                && desc.equals("()Ljava/lang/String;")) {
            return as.isEmpty() ? null : String.valueOf(as.get(0));
        }
        return null;
    }

    /** static calls we can evaluate exactly */
    static String modelStaticCall(String owner, String name, String desc, List<Object> as) {
        if (owner.equals("net/md_5/bungee/api/ChatColor") && name.equals("of")
                && desc.equals("(Ljava/lang/String;)Lnet/md_5/bungee/api/ChatColor;")) {
            return "\u00a7" + String.valueOf(as.get(0));
        }
        if (owner.equals("net/md_5/bungee/api/ChatColor") && name.equals("valueOf")
                && desc.equals("(Ljava/lang/String;)Lnet/md_5/bungee/api/ChatColor;")) {
            String s = String.valueOf(as.get(0));
            if (s.equalsIgnoreCase("RESET")) return "\u00a7r";
            if (s.equalsIgnoreCase("BOLD")) return "\u00a7l";
            if (s.length() == 1) return "\u00a7" + s.toLowerCase();
            return "\u00a7x" + s;
        }
        if (owner.equals("java/lang/String") && name.equals("valueOf")
                && desc.equals("(Ljava/lang/Object;)Ljava/lang/String;")) {
            Object o = as.get(0);
            return o == null ? "null" : String.valueOf(o);
        }
        if (owner.equals("java/lang/String") && name.equals("valueOf")
                && desc.equals("(I)Ljava/lang/String;")) {
            return String.valueOf(as.get(0));
        }
        if (owner.equals("java/lang/String") && name.equals("valueOf")
                && desc.equals("(J)Ljava/lang/String;")) {
            return String.valueOf(as.get(0));
        }
        if (owner.equals("java/lang/String") && name.equals("valueOf")
                && desc.equals("(Z)Ljava/lang/String;")) {
            return String.valueOf(as.get(0));
        }
        if (owner.equals("java/lang/String") && name.equals("valueOf")
                && desc.equals("(D)Ljava/lang/String;")) {
            return String.valueOf(as.get(0));
        }
        return null;
    }

    /** Apply a makeConcatWithConstants recipe to the evaluated argument list. */
    static String apply(String recipe, List<Object> args) {
        StringBuilder sb = new StringBuilder();
        int ai = 0;
        for (int i = 0; i < recipe.length(); i++) {
            char c = recipe.charAt(i);
            if (c == '\u0001') {
                sb.append(ai < args.size() ? render(args.get(ai++)) : "<MISSING>");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String render(Object o) {
        if (o == null) return "<null>";
        if (o instanceof String) {
            String s = (String) o;
            if (s.startsWith("GS:") || s.contains("/") || s.startsWith("INDY:")) return "<" + s + ">";
            return s;
        }
        if (o instanceof Integer || o instanceof Long || o instanceof Double || o instanceof Float)
            return String.valueOf(o);
        return "<" + o + ">";
    }

    static void collect(File d, List<File> out) {
        File[] ch = d.listFiles();
        if (ch == null) return;
        for (File f : ch) { if (f.isDirectory()) collect(f, out); else out.add(f); }
    }
}
