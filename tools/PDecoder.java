import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.jar.*;

public class PDecoder {
    static byte[] jarBytes;
    static JarFile jar;

    public static void main(String[] args) throws Exception {
        String jarPath = args[0];
        String cn = args[1].replace('.', '/');
        jar = new JarFile(jarPath);
        // collect total size
        long total = 0;
        Enumeration<JarEntry> es = jar.entries();
        while (es.hasMoreElements()) total += es.nextElement().getSize();
        jarBytes = new byte[(int) total];
        int pos = 0;
        es = jar.entries();
        while (es.hasMoreElements()) {
            JarEntry e = es.nextElement();
            if (e.isDirectory()) continue;
            InputStream in = jar.getInputStream(e);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[65536];
            int n;
            while ((n = in.read(buf)) > 0) bos.write(buf, 0, n);
            byte[] b = bos.toByteArray();
            System.arraycopy(b, 0, jarBytes, pos, b.length);
            pos += b.length;
        }
        ClassLoader loader = new ClassLoader(PDecoder.class.getClassLoader()) {
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                String p = name.replace('.', '/') + ".class";
                byte[] b = patch(readClass(p));
                return defineClass(name, b, 0, b.length);
            }
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                if (name.startsWith("pl.")) {
                    synchronized (getClassLoadingLock(name)) {
                        Class<?> c = findLoadedClass(name);
                        if (c == null) c = findClass(name);
                        if (resolve) resolveClass(c);
                        return c;
                    }
                }
                return super.loadClass(name, resolve);
            }
        };
        Class<?> c = Class.forName(args[1], true, loader);
        // try to read field for single-string
        String single = null;
        try {
            Field f = c.getDeclaredField("a");
            if (f.getType() == String.class) {
                f.setAccessible(true);
                Object o = f.get(null);
                if (o != null) {
                    single = (String) o;
                    System.out.println("SINGLE\t" + single.replace("\n", "\\n"));
                }
            }
        } catch (Throwable t) {
            System.out.println("SINGLEERR\t" + t);
        }
        // decrypt method
        Method m = null;
        for (Method mth : c.getDeclaredMethods()) {
            if (mth.getName().equals("a") && mth.getParameterCount() == 2) {
                m = mth;
                m.setAccessible(true);
                break;
            }
        }
        if (m != null) {
            for (int i = 2; i + 1 < args.length; i += 2) {
                try {
                    Object r = m.invoke(null, Integer.parseInt(args[i]), Integer.parseInt(args[i + 1]));
                    System.out.println("OK\t" + args[i] + "\t" + args[i + 1] + "\t" + ((String) r).replace("\n", "\\n"));
                } catch (InvocationTargetException e) {
                    System.out.println("ERR\t" + args[i] + "\t" + args[i + 1] + "\t" + e.getCause());
                } catch (Throwable e) {
                    System.out.println("ERR\t" + args[i] + "\t" + args[i + 1] + "\t" + e);
                }
            }
        } else {
            System.out.println("NOMETHOD");
        }
        // dump tables
        for (String fname : new String[] { "a", "b" }) {
            try {
                Field f = c.getDeclaredField(fname);
                f.setAccessible(true);
                Object o = f.get(null);
                if (o instanceof String[]) {
                    String[] arr = (String[]) o;
                    System.out.println("TBL\t" + fname + "\t" + arr.length);
                }
            } catch (Throwable t) {
                System.out.println("TBLERR\t" + fname + "\t" + t);
            }
        }
        // prefix-named String fields that were initialized before the tail goto
        String PREFIX = "You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764";
        for (Field f : c.getDeclaredFields()) {
            if (f.getType() == String.class && f.getName().startsWith(PREFIX)) {
                try {
                    f.setAccessible(true);
                    Object o = f.get(null);
                    System.out.println("STRVAL\t" + f.getName() + "\t"
                        + ((o == null) ? "null" : ((String) o).replace("\n", "\\n")));
                } catch (Throwable t) {
                    System.out.println("STRVAL\t" + f.getName() + "\tnull");
                }
            }
        }
    }

    static byte[] readClass(String path) {
        try {
            JarEntry e = jar.getJarEntry(path);
            if (e == null) throw new RuntimeException("no entry " + path);
            InputStream in = jar.getInputStream(e);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[65536];
            int n;
            while ((n = in.read(buf)) > 0) bos.write(buf, 0, n);
            return bos.toByteArray();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static byte[] patch(byte[] bytes) {
        ClassNode cn = new ClassNode();
        new ClassReader(bytes).accept(cn, 0);
        for (MethodNode m : cn.methods) {
            if (!m.name.equals("<clinit>")) continue;
            FieldInsnNode cut = null;
            int cutType = 0; // 0 none, 1 b-array, 2 a-string
            for (AbstractInsnNode ins = m.instructions.getFirst(); ins != null; ins = ins.getNext()) {
                if (ins instanceof FieldInsnNode && ins.getOpcode() == Opcodes.PUTSTATIC) {
                    FieldInsnNode fi = (FieldInsnNode) ins;
                    if (!fi.owner.equals(cn.name)) continue;
                    if (fi.name.equals("b") && fi.desc.equals("[Ljava/lang/String;")) {
                        cut = fi;
                        cutType = 1;
                        break;
                    }
                    if (fi.name.equals("a") && cut == null && fi.desc.equals("Ljava/lang/String;")) {
                        cut = fi;
                        cutType = 2;
                    }
                }
            }
            if (cut == null) continue;
            InsnList il = m.instructions;
            AbstractInsnNode patchTarget = null;
            for (AbstractInsnNode in = cut.getNext(); in != null; in = in.getNext()) {
                if (in instanceof JumpInsnNode && in.getOpcode() == Opcodes.GOTO) {
                    int tgt = il.indexOf(((JumpInsnNode) in).label);
                    int idx = il.indexOf(in);
                    if (tgt > idx) { patchTarget = in; break; }
                }
                if (in.getOpcode() == Opcodes.RETURN || in.getOpcode() == Opcodes.ATHROW) break;
            }
            if (patchTarget != null) {
                // in-place 3-byte swap: goto -> return+nop+nop (offsets/frames stay valid)
                il.insertBefore(patchTarget, new InsnNode(Opcodes.RETURN));
                il.insertBefore(patchTarget, new InsnNode(Opcodes.NOP));
                il.insertBefore(patchTarget, new InsnNode(Opcodes.NOP));
                il.remove(patchTarget);
                System.out.println("PATCH\t" + (cutType == 1 ? "array" : "single") + "\t@inplace");
            } else {
                System.out.println("PATCH\t" + (cutType == 1 ? "array" : "single") + "\t@none");
            }
            break;
        }
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cn.accept(cw);
        return cw.toByteArray();
    }
}