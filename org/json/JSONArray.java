/*      */ package org.json;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.lang.reflect.Array;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JSONArray
/*      */   implements Iterable<Object>
/*      */ {
/*      */   private final ArrayList<Object> myArrayList;
/*      */   
/*      */   public JSONArray() {
/*   75 */     this.myArrayList = new ArrayList();
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
/*      */   public JSONArray(JSONTokener x) throws JSONException {
/*   87 */     this();
/*   88 */     if (x.nextClean() != '[') {
/*   89 */       throw x.syntaxError("A JSONArray text must start with '['");
/*      */     }
/*      */     
/*   92 */     char nextChar = x.nextClean();
/*   93 */     if (nextChar == '\000')
/*      */     {
/*   95 */       throw x.syntaxError("Expected a ',' or ']'");
/*      */     }
/*   97 */     if (nextChar != ']') {
/*   98 */       x.back();
/*      */       while (true) {
/*  100 */         if (x.nextClean() == ',') {
/*  101 */           x.back();
/*  102 */           this.myArrayList.add(JSONObject.NULL);
/*      */         } else {
/*  104 */           x.back();
/*  105 */           this.myArrayList.add(x.nextValue());
/*      */         } 
/*  107 */         switch (x.nextClean()) {
/*      */           
/*      */           case '\000':
/*  110 */             throw x.syntaxError("Expected a ',' or ']'");
/*      */           case ',':
/*  112 */             nextChar = x.nextClean();
/*  113 */             if (nextChar == '\000')
/*      */             {
/*  115 */               throw x.syntaxError("Expected a ',' or ']'");
/*      */             }
/*  117 */             if (nextChar == ']') {
/*      */               return;
/*      */             }
/*  120 */             x.back(); continue;
/*      */           case ']':
/*      */             return;
/*      */         }  break;
/*      */       } 
/*  125 */       throw x.syntaxError("Expected a ',' or ']'");
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
/*      */   public JSONArray(String source) throws JSONException {
/*  142 */     this(new JSONTokener(source));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray(Collection<?> collection) {
/*  152 */     this(collection, 0, new JSONParserConfiguration());
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
/*      */   public JSONArray(Collection<?> collection, JSONParserConfiguration jsonParserConfiguration) {
/*  164 */     this(collection, 0, jsonParserConfiguration);
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
/*      */   JSONArray(Collection<?> collection, int recursionDepth, JSONParserConfiguration jsonParserConfiguration) {
/*  178 */     if (recursionDepth > jsonParserConfiguration.getMaxNestingDepth()) {
/*  179 */       throw new JSONException("JSONArray has reached recursion depth limit of " + jsonParserConfiguration.getMaxNestingDepth());
/*      */     }
/*  181 */     if (collection == null) {
/*  182 */       this.myArrayList = new ArrayList();
/*      */     } else {
/*  184 */       this.myArrayList = new ArrayList(collection.size());
/*  185 */       addAll(collection, true, recursionDepth, jsonParserConfiguration);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray(Iterable<?> iter) {
/*  196 */     this();
/*  197 */     if (iter == null) {
/*      */       return;
/*      */     }
/*  200 */     addAll(iter, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray(JSONArray array) {
/*  210 */     if (array == null) {
/*  211 */       this.myArrayList = new ArrayList();
/*      */     }
/*      */     else {
/*      */       
/*  215 */       this.myArrayList = new ArrayList(array.myArrayList);
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
/*      */   public JSONArray(Object array) throws JSONException {
/*  232 */     this();
/*  233 */     if (!array.getClass().isArray()) {
/*  234 */       throw new JSONException("JSONArray initial value should be a string or collection or array.");
/*      */     }
/*      */     
/*  237 */     addAll(array, true, 0);
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
/*      */   public JSONArray(int initialCapacity) throws JSONException {
/*  249 */     if (initialCapacity < 0) {
/*  250 */       throw new JSONException("JSONArray initial capacity cannot be negative.");
/*      */     }
/*      */     
/*  253 */     this.myArrayList = new ArrayList(initialCapacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public Iterator<Object> iterator() {
/*  258 */     return this.myArrayList.iterator();
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
/*      */   public Object get(int index) throws JSONException {
/*  271 */     Object object = opt(index);
/*  272 */     if (object == null) {
/*  273 */       throw new JSONException("JSONArray[" + index + "] not found.");
/*      */     }
/*  275 */     return object;
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
/*      */   public boolean getBoolean(int index) throws JSONException {
/*  290 */     Object object = get(index);
/*  291 */     if (object.equals(Boolean.FALSE) || (object instanceof String && ((String)object)
/*      */       
/*  293 */       .equalsIgnoreCase("false")))
/*  294 */       return false; 
/*  295 */     if (object.equals(Boolean.TRUE) || (object instanceof String && ((String)object)
/*      */       
/*  297 */       .equalsIgnoreCase("true"))) {
/*  298 */       return true;
/*      */     }
/*  300 */     throw wrongValueFormatException(index, "boolean", object, null);
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
/*      */   public double getDouble(int index) throws JSONException {
/*  314 */     Object object = get(index);
/*  315 */     if (object instanceof Number) {
/*  316 */       return ((Number)object).doubleValue();
/*      */     }
/*      */     try {
/*  319 */       return Double.parseDouble(object.toString());
/*  320 */     } catch (Exception e) {
/*  321 */       throw wrongValueFormatException(index, "double", object, e);
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
/*      */   public float getFloat(int index) throws JSONException {
/*  336 */     Object object = get(index);
/*  337 */     if (object instanceof Number) {
/*  338 */       return ((Number)object).floatValue();
/*      */     }
/*      */     try {
/*  341 */       return Float.parseFloat(object.toString());
/*  342 */     } catch (Exception e) {
/*  343 */       throw wrongValueFormatException(index, "float", object, e);
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
/*      */   public Number getNumber(int index) throws JSONException {
/*  358 */     Object object = get(index);
/*      */     try {
/*  360 */       if (object instanceof Number) {
/*  361 */         return (Number)object;
/*      */       }
/*  363 */       return JSONObject.stringToNumber(object.toString());
/*  364 */     } catch (Exception e) {
/*  365 */       throw wrongValueFormatException(index, "number", object, e);
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
/*      */   public <E extends Enum<E>> E getEnum(Class<E> clazz, int index) throws JSONException {
/*  384 */     E val = optEnum(clazz, index);
/*  385 */     if (val == null)
/*      */     {
/*      */ 
/*      */       
/*  389 */       throw wrongValueFormatException(index, "enum of type " + 
/*  390 */           JSONObject.quote(clazz.getSimpleName()), opt(index), null);
/*      */     }
/*  392 */     return val;
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
/*      */   public BigDecimal getBigDecimal(int index) throws JSONException {
/*  409 */     Object object = get(index);
/*  410 */     BigDecimal val = JSONObject.objectToBigDecimal(object, null);
/*  411 */     if (val == null) {
/*  412 */       throw wrongValueFormatException(index, "BigDecimal", object, null);
/*      */     }
/*  414 */     return val;
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
/*      */   public BigInteger getBigInteger(int index) throws JSONException {
/*  428 */     Object object = get(index);
/*  429 */     BigInteger val = JSONObject.objectToBigInteger(object, null);
/*  430 */     if (val == null) {
/*  431 */       throw wrongValueFormatException(index, "BigInteger", object, null);
/*      */     }
/*  433 */     return val;
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
/*      */   public int getInt(int index) throws JSONException {
/*  446 */     Object object = get(index);
/*  447 */     if (object instanceof Number) {
/*  448 */       return ((Number)object).intValue();
/*      */     }
/*      */     try {
/*  451 */       return Integer.parseInt(object.toString());
/*  452 */     } catch (Exception e) {
/*  453 */       throw wrongValueFormatException(index, "int", object, e);
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
/*      */   public JSONArray getJSONArray(int index) throws JSONException {
/*  468 */     Object object = get(index);
/*  469 */     if (object instanceof JSONArray) {
/*  470 */       return (JSONArray)object;
/*      */     }
/*  472 */     throw wrongValueFormatException(index, "JSONArray", object, null);
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
/*      */   public JSONObject getJSONObject(int index) throws JSONException {
/*  486 */     Object object = get(index);
/*  487 */     if (object instanceof JSONObject) {
/*  488 */       return (JSONObject)object;
/*      */     }
/*  490 */     throw wrongValueFormatException(index, "JSONObject", object, null);
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
/*      */   public long getLong(int index) throws JSONException {
/*  504 */     Object object = get(index);
/*  505 */     if (object instanceof Number) {
/*  506 */       return ((Number)object).longValue();
/*      */     }
/*      */     try {
/*  509 */       return Long.parseLong(object.toString());
/*  510 */     } catch (Exception e) {
/*  511 */       throw wrongValueFormatException(index, "long", object, e);
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
/*      */   public String getString(int index) throws JSONException {
/*  525 */     Object object = get(index);
/*  526 */     if (object instanceof String) {
/*  527 */       return (String)object;
/*      */     }
/*  529 */     throw wrongValueFormatException(index, "String", object, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNull(int index) {
/*  540 */     return JSONObject.NULL.equals(opt(index));
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
/*      */   public String join(String separator) throws JSONException {
/*  555 */     int len = length();
/*  556 */     if (len == 0) {
/*  557 */       return "";
/*      */     }
/*      */ 
/*      */     
/*  561 */     StringBuilder sb = new StringBuilder(JSONObject.valueToString(this.myArrayList.get(0)));
/*      */     
/*  563 */     for (int i = 1; i < len; i++) {
/*  564 */       sb.append(separator)
/*  565 */         .append(JSONObject.valueToString(this.myArrayList.get(i)));
/*      */     }
/*  567 */     return sb.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  576 */     return this.myArrayList.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  584 */     this.myArrayList.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object opt(int index) {
/*  595 */     return (index < 0 || index >= length()) ? null : this.myArrayList
/*  596 */       .get(index);
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
/*      */   public boolean optBoolean(int index) {
/*  609 */     return optBoolean(index, false);
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
/*      */   public boolean optBoolean(int index, boolean defaultValue) {
/*      */     try {
/*  625 */       return getBoolean(index);
/*  626 */     } catch (Exception e) {
/*  627 */       return defaultValue;
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
/*      */   public Boolean optBooleanObject(int index) {
/*  641 */     return optBooleanObject(index, Boolean.valueOf(false));
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
/*      */   public Boolean optBooleanObject(int index, Boolean defaultValue) {
/*      */     try {
/*  657 */       return Boolean.valueOf(getBoolean(index));
/*  658 */     } catch (Exception e) {
/*  659 */       return defaultValue;
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
/*      */   public double optDouble(int index) {
/*  673 */     return optDouble(index, Double.NaN);
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
/*      */   public double optDouble(int index, double defaultValue) {
/*  688 */     Number val = optNumber(index, null);
/*  689 */     if (val == null) {
/*  690 */       return defaultValue;
/*      */     }
/*  692 */     double doubleValue = val.doubleValue();
/*      */ 
/*      */ 
/*      */     
/*  696 */     return doubleValue;
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
/*      */   public Double optDoubleObject(int index) {
/*  709 */     return optDoubleObject(index, Double.valueOf(Double.NaN));
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
/*      */   public Double optDoubleObject(int index, Double defaultValue) {
/*  724 */     Number val = optNumber(index, null);
/*  725 */     if (val == null) {
/*  726 */       return defaultValue;
/*      */     }
/*  728 */     Double doubleValue = Double.valueOf(val.doubleValue());
/*      */ 
/*      */ 
/*      */     
/*  732 */     return doubleValue;
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
/*      */   public float optFloat(int index) {
/*  745 */     return optFloat(index, Float.NaN);
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
/*      */   public float optFloat(int index, float defaultValue) {
/*  760 */     Number val = optNumber(index, null);
/*  761 */     if (val == null) {
/*  762 */       return defaultValue;
/*      */     }
/*  764 */     float floatValue = val.floatValue();
/*      */ 
/*      */ 
/*      */     
/*  768 */     return floatValue;
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
/*      */   public Float optFloatObject(int index) {
/*  781 */     return optFloatObject(index, Float.valueOf(Float.NaN));
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
/*      */   public Float optFloatObject(int index, Float defaultValue) {
/*  796 */     Number val = optNumber(index, null);
/*  797 */     if (val == null) {
/*  798 */       return defaultValue;
/*      */     }
/*  800 */     Float floatValue = Float.valueOf(val.floatValue());
/*      */ 
/*      */ 
/*      */     
/*  804 */     return floatValue;
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
/*      */   public int optInt(int index) {
/*  817 */     return optInt(index, 0);
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
/*      */   public int optInt(int index, int defaultValue) {
/*  832 */     Number val = optNumber(index, null);
/*  833 */     if (val == null) {
/*  834 */       return defaultValue;
/*      */     }
/*  836 */     return val.intValue();
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
/*      */   public Integer optIntegerObject(int index) {
/*  849 */     return optIntegerObject(index, Integer.valueOf(0));
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
/*      */   public Integer optIntegerObject(int index, Integer defaultValue) {
/*  864 */     Number val = optNumber(index, null);
/*  865 */     if (val == null) {
/*  866 */       return defaultValue;
/*      */     }
/*  868 */     return Integer.valueOf(val.intValue());
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
/*      */   public <E extends Enum<E>> E optEnum(Class<E> clazz, int index) {
/*  883 */     return optEnum(clazz, index, null);
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
/*      */   public <E extends Enum<E>> E optEnum(Class<E> clazz, int index, E defaultValue) {
/*      */     try {
/*  902 */       Object val = opt(index);
/*  903 */       if (JSONObject.NULL.equals(val)) {
/*  904 */         return defaultValue;
/*      */       }
/*  906 */       if (clazz.isAssignableFrom(val.getClass()))
/*      */       {
/*      */         
/*  909 */         return (E)val;
/*      */       }
/*      */       
/*  912 */       return Enum.valueOf(clazz, val.toString());
/*  913 */     } catch (IllegalArgumentException e) {
/*  914 */       return defaultValue;
/*  915 */     } catch (NullPointerException e) {
/*  916 */       return defaultValue;
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
/*      */   public BigInteger optBigInteger(int index, BigInteger defaultValue) {
/*  932 */     Object val = opt(index);
/*  933 */     return JSONObject.objectToBigInteger(val, defaultValue);
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
/*      */   public BigDecimal optBigDecimal(int index, BigDecimal defaultValue) {
/*  951 */     Object val = opt(index);
/*  952 */     return JSONObject.objectToBigDecimal(val, defaultValue);
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
/*      */   public JSONArray optJSONArray(int index) {
/*  964 */     return optJSONArray(index, null);
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
/*      */   public JSONArray optJSONArray(int index, JSONArray defaultValue) {
/*  978 */     Object object = opt(index);
/*  979 */     return (object instanceof JSONArray) ? (JSONArray)object : defaultValue;
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
/*      */   public JSONObject optJSONObject(int index) {
/*  991 */     return optJSONObject(index, null);
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
/*      */   public JSONObject optJSONObject(int index, JSONObject defaultValue) {
/* 1005 */     Object object = opt(index);
/* 1006 */     return (object instanceof JSONObject) ? (JSONObject)object : defaultValue;
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
/*      */   public long optLong(int index) {
/* 1019 */     return optLong(index, 0L);
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
/*      */   public long optLong(int index, long defaultValue) {
/* 1034 */     Number val = optNumber(index, null);
/* 1035 */     if (val == null) {
/* 1036 */       return defaultValue;
/*      */     }
/* 1038 */     return val.longValue();
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
/*      */   public Long optLongObject(int index) {
/* 1051 */     return optLongObject(index, Long.valueOf(0L));
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
/*      */   public Long optLongObject(int index, Long defaultValue) {
/* 1066 */     Number val = optNumber(index, null);
/* 1067 */     if (val == null) {
/* 1068 */       return defaultValue;
/*      */     }
/* 1070 */     return Long.valueOf(val.longValue());
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
/*      */   public Number optNumber(int index) {
/* 1084 */     return optNumber(index, null);
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
/*      */   public Number optNumber(int index, Number defaultValue) {
/* 1100 */     Object val = opt(index);
/* 1101 */     if (JSONObject.NULL.equals(val)) {
/* 1102 */       return defaultValue;
/*      */     }
/* 1104 */     if (val instanceof Number) {
/* 1105 */       return (Number)val;
/*      */     }
/*      */     
/* 1108 */     if (val instanceof String) {
/*      */       try {
/* 1110 */         return JSONObject.stringToNumber((String)val);
/* 1111 */       } catch (Exception e) {
/* 1112 */         return defaultValue;
/*      */       } 
/*      */     }
/* 1115 */     return defaultValue;
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
/*      */   public String optString(int index) {
/* 1128 */     return optString(index, "");
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
/*      */   public String optString(int index, String defaultValue) {
/* 1142 */     Object object = opt(index);
/* 1143 */     return JSONObject.NULL.equals(object) ? defaultValue : object
/* 1144 */       .toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray put(boolean value) {
/* 1155 */     return put(value ? Boolean.TRUE : Boolean.FALSE);
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
/*      */   public JSONArray put(Collection<?> value) {
/* 1169 */     return put(new JSONArray(value));
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
/*      */   public JSONArray put(double value) throws JSONException {
/* 1182 */     return put(Double.valueOf(value));
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
/*      */   public JSONArray put(float value) throws JSONException {
/* 1195 */     return put(Float.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray put(int value) {
/* 1206 */     return put(Integer.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray put(long value) {
/* 1217 */     return put(Long.valueOf(value));
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
/*      */   public JSONArray put(Map<?, ?> value) {
/* 1233 */     return put(new JSONObject(value));
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
/*      */   public JSONArray put(Object value) {
/* 1248 */     JSONObject.testValidity(value);
/* 1249 */     this.myArrayList.add(value);
/* 1250 */     return this;
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
/*      */   public JSONArray put(int index, boolean value) throws JSONException {
/* 1267 */     return put(index, value ? Boolean.TRUE : Boolean.FALSE);
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
/*      */   public JSONArray put(int index, Collection<?> value) throws JSONException {
/* 1283 */     return put(index, new JSONArray(value));
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
/*      */   public JSONArray put(int index, double value) throws JSONException {
/* 1300 */     return put(index, Double.valueOf(value));
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
/*      */   public JSONArray put(int index, float value) throws JSONException {
/* 1317 */     return put(index, Float.valueOf(value));
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
/*      */   public JSONArray put(int index, int value) throws JSONException {
/* 1334 */     return put(index, Integer.valueOf(value));
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
/*      */   public JSONArray put(int index, long value) throws JSONException {
/* 1351 */     return put(index, Long.valueOf(value));
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
/*      */   public JSONArray put(int index, Map<?, ?> value) throws JSONException {
/* 1371 */     put(index, new JSONObject(value, new JSONParserConfiguration()));
/* 1372 */     return this;
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
/*      */   public JSONArray put(int index, Map<?, ?> value, JSONParserConfiguration jsonParserConfiguration) throws JSONException {
/* 1391 */     put(index, new JSONObject(value, jsonParserConfiguration));
/* 1392 */     return this;
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
/*      */   public JSONArray put(int index, Object value) throws JSONException {
/* 1412 */     if (index < 0) {
/* 1413 */       throw new JSONException("JSONArray[" + index + "] not found.");
/*      */     }
/* 1415 */     if (index < length()) {
/* 1416 */       JSONObject.testValidity(value);
/* 1417 */       this.myArrayList.set(index, value);
/* 1418 */       return this;
/*      */     } 
/* 1420 */     if (index == length())
/*      */     {
/* 1422 */       return put(value);
/*      */     }
/*      */ 
/*      */     
/* 1426 */     this.myArrayList.ensureCapacity(index + 1);
/* 1427 */     while (index != length())
/*      */     {
/* 1429 */       this.myArrayList.add(JSONObject.NULL);
/*      */     }
/* 1431 */     return put(value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray putAll(Collection<?> collection) {
/* 1442 */     addAll(collection, false);
/* 1443 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray putAll(Iterable<?> iter) {
/* 1454 */     addAll(iter, false);
/* 1455 */     return this;
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
/*      */   public JSONArray putAll(JSONArray array) {
/* 1468 */     this.myArrayList.addAll(array.myArrayList);
/* 1469 */     return this;
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
/*      */   public JSONArray putAll(Object array) throws JSONException {
/* 1486 */     addAll(array, false);
/* 1487 */     return this;
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
/* 1510 */     return query(new JSONPointer(jsonPointer));
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
/*      */   public Object query(JSONPointer jsonPointer) {
/* 1533 */     return jsonPointer.queryFrom(this);
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
/* 1545 */     return optQuery(new JSONPointer(jsonPointer));
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
/* 1558 */       return jsonPointer.queryFrom(this);
/* 1559 */     } catch (JSONPointerException e) {
/* 1560 */       return null;
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
/*      */   public Object remove(int index) {
/* 1573 */     return (index >= 0 && index < length()) ? this.myArrayList
/* 1574 */       .remove(index) : null;
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
/* 1586 */     if (!(other instanceof JSONArray)) {
/* 1587 */       return false;
/*      */     }
/* 1589 */     int len = length();
/* 1590 */     if (len != ((JSONArray)other).length()) {
/* 1591 */       return false;
/*      */     }
/* 1593 */     for (int i = 0; i < len; i++) {
/* 1594 */       Object valueThis = this.myArrayList.get(i);
/* 1595 */       Object valueOther = ((JSONArray)other).myArrayList.get(i);
/* 1596 */       if (valueThis != valueOther) {
/*      */ 
/*      */         
/* 1599 */         if (valueThis == null) {
/* 1600 */           return false;
/*      */         }
/* 1602 */         if (valueThis instanceof JSONObject) {
/* 1603 */           if (!((JSONObject)valueThis).similar(valueOther)) {
/* 1604 */             return false;
/*      */           }
/* 1606 */         } else if (valueThis instanceof JSONArray) {
/* 1607 */           if (!((JSONArray)valueThis).similar(valueOther)) {
/* 1608 */             return false;
/*      */           }
/* 1610 */         } else if (valueThis instanceof Number && valueOther instanceof Number) {
/* 1611 */           if (!JSONObject.isNumberSimilar((Number)valueThis, (Number)valueOther)) {
/* 1612 */             return false;
/*      */           }
/* 1614 */         } else if (valueThis instanceof JSONString && valueOther instanceof JSONString) {
/* 1615 */           if (!((JSONString)valueThis).toJSONString().equals(((JSONString)valueOther).toJSONString())) {
/* 1616 */             return false;
/*      */           }
/* 1618 */         } else if (!valueThis.equals(valueOther)) {
/* 1619 */           return false;
/*      */         } 
/*      */       } 
/* 1622 */     }  return true;
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
/*      */   public JSONObject toJSONObject(JSONArray names) throws JSONException {
/* 1638 */     if (names == null || names.isEmpty() || isEmpty()) {
/* 1639 */       return null;
/*      */     }
/* 1641 */     JSONObject jo = new JSONObject(names.length());
/* 1642 */     for (int i = 0; i < names.length(); i++) {
/* 1643 */       jo.put(names.getString(i), opt(i));
/*      */     }
/* 1645 */     return jo;
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
/*      */   public String toString() {
/*      */     try {
/* 1663 */       return toString(0);
/* 1664 */     } catch (Exception e) {
/* 1665 */       return null;
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
/*      */   public String toString(int indentFactor) throws JSONException {
/* 1698 */     StringWriter sw = new StringWriter();
/* 1699 */     return write(sw, indentFactor, 0).toString();
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
/* 1713 */     return write(writer, 0, 0);
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
/*      */   public Writer write(Writer writer, int indentFactor, int indent) throws JSONException {
/*      */     try {
/* 1748 */       boolean needsComma = false;
/* 1749 */       int length = length();
/* 1750 */       writer.write(91);
/*      */       
/* 1752 */       if (length == 1) {
/*      */         try {
/* 1754 */           JSONObject.writeValue(writer, this.myArrayList.get(0), indentFactor, indent);
/*      */         }
/* 1756 */         catch (Exception e) {
/* 1757 */           throw new JSONException("Unable to write JSONArray value at index: 0", e);
/*      */         } 
/* 1759 */       } else if (length != 0) {
/* 1760 */         int newIndent = indent + indentFactor;
/*      */         
/* 1762 */         for (int i = 0; i < length; i++) {
/* 1763 */           if (needsComma) {
/* 1764 */             writer.write(44);
/*      */           }
/* 1766 */           if (indentFactor > 0) {
/* 1767 */             writer.write(10);
/*      */           }
/* 1769 */           JSONObject.indent(writer, newIndent);
/*      */           try {
/* 1771 */             JSONObject.writeValue(writer, this.myArrayList.get(i), indentFactor, newIndent);
/*      */           }
/* 1773 */           catch (Exception e) {
/* 1774 */             throw new JSONException("Unable to write JSONArray value at index: " + i, e);
/*      */           } 
/* 1776 */           needsComma = true;
/*      */         } 
/* 1778 */         if (indentFactor > 0) {
/* 1779 */           writer.write(10);
/*      */         }
/* 1781 */         JSONObject.indent(writer, indent);
/*      */       } 
/* 1783 */       writer.write(93);
/* 1784 */       return writer;
/* 1785 */     } catch (IOException e) {
/* 1786 */       throw new JSONException(e);
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
/*      */   public List<Object> toList() {
/* 1800 */     List<Object> results = new ArrayList(this.myArrayList.size());
/* 1801 */     for (Object element : this.myArrayList) {
/* 1802 */       if (element == null || JSONObject.NULL.equals(element)) {
/* 1803 */         results.add(null); continue;
/* 1804 */       }  if (element instanceof JSONArray) {
/* 1805 */         results.add(((JSONArray)element).toList()); continue;
/* 1806 */       }  if (element instanceof JSONObject) {
/* 1807 */         results.add(((JSONObject)element).toMap()); continue;
/*      */       } 
/* 1809 */       results.add(element);
/*      */     } 
/*      */     
/* 1812 */     return results;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/* 1821 */     return this.myArrayList.isEmpty();
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
/*      */   private void addAll(Collection<?> collection, boolean wrap, int recursionDepth, JSONParserConfiguration jsonParserConfiguration) {
/* 1836 */     this.myArrayList.ensureCapacity(this.myArrayList.size() + collection.size());
/* 1837 */     if (wrap) {
/* 1838 */       for (Object o : collection) {
/* 1839 */         put(JSONObject.wrap(o, recursionDepth + 1, jsonParserConfiguration));
/*      */       }
/*      */     } else {
/* 1842 */       for (Object o : collection) {
/* 1843 */         put(o);
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
/*      */   private void addAll(Iterable<?> iter, boolean wrap) {
/* 1858 */     if (wrap) {
/* 1859 */       for (Object o : iter) {
/* 1860 */         put(JSONObject.wrap(o));
/*      */       }
/*      */     } else {
/* 1863 */       for (Object o : iter) {
/* 1864 */         put(o);
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
/*      */   private void addAll(Object array, boolean wrap) throws JSONException {
/* 1883 */     addAll(array, wrap, 0);
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
/*      */   private void addAll(Object array, boolean wrap, int recursionDepth) {
/* 1900 */     addAll(array, wrap, recursionDepth, new JSONParserConfiguration());
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
/*      */   private void addAll(Object array, boolean wrap, int recursionDepth, JSONParserConfiguration jsonParserConfiguration) throws JSONException {
/* 1922 */     if (array.getClass().isArray()) {
/* 1923 */       int length = Array.getLength(array);
/* 1924 */       this.myArrayList.ensureCapacity(this.myArrayList.size() + length);
/* 1925 */       if (wrap) {
/* 1926 */         for (int i = 0; i < length; i++) {
/* 1927 */           put(JSONObject.wrap(Array.get(array, i), recursionDepth + 1, jsonParserConfiguration));
/*      */         }
/*      */       } else {
/* 1930 */         for (int i = 0; i < length; i++) {
/* 1931 */           put(Array.get(array, i));
/*      */         }
/*      */       } 
/* 1934 */     } else if (array instanceof JSONArray) {
/*      */ 
/*      */ 
/*      */       
/* 1938 */       this.myArrayList.addAll(((JSONArray)array).myArrayList);
/* 1939 */     } else if (array instanceof Collection) {
/* 1940 */       addAll(array, wrap, recursionDepth);
/* 1941 */     } else if (array instanceof Iterable) {
/* 1942 */       addAll((Iterable)array, wrap);
/*      */     } else {
/* 1944 */       throw new JSONException("JSONArray initial value should be a string or collection or array.");
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
/*      */   private static JSONException wrongValueFormatException(int idx, String valueType, Object value, Throwable cause) {
/* 1961 */     if (value == null) {
/* 1962 */       return new JSONException("JSONArray[" + idx + "] is not a " + valueType + " (null).", cause);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1967 */     if (value instanceof Map || value instanceof Iterable || value instanceof JSONObject) {
/* 1968 */       return new JSONException("JSONArray[" + idx + "] is not a " + valueType + " (" + value
/* 1969 */           .getClass() + ").", cause);
/*      */     }
/*      */     
/* 1972 */     return new JSONException("JSONArray[" + idx + "] is not a " + valueType + " (" + value
/* 1973 */         .getClass() + " : " + value + ").", cause);
/*      */   }
/*      */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/JSONArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */