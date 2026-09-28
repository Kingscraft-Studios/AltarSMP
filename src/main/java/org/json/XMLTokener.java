/*     */ package org.json;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.util.HashMap;
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
/*     */ public class XMLTokener
/*     */   extends JSONTokener
/*     */ {
/*  23 */   private XMLParserConfiguration configuration = XMLParserConfiguration.ORIGINAL;
/*     */ 
/*     */   
/*  26 */   public static final HashMap<String, Character> entity = new HashMap<>(8); static {
/*  27 */     entity.put("amp", XML.AMP);
/*  28 */     entity.put("apos", XML.APOS);
/*  29 */     entity.put("gt", XML.GT);
/*  30 */     entity.put("lt", XML.LT);
/*  31 */     entity.put("quot", XML.QUOT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLTokener(Reader r) {
/*  39 */     super(r);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLTokener(String s) {
/*  47 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLTokener(Reader r, XMLParserConfiguration configuration) {
/*  56 */     super(r);
/*  57 */     this.configuration = configuration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String nextCDATA() throws JSONException {
/*  68 */     StringBuilder sb = new StringBuilder();
/*  69 */     while (more()) {
/*  70 */       char c = next();
/*  71 */       sb.append(c);
/*  72 */       int i = sb.length() - 3;
/*  73 */       if (i >= 0 && sb.charAt(i) == ']' && sb
/*  74 */         .charAt(i + 1) == ']' && sb.charAt(i + 2) == '>') {
/*  75 */         sb.setLength(i);
/*  76 */         return sb.toString();
/*     */       } 
/*     */     } 
/*  79 */     throw syntaxError("Unclosed CDATA");
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
/*     */   public Object nextContent() throws JSONException {
/*     */     char c;
/*     */     do {
/*  97 */       c = next();
/*  98 */     } while (Character.isWhitespace(c) && this.configuration.shouldTrimWhiteSpace());
/*  99 */     if (c == '\000') {
/* 100 */       return null;
/*     */     }
/* 102 */     if (c == '<') {
/* 103 */       return XML.LT;
/*     */     }
/* 105 */     StringBuilder sb = new StringBuilder();
/*     */     while (true) {
/* 107 */       if (c == '\000') {
/* 108 */         return sb.toString().trim();
/*     */       }
/* 110 */       if (c == '<') {
/* 111 */         back();
/* 112 */         if (this.configuration.shouldTrimWhiteSpace())
/* 113 */           return sb.toString().trim(); 
/* 114 */         return sb.toString();
/*     */       } 
/* 116 */       if (c == '&') {
/* 117 */         sb.append(nextEntity(c));
/*     */       } else {
/* 119 */         sb.append(c);
/*     */       } 
/* 121 */       c = next();
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
/*     */   public Object nextEntity(char ampersand) throws JSONException {
/*     */     char c;
/* 136 */     StringBuilder sb = new StringBuilder();
/*     */     while (true) {
/* 138 */       c = next();
/* 139 */       if (Character.isLetterOrDigit(c) || c == '#')
/* 140 */       { sb.append(Character.toLowerCase(c)); continue; }  break;
/* 141 */     }  if (c == ';') {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       String string = sb.toString();
/* 148 */       return unescapeEntity(string);
/*     */     } 
/*     */     throw syntaxError("Missing ';' in XML entity: &" + sb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String unescapeEntity(String e) {
/* 158 */     if (e == null || e.isEmpty()) {
/* 159 */       return "";
/*     */     }
/*     */     
/* 162 */     if (e.charAt(0) == '#') {
/*     */       int cp;
/* 164 */       if (e.charAt(1) == 'x' || e.charAt(1) == 'X') {
/*     */         
/* 166 */         cp = Integer.parseInt(e.substring(2), 16);
/*     */       } else {
/*     */         
/* 169 */         cp = Integer.parseInt(e.substring(1));
/*     */       } 
/* 171 */       return new String(new int[] { cp }, 0, 1);
/*     */     } 
/* 173 */     Character knownEntity = entity.get(e);
/* 174 */     if (knownEntity == null)
/*     */     {
/* 176 */       return '&' + e + ';';
/*     */     }
/* 178 */     return knownEntity.toString();
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
/*     */   public Object nextMeta() throws JSONException {
/*     */     char c, q;
/*     */     do {
/* 198 */       c = next();
/* 199 */     } while (Character.isWhitespace(c));
/* 200 */     switch (c) {
/*     */       case '\000':
/* 202 */         throw syntaxError("Misshaped meta tag");
/*     */       case '<':
/* 204 */         return XML.LT;
/*     */       case '>':
/* 206 */         return XML.GT;
/*     */       case '/':
/* 208 */         return XML.SLASH;
/*     */       case '=':
/* 210 */         return XML.EQ;
/*     */       case '!':
/* 212 */         return XML.BANG;
/*     */       case '?':
/* 214 */         return XML.QUEST;
/*     */       case '"':
/*     */       case '\'':
/* 217 */         q = c;
/*     */         while (true) {
/* 219 */           c = next();
/* 220 */           if (c == '\000') {
/* 221 */             throw syntaxError("Unterminated string");
/*     */           }
/* 223 */           if (c == q) {
/* 224 */             return Boolean.TRUE;
/*     */           }
/*     */         } 
/*     */     } 
/*     */     while (true)
/* 229 */     { c = next();
/* 230 */       if (Character.isWhitespace(c)) {
/* 231 */         return Boolean.TRUE;
/*     */       }
/* 233 */       switch (c)
/*     */       { case '\000':
/* 235 */           throw syntaxError("Unterminated string");
/*     */         case '!':
/*     */         case '"':
/*     */         case '\'':
/*     */         case '/':
/*     */         case '<':
/*     */         case '=':
/*     */         case '>':
/*     */         case '?':
/* 244 */           break; }  }  back();
/* 245 */     return Boolean.TRUE;
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
/*     */   public Object nextToken() throws JSONException {
/*     */     char c, q;
/*     */     do {
/* 267 */       c = next();
/* 268 */     } while (Character.isWhitespace(c));
/* 269 */     switch (c) {
/*     */       case '\000':
/* 271 */         throw syntaxError("Misshaped element");
/*     */       case '<':
/* 273 */         throw syntaxError("Misplaced '<'");
/*     */       case '>':
/* 275 */         return XML.GT;
/*     */       case '/':
/* 277 */         return XML.SLASH;
/*     */       case '=':
/* 279 */         return XML.EQ;
/*     */       case '!':
/* 281 */         return XML.BANG;
/*     */       case '?':
/* 283 */         return XML.QUEST;
/*     */ 
/*     */ 
/*     */       
/*     */       case '"':
/*     */       case '\'':
/* 289 */         q = c;
/* 290 */         StringBuilder sb = new StringBuilder();
/*     */         while (true) {
/* 292 */           c = next();
/* 293 */           if (c == '\000') {
/* 294 */             throw syntaxError("Unterminated string");
/*     */           }
/* 296 */           if (c == q) {
/* 297 */             return sb.toString();
/*     */           }
/* 299 */           if (c == '&') {
/* 300 */             sb.append(nextEntity(c)); continue;
/*     */           } 
/* 302 */           sb.append(c);
/*     */         } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     StringBuilder sb = new StringBuilder();
/*     */     while (true)
/* 311 */     { sb.append(c);
/* 312 */       c = next();
/* 313 */       if (Character.isWhitespace(c)) {
/* 314 */         return sb.toString();
/*     */       }
/* 316 */       switch (c)
/*     */       { case '\000':
/* 318 */           return sb.toString();
/*     */         case '!':
/*     */         case '/':
/*     */         case '=':
/*     */         case '>':
/*     */         case '?':
/*     */         case '[':
/*     */         case ']':
/* 326 */           back();
/* 327 */           return sb.toString();
/*     */         case '"':
/*     */         case '\'':
/*     */         case '<':
/* 331 */           break; }  }  throw syntaxError("Bad character in a name");
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
/*     */   public void skipPast(String to) {
/* 351 */     int offset = 0;
/* 352 */     int length = to.length();
/* 353 */     char[] circle = new char[length];
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/* 360 */     for (i = 0; i < length; i++) {
/* 361 */       char c = next();
/* 362 */       if (c == '\000') {
/*     */         return;
/*     */       }
/* 365 */       circle[i] = c;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 371 */       int j = offset;
/* 372 */       boolean b = true;
/*     */ 
/*     */ 
/*     */       
/* 376 */       for (i = 0; i < length; i++) {
/* 377 */         if (circle[j] != to.charAt(i)) {
/* 378 */           b = false;
/*     */           break;
/*     */         } 
/* 381 */         j++;
/* 382 */         if (j >= length) {
/* 383 */           j -= length;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 389 */       if (b) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 395 */       char c = next();
/* 396 */       if (c == '\000') {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 403 */       circle[offset] = c;
/* 404 */       offset++;
/* 405 */       if (offset >= length)
/* 406 */         offset -= length; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/XMLTokener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */