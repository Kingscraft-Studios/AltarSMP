import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.jar.*;

/** Decodes every (arg1,arg2) call site found by ScanCalls, using the owning class's
 *  own private a(II)String decoder, and prints class\tmethod\targ1\targ2\tstring */
public class DecodeAll {
    static JarFile jar;
    static Map<String, Class<?>> loaded = new HashMap<>();

    public static void main(String[] args) throws Exception {
        jar = new JarFile(args[0]);
        String tsv = args[1];
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(tsv))) {
            String l;
            while ((l = r.readLine()) != null) {
                String[] p = l.split("\t");
                if (p.length >= 5) rows.add(p);
            }
        }
        // group by owner class
        Map<String, List<String[]>> byClass = new LinkedHashMap<>();
        for (String[] r : rows) byClass.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r);

        ClassLoader loader = new ClassLoader(DecodeAll.class.getClassLoader()) {
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                Class<?> c = loaded.get(name);
                if (c != null) return c;
                String p = name.replace('.', '/') + ".class";
                JarEntry e = jar.getJarEntry(p);
                if (e == null) throw new ClassNotFoundException(name);
                byte[] b;
                try (InputStream in = jar.getInputStream(e)) {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[65536];
                    int n;
                    while ((n = in.read(buf)) > 0) bos.write(buf, 0, n);
                    b = bos.toByteArray();
                }
                byte[] patched = PDecoder.patch(b);
                c = defineClass(name, patched, 0, patched.length);
                loaded.put(name, c);
                return c;
                } catch (java.io.IOException io) { throw new ClassNotFoundException(name, io); }
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

        for (Map.Entry<String, List<String[]>> e : byClass.entrySet()) {
            String cls = e.getKey();
            Method dec = null;
            try {
                Class<?> c = Class.forName(cls, true, loader);
                for (Method mth : c.getDeclaredMethods()) {
                    if (mth.getName().equals("a") && mth.getParameterCount() == 2) {
                        dec = mth; dec.setAccessible(true); break;
                    }
                }
            } catch (Throwable t) {
                System.err.println("LOADFAIL\t" + cls + "\t" + t);
            }
            for (String[] r : e.getValue()) {
                if (dec == null) { System.out.println(String.join("\t", r[0], r[1], r[2], r[3], r[4], "?NODECODER")); continue; }
                int a1, a2;
                try { a1 = Integer.parseInt(r[3]); a2 = Integer.parseInt(r[4]); }
                catch (NumberFormatException ex) { System.out.println(String.join("\t", r[0], r[1], r[2], r[3], r[4], "?NONCONST")); continue; }
                try {
                    Object v = dec.invoke(null, a1, a2);
                    String s = v == null ? "null" : v.toString();
                    s = s.replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
                    System.out.println(String.join("\t", r[0], r[1], r[2], Integer.toString(a1), Integer.toString(a2), s));
                } catch (InvocationTargetException ex) {
                    Throwable c2 = ex.getCause();
                    String msg = c2 == null ? "?" : c2.getClass().getSimpleName();
                    System.out.println(String.join("\t", r[0], r[1], r[2], Integer.toString(a1), Integer.toString(a2), "!ERR:" + msg));
                } catch (Throwable t) {
                    System.out.println(String.join("\t", r[0], r[1], r[2], Integer.toString(a1), Integer.toString(a2), "!ERR:" + t.getClass().getSimpleName()));
                }
            }
        }
    }
}
