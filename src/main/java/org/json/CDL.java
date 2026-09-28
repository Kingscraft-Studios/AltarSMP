/*     */ package org.json;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CDL
/*     */ {
/*     */   private static String getValue(JSONTokener x, char delimiter) throws JSONException {
/*     */     while (true) {
/*  47 */       char c = x.next();
/*  48 */       if (c != ' ' && c != '\t') {
/*  49 */         if (c == '\000')
/*  50 */           return null; 
/*  51 */         if (c == '"' || c == '\'') {
/*  52 */           char q = c;
/*  53 */           StringBuilder sb = new StringBuilder();
/*     */           while (true) {
/*  55 */             c = x.next();
/*  56 */             if (c == q) {
/*     */               
/*  58 */               char nextC = x.next();
/*  59 */               if (nextC != '"') {
/*     */                 
/*  61 */                 if (nextC > '\000') {
/*  62 */                   x.back();
/*     */                 }
/*     */                 break;
/*     */               } 
/*     */             } 
/*  67 */             if (c == '\000' || c == '\n' || c == '\r') {
/*  68 */               throw x.syntaxError("Missing close quote '" + q + "'.");
/*     */             }
/*  70 */             sb.append(c);
/*     */           } 
/*  72 */           return sb.toString();
/*  73 */         }  if (c == delimiter) {
/*  74 */           x.back();
/*  75 */           return "";
/*     */         } 
/*  77 */         x.back();
/*  78 */         return x.nextTo(delimiter);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray rowToJSONArray(JSONTokener x) throws JSONException {
/*  88 */     return rowToJSONArray(x, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray rowToJSONArray(JSONTokener x, char delimiter) throws JSONException {
/*  99 */     JSONArray ja = new JSONArray();
/*     */     while (true) {
/* 101 */       String value = getValue(x, delimiter);
/* 102 */       char c = x.next();
/* 103 */       if (value == null || (ja
/* 104 */         .length() == 0 && value.length() == 0 && c != delimiter)) {
/* 105 */         return null;
/*     */       }
/* 107 */       ja.put(value);
/*     */       
/* 109 */       while (c != delimiter) {
/*     */ 
/*     */         
/* 112 */         if (c != ' ') {
/* 113 */           if (c == '\n' || c == '\r' || c == '\000') {
/* 114 */             return ja;
/*     */           }
/* 116 */           throw x.syntaxError("Bad character '" + c + "' (" + c + ").");
/*     */         } 
/*     */         
/* 119 */         c = x.next();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONObject rowToJSONObject(JSONArray names, JSONTokener x) throws JSONException {
/* 135 */     return rowToJSONObject(names, x, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONObject rowToJSONObject(JSONArray names, JSONTokener x, char delimiter) throws JSONException {
/* 150 */     JSONArray ja = rowToJSONArray(x, delimiter);
/* 151 */     return (ja != null) ? ja.toJSONObject(names) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String rowToString(JSONArray ja) {
/* 162 */     return rowToString(ja, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String rowToString(JSONArray ja, char delimiter) {
/* 174 */     StringBuilder sb = new StringBuilder();
/* 175 */     for (int i = 0; i < ja.length(); i++) {
/* 176 */       if (i > 0) {
/* 177 */         sb.append(delimiter);
/*     */       }
/* 179 */       Object object = ja.opt(i);
/* 180 */       if (object != null) {
/* 181 */         String string = object.toString();
/* 182 */         if (string.length() > 0 && (string.indexOf(delimiter) >= 0 || string
/* 183 */           .indexOf('\n') >= 0 || string.indexOf('\r') >= 0 || string
/* 184 */           .indexOf('\0') >= 0 || string.charAt(0) == '"')) {
/* 185 */           sb.append('"');
/* 186 */           int length = string.length();
/* 187 */           for (int j = 0; j < length; j++) {
/* 188 */             char c = string.charAt(j);
/* 189 */             if (c >= ' ' && c != '"') {
/* 190 */               sb.append(c);
/*     */             }
/*     */           } 
/* 193 */           sb.append('"');
/*     */         } else {
/* 195 */           sb.append(string);
/*     */         } 
/*     */       } 
/*     */     } 
/* 199 */     sb.append('\n');
/* 200 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(String string) throws JSONException {
/* 211 */     return toJSONArray(string, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(String string, char delimiter) throws JSONException {
/* 223 */     return toJSONArray(new JSONTokener(string), delimiter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(JSONTokener x) throws JSONException {
/* 234 */     return toJSONArray(x, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(JSONTokener x, char delimiter) throws JSONException {
/* 246 */     return toJSONArray(rowToJSONArray(x, delimiter), x, delimiter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(JSONArray names, String string) throws JSONException {
/* 258 */     return toJSONArray(names, string, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(JSONArray names, String string, char delimiter) throws JSONException {
/* 271 */     return toJSONArray(names, new JSONTokener(string), delimiter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(JSONArray names, JSONTokener x) throws JSONException {
/* 283 */     return toJSONArray(names, x, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(JSONArray names, JSONTokener x, char delimiter) throws JSONException {
/* 296 */     if (names == null || names.length() == 0) {
/* 297 */       return null;
/*     */     }
/* 299 */     JSONArray ja = new JSONArray();
/*     */     while (true) {
/* 301 */       JSONObject jo = rowToJSONObject(names, x, delimiter);
/* 302 */       if (jo == null) {
/*     */         break;
/*     */       }
/* 305 */       ja.put(jo);
/*     */     } 
/* 307 */     if (ja.length() == 0) {
/* 308 */       return null;
/*     */     }
/* 310 */     return ja;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(JSONArray ja) throws JSONException {
/* 323 */     return toString(ja, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(JSONArray ja, char delimiter) throws JSONException {
/* 336 */     JSONObject jo = ja.optJSONObject(0);
/* 337 */     if (jo != null) {
/* 338 */       JSONArray names = jo.names();
/* 339 */       if (names != null) {
/* 340 */         return rowToString(names, delimiter) + toString(names, ja, delimiter);
/*     */       }
/*     */     } 
/* 343 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(JSONArray names, JSONArray ja) throws JSONException {
/* 356 */     return toString(names, ja, ',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(JSONArray names, JSONArray ja, char delimiter) throws JSONException {
/* 370 */     if (names == null || names.length() == 0) {
/* 371 */       return null;
/*     */     }
/* 373 */     StringBuilder sb = new StringBuilder();
/* 374 */     for (int i = 0; i < ja.length(); i++) {
/* 375 */       JSONObject jo = ja.optJSONObject(i);
/* 376 */       if (jo != null) {
/* 377 */         sb.append(rowToString(jo.toJSONArray(names), delimiter));
/*     */       }
/*     */     } 
/* 380 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/CDL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */