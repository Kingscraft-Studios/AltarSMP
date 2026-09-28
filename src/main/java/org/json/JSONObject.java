/*      */ package org.json;
/*      */ 
/*      */ import java.io.Closeable;
/*      */ import java.io.IOException;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.IdentityHashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.ResourceBundle;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JSONObject
/*      */ {
/*      */   private static final class Null
/*      */   {
/*      */     private Null() {}
/*      */     
/*      */     protected final Object clone() {
/*  100 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object object) {
/*  114 */       return (object == null || object == this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  123 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  133 */       return "null";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  141 */   static final Pattern NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Map<String, Object> map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<? extends Map> getMapType() {
/*  154 */     return (Class)this.map.getClass();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  163 */   public static final Object NULL = new Null();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject() {
/*  175 */     this.map = new HashMap<>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(JSONObject jo, String... names) {
/*  189 */     this(names.length);
/*  190 */     for (int i = 0; i < names.length; i++) {
/*      */       try {
/*  192 */         putOnce(names[i], jo.opt(names[i]));
/*  193 */       } catch (Exception exception) {}
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(JSONTokener x) throws JSONException {
/*  208 */     this();
/*      */ 
/*      */ 
/*      */     
/*  212 */     if (x.nextClean() != '{') {
/*  213 */       throw x.syntaxError("A JSONObject text must begin with '{'");
/*      */     }
/*      */     while (true) {
/*  216 */       char c = x.nextClean();
/*  217 */       switch (c) {
/*      */         case '\000':
/*  219 */           throw x.syntaxError("A JSONObject text must end with '}'");
/*      */         case '}':
/*      */           return;
/*      */       } 
/*  223 */       String key = x.nextSimpleValue(c).toString();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  228 */       c = x.nextClean();
/*  229 */       if (c != ':') {
/*  230 */         throw x.syntaxError("Expected a ':' after a key");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  235 */       if (key != null) {
/*      */         
/*  237 */         if (opt(key) != null)
/*      */         {
/*  239 */           throw x.syntaxError("Duplicate key \"" + key + "\"");
/*      */         }
/*      */         
/*  242 */         Object value = x.nextValue();
/*  243 */         if (value != null) {
/*  244 */           put(key, value);
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  250 */       switch (x.nextClean()) {
/*      */         case ',':
/*      */         case ';':
/*  253 */           if (x.nextClean() == '}') {
/*      */             return;
/*      */           }
/*  256 */           if (x.end()) {
/*  257 */             throw x.syntaxError("A JSONObject text must end with '}'");
/*      */           }
/*  259 */           x.back(); continue;
/*      */         case '}':
/*      */           return;
/*      */       }  break;
/*      */     } 
/*  264 */     throw x.syntaxError("Expected a ',' or '}'");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(Map<?, ?> m) {
/*  281 */     this(m, 0, new JSONParserConfiguration());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(Map<?, ?> m, JSONParserConfiguration jsonParserConfiguration) {
/*  294 */     this(m, 0, jsonParserConfiguration);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private JSONObject(Map<?, ?> m, int recursionDepth, JSONParserConfiguration jsonParserConfiguration) {
/*  302 */     if (recursionDepth > jsonParserConfiguration.getMaxNestingDepth()) {
/*  303 */       throw new JSONException("JSONObject has reached recursion depth limit of " + jsonParserConfiguration.getMaxNestingDepth());
/*      */     }
/*  305 */     if (m == null) {
/*  306 */       this.map = new HashMap<>();
/*      */     } else {
/*  308 */       this.map = new HashMap<>(m.size());
/*  309 */       for (Map.Entry<?, ?> e : m.entrySet()) {
/*  310 */         if (e.getKey() == null) {
/*  311 */           throw new NullPointerException("Null key.");
/*      */         }
/*  313 */         Object value = e.getValue();
/*  314 */         if (value != null) {
/*  315 */           testValidity(value);
/*  316 */           this.map.put(String.valueOf(e.getKey()), wrap(value, recursionDepth + 1, jsonParserConfiguration));
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(Object bean) {
/*  382 */     this();
/*  383 */     populateMap(bean);
/*      */   }
/*      */   
/*      */   private JSONObject(Object bean, Set<Object> objectsRecord) {
/*  387 */     this();
/*  388 */     populateMap(bean, objectsRecord);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(Object object, String... names) {
/*  406 */     this(names.length);
/*  407 */     Class<?> c = object.getClass();
/*  408 */     for (int i = 0; i < names.length; i++) {
/*  409 */       String name = names[i];
/*      */       try {
/*  411 */         putOpt(name, c.getField(name).get(object));
/*  412 */       } catch (Exception exception) {}
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(String source) throws JSONException {
/*  430 */     this(new JSONTokener(source));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject(String baseName, Locale locale) throws JSONException {
/*  444 */     this();
/*  445 */     ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale, 
/*  446 */         Thread.currentThread().getContextClassLoader());
/*      */ 
/*      */ 
/*      */     
/*  450 */     Enumeration<String> keys = bundle.getKeys();
/*  451 */     while (keys.hasMoreElements()) {
/*  452 */       Object key = keys.nextElement();
/*  453 */       if (key != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  459 */         String[] path = ((String)key).split("\\.");
/*  460 */         int last = path.length - 1;
/*  461 */         JSONObject target = this;
/*  462 */         for (int i = 0; i < last; i++) {
/*  463 */           String segment = path[i];
/*  464 */           JSONObject nextTarget = target.optJSONObject(segment);
/*  465 */           if (nextTarget == null) {
/*  466 */             nextTarget = new JSONObject();
/*  467 */             target.put(segment, nextTarget);
/*      */           } 
/*  469 */           target = nextTarget;
/*      */         } 
/*  471 */         target.put(path[last], bundle.getString((String)key));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected JSONObject(int initialCapacity) {
/*  484 */     this.map = new HashMap<>(initialCapacity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject accumulate(String key, Object value) throws JSONException {
/*  509 */     testValidity(value);
/*  510 */     Object object = opt(key);
/*  511 */     if (object == null) {
/*  512 */       put(key, (value instanceof JSONArray) ? (new JSONArray())
/*  513 */           .put(value) : value);
/*      */     }
/*  515 */     else if (object instanceof JSONArray) {
/*  516 */       ((JSONArray)object).put(value);
/*      */     } else {
/*  518 */       put(key, (new JSONArray()).put(object).put(value));
/*      */     } 
/*  520 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject append(String key, Object value) throws JSONException {
/*  541 */     testValidity(value);
/*  542 */     Object object = opt(key);
/*  543 */     if (object == null) {
/*  544 */       put(key, (new JSONArray()).put(value));
/*  545 */     } else if (object instanceof JSONArray) {
/*  546 */       put(key, ((JSONArray)object).put(value));
/*      */     } else {
/*  548 */       throw wrongValueFormatException(key, "JSONArray", null, null);
/*      */     } 
/*  550 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String doubleToString(double d) {
/*  562 */     if (Double.isInfinite(d) || Double.isNaN(d)) {
/*  563 */       return "null";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  568 */     String string = Double.toString(d);
/*  569 */     if (string.indexOf('.') > 0 && string.indexOf('e') < 0 && string
/*  570 */       .indexOf('E') < 0) {
/*  571 */       while (string.endsWith("0")) {
/*  572 */         string = string.substring(0, string.length() - 1);
/*      */       }
/*  574 */       if (string.endsWith(".")) {
/*  575 */         string = string.substring(0, string.length() - 1);
/*      */       }
/*      */     } 
/*  578 */     return string;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object get(String key) throws JSONException {
/*  591 */     if (key == null) {
/*  592 */       throw new JSONException("Null key.");
/*      */     }
/*  594 */     Object object = opt(key);
/*  595 */     if (object == null) {
/*  596 */       throw new JSONException("JSONObject[" + quote(key) + "] not found.");
/*      */     }
/*  598 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <E extends Enum<E>> E getEnum(Class<E> clazz, String key) throws JSONException {
/*  616 */     E val = optEnum(clazz, key);
/*  617 */     if (val == null)
/*      */     {
/*      */ 
/*      */       
/*  621 */       throw wrongValueFormatException(key, "enum of type " + quote(clazz.getSimpleName()), opt(key), null);
/*      */     }
/*  623 */     return val;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBoolean(String key) throws JSONException {
/*  637 */     Object object = get(key);
/*  638 */     if (object.equals(Boolean.FALSE) || (object instanceof String && ((String)object)
/*      */       
/*  640 */       .equalsIgnoreCase("false")))
/*  641 */       return false; 
/*  642 */     if (object.equals(Boolean.TRUE) || (object instanceof String && ((String)object)
/*      */       
/*  644 */       .equalsIgnoreCase("true"))) {
/*  645 */       return true;
/*      */     }
/*  647 */     throw wrongValueFormatException(key, "Boolean", object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getBigInteger(String key) throws JSONException {
/*  661 */     Object object = get(key);
/*  662 */     BigInteger ret = objectToBigInteger(object, null);
/*  663 */     if (ret != null) {
/*  664 */       return ret;
/*      */     }
/*  666 */     throw wrongValueFormatException(key, "BigInteger", object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBigDecimal(String key) throws JSONException {
/*  683 */     Object object = get(key);
/*  684 */     BigDecimal ret = objectToBigDecimal(object, null);
/*  685 */     if (ret != null) {
/*  686 */       return ret;
/*      */     }
/*  688 */     throw wrongValueFormatException(key, "BigDecimal", object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDouble(String key) throws JSONException {
/*  702 */     Object object = get(key);
/*  703 */     if (object instanceof Number) {
/*  704 */       return ((Number)object).doubleValue();
/*      */     }
/*      */     try {
/*  707 */       return Double.parseDouble(object.toString());
/*  708 */     } catch (Exception e) {
/*  709 */       throw wrongValueFormatException(key, "double", object, e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloat(String key) throws JSONException {
/*  724 */     Object object = get(key);
/*  725 */     if (object instanceof Number) {
/*  726 */       return ((Number)object).floatValue();
/*      */     }
/*      */     try {
/*  729 */       return Float.parseFloat(object.toString());
/*  730 */     } catch (Exception e) {
/*  731 */       throw wrongValueFormatException(key, "float", object, e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Number getNumber(String key) throws JSONException {
/*  746 */     Object object = get(key);
/*      */     try {
/*  748 */       if (object instanceof Number) {
/*  749 */         return (Number)object;
/*      */       }
/*  751 */       return stringToNumber(object.toString());
/*  752 */     } catch (Exception e) {
/*  753 */       throw wrongValueFormatException(key, "number", object, e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInt(String key) throws JSONException {
/*  768 */     Object object = get(key);
/*  769 */     if (object instanceof Number) {
/*  770 */       return ((Number)object).intValue();
/*      */     }
/*      */     try {
/*  773 */       return Integer.parseInt(object.toString());
/*  774 */     } catch (Exception e) {
/*  775 */       throw wrongValueFormatException(key, "int", object, e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray getJSONArray(String key) throws JSONException {
/*  789 */     Object object = get(key);
/*  790 */     if (object instanceof JSONArray) {
/*  791 */       return (JSONArray)object;
/*      */     }
/*  793 */     throw wrongValueFormatException(key, "JSONArray", object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject getJSONObject(String key) throws JSONException {
/*  806 */     Object object = get(key);
/*  807 */     if (object instanceof JSONObject) {
/*  808 */       return (JSONObject)object;
/*      */     }
/*  810 */     throw wrongValueFormatException(key, "JSONObject", object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLong(String key) throws JSONException {
/*  824 */     Object object = get(key);
/*  825 */     if (object instanceof Number) {
/*  826 */       return ((Number)object).longValue();
/*      */     }
/*      */     try {
/*  829 */       return Long.parseLong(object.toString());
/*  830 */     } catch (Exception e) {
/*  831 */       throw wrongValueFormatException(key, "long", object, e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] getNames(JSONObject jo) {
/*  843 */     if (jo.isEmpty()) {
/*  844 */       return null;
/*      */     }
/*  846 */     return jo.keySet().<String>toArray(new String[jo.length()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] getNames(Object object) {
/*  857 */     if (object == null) {
/*  858 */       return null;
/*      */     }
/*  860 */     Class<?> klass = object.getClass();
/*  861 */     Field[] fields = klass.getFields();
/*  862 */     int length = fields.length;
/*  863 */     if (length == 0) {
/*  864 */       return null;
/*      */     }
/*  866 */     String[] names = new String[length];
/*  867 */     for (int i = 0; i < length; i++) {
/*  868 */       names[i] = fields[i].getName();
/*      */     }
/*  870 */     return names;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(String key) throws JSONException {
/*  883 */     Object object = get(key);
/*  884 */     if (object instanceof String) {
/*  885 */       return (String)object;
/*      */     }
/*  887 */     throw wrongValueFormatException(key, "string", object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean has(String key) {
/*  898 */     return this.map.containsKey(key);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject increment(String key) throws JSONException {
/*  917 */     Object value = opt(key);
/*  918 */     if (value == null) {
/*  919 */       put(key, 1);
/*  920 */     } else if (value instanceof Integer) {
/*  921 */       put(key, ((Integer)value).intValue() + 1);
/*  922 */     } else if (value instanceof Long) {
/*  923 */       put(key, ((Long)value).longValue() + 1L);
/*  924 */     } else if (value instanceof BigInteger) {
/*  925 */       put(key, ((BigInteger)value).add(BigInteger.ONE));
/*  926 */     } else if (value instanceof Float) {
/*  927 */       put(key, ((Float)value).floatValue() + 1.0F);
/*  928 */     } else if (value instanceof Double) {
/*  929 */       put(key, ((Double)value).doubleValue() + 1.0D);
/*  930 */     } else if (value instanceof BigDecimal) {
/*  931 */       put(key, ((BigDecimal)value).add(BigDecimal.ONE));
/*      */     } else {
/*  933 */       throw new JSONException("Unable to increment [" + quote(key) + "].");
/*      */     } 
/*  935 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNull(String key) {
/*  948 */     return NULL.equals(opt(key));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<String> keys() {
/*  960 */     return keySet().iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> keySet() {
/*  972 */     return this.map.keySet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Set<Map.Entry<String, Object>> entrySet() {
/*  988 */     return this.map.entrySet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  997 */     return this.map.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/* 1005 */     this.map.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/* 1014 */     return this.map.isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray names() {
/* 1025 */     if (this.map.isEmpty()) {
/* 1026 */       return null;
/*      */     }
/* 1028 */     return new JSONArray(this.map.keySet());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String numberToString(Number number) throws JSONException {
/* 1041 */     if (number == null) {
/* 1042 */       throw new JSONException("Null pointer");
/*      */     }
/* 1044 */     testValidity(number);
/*      */ 
/*      */ 
/*      */     
/* 1048 */     String string = number.toString();
/* 1049 */     if (string.indexOf('.') > 0 && string.indexOf('e') < 0 && string
/* 1050 */       .indexOf('E') < 0) {
/* 1051 */       while (string.endsWith("0")) {
/* 1052 */         string = string.substring(0, string.length() - 1);
/*      */       }
/* 1054 */       if (string.endsWith(".")) {
/* 1055 */         string = string.substring(0, string.length() - 1);
/*      */       }
/*      */     } 
/* 1058 */     return string;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object opt(String key) {
/* 1069 */     return (key == null) ? null : this.map.get(key);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <E extends Enum<E>> E optEnum(Class<E> clazz, String key) {
/* 1084 */     return optEnum(clazz, key, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <E extends Enum<E>> E optEnum(Class<E> clazz, String key, E defaultValue) {
/*      */     try {
/* 1103 */       Object val = opt(key);
/* 1104 */       if (NULL.equals(val)) {
/* 1105 */         return defaultValue;
/*      */       }
/* 1107 */       if (clazz.isAssignableFrom(val.getClass()))
/*      */       {
/*      */         
/* 1110 */         return (E)val;
/*      */       }
/*      */       
/* 1113 */       return Enum.valueOf(clazz, val.toString());
/* 1114 */     } catch (IllegalArgumentException e) {
/* 1115 */       return defaultValue;
/* 1116 */     } catch (NullPointerException e) {
/* 1117 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean optBoolean(String key) {
/* 1130 */     return optBoolean(key, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean optBoolean(String key, boolean defaultValue) {
/* 1145 */     Object val = opt(key);
/* 1146 */     if (NULL.equals(val)) {
/* 1147 */       return defaultValue;
/*      */     }
/* 1149 */     if (val instanceof Boolean) {
/* 1150 */       return ((Boolean)val).booleanValue();
/*      */     }
/*      */     
/*      */     try {
/* 1154 */       return getBoolean(key);
/* 1155 */     } catch (Exception e) {
/* 1156 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Boolean optBooleanObject(String key) {
/* 1169 */     return optBooleanObject(key, Boolean.valueOf(false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Boolean optBooleanObject(String key, Boolean defaultValue) {
/* 1184 */     Object val = opt(key);
/* 1185 */     if (NULL.equals(val)) {
/* 1186 */       return defaultValue;
/*      */     }
/* 1188 */     if (val instanceof Boolean) {
/* 1189 */       return Boolean.valueOf(((Boolean)val).booleanValue());
/*      */     }
/*      */     
/*      */     try {
/* 1193 */       return Boolean.valueOf(getBoolean(key));
/* 1194 */     } catch (Exception e) {
/* 1195 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal optBigDecimal(String key, BigDecimal defaultValue) {
/* 1214 */     Object val = opt(key);
/* 1215 */     return objectToBigDecimal(val, defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static BigDecimal objectToBigDecimal(Object val, BigDecimal defaultValue) {
/* 1225 */     return objectToBigDecimal(val, defaultValue, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static BigDecimal objectToBigDecimal(Object val, BigDecimal defaultValue, boolean exact) {
/* 1237 */     if (NULL.equals(val)) {
/* 1238 */       return defaultValue;
/*      */     }
/* 1240 */     if (val instanceof BigDecimal) {
/* 1241 */       return (BigDecimal)val;
/*      */     }
/* 1243 */     if (val instanceof BigInteger) {
/* 1244 */       return new BigDecimal((BigInteger)val);
/*      */     }
/* 1246 */     if (val instanceof Double || val instanceof Float) {
/* 1247 */       if (!numberIsFinite((Number)val)) {
/* 1248 */         return defaultValue;
/*      */       }
/* 1250 */       if (exact) {
/* 1251 */         return new BigDecimal(((Number)val).doubleValue());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1256 */       return new BigDecimal(val.toString());
/*      */     } 
/* 1258 */     if (val instanceof Long || val instanceof Integer || val instanceof Short || val instanceof Byte)
/*      */     {
/* 1260 */       return new BigDecimal(((Number)val).longValue());
/*      */     }
/*      */     
/*      */     try {
/* 1264 */       return new BigDecimal(val.toString());
/* 1265 */     } catch (Exception e) {
/* 1266 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger optBigInteger(String key, BigInteger defaultValue) {
/* 1282 */     Object val = opt(key);
/* 1283 */     return objectToBigInteger(val, defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static BigInteger objectToBigInteger(Object val, BigInteger defaultValue) {
/* 1293 */     if (NULL.equals(val)) {
/* 1294 */       return defaultValue;
/*      */     }
/* 1296 */     if (val instanceof BigInteger) {
/* 1297 */       return (BigInteger)val;
/*      */     }
/* 1299 */     if (val instanceof BigDecimal) {
/* 1300 */       return ((BigDecimal)val).toBigInteger();
/*      */     }
/* 1302 */     if (val instanceof Double || val instanceof Float) {
/* 1303 */       if (!numberIsFinite((Number)val)) {
/* 1304 */         return defaultValue;
/*      */       }
/* 1306 */       return (new BigDecimal(((Number)val).doubleValue())).toBigInteger();
/*      */     } 
/* 1308 */     if (val instanceof Long || val instanceof Integer || val instanceof Short || val instanceof Byte)
/*      */     {
/* 1310 */       return BigInteger.valueOf(((Number)val).longValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1319 */       String valStr = val.toString();
/* 1320 */       if (isDecimalNotation(valStr)) {
/* 1321 */         return (new BigDecimal(valStr)).toBigInteger();
/*      */       }
/* 1323 */       return new BigInteger(valStr);
/* 1324 */     } catch (Exception e) {
/* 1325 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double optDouble(String key) {
/* 1339 */     return optDouble(key, Double.NaN);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double optDouble(String key, double defaultValue) {
/* 1354 */     Number val = optNumber(key);
/* 1355 */     if (val == null) {
/* 1356 */       return defaultValue;
/*      */     }
/* 1358 */     return val.doubleValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Double optDoubleObject(String key) {
/* 1371 */     return optDoubleObject(key, Double.valueOf(Double.NaN));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Double optDoubleObject(String key, Double defaultValue) {
/* 1386 */     Number val = optNumber(key);
/* 1387 */     if (val == null) {
/* 1388 */       return defaultValue;
/*      */     }
/* 1390 */     return Double.valueOf(val.doubleValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float optFloat(String key) {
/* 1403 */     return optFloat(key, Float.NaN);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float optFloat(String key, float defaultValue) {
/* 1418 */     Number val = optNumber(key);
/* 1419 */     if (val == null) {
/* 1420 */       return defaultValue;
/*      */     }
/* 1422 */     float floatValue = val.floatValue();
/*      */ 
/*      */ 
/*      */     
/* 1426 */     return floatValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Float optFloatObject(String key) {
/* 1439 */     return optFloatObject(key, Float.valueOf(Float.NaN));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Float optFloatObject(String key, Float defaultValue) {
/* 1454 */     Number val = optNumber(key);
/* 1455 */     if (val == null) {
/* 1456 */       return defaultValue;
/*      */     }
/* 1458 */     Float floatValue = Float.valueOf(val.floatValue());
/*      */ 
/*      */ 
/*      */     
/* 1462 */     return floatValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int optInt(String key) {
/* 1475 */     return optInt(key, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int optInt(String key, int defaultValue) {
/* 1490 */     Number val = optNumber(key, null);
/* 1491 */     if (val == null) {
/* 1492 */       return defaultValue;
/*      */     }
/* 1494 */     return val.intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Integer optIntegerObject(String key) {
/* 1507 */     return optIntegerObject(key, Integer.valueOf(0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Integer optIntegerObject(String key, Integer defaultValue) {
/* 1522 */     Number val = optNumber(key, null);
/* 1523 */     if (val == null) {
/* 1524 */       return defaultValue;
/*      */     }
/* 1526 */     return Integer.valueOf(val.intValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray optJSONArray(String key) {
/* 1538 */     return optJSONArray(key, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray optJSONArray(String key, JSONArray defaultValue) {
/* 1552 */     Object object = opt(key);
/* 1553 */     return (object instanceof JSONArray) ? (JSONArray)object : defaultValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject optJSONObject(String key) {
/* 1564 */     return optJSONObject(key, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject optJSONObject(String key, JSONObject defaultValue) {
/* 1577 */     Object object = opt(key);
/* 1578 */     return (object instanceof JSONObject) ? (JSONObject)object : defaultValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long optLong(String key) {
/* 1591 */     return optLong(key, 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long optLong(String key, long defaultValue) {
/* 1606 */     Number val = optNumber(key, null);
/* 1607 */     if (val == null) {
/* 1608 */       return defaultValue;
/*      */     }
/*      */     
/* 1611 */     return val.longValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Long optLongObject(String key) {
/* 1624 */     return optLongObject(key, Long.valueOf(0L));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Long optLongObject(String key, Long defaultValue) {
/* 1639 */     Number val = optNumber(key, null);
/* 1640 */     if (val == null) {
/* 1641 */       return defaultValue;
/*      */     }
/*      */     
/* 1644 */     return Long.valueOf(val.longValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Number optNumber(String key) {
/* 1658 */     return optNumber(key, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Number optNumber(String key, Number defaultValue) {
/* 1674 */     Object val = opt(key);
/* 1675 */     if (NULL.equals(val)) {
/* 1676 */       return defaultValue;
/*      */     }
/* 1678 */     if (val instanceof Number) {
/* 1679 */       return (Number)val;
/*      */     }
/*      */     
/*      */     try {
/* 1683 */       return stringToNumber(val.toString());
/* 1684 */     } catch (Exception e) {
/* 1685 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String optString(String key) {
/* 1699 */     return optString(key, "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String optString(String key, String defaultValue) {
/* 1713 */     Object object = opt(key);
/* 1714 */     return NULL.equals(object) ? defaultValue : object.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void populateMap(Object bean) {
/* 1729 */     populateMap(bean, Collections.newSetFromMap(new IdentityHashMap<>()));
/*      */   }
/*      */   
/*      */   private void populateMap(Object bean, Set<Object> objectsRecord) {
/* 1733 */     Class<?> klass = bean.getClass();
/*      */ 
/*      */ 
/*      */     
/* 1737 */     boolean includeSuperClass = (klass.getClassLoader() != null);
/*      */     
/* 1739 */     Method[] methods = includeSuperClass ? klass.getMethods() : klass.getDeclaredMethods();
/* 1740 */     for (Method method : methods) {
/* 1741 */       int modifiers = method.getModifiers();
/* 1742 */       if (Modifier.isPublic(modifiers) && 
/* 1743 */         !Modifier.isStatic(modifiers) && (method
/* 1744 */         .getParameterTypes()).length == 0 && 
/* 1745 */         !method.isBridge() && method
/* 1746 */         .getReturnType() != void.class && 
/* 1747 */         isValidMethodName(method.getName())) {
/* 1748 */         String key = getKeyNameFromMethod(method);
/* 1749 */         if (key != null && !key.isEmpty()) {
/*      */           
/* 1751 */           try { Object result = method.invoke(bean, new Object[0]);
/* 1752 */             if (result != null)
/*      */             {
/*      */ 
/*      */               
/* 1756 */               if (objectsRecord.contains(result)) {
/* 1757 */                 throw recursivelyDefinedObjectException(key);
/*      */               }
/*      */               
/* 1760 */               objectsRecord.add(result);
/*      */               
/* 1762 */               testValidity(result);
/* 1763 */               this.map.put(key, wrap(result, objectsRecord));
/*      */               
/* 1765 */               objectsRecord.remove(result);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1770 */               if (result instanceof Closeable) {
/*      */                 try {
/* 1772 */                   ((Closeable)result).close();
/* 1773 */                 } catch (IOException iOException) {}
/*      */               }
/*      */             }
/*      */              }
/* 1777 */           catch (IllegalAccessException illegalAccessException) {  }
/* 1778 */           catch (IllegalArgumentException illegalArgumentException) {  }
/* 1779 */           catch (InvocationTargetException invocationTargetException) {}
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isValidMethodName(String name) {
/* 1787 */     return (!"getClass".equals(name) && !"getDeclaringClass".equals(name));
/*      */   }
/*      */   private static String getKeyNameFromMethod(Method method) {
/*      */     String key;
/* 1791 */     int ignoreDepth = getAnnotationDepth(method, (Class)JSONPropertyIgnore.class);
/* 1792 */     if (ignoreDepth > 0) {
/* 1793 */       int forcedNameDepth = getAnnotationDepth(method, (Class)JSONPropertyName.class);
/* 1794 */       if (forcedNameDepth < 0 || ignoreDepth <= forcedNameDepth)
/*      */       {
/*      */         
/* 1797 */         return null;
/*      */       }
/*      */     } 
/* 1800 */     JSONPropertyName annotation = getAnnotation(method, JSONPropertyName.class);
/* 1801 */     if (annotation != null && annotation.value() != null && !annotation.value().isEmpty()) {
/* 1802 */       return annotation.value();
/*      */     }
/*      */     
/* 1805 */     String name = method.getName();
/* 1806 */     if (name.startsWith("get") && name.length() > 3) {
/* 1807 */       key = name.substring(3);
/* 1808 */     } else if (name.startsWith("is") && name.length() > 2) {
/* 1809 */       key = name.substring(2);
/*      */     } else {
/* 1811 */       return null;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1816 */     if (key.length() == 0 || Character.isLowerCase(key.charAt(0))) {
/* 1817 */       return null;
/*      */     }
/* 1819 */     if (key.length() == 1) {
/* 1820 */       key = key.toLowerCase(Locale.ROOT);
/* 1821 */     } else if (!Character.isUpperCase(key.charAt(1))) {
/* 1822 */       key = key.substring(0, 1).toLowerCase(Locale.ROOT) + key.substring(1);
/*      */     } 
/* 1824 */     return key;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <A extends Annotation> A getAnnotation(Method m, Class<A> annotationClass) {
/* 1843 */     if (m == null || annotationClass == null) {
/* 1844 */       return null;
/*      */     }
/*      */     
/* 1847 */     if (m.isAnnotationPresent(annotationClass)) {
/* 1848 */       return m.getAnnotation(annotationClass);
/*      */     }
/*      */ 
/*      */     
/* 1852 */     Class<?> c = m.getDeclaringClass();
/* 1853 */     if (c.getSuperclass() == null) {
/* 1854 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1858 */     for (Class<?> i : c.getInterfaces()) {
/*      */       try {
/* 1860 */         Method im = i.getMethod(m.getName(), m.getParameterTypes());
/* 1861 */         return getAnnotation(im, annotationClass);
/* 1862 */       } catch (SecurityException ex) {
/*      */       
/* 1864 */       } catch (NoSuchMethodException ex) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1870 */     if (c.getSuperclass().equals(Object.class)) {
/* 1871 */       return null;
/*      */     }
/*      */     try {
/* 1874 */       return getAnnotation(c
/* 1875 */           .getSuperclass().getMethod(m.getName(), m.getParameterTypes()), annotationClass);
/*      */     }
/* 1877 */     catch (SecurityException ex) {
/* 1878 */       return null;
/* 1879 */     } catch (NoSuchMethodException ex) {
/* 1880 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int getAnnotationDepth(Method m, Class<? extends Annotation> annotationClass) {
/* 1897 */     if (m == null || annotationClass == null) {
/* 1898 */       return -1;
/*      */     }
/*      */     
/* 1901 */     if (m.isAnnotationPresent(annotationClass)) {
/* 1902 */       return 1;
/*      */     }
/*      */ 
/*      */     
/* 1906 */     Class<?> c = m.getDeclaringClass();
/* 1907 */     if (c.getSuperclass() == null) {
/* 1908 */       return -1;
/*      */     }
/*      */ 
/*      */     
/* 1912 */     for (Class<?> i : c.getInterfaces()) {
/*      */       try {
/* 1914 */         Method im = i.getMethod(m.getName(), m.getParameterTypes());
/* 1915 */         int d = getAnnotationDepth(im, annotationClass);
/* 1916 */         if (d > 0)
/*      */         {
/* 1918 */           return d + 1;
/*      */         }
/* 1920 */       } catch (SecurityException ex) {
/*      */       
/* 1922 */       } catch (NoSuchMethodException ex) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1928 */     if (c.getSuperclass().equals(Object.class)) {
/* 1929 */       return -1;
/*      */     }
/*      */     try {
/* 1932 */       int d = getAnnotationDepth(c
/* 1933 */           .getSuperclass().getMethod(m.getName(), m.getParameterTypes()), annotationClass);
/*      */       
/* 1935 */       if (d > 0)
/*      */       {
/* 1937 */         return d + 1;
/*      */       }
/* 1939 */       return -1;
/* 1940 */     } catch (SecurityException ex) {
/* 1941 */       return -1;
/* 1942 */     } catch (NoSuchMethodException ex) {
/* 1943 */       return -1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, boolean value) throws JSONException {
/* 1961 */     return put(key, value ? Boolean.TRUE : Boolean.FALSE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, Collection<?> value) throws JSONException {
/* 1979 */     return put(key, new JSONArray(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, double value) throws JSONException {
/* 1996 */     return put(key, Double.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, float value) throws JSONException {
/* 2013 */     return put(key, Float.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, int value) throws JSONException {
/* 2030 */     return put(key, Integer.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, long value) throws JSONException {
/* 2047 */     return put(key, Long.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, Map<?, ?> value) throws JSONException {
/* 2065 */     return put(key, new JSONObject(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject put(String key, Object value) throws JSONException {
/* 2085 */     if (key == null) {
/* 2086 */       throw new NullPointerException("Null key.");
/*      */     }
/* 2088 */     if (value != null) {
/* 2089 */       testValidity(value);
/* 2090 */       this.map.put(key, value);
/*      */     } else {
/* 2092 */       remove(key);
/*      */     } 
/* 2094 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject putOnce(String key, Object value) throws JSONException {
/* 2111 */     if (key != null && value != null) {
/* 2112 */       if (opt(key) != null) {
/* 2113 */         throw new JSONException("Duplicate key \"" + key + "\"");
/*      */       }
/* 2115 */       return put(key, value);
/*      */     } 
/* 2117 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject putOpt(String key, Object value) throws JSONException {
/* 2135 */     if (key != null && value != null) {
/* 2136 */       return put(key, value);
/*      */     }
/* 2138 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object query(String jsonPointer) {
/* 2161 */     return query(new JSONPointer(jsonPointer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object query(JSONPointer jsonPointer) {
/* 2183 */     return jsonPointer.queryFrom(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object optQuery(String jsonPointer) {
/* 2195 */     return optQuery(new JSONPointer(jsonPointer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object optQuery(JSONPointer jsonPointer) {
/*      */     try {
/* 2208 */       return jsonPointer.queryFrom(this);
/* 2209 */     } catch (JSONPointerException e) {
/* 2210 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quote(String string) {
/* 2227 */     StringWriter sw = new StringWriter();
/*      */     try {
/* 2229 */       return quote(string, sw).toString();
/* 2230 */     } catch (IOException ignored) {
/*      */       
/* 2232 */       return "";
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Writer quote(String string, Writer w) throws IOException {
/* 2245 */     if (string == null || string.isEmpty()) {
/* 2246 */       w.write("\"\"");
/* 2247 */       return w;
/*      */     } 
/*      */ 
/*      */     
/* 2251 */     char c = Character.MIN_VALUE;
/*      */ 
/*      */     
/* 2254 */     int len = string.length();
/*      */     
/* 2256 */     w.write(34);
/* 2257 */     for (int i = 0; i < len; i++) {
/* 2258 */       char b = c;
/* 2259 */       c = string.charAt(i);
/* 2260 */       switch (c) {
/*      */         case '"':
/*      */         case '\\':
/* 2263 */           w.write(92);
/* 2264 */           w.write(c);
/*      */           break;
/*      */         case '/':
/* 2267 */           if (b == '<') {
/* 2268 */             w.write(92);
/*      */           }
/* 2270 */           w.write(c);
/*      */           break;
/*      */         case '\b':
/* 2273 */           w.write("\\b");
/*      */           break;
/*      */         case '\t':
/* 2276 */           w.write("\\t");
/*      */           break;
/*      */         case '\n':
/* 2279 */           w.write("\\n");
/*      */           break;
/*      */         case '\f':
/* 2282 */           w.write("\\f");
/*      */           break;
/*      */         case '\r':
/* 2285 */           w.write("\\r");
/*      */           break;
/*      */         default:
/* 2288 */           if (c < ' ' || (c >= '' && c < ' ') || (c >= ' ' && c < '℀')) {
/*      */             
/* 2290 */             w.write("\\u");
/* 2291 */             String hhhh = Integer.toHexString(c);
/* 2292 */             w.write("0000", 0, 4 - hhhh.length());
/* 2293 */             w.write(hhhh); break;
/*      */           } 
/* 2295 */           w.write(c);
/*      */           break;
/*      */       } 
/*      */     } 
/* 2299 */     w.write(34);
/* 2300 */     return w;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object remove(String key) {
/* 2312 */     return this.map.remove(key);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean similar(Object other) {
/*      */     try {
/* 2325 */       if (!(other instanceof JSONObject)) {
/* 2326 */         return false;
/*      */       }
/* 2328 */       if (!keySet().equals(((JSONObject)other).keySet())) {
/* 2329 */         return false;
/*      */       }
/* 2331 */       for (Map.Entry<String, ?> entry : entrySet()) {
/* 2332 */         String name = entry.getKey();
/* 2333 */         Object valueThis = entry.getValue();
/* 2334 */         Object valueOther = ((JSONObject)other).get(name);
/* 2335 */         if (valueThis == valueOther) {
/*      */           continue;
/*      */         }
/* 2338 */         if (valueThis == null) {
/* 2339 */           return false;
/*      */         }
/* 2341 */         if (valueThis instanceof JSONObject) {
/* 2342 */           if (!((JSONObject)valueThis).similar(valueOther))
/* 2343 */             return false;  continue;
/*      */         } 
/* 2345 */         if (valueThis instanceof JSONArray) {
/* 2346 */           if (!((JSONArray)valueThis).similar(valueOther))
/* 2347 */             return false;  continue;
/*      */         } 
/* 2349 */         if (valueThis instanceof Number && valueOther instanceof Number) {
/* 2350 */           if (!isNumberSimilar((Number)valueThis, (Number)valueOther))
/* 2351 */             return false;  continue;
/*      */         } 
/* 2353 */         if (valueThis instanceof JSONString && valueOther instanceof JSONString) {
/* 2354 */           if (!((JSONString)valueThis).toJSONString().equals(((JSONString)valueOther).toJSONString()))
/* 2355 */             return false;  continue;
/*      */         } 
/* 2357 */         if (!valueThis.equals(valueOther)) {
/* 2358 */           return false;
/*      */         }
/*      */       } 
/* 2361 */       return true;
/* 2362 */     } catch (Throwable exception) {
/* 2363 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isNumberSimilar(Number l, Number r) {
/* 2383 */     if (!numberIsFinite(l) || !numberIsFinite(r))
/*      */     {
/* 2385 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2390 */     if (l.getClass().equals(r.getClass()) && l instanceof Comparable) {
/*      */       
/* 2392 */       int compareTo = ((Comparable<Number>)l).compareTo(r);
/* 2393 */       return (compareTo == 0);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2399 */     BigDecimal lBigDecimal = objectToBigDecimal(l, null, false);
/* 2400 */     BigDecimal rBigDecimal = objectToBigDecimal(r, null, false);
/* 2401 */     if (lBigDecimal == null || rBigDecimal == null) {
/* 2402 */       return false;
/*      */     }
/* 2404 */     return (lBigDecimal.compareTo(rBigDecimal) == 0);
/*      */   }
/*      */   
/*      */   private static boolean numberIsFinite(Number n) {
/* 2408 */     if (n instanceof Double && (((Double)n).isInfinite() || ((Double)n).isNaN()))
/* 2409 */       return false; 
/* 2410 */     if (n instanceof Float && (((Float)n).isInfinite() || ((Float)n).isNaN())) {
/* 2411 */       return false;
/*      */     }
/* 2413 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean isDecimalNotation(String val) {
/* 2423 */     return (val.indexOf('.') > -1 || val.indexOf('e') > -1 || val
/* 2424 */       .indexOf('E') > -1 || "-0".equals(val));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object stringToValue(String string) {
/* 2440 */     if ("".equals(string)) {
/* 2441 */       return string;
/*      */     }
/*      */ 
/*      */     
/* 2445 */     if ("true".equalsIgnoreCase(string)) {
/* 2446 */       return Boolean.TRUE;
/*      */     }
/* 2448 */     if ("false".equalsIgnoreCase(string)) {
/* 2449 */       return Boolean.FALSE;
/*      */     }
/* 2451 */     if ("null".equalsIgnoreCase(string)) {
/* 2452 */       return NULL;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2460 */     char initial = string.charAt(0);
/* 2461 */     if ((initial >= '0' && initial <= '9') || initial == '-') {
/*      */       try {
/* 2463 */         return stringToNumber(string);
/* 2464 */       } catch (Exception exception) {}
/*      */     }
/*      */     
/* 2467 */     return string;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static Number stringToNumber(String val) throws NumberFormatException {
/* 2481 */     char initial = val.charAt(0);
/* 2482 */     if ((initial >= '0' && initial <= '9') || initial == '-') {
/*      */       
/* 2484 */       if (isDecimalNotation(val)) {
/*      */         
/*      */         try {
/*      */ 
/*      */           
/* 2489 */           BigDecimal bd = new BigDecimal(val);
/* 2490 */           if (initial == '-' && BigDecimal.ZERO.compareTo(bd) == 0) {
/* 2491 */             return Double.valueOf(-0.0D);
/*      */           }
/* 2493 */           return bd;
/* 2494 */         } catch (NumberFormatException retryAsDouble) {
/*      */           
/*      */           try {
/* 2497 */             Double d = Double.valueOf(val);
/* 2498 */             if (d.isNaN() || d.isInfinite()) {
/* 2499 */               throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */             }
/* 2501 */             return d;
/* 2502 */           } catch (NumberFormatException ignore) {
/* 2503 */             throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/* 2508 */       if (initial == '0' && val.length() > 1) {
/* 2509 */         char at1 = val.charAt(1);
/* 2510 */         if (at1 >= '0' && at1 <= '9') {
/* 2511 */           throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */         }
/* 2513 */       } else if (initial == '-' && val.length() > 2) {
/* 2514 */         char at1 = val.charAt(1);
/* 2515 */         char at2 = val.charAt(2);
/* 2516 */         if (at1 == '0' && at2 >= '0' && at2 <= '9') {
/* 2517 */           throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2528 */       BigInteger bi = new BigInteger(val);
/* 2529 */       if (bi.bitLength() <= 31) {
/* 2530 */         return Integer.valueOf(bi.intValue());
/*      */       }
/* 2532 */       if (bi.bitLength() <= 63) {
/* 2533 */         return Long.valueOf(bi.longValue());
/*      */       }
/* 2535 */       return bi;
/*      */     } 
/* 2537 */     throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void testValidity(Object o) throws JSONException {
/* 2549 */     if (o instanceof Number && !numberIsFinite((Number)o)) {
/* 2550 */       throw new JSONException("JSON does not allow non-finite numbers.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray toJSONArray(JSONArray names) throws JSONException {
/* 2566 */     if (names == null || names.isEmpty()) {
/* 2567 */       return null;
/*      */     }
/* 2569 */     JSONArray ja = new JSONArray();
/* 2570 */     for (int i = 0; i < names.length(); i++) {
/* 2571 */       ja.put(opt(names.getString(i)));
/*      */     }
/* 2573 */     return ja;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*      */     try {
/* 2592 */       return toString(0);
/* 2593 */     } catch (Exception e) {
/* 2594 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString(int indentFactor) throws JSONException {
/* 2626 */     StringWriter w = new StringWriter();
/* 2627 */     return write(w, indentFactor, 0).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String valueToString(Object value) throws JSONException {
/* 2659 */     return JSONWriter.valueToString(value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object wrap(Object object) {
/* 2675 */     return wrap(object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Object wrap(Object object, int recursionDepth, JSONParserConfiguration jsonParserConfiguration) {
/* 2695 */     return wrap(object, null, recursionDepth, jsonParserConfiguration);
/*      */   }
/*      */   
/*      */   private static Object wrap(Object object, Set<Object> objectsRecord) {
/* 2699 */     return wrap(object, objectsRecord, 0, new JSONParserConfiguration());
/*      */   }
/*      */   
/*      */   private static Object wrap(Object object, Set<Object> objectsRecord, int recursionDepth, JSONParserConfiguration jsonParserConfiguration) {
/*      */     try {
/* 2704 */       if (NULL.equals(object)) {
/* 2705 */         return NULL;
/*      */       }
/* 2707 */       if (object instanceof JSONObject || object instanceof JSONArray || NULL
/* 2708 */         .equals(object) || object instanceof JSONString || object instanceof Byte || object instanceof Character || object instanceof Short || object instanceof Integer || object instanceof Long || object instanceof Boolean || object instanceof Float || object instanceof Double || object instanceof String || object instanceof BigInteger || object instanceof BigDecimal || object instanceof Enum)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2715 */         return object;
/*      */       }
/*      */       
/* 2718 */       if (object instanceof Collection) {
/* 2719 */         Collection<?> coll = (Collection)object;
/* 2720 */         return new JSONArray(coll, recursionDepth, jsonParserConfiguration);
/*      */       } 
/* 2722 */       if (object.getClass().isArray()) {
/* 2723 */         return new JSONArray(object);
/*      */       }
/* 2725 */       if (object instanceof Map) {
/* 2726 */         Map<?, ?> map = (Map<?, ?>)object;
/* 2727 */         return new JSONObject(map, recursionDepth, jsonParserConfiguration);
/*      */       } 
/* 2729 */       Package objectPackage = object.getClass().getPackage();
/*      */       
/* 2731 */       String objectPackageName = (objectPackage != null) ? objectPackage.getName() : "";
/* 2732 */       if (objectPackageName.startsWith("java.") || objectPackageName
/* 2733 */         .startsWith("javax.") || object
/* 2734 */         .getClass().getClassLoader() == null) {
/* 2735 */         return object.toString();
/*      */       }
/* 2737 */       if (objectsRecord != null) {
/* 2738 */         return new JSONObject(object, objectsRecord);
/*      */       }
/* 2740 */       return new JSONObject(object);
/*      */     }
/* 2742 */     catch (JSONException exception) {
/* 2743 */       throw exception;
/* 2744 */     } catch (Exception exception) {
/* 2745 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Writer write(Writer writer) throws JSONException {
/* 2760 */     return write(writer, 0, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static final Writer writeValue(Writer writer, Object value, int indentFactor, int indent) throws JSONException, IOException {
/* 2766 */     if (value == null || value.equals(null)) {
/* 2767 */       writer.write("null");
/* 2768 */     } else if (value instanceof JSONString) {
/*      */       Object o;
/*      */       try {
/* 2771 */         o = ((JSONString)value).toJSONString();
/* 2772 */       } catch (Exception e) {
/* 2773 */         throw new JSONException(e);
/*      */       } 
/* 2775 */       writer.write((o != null) ? o.toString() : quote(value.toString()));
/* 2776 */     } else if (value instanceof Number) {
/*      */       
/* 2778 */       String numberAsString = numberToString((Number)value);
/* 2779 */       if (NUMBER_PATTERN.matcher(numberAsString).matches()) {
/* 2780 */         writer.write(numberAsString);
/*      */       }
/*      */       else {
/*      */         
/* 2784 */         quote(numberAsString, writer);
/*      */       } 
/* 2786 */     } else if (value instanceof Boolean) {
/* 2787 */       writer.write(value.toString());
/* 2788 */     } else if (value instanceof Enum) {
/* 2789 */       writer.write(quote(((Enum)value).name()));
/* 2790 */     } else if (value instanceof JSONObject) {
/* 2791 */       ((JSONObject)value).write(writer, indentFactor, indent);
/* 2792 */     } else if (value instanceof JSONArray) {
/* 2793 */       ((JSONArray)value).write(writer, indentFactor, indent);
/* 2794 */     } else if (value instanceof Map) {
/* 2795 */       Map<?, ?> map = (Map<?, ?>)value;
/* 2796 */       (new JSONObject(map)).write(writer, indentFactor, indent);
/* 2797 */     } else if (value instanceof Collection) {
/* 2798 */       Collection<?> coll = (Collection)value;
/* 2799 */       (new JSONArray(coll)).write(writer, indentFactor, indent);
/* 2800 */     } else if (value.getClass().isArray()) {
/* 2801 */       (new JSONArray(value)).write(writer, indentFactor, indent);
/*      */     } else {
/* 2803 */       quote(value.toString(), writer);
/*      */     } 
/* 2805 */     return writer;
/*      */   }
/*      */   
/*      */   static final void indent(Writer writer, int indent) throws IOException {
/* 2809 */     for (int i = 0; i < indent; i++) {
/* 2810 */       writer.write(32);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Writer write(Writer writer, int indentFactor, int indent) throws JSONException {
/*      */     try {
/* 2845 */       boolean needsComma = false;
/* 2846 */       int length = length();
/* 2847 */       writer.write(123);
/*      */       
/* 2849 */       if (length == 1) {
/* 2850 */         Map.Entry<String, ?> entry = entrySet().iterator().next();
/* 2851 */         String key = entry.getKey();
/* 2852 */         writer.write(quote(key));
/* 2853 */         writer.write(58);
/* 2854 */         if (indentFactor > 0) {
/* 2855 */           writer.write(32);
/*      */         }
/*      */         try {
/* 2858 */           writeValue(writer, entry.getValue(), indentFactor, indent);
/* 2859 */         } catch (Exception e) {
/* 2860 */           throw new JSONException("Unable to write JSONObject value for key: " + key, e);
/*      */         } 
/* 2862 */       } else if (length != 0) {
/* 2863 */         int newIndent = indent + indentFactor;
/* 2864 */         for (Map.Entry<String, ?> entry : entrySet()) {
/* 2865 */           if (needsComma) {
/* 2866 */             writer.write(44);
/*      */           }
/* 2868 */           if (indentFactor > 0) {
/* 2869 */             writer.write(10);
/*      */           }
/* 2871 */           indent(writer, newIndent);
/* 2872 */           String key = entry.getKey();
/* 2873 */           writer.write(quote(key));
/* 2874 */           writer.write(58);
/* 2875 */           if (indentFactor > 0) {
/* 2876 */             writer.write(32);
/*      */           }
/*      */           try {
/* 2879 */             writeValue(writer, entry.getValue(), indentFactor, newIndent);
/* 2880 */           } catch (Exception e) {
/* 2881 */             throw new JSONException("Unable to write JSONObject value for key: " + key, e);
/*      */           } 
/* 2883 */           needsComma = true;
/*      */         } 
/* 2885 */         if (indentFactor > 0) {
/* 2886 */           writer.write(10);
/*      */         }
/* 2888 */         indent(writer, indent);
/*      */       } 
/* 2890 */       writer.write(125);
/* 2891 */       return writer;
/* 2892 */     } catch (IOException exception) {
/* 2893 */       throw new JSONException(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, Object> toMap() {
/* 2907 */     Map<String, Object> results = new HashMap<>();
/* 2908 */     for (Map.Entry<String, Object> entry : entrySet()) {
/*      */       Object value;
/* 2910 */       if (entry.getValue() == null || NULL.equals(entry.getValue())) {
/* 2911 */         value = null;
/* 2912 */       } else if (entry.getValue() instanceof JSONObject) {
/* 2913 */         value = ((JSONObject)entry.getValue()).toMap();
/* 2914 */       } else if (entry.getValue() instanceof JSONArray) {
/* 2915 */         value = ((JSONArray)entry.getValue()).toList();
/*      */       } else {
/* 2917 */         value = entry.getValue();
/*      */       } 
/* 2919 */       results.put(entry.getKey(), value);
/*      */     } 
/* 2921 */     return results;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static JSONException wrongValueFormatException(String key, String valueType, Object value, Throwable cause) {
/* 2936 */     if (value == null)
/*      */     {
/* 2938 */       return new JSONException("JSONObject[" + 
/* 2939 */           quote(key) + "] is not a " + valueType + " (null).", cause);
/*      */     }
/*      */ 
/*      */     
/* 2943 */     if (value instanceof Map || value instanceof Iterable || value instanceof JSONObject) {
/* 2944 */       return new JSONException("JSONObject[" + 
/* 2945 */           quote(key) + "] is not a " + valueType + " (" + value.getClass() + ").", cause);
/*      */     }
/*      */     
/* 2948 */     return new JSONException("JSONObject[" + 
/* 2949 */         quote(key) + "] is not a " + valueType + " (" + value.getClass() + " : " + value + ").", cause);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static JSONException recursivelyDefinedObjectException(String key) {
/* 2959 */     return new JSONException("JavaBean object contains recursively defined member variable of key " + 
/* 2960 */         quote(key));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String removeLeadingZerosOfNumber(String value) {
/* 2970 */     if (value.equals("-")) return value; 
/* 2971 */     boolean negativeFirstChar = (value.charAt(0) == '-');
/* 2972 */     int counter = negativeFirstChar ? 1 : 0;
/* 2973 */     while (counter < value.length()) {
/* 2974 */       if (value.charAt(counter) != '0') {
/* 2975 */         if (negativeFirstChar) return "-".concat(value.substring(counter)); 
/* 2976 */         return value.substring(counter);
/*      */       } 
/* 2978 */       counter++;
/*      */     } 
/* 2980 */     if (negativeFirstChar) return "-0"; 
/* 2981 */     return "0";
/*      */   }
/*      */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/JSONObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */