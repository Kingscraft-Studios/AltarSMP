/*     */ package org.json;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
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
/*     */ public class JSONPointer
/*     */ {
/*     */   private static final String ENCODING = "utf-8";
/*     */   private final List<String> refTokens;
/*     */   
/*     */   public static class Builder
/*     */   {
/*  52 */     private final List<String> refTokens = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public JSONPointer build() {
/*  60 */       return new JSONPointer(this.refTokens);
/*     */     }
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
/*     */     public Builder append(String token) {
/*  76 */       if (token == null) {
/*  77 */         throw new NullPointerException("token cannot be null");
/*     */       }
/*  79 */       this.refTokens.add(token);
/*  80 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder append(int arrayIndex) {
/*  91 */       this.refTokens.add(String.valueOf(arrayIndex));
/*  92 */       return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Builder builder() {
/* 112 */     return new Builder();
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
/*     */   public JSONPointer(String pointer) {
/*     */     String refs;
/* 127 */     if (pointer == null) {
/* 128 */       throw new NullPointerException("pointer cannot be null");
/*     */     }
/* 130 */     if (pointer.isEmpty() || pointer.equals("#")) {
/* 131 */       this.refTokens = Collections.emptyList();
/*     */       
/*     */       return;
/*     */     } 
/* 135 */     if (pointer.startsWith("#/")) {
/* 136 */       refs = pointer.substring(2);
/*     */       try {
/* 138 */         refs = URLDecoder.decode(refs, "utf-8");
/* 139 */       } catch (UnsupportedEncodingException e) {
/* 140 */         throw new RuntimeException(e);
/*     */       } 
/* 142 */     } else if (pointer.startsWith("/")) {
/* 143 */       refs = pointer.substring(1);
/*     */     } else {
/* 145 */       throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
/*     */     } 
/* 147 */     this.refTokens = new ArrayList<>();
/* 148 */     int slashIdx = -1;
/* 149 */     int prevSlashIdx = 0;
/*     */     do {
/* 151 */       prevSlashIdx = slashIdx + 1;
/* 152 */       slashIdx = refs.indexOf('/', prevSlashIdx);
/* 153 */       if (prevSlashIdx == slashIdx || prevSlashIdx == refs.length()) {
/*     */ 
/*     */         
/* 156 */         this.refTokens.add("");
/* 157 */       } else if (slashIdx >= 0) {
/* 158 */         String token = refs.substring(prevSlashIdx, slashIdx);
/* 159 */         this.refTokens.add(unescape(token));
/*     */       } else {
/*     */         
/* 162 */         String token = refs.substring(prevSlashIdx);
/* 163 */         this.refTokens.add(unescape(token));
/*     */       } 
/* 165 */     } while (slashIdx >= 0);
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
/*     */   public JSONPointer(List<String> refTokens) {
/* 179 */     this.refTokens = new ArrayList<>(refTokens);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String unescape(String token) {
/* 186 */     return token.replace("~1", "/").replace("~0", "~");
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
/*     */   public Object queryFrom(Object document) throws JSONPointerException {
/* 200 */     if (this.refTokens.isEmpty()) {
/* 201 */       return document;
/*     */     }
/* 203 */     Object current = document;
/* 204 */     for (String token : this.refTokens) {
/* 205 */       if (current instanceof JSONObject) {
/* 206 */         current = ((JSONObject)current).opt(unescape(token)); continue;
/* 207 */       }  if (current instanceof JSONArray) {
/* 208 */         current = readByIndexToken(current, token); continue;
/*     */       } 
/* 210 */       throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", new Object[] { current, token }));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 215 */     return current;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object readByIndexToken(Object current, String indexToken) throws JSONPointerException {
/*     */     try {
/* 227 */       int index = Integer.parseInt(indexToken);
/* 228 */       JSONArray currentArr = (JSONArray)current;
/* 229 */       if (index >= currentArr.length()) {
/* 230 */         throw new JSONPointerException(String.format("index %s is out of bounds - the array has %d elements", new Object[] { indexToken, 
/* 231 */                 Integer.valueOf(currentArr.length()) }));
/*     */       }
/*     */       try {
/* 234 */         return currentArr.get(index);
/* 235 */       } catch (JSONException e) {
/* 236 */         throw new JSONPointerException("Error reading value at index position " + index, e);
/*     */       } 
/* 238 */     } catch (NumberFormatException e) {
/* 239 */       throw new JSONPointerException(String.format("%s is not an array index", new Object[] { indexToken }), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 249 */     StringBuilder rval = new StringBuilder("");
/* 250 */     for (String token : this.refTokens) {
/* 251 */       rval.append('/').append(escape(token));
/*     */     }
/* 253 */     return rval.toString();
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
/*     */   private static String escape(String token) {
/* 266 */     return token.replace("~", "~0")
/* 267 */       .replace("/", "~1");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toURIFragment() {
/*     */     try {
/* 277 */       StringBuilder rval = new StringBuilder("#");
/* 278 */       for (String token : this.refTokens) {
/* 279 */         rval.append('/').append(URLEncoder.encode(token, "utf-8"));
/*     */       }
/* 281 */       return rval.toString();
/* 282 */     } catch (UnsupportedEncodingException e) {
/* 283 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/JSONPointer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */