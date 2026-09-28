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
/*     */ public class JSONML
/*     */ {
/*     */   private static Object parse(XMLTokener x, boolean arrayForm, JSONArray ja, boolean keepStrings, int currentNestingDepth) throws JSONException {
/*  40 */     return parse(x, arrayForm, ja, keepStrings ? JSONMLParserConfiguration.KEEP_STRINGS : JSONMLParserConfiguration.ORIGINAL, currentNestingDepth);
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
/*     */   
/*     */   private static Object parse(XMLTokener x, boolean arrayForm, JSONArray ja, JSONMLParserConfiguration config, int currentNestingDepth) throws JSONException {
/*  66 */     String closeTag = null;
/*     */     
/*  68 */     JSONArray newja = null;
/*  69 */     JSONObject newjo = null;
/*     */     
/*  71 */     String tagName = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     label118: while (true) {
/*  80 */       if (!x.more()) {
/*  81 */         throw x.syntaxError("Bad XML");
/*     */       }
/*  83 */       Object token = x.nextContent();
/*  84 */       if (token == XML.LT) {
/*  85 */         token = x.nextToken();
/*  86 */         if (token instanceof Character) {
/*  87 */           if (token == XML.SLASH) {
/*     */ 
/*     */ 
/*     */             
/*  91 */             token = x.nextToken();
/*  92 */             if (!(token instanceof String)) {
/*  93 */               throw new JSONException("Expected a closing name instead of '" + token + "'.");
/*     */             }
/*     */ 
/*     */             
/*  97 */             if (x.nextToken() != XML.GT) {
/*  98 */               throw x.syntaxError("Misshaped close tag");
/*     */             }
/* 100 */             return token;
/* 101 */           }  if (token == XML.BANG) {
/*     */ 
/*     */ 
/*     */             
/* 105 */             char c = x.next();
/* 106 */             if (c == '-') {
/* 107 */               if (x.next() == '-') {
/* 108 */                 x.skipPast("-->"); continue;
/*     */               } 
/* 110 */               x.back(); continue;
/*     */             } 
/* 112 */             if (c == '[') {
/* 113 */               token = x.nextToken();
/* 114 */               if (token.equals("CDATA") && x.next() == '[') {
/* 115 */                 if (ja != null)
/* 116 */                   ja.put(x.nextCDATA()); 
/*     */                 continue;
/*     */               } 
/* 119 */               throw x.syntaxError("Expected 'CDATA['");
/*     */             } 
/*     */             
/* 122 */             int i = 1;
/*     */             while (true)
/* 124 */             { token = x.nextMeta();
/* 125 */               if (token == null)
/* 126 */                 throw x.syntaxError("Missing '>' after '<!'."); 
/* 127 */               if (token == XML.LT) {
/* 128 */                 i++;
/* 129 */               } else if (token == XML.GT) {
/* 130 */                 i--;
/*     */               } 
/* 132 */               if (i <= 0)
/*     */                 continue label118;  }  break;
/* 134 */           }  if (token == XML.QUEST) {
/*     */ 
/*     */ 
/*     */             
/* 138 */             x.skipPast("?>"); continue;
/*     */           } 
/* 140 */           throw x.syntaxError("Misshaped tag");
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 146 */         if (!(token instanceof String)) {
/* 147 */           throw x.syntaxError("Bad tagName '" + token + "'.");
/*     */         }
/* 149 */         tagName = (String)token;
/* 150 */         newja = new JSONArray();
/* 151 */         newjo = new JSONObject();
/* 152 */         if (arrayForm) {
/* 153 */           newja.put(tagName);
/* 154 */           if (ja != null) {
/* 155 */             ja.put(newja);
/*     */           }
/*     */         } else {
/* 158 */           newjo.put("tagName", tagName);
/* 159 */           if (ja != null) {
/* 160 */             ja.put(newjo);
/*     */           }
/*     */         } 
/* 163 */         token = null;
/*     */         while (true) {
/* 165 */           if (token == null) {
/* 166 */             token = x.nextToken();
/*     */           }
/* 168 */           if (token == null) {
/* 169 */             throw x.syntaxError("Misshaped tag");
/*     */           }
/* 171 */           if (!(token instanceof String)) {
/*     */             break;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 177 */           String attribute = (String)token;
/* 178 */           if (!arrayForm && ("tagName".equals(attribute) || "childNode".equals(attribute))) {
/* 179 */             throw x.syntaxError("Reserved attribute.");
/*     */           }
/* 181 */           token = x.nextToken();
/* 182 */           if (token == XML.EQ) {
/* 183 */             token = x.nextToken();
/* 184 */             if (!(token instanceof String)) {
/* 185 */               throw x.syntaxError("Missing value");
/*     */             }
/* 187 */             newjo.accumulate(attribute, config.isKeepStrings() ? token : XML.stringToValue((String)token));
/* 188 */             token = null; continue;
/*     */           } 
/* 190 */           newjo.accumulate(attribute, "");
/*     */         } 
/*     */         
/* 193 */         if (arrayForm && newjo.length() > 0) {
/* 194 */           newja.put(newjo);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 199 */         if (token == XML.SLASH) {
/* 200 */           if (x.nextToken() != XML.GT) {
/* 201 */             throw x.syntaxError("Misshaped tag");
/*     */           }
/* 203 */           if (ja == null) {
/* 204 */             if (arrayForm) {
/* 205 */               return newja;
/*     */             }
/* 207 */             return newjo;
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 213 */         if (token != XML.GT) {
/* 214 */           throw x.syntaxError("Misshaped tag");
/*     */         }
/*     */         
/* 217 */         if (currentNestingDepth == config.getMaxNestingDepth()) {
/* 218 */           throw x.syntaxError("Maximum nesting depth of " + config.getMaxNestingDepth() + " reached");
/*     */         }
/*     */         
/* 221 */         closeTag = (String)parse(x, arrayForm, newja, config, currentNestingDepth + 1);
/* 222 */         if (closeTag != null) {
/* 223 */           if (!closeTag.equals(tagName)) {
/* 224 */             throw x.syntaxError("Mismatched '" + tagName + "' and '" + closeTag + "'");
/*     */           }
/*     */           
/* 227 */           tagName = null;
/* 228 */           if (!arrayForm && newja.length() > 0) {
/* 229 */             newjo.put("childNodes", newja);
/*     */           }
/* 231 */           if (ja == null) {
/* 232 */             if (arrayForm) {
/* 233 */               return newja;
/*     */             }
/* 235 */             return newjo;
/*     */           } 
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/* 241 */       if (ja != null) {
/* 242 */         ja.put((token instanceof String) ? (
/* 243 */             config.isKeepStrings() ? XML.unescape((String)token) : XML.stringToValue((String)token)) : token);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JSONArray toJSONArray(String string) throws JSONException {
/* 264 */     return (JSONArray)parse(new XMLTokener(string), true, (JSONArray)null, JSONMLParserConfiguration.ORIGINAL, 0);
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
/*     */   public static JSONArray toJSONArray(String string, boolean keepStrings) throws JSONException {
/* 286 */     return (JSONArray)parse(new XMLTokener(string), true, (JSONArray)null, keepStrings, 0);
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
/*     */   public static JSONArray toJSONArray(String string, JSONMLParserConfiguration config) throws JSONException {
/* 311 */     return (JSONArray)parse(new XMLTokener(string), true, (JSONArray)null, config, 0);
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
/*     */   public static JSONArray toJSONArray(XMLTokener x, JSONMLParserConfiguration config) throws JSONException {
/* 335 */     return (JSONArray)parse(x, true, (JSONArray)null, config, 0);
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
/*     */   public static JSONArray toJSONArray(XMLTokener x, boolean keepStrings) throws JSONException {
/* 357 */     return (JSONArray)parse(x, true, (JSONArray)null, keepStrings, 0);
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
/*     */   public static JSONArray toJSONArray(XMLTokener x) throws JSONException {
/* 374 */     return (JSONArray)parse(x, true, (JSONArray)null, false, 0);
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
/*     */   public static JSONObject toJSONObject(String string) throws JSONException {
/* 392 */     return (JSONObject)parse(new XMLTokener(string), false, (JSONArray)null, false, 0);
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
/*     */   public static JSONObject toJSONObject(String string, boolean keepStrings) throws JSONException {
/* 412 */     return (JSONObject)parse(new XMLTokener(string), false, (JSONArray)null, keepStrings, 0);
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
/*     */   public static JSONObject toJSONObject(String string, JSONMLParserConfiguration config) throws JSONException {
/* 434 */     return (JSONObject)parse(new XMLTokener(string), false, (JSONArray)null, config, 0);
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
/*     */   public static JSONObject toJSONObject(XMLTokener x) throws JSONException {
/* 452 */     return (JSONObject)parse(x, false, (JSONArray)null, false, 0);
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
/*     */   public static JSONObject toJSONObject(XMLTokener x, boolean keepStrings) throws JSONException {
/* 472 */     return (JSONObject)parse(x, false, (JSONArray)null, keepStrings, 0);
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
/*     */   public static JSONObject toJSONObject(XMLTokener x, JSONMLParserConfiguration config) throws JSONException {
/* 494 */     return (JSONObject)parse(x, false, (JSONArray)null, config, 0);
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
/*     */   public static String toString(JSONArray ja) throws JSONException {
/*     */     int i;
/* 509 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 514 */     String tagName = ja.getString(0);
/* 515 */     XML.noSpace(tagName);
/* 516 */     tagName = XML.escape(tagName);
/* 517 */     sb.append('<');
/* 518 */     sb.append(tagName);
/*     */     
/* 520 */     Object object = ja.opt(1);
/* 521 */     if (object instanceof JSONObject) {
/* 522 */       i = 2;
/* 523 */       JSONObject jo = (JSONObject)object;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 528 */       for (String key : jo.keySet()) {
/* 529 */         Object value = jo.opt(key);
/* 530 */         XML.noSpace(key);
/* 531 */         if (value != null) {
/* 532 */           sb.append(' ');
/* 533 */           sb.append(XML.escape(key));
/* 534 */           sb.append('=');
/* 535 */           sb.append('"');
/* 536 */           sb.append(XML.escape(value.toString()));
/* 537 */           sb.append('"');
/*     */         } 
/*     */       } 
/*     */     } else {
/* 541 */       i = 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 546 */     int length = ja.length();
/* 547 */     if (i >= length)
/* 548 */     { sb.append('/');
/* 549 */       sb.append('>'); }
/*     */     else
/* 551 */     { sb.append('>');
/*     */       while (true)
/* 553 */       { object = ja.get(i);
/* 554 */         i++;
/* 555 */         if (object != null) {
/* 556 */           if (object instanceof String) {
/* 557 */             sb.append(XML.escape(object.toString()));
/* 558 */           } else if (object instanceof JSONObject) {
/* 559 */             sb.append(toString((JSONObject)object));
/* 560 */           } else if (object instanceof JSONArray) {
/* 561 */             sb.append(toString((JSONArray)object));
/*     */           } else {
/* 563 */             sb.append(object.toString());
/*     */           } 
/*     */         }
/* 566 */         if (i >= length)
/* 567 */         { sb.append('<');
/* 568 */           sb.append('/');
/* 569 */           sb.append(tagName);
/* 570 */           sb.append('>');
/*     */           
/* 572 */           return sb.toString(); }  }  }  return sb.toString();
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
/*     */   public static String toString(JSONObject jo) throws JSONException {
/* 586 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 596 */     String tagName = jo.optString("tagName");
/* 597 */     if (tagName == null) {
/* 598 */       return XML.escape(jo.toString());
/*     */     }
/* 600 */     XML.noSpace(tagName);
/* 601 */     tagName = XML.escape(tagName);
/* 602 */     sb.append('<');
/* 603 */     sb.append(tagName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 608 */     for (String key : jo.keySet()) {
/* 609 */       if (!"tagName".equals(key) && !"childNodes".equals(key)) {
/* 610 */         XML.noSpace(key);
/* 611 */         Object value = jo.opt(key);
/* 612 */         if (value != null) {
/* 613 */           sb.append(' ');
/* 614 */           sb.append(XML.escape(key));
/* 615 */           sb.append('=');
/* 616 */           sb.append('"');
/* 617 */           sb.append(XML.escape(value.toString()));
/* 618 */           sb.append('"');
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 625 */     JSONArray ja = jo.optJSONArray("childNodes");
/* 626 */     if (ja == null) {
/* 627 */       sb.append('/');
/* 628 */       sb.append('>');
/*     */     } else {
/* 630 */       sb.append('>');
/* 631 */       int length = ja.length();
/* 632 */       for (int i = 0; i < length; i++) {
/* 633 */         Object object = ja.get(i);
/* 634 */         if (object != null) {
/* 635 */           if (object instanceof String) {
/* 636 */             sb.append(XML.escape(object.toString()));
/* 637 */           } else if (object instanceof JSONObject) {
/* 638 */             sb.append(toString((JSONObject)object));
/* 639 */           } else if (object instanceof JSONArray) {
/* 640 */             sb.append(toString((JSONArray)object));
/*     */           } else {
/* 642 */             sb.append(object.toString());
/*     */           } 
/*     */         }
/*     */       } 
/* 646 */       sb.append('<');
/* 647 */       sb.append('/');
/* 648 */       sb.append(tagName);
/* 649 */       sb.append('>');
/*     */     } 
/* 651 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/JSONML.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */