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
/*     */ public class HTTP
/*     */ {
/*     */   public static final String CRLF = "\r\n";
/*     */   
/*     */   public static JSONObject toJSONObject(String string) throws JSONException {
/*  58 */     JSONObject jo = new JSONObject();
/*  59 */     HTTPTokener x = new HTTPTokener(string);
/*     */ 
/*     */     
/*  62 */     String token = x.nextToken();
/*  63 */     if (token.toUpperCase(Locale.ROOT).startsWith("HTTP")) {
/*     */ 
/*     */ 
/*     */       
/*  67 */       jo.put("HTTP-Version", token);
/*  68 */       jo.put("Status-Code", x.nextToken());
/*  69 */       jo.put("Reason-Phrase", x.nextTo('\0'));
/*  70 */       x.next();
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  76 */       jo.put("Method", token);
/*  77 */       jo.put("Request-URI", x.nextToken());
/*  78 */       jo.put("HTTP-Version", x.nextToken());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  83 */     while (x.more()) {
/*  84 */       String name = x.nextTo(':');
/*  85 */       x.next(':');
/*  86 */       jo.put(name, x.nextTo('\0'));
/*  87 */       x.next();
/*     */     } 
/*  89 */     return jo;
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
/*     */   public static String toString(JSONObject jo) throws JSONException {
/* 114 */     StringBuilder sb = new StringBuilder();
/* 115 */     if (jo.has("Status-Code") && jo.has("Reason-Phrase")) {
/* 116 */       sb.append(jo.getString("HTTP-Version"));
/* 117 */       sb.append(' ');
/* 118 */       sb.append(jo.getString("Status-Code"));
/* 119 */       sb.append(' ');
/* 120 */       sb.append(jo.getString("Reason-Phrase"));
/* 121 */     } else if (jo.has("Method") && jo.has("Request-URI")) {
/* 122 */       sb.append(jo.getString("Method"));
/* 123 */       sb.append(' ');
/* 124 */       sb.append('"');
/* 125 */       sb.append(jo.getString("Request-URI"));
/* 126 */       sb.append('"');
/* 127 */       sb.append(' ');
/* 128 */       sb.append(jo.getString("HTTP-Version"));
/*     */     } else {
/* 130 */       throw new JSONException("Not enough material for an HTTP header.");
/*     */     } 
/* 132 */     sb.append("\r\n");
/*     */     
/* 134 */     for (String key : jo.keySet()) {
/* 135 */       String value = jo.optString(key);
/* 136 */       if (!"HTTP-Version".equals(key) && !"Status-Code".equals(key) && 
/* 137 */         !"Reason-Phrase".equals(key) && !"Method".equals(key) && 
/* 138 */         !"Request-URI".equals(key) && !JSONObject.NULL.equals(value)) {
/* 139 */         sb.append(key);
/* 140 */         sb.append(": ");
/* 141 */         sb.append(jo.optString(key));
/* 142 */         sb.append("\r\n");
/*     */       } 
/*     */     } 
/* 145 */     sb.append("\r\n");
/* 146 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/HTTP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */