/*     */ package org.json;
/*     */ 
/*     */ import java.util.Locale;
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
/*     */ public class Cookie
/*     */ {
/*     */   public static String escape(String string) {
/*  38 */     String s = string.trim();
/*  39 */     int length = s.length();
/*  40 */     StringBuilder sb = new StringBuilder(length);
/*  41 */     for (int i = 0; i < length; i++) {
/*  42 */       char c = s.charAt(i);
/*  43 */       if (c < ' ' || c == '+' || c == '%' || c == '=' || c == ';') {
/*  44 */         sb.append('%');
/*  45 */         sb.append(Character.forDigit((char)(c >>> 4 & 0xF), 16));
/*  46 */         sb.append(Character.forDigit((char)(c & 0xF), 16));
/*     */       } else {
/*  48 */         sb.append(c);
/*     */       } 
/*     */     } 
/*  51 */     return sb.toString();
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
/*     */   public static JSONObject toJSONObject(String string) {
/*  76 */     JSONObject jo = new JSONObject();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     JSONTokener x = new JSONTokener(string);
/*     */     
/*  83 */     String name = unescape(x.nextTo('=').trim());
/*     */     
/*  85 */     if ("".equals(name)) {
/*  86 */       throw new JSONException("Cookies must have a 'name'");
/*     */     }
/*  88 */     jo.put("name", name);
/*     */ 
/*     */     
/*  91 */     x.next('=');
/*  92 */     jo.put("value", unescape(x.nextTo(';')).trim());
/*     */     
/*  94 */     x.next();
/*     */     
/*  96 */     while (x.more()) {
/*  97 */       Object value; name = unescape(x.nextTo("=;")).trim().toLowerCase(Locale.ROOT);
/*     */       
/*  99 */       if ("name".equalsIgnoreCase(name)) {
/* 100 */         throw new JSONException("Illegal attribute name: 'name'");
/*     */       }
/* 102 */       if ("value".equalsIgnoreCase(name)) {
/* 103 */         throw new JSONException("Illegal attribute name: 'value'");
/*     */       }
/*     */       
/* 106 */       if (x.next() != '=') {
/* 107 */         value = Boolean.TRUE;
/*     */       } else {
/* 109 */         value = unescape(x.nextTo(';')).trim();
/* 110 */         x.next();
/*     */       } 
/*     */       
/* 113 */       if (!"".equals(name) && !"".equals(value)) {
/* 114 */         jo.put(name, value);
/*     */       }
/*     */     } 
/* 117 */     return jo;
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
/*     */   
/*     */   public static String toString(JSONObject jo) throws JSONException {
/* 133 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 135 */     String name = null;
/* 136 */     Object value = null;
/* 137 */     for (String key : jo.keySet()) {
/* 138 */       if ("name".equalsIgnoreCase(key)) {
/* 139 */         name = jo.getString(key).trim();
/*     */       }
/* 141 */       if ("value".equalsIgnoreCase(key)) {
/* 142 */         value = jo.getString(key).trim();
/*     */       }
/* 144 */       if (name != null && value != null) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 149 */     if (name == null || "".equals(name.trim())) {
/* 150 */       throw new JSONException("Cookie does not have a name");
/*     */     }
/* 152 */     if (value == null) {
/* 153 */       value = "";
/*     */     }
/*     */     
/* 156 */     sb.append(escape(name));
/* 157 */     sb.append("=");
/* 158 */     sb.append(escape((String)value));
/*     */     
/* 160 */     for (String key : jo.keySet()) {
/* 161 */       if ("name".equalsIgnoreCase(key) || "value"
/* 162 */         .equalsIgnoreCase(key)) {
/*     */         continue;
/*     */       }
/*     */       
/* 166 */       value = jo.opt(key);
/* 167 */       if (value instanceof Boolean) {
/* 168 */         if (Boolean.TRUE.equals(value)) {
/* 169 */           sb.append(';').append(escape(key));
/*     */         }
/*     */         continue;
/*     */       } 
/* 173 */       sb.append(';')
/* 174 */         .append(escape(key))
/* 175 */         .append('=')
/* 176 */         .append(escape(value.toString()));
/*     */     } 
/*     */ 
/*     */     
/* 180 */     return sb.toString();
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
/*     */   public static String unescape(String string) {
/* 192 */     int length = string.length();
/* 193 */     StringBuilder sb = new StringBuilder(length);
/* 194 */     for (int i = 0; i < length; i++) {
/* 195 */       char c = string.charAt(i);
/* 196 */       if (c == '+') {
/* 197 */         c = ' ';
/* 198 */       } else if (c == '%' && i + 2 < length) {
/* 199 */         int d = JSONTokener.dehexchar(string.charAt(i + 1));
/* 200 */         int e = JSONTokener.dehexchar(string.charAt(i + 2));
/* 201 */         if (d >= 0 && e >= 0) {
/* 202 */           c = (char)(d * 16 + e);
/* 203 */           i += 2;
/*     */         } 
/*     */       } 
/* 206 */       sb.append(c);
/*     */     } 
/* 208 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/Cookie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */