/*      */ package org.json;
/*      */ 
/*      */ import java.io.Reader;
/*      */ import java.io.StringReader;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Iterator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XML
/*      */ {
/*   30 */   public static final Character AMP = Character.valueOf('&');
/*      */ 
/*      */   
/*   33 */   public static final Character APOS = Character.valueOf('\'');
/*      */ 
/*      */   
/*   36 */   public static final Character BANG = Character.valueOf('!');
/*      */ 
/*      */   
/*   39 */   public static final Character EQ = Character.valueOf('=');
/*      */ 
/*      */   
/*   42 */   public static final Character GT = Character.valueOf('>');
/*      */ 
/*      */   
/*   45 */   public static final Character LT = Character.valueOf('<');
/*      */ 
/*      */   
/*   48 */   public static final Character QUEST = Character.valueOf('?');
/*      */ 
/*      */   
/*   51 */   public static final Character QUOT = Character.valueOf('"');
/*      */ 
/*      */   
/*   54 */   public static final Character SLASH = Character.valueOf('/');
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String NULL_ATTR = "xsi:nil";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String TYPE_ATTR = "xsi:type";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Iterable<Integer> codePointIterator(final String string) {
/*   78 */     return new Iterable<Integer>()
/*      */       {
/*      */         public Iterator<Integer> iterator() {
/*   81 */           return new Iterator<Integer>() {
/*   82 */               private int nextIndex = 0;
/*   83 */               private int length = string.length();
/*      */ 
/*      */               
/*      */               public boolean hasNext() {
/*   87 */                 return (this.nextIndex < this.length);
/*      */               }
/*      */ 
/*      */               
/*      */               public Integer next() {
/*   92 */                 int result = string.codePointAt(this.nextIndex);
/*   93 */                 this.nextIndex += Character.charCount(result);
/*   94 */                 return Integer.valueOf(result);
/*      */               }
/*      */ 
/*      */               
/*      */               public void remove() {
/*   99 */                 throw new UnsupportedOperationException();
/*      */               }
/*      */             };
/*      */         }
/*      */       };
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
/*      */   public static String escape(String string) {
/*  122 */     StringBuilder sb = new StringBuilder(string.length());
/*  123 */     for (Iterator<Integer> iterator = codePointIterator(string).iterator(); iterator.hasNext(); ) { int cp = ((Integer)iterator.next()).intValue();
/*  124 */       switch (cp) {
/*      */         case 38:
/*  126 */           sb.append("&amp;");
/*      */           continue;
/*      */         case 60:
/*  129 */           sb.append("&lt;");
/*      */           continue;
/*      */         case 62:
/*  132 */           sb.append("&gt;");
/*      */           continue;
/*      */         case 34:
/*  135 */           sb.append("&quot;");
/*      */           continue;
/*      */         case 39:
/*  138 */           sb.append("&apos;");
/*      */           continue;
/*      */       } 
/*  141 */       if (mustEscape(cp)) {
/*  142 */         sb.append("&#x");
/*  143 */         sb.append(Integer.toHexString(cp));
/*  144 */         sb.append(';'); continue;
/*      */       } 
/*  146 */       sb.appendCodePoint(cp); }
/*      */ 
/*      */ 
/*      */     
/*  150 */     return sb.toString();
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
/*      */   private static boolean mustEscape(int cp) {
/*  166 */     return ((Character.isISOControl(cp) && cp != 9 && cp != 10 && cp != 13) || ((cp < 32 || cp > 55295) && (cp < 57344 || cp > 65533) && (cp < 65536 || cp > 1114111)));
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
/*      */   public static String unescape(String string) {
/*  187 */     StringBuilder sb = new StringBuilder(string.length());
/*  188 */     for (int i = 0, length = string.length(); i < length; i++) {
/*  189 */       char c = string.charAt(i);
/*  190 */       if (c == '&') {
/*  191 */         int semic = string.indexOf(';', i);
/*  192 */         if (semic > i) {
/*  193 */           String entity = string.substring(i + 1, semic);
/*  194 */           sb.append(XMLTokener.unescapeEntity(entity));
/*      */           
/*  196 */           i += entity.length() + 1;
/*      */         }
/*      */         else {
/*      */           
/*  200 */           sb.append(c);
/*      */         } 
/*      */       } else {
/*      */         
/*  204 */         sb.append(c);
/*      */       } 
/*      */     } 
/*  207 */     return sb.toString();
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
/*      */   public static void noSpace(String string) throws JSONException {
/*  219 */     int length = string.length();
/*  220 */     if (length == 0) {
/*  221 */       throw new JSONException("Empty string.");
/*      */     }
/*  223 */     for (int i = 0; i < length; i++) {
/*  224 */       if (Character.isWhitespace(string.charAt(i))) {
/*  225 */         throw new JSONException("'" + string + "' contains a space character.");
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
/*      */   private static boolean parse(XMLTokener x, JSONObject context, String name, XMLParserConfiguration config, int currentNestingDepth) throws JSONException {
/*  251 */     JSONObject jsonObject = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  267 */     Object token = x.nextToken();
/*      */ 
/*      */ 
/*      */     
/*  271 */     if (token == BANG) {
/*  272 */       char c = x.next();
/*  273 */       if (c == '-') {
/*  274 */         if (x.next() == '-') {
/*  275 */           x.skipPast("-->");
/*  276 */           return false;
/*      */         } 
/*  278 */         x.back();
/*  279 */       } else if (c == '[') {
/*  280 */         token = x.nextToken();
/*  281 */         if ("CDATA".equals(token) && 
/*  282 */           x.next() == '[') {
/*  283 */           String string = x.nextCDATA();
/*  284 */           if (string.length() > 0) {
/*  285 */             context.accumulate(config.getcDataTagName(), string);
/*      */           }
/*  287 */           return false;
/*      */         } 
/*      */         
/*  290 */         throw x.syntaxError("Expected 'CDATA['");
/*      */       } 
/*  292 */       int i = 1;
/*      */       while (true)
/*  294 */       { token = x.nextMeta();
/*  295 */         if (token == null)
/*  296 */           throw x.syntaxError("Missing '>' after '<!'."); 
/*  297 */         if (token == LT) {
/*  298 */           i++;
/*  299 */         } else if (token == GT) {
/*  300 */           i--;
/*      */         } 
/*  302 */         if (i <= 0)
/*  303 */           return false;  } 
/*  304 */     }  if (token == QUEST) {
/*      */ 
/*      */       
/*  307 */       x.skipPast("?>");
/*  308 */       return false;
/*  309 */     }  if (token == SLASH) {
/*      */ 
/*      */ 
/*      */       
/*  313 */       token = x.nextToken();
/*  314 */       if (name == null) {
/*  315 */         throw x.syntaxError("Mismatched close tag " + token);
/*      */       }
/*  317 */       if (!token.equals(name)) {
/*  318 */         throw x.syntaxError("Mismatched " + name + " and " + token);
/*      */       }
/*  320 */       if (x.nextToken() != GT) {
/*  321 */         throw x.syntaxError("Misshaped close tag");
/*      */       }
/*  323 */       return true;
/*      */     } 
/*  325 */     if (token instanceof Character) {
/*  326 */       throw x.syntaxError("Misshaped tag");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  331 */     String tagName = (String)token;
/*  332 */     token = null;
/*  333 */     jsonObject = new JSONObject();
/*  334 */     boolean nilAttributeFound = false;
/*  335 */     XMLXsiTypeConverter<?> xmlXsiTypeConverter = null;
/*      */     while (true) {
/*  337 */       if (token == null) {
/*  338 */         token = x.nextToken();
/*      */       }
/*      */       
/*  341 */       if (token instanceof String) {
/*  342 */         String string = (String)token;
/*  343 */         token = x.nextToken();
/*  344 */         if (token == EQ) {
/*  345 */           token = x.nextToken();
/*  346 */           if (!(token instanceof String)) {
/*  347 */             throw x.syntaxError("Missing value");
/*      */           }
/*      */           
/*  350 */           if (config.isConvertNilAttributeToNull() && "xsi:nil"
/*  351 */             .equals(string) && 
/*  352 */             Boolean.parseBoolean((String)token)) {
/*  353 */             nilAttributeFound = true;
/*  354 */           } else if (config.getXsiTypeMap() != null && !config.getXsiTypeMap().isEmpty() && "xsi:type"
/*  355 */             .equals(string)) {
/*  356 */             xmlXsiTypeConverter = config.getXsiTypeMap().get(token);
/*  357 */           } else if (!nilAttributeFound) {
/*  358 */             jsonObject.accumulate(string, 
/*  359 */                 config.isKeepStrings() ? token : 
/*      */                 
/*  361 */                 stringToValue((String)token));
/*      */           } 
/*  363 */           token = null; continue;
/*      */         } 
/*  365 */         jsonObject.accumulate(string, ""); continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  369 */     if (token == SLASH) {
/*      */       
/*  371 */       if (x.nextToken() != GT) {
/*  372 */         throw x.syntaxError("Misshaped tag");
/*      */       }
/*  374 */       if (config.getForceList().contains(tagName)) {
/*      */         
/*  376 */         if (nilAttributeFound) {
/*  377 */           context.append(tagName, JSONObject.NULL);
/*  378 */         } else if (jsonObject.length() > 0) {
/*  379 */           context.append(tagName, jsonObject);
/*      */         } else {
/*  381 */           context.put(tagName, new JSONArray());
/*      */         }
/*      */       
/*  384 */       } else if (nilAttributeFound) {
/*  385 */         context.accumulate(tagName, JSONObject.NULL);
/*  386 */       } else if (jsonObject.length() > 0) {
/*  387 */         context.accumulate(tagName, jsonObject);
/*      */       } else {
/*  389 */         context.accumulate(tagName, "");
/*      */       } 
/*      */       
/*  392 */       return false;
/*      */     } 
/*  394 */     if (token == GT) {
/*      */       while (true) {
/*      */         
/*  397 */         token = x.nextContent();
/*  398 */         if (token == null) {
/*  399 */           if (tagName != null) {
/*  400 */             throw x.syntaxError("Unclosed tag " + tagName);
/*      */           }
/*  402 */           return false;
/*  403 */         }  if (token instanceof String) {
/*  404 */           String string = (String)token;
/*  405 */           if (string.length() > 0) {
/*  406 */             if (xmlXsiTypeConverter != null) {
/*  407 */               jsonObject.accumulate(config.getcDataTagName(), 
/*  408 */                   stringToValue(string, xmlXsiTypeConverter)); continue;
/*      */             } 
/*  410 */             jsonObject.accumulate(config.getcDataTagName(), 
/*  411 */                 config.isKeepStrings() ? string : stringToValue(string));
/*      */           } 
/*      */           continue;
/*      */         } 
/*  415 */         if (token == LT) {
/*      */           
/*  417 */           if (currentNestingDepth == config.getMaxNestingDepth()) {
/*  418 */             throw x.syntaxError("Maximum nesting depth of " + config.getMaxNestingDepth() + " reached");
/*      */           }
/*      */           
/*  421 */           if (parse(x, jsonObject, tagName, config, currentNestingDepth + 1)) {
/*  422 */             if (config.getForceList().contains(tagName)) {
/*      */               
/*  424 */               if (jsonObject.length() == 0) {
/*  425 */                 context.put(tagName, new JSONArray());
/*  426 */               } else if (jsonObject.length() == 1 && jsonObject
/*  427 */                 .opt(config.getcDataTagName()) != null) {
/*  428 */                 context.append(tagName, jsonObject.opt(config.getcDataTagName()));
/*      */               } else {
/*  430 */                 context.append(tagName, jsonObject);
/*      */               }
/*      */             
/*  433 */             } else if (jsonObject.length() == 0) {
/*  434 */               context.accumulate(tagName, "");
/*  435 */             } else if (jsonObject.length() == 1 && jsonObject
/*  436 */               .opt(config.getcDataTagName()) != null) {
/*  437 */               context.accumulate(tagName, jsonObject.opt(config.getcDataTagName()));
/*      */             } else {
/*  439 */               if (!config.shouldTrimWhiteSpace()) {
/*  440 */                 removeEmpty(jsonObject, config);
/*      */               }
/*  442 */               context.accumulate(tagName, jsonObject);
/*      */             } 
/*      */ 
/*      */             
/*  446 */             return false;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*  451 */     throw x.syntaxError("Misshaped tag");
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
/*      */   private static void removeEmpty(JSONObject jsonObject, XMLParserConfiguration config) {
/*  463 */     if (jsonObject.has(config.getcDataTagName())) {
/*  464 */       Object s = jsonObject.get(config.getcDataTagName());
/*  465 */       if (s instanceof String) {
/*  466 */         if (isStringAllWhiteSpace(s.toString())) {
/*  467 */           jsonObject.remove(config.getcDataTagName());
/*      */         }
/*      */       }
/*  470 */       else if (s instanceof JSONArray) {
/*  471 */         JSONArray sArray = (JSONArray)s;
/*  472 */         for (int k = sArray.length() - 1; k >= 0; k--) {
/*  473 */           Object eachString = sArray.get(k);
/*  474 */           if (eachString instanceof String) {
/*  475 */             String s1 = (String)eachString;
/*  476 */             if (isStringAllWhiteSpace(s1)) {
/*  477 */               sArray.remove(k);
/*      */             }
/*      */           } 
/*      */         } 
/*  481 */         if (sArray.isEmpty()) {
/*  482 */           jsonObject.remove(config.getcDataTagName());
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean isStringAllWhiteSpace(String s) {
/*  489 */     for (int k = 0; k < s.length(); k++) {
/*  490 */       char eachChar = s.charAt(k);
/*  491 */       if (!Character.isWhitespace(eachChar)) {
/*  492 */         return false;
/*      */       }
/*      */     } 
/*  495 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Number stringToNumber(String val) throws NumberFormatException {
/*  502 */     char initial = val.charAt(0);
/*  503 */     if ((initial >= '0' && initial <= '9') || initial == '-') {
/*      */       
/*  505 */       if (isDecimalNotation(val)) {
/*      */         
/*      */         try {
/*      */ 
/*      */           
/*  510 */           BigDecimal bd = new BigDecimal(val);
/*  511 */           if (initial == '-' && BigDecimal.ZERO.compareTo(bd) == 0) {
/*  512 */             return Double.valueOf(-0.0D);
/*      */           }
/*  514 */           return bd;
/*  515 */         } catch (NumberFormatException retryAsDouble) {
/*      */           
/*      */           try {
/*  518 */             Double d = Double.valueOf(val);
/*  519 */             if (d.isNaN() || d.isInfinite()) {
/*  520 */               throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */             }
/*  522 */             return d;
/*  523 */           } catch (NumberFormatException ignore) {
/*  524 */             throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/*  529 */       if (initial == '0' && val.length() > 1) {
/*  530 */         char at1 = val.charAt(1);
/*  531 */         if (at1 >= '0' && at1 <= '9') {
/*  532 */           throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */         }
/*  534 */       } else if (initial == '-' && val.length() > 2) {
/*  535 */         char at1 = val.charAt(1);
/*  536 */         char at2 = val.charAt(2);
/*  537 */         if (at1 == '0' && at2 >= '0' && at2 <= '9') {
/*  538 */           throw new NumberFormatException("val [" + val + "] is not a valid number.");
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
/*  549 */       BigInteger bi = new BigInteger(val);
/*  550 */       if (bi.bitLength() <= 31) {
/*  551 */         return Integer.valueOf(bi.intValue());
/*      */       }
/*  553 */       if (bi.bitLength() <= 63) {
/*  554 */         return Long.valueOf(bi.longValue());
/*      */       }
/*  556 */       return bi;
/*      */     } 
/*  558 */     throw new NumberFormatException("val [" + val + "] is not a valid number.");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isDecimalNotation(String val) {
/*  565 */     return (val.indexOf('.') > -1 || val.indexOf('e') > -1 || val
/*  566 */       .indexOf('E') > -1 || "-0".equals(val));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object stringToValue(String string, XMLXsiTypeConverter<?> typeConverter) {
/*  576 */     if (typeConverter != null) {
/*  577 */       return typeConverter.convert(string);
/*      */     }
/*  579 */     return stringToValue(string);
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
/*      */   public static Object stringToValue(String string) {
/*  592 */     if ("".equals(string)) {
/*  593 */       return string;
/*      */     }
/*      */ 
/*      */     
/*  597 */     if ("true".equalsIgnoreCase(string)) {
/*  598 */       return Boolean.TRUE;
/*      */     }
/*  600 */     if ("false".equalsIgnoreCase(string)) {
/*  601 */       return Boolean.FALSE;
/*      */     }
/*  603 */     if ("null".equalsIgnoreCase(string)) {
/*  604 */       return JSONObject.NULL;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  612 */     char initial = string.charAt(0);
/*  613 */     if ((initial >= '0' && initial <= '9') || initial == '-') {
/*      */       try {
/*  615 */         return stringToNumber(string);
/*  616 */       } catch (Exception exception) {}
/*      */     }
/*      */     
/*  619 */     return string;
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
/*      */   public static JSONObject toJSONObject(String string) throws JSONException {
/*  640 */     return toJSONObject(string, XMLParserConfiguration.ORIGINAL);
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
/*      */   public static JSONObject toJSONObject(Reader reader) throws JSONException {
/*  660 */     return toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
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
/*      */   public static JSONObject toJSONObject(Reader reader, boolean keepStrings) throws JSONException {
/*  685 */     if (keepStrings) {
/*  686 */       return toJSONObject(reader, XMLParserConfiguration.KEEP_STRINGS);
/*      */     }
/*  688 */     return toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
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
/*      */   public static JSONObject toJSONObject(Reader reader, XMLParserConfiguration config) throws JSONException {
/*  712 */     JSONObject jo = new JSONObject();
/*  713 */     XMLTokener x = new XMLTokener(reader, config);
/*  714 */     while (x.more()) {
/*  715 */       x.skipPast("<");
/*  716 */       if (x.more()) {
/*  717 */         parse(x, jo, null, config, 0);
/*      */       }
/*      */     } 
/*  720 */     return jo;
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
/*      */   public static JSONObject toJSONObject(String string, boolean keepStrings) throws JSONException {
/*  746 */     return toJSONObject(new StringReader(string), keepStrings);
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
/*      */   public static JSONObject toJSONObject(String string, XMLParserConfiguration config) throws JSONException {
/*  771 */     return toJSONObject(new StringReader(string), config);
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
/*      */   public static String toString(Object object) throws JSONException {
/*  783 */     return toString(object, (String)null, XMLParserConfiguration.ORIGINAL);
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
/*      */   public static String toString(Object object, String tagName) {
/*  797 */     return toString(object, tagName, XMLParserConfiguration.ORIGINAL);
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
/*      */   public static String toString(Object object, String tagName, XMLParserConfiguration config) throws JSONException {
/*  814 */     return toString(object, tagName, config, 0, 0);
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
/*      */   private static String toString(Object object, String tagName, XMLParserConfiguration config, int indentFactor, int indent) throws JSONException {
/*  836 */     StringBuilder sb = new StringBuilder();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  841 */     if (object instanceof JSONObject) {
/*      */ 
/*      */       
/*  844 */       if (tagName != null) {
/*  845 */         sb.append(indent(indent));
/*  846 */         sb.append('<');
/*  847 */         sb.append(tagName);
/*  848 */         sb.append('>');
/*  849 */         if (indentFactor > 0) {
/*  850 */           sb.append("\n");
/*  851 */           indent += indentFactor;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  857 */       JSONObject jo = (JSONObject)object;
/*  858 */       for (String key : jo.keySet()) {
/*  859 */         Object value = jo.opt(key);
/*  860 */         if (value == null) {
/*  861 */           value = "";
/*  862 */         } else if (value.getClass().isArray()) {
/*  863 */           value = new JSONArray(value);
/*      */         } 
/*      */ 
/*      */         
/*  867 */         if (key.equals(config.getcDataTagName())) {
/*  868 */           if (value instanceof JSONArray) {
/*  869 */             JSONArray ja = (JSONArray)value;
/*  870 */             int jaLength = ja.length();
/*      */             
/*  872 */             for (int i = 0; i < jaLength; i++) {
/*  873 */               if (i > 0) {
/*  874 */                 sb.append('\n');
/*      */               }
/*  876 */               Object val = ja.opt(i);
/*  877 */               sb.append(escape(val.toString()));
/*      */             }  continue;
/*      */           } 
/*  880 */           sb.append(escape(value.toString()));
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  885 */         if (value instanceof JSONArray) {
/*  886 */           JSONArray ja = (JSONArray)value;
/*  887 */           int jaLength = ja.length();
/*      */           
/*  889 */           for (int i = 0; i < jaLength; i++) {
/*  890 */             Object val = ja.opt(i);
/*  891 */             if (val instanceof JSONArray) {
/*  892 */               sb.append('<');
/*  893 */               sb.append(key);
/*  894 */               sb.append('>');
/*  895 */               sb.append(toString(val, null, config, indentFactor, indent));
/*  896 */               sb.append("</");
/*  897 */               sb.append(key);
/*  898 */               sb.append('>');
/*      */             } else {
/*  900 */               sb.append(toString(val, key, config, indentFactor, indent));
/*      */             } 
/*      */           }  continue;
/*  903 */         }  if ("".equals(value)) {
/*  904 */           if (config.isCloseEmptyTag()) {
/*  905 */             sb.append(indent(indent));
/*  906 */             sb.append('<');
/*  907 */             sb.append(key);
/*  908 */             sb.append(">");
/*  909 */             sb.append("</");
/*  910 */             sb.append(key);
/*  911 */             sb.append(">");
/*  912 */             if (indentFactor > 0)
/*  913 */               sb.append("\n"); 
/*      */             continue;
/*      */           } 
/*  916 */           sb.append(indent(indent));
/*  917 */           sb.append('<');
/*  918 */           sb.append(key);
/*  919 */           sb.append("/>");
/*  920 */           if (indentFactor > 0) {
/*  921 */             sb.append("\n");
/*      */           }
/*      */ 
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  928 */         sb.append(toString(value, key, config, indentFactor, indent));
/*      */       } 
/*      */       
/*  931 */       if (tagName != null) {
/*      */ 
/*      */         
/*  934 */         sb.append(indent(indent - indentFactor));
/*  935 */         sb.append("</");
/*  936 */         sb.append(tagName);
/*  937 */         sb.append('>');
/*  938 */         if (indentFactor > 0) {
/*  939 */           sb.append("\n");
/*      */         }
/*      */       } 
/*  942 */       return sb.toString();
/*      */     } 
/*      */ 
/*      */     
/*  946 */     if (object != null && (object instanceof JSONArray || object.getClass().isArray())) {
/*  947 */       JSONArray ja; if (object.getClass().isArray()) {
/*  948 */         ja = new JSONArray(object);
/*      */       } else {
/*  950 */         ja = (JSONArray)object;
/*      */       } 
/*  952 */       int jaLength = ja.length();
/*      */       
/*  954 */       for (int i = 0; i < jaLength; i++) {
/*  955 */         Object val = ja.opt(i);
/*      */ 
/*      */ 
/*      */         
/*  959 */         sb.append(toString(val, (tagName == null) ? "array" : tagName, config, indentFactor, indent));
/*      */       } 
/*  961 */       return sb.toString();
/*      */     } 
/*      */ 
/*      */     
/*  965 */     String string = (object == null) ? "null" : escape(object.toString());
/*  966 */     String indentationSuffix = (indentFactor > 0) ? "\n" : "";
/*  967 */     if (tagName == null)
/*  968 */       return indent(indent) + "\"" + string + "\"" + indentationSuffix; 
/*  969 */     if (string.length() == 0) {
/*  970 */       return indent(indent) + "<" + tagName + "/>" + indentationSuffix;
/*      */     }
/*  972 */     return indent(indent) + "<" + tagName + ">" + string + "</" + tagName + ">" + indentationSuffix;
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
/*      */   public static String toString(Object object, int indentFactor) {
/*  988 */     return toString(object, null, XMLParserConfiguration.ORIGINAL, indentFactor);
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
/*      */   public static String toString(Object object, String tagName, int indentFactor) {
/* 1004 */     return toString(object, tagName, XMLParserConfiguration.ORIGINAL, indentFactor);
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
/*      */   public static String toString(Object object, String tagName, XMLParserConfiguration config, int indentFactor) throws JSONException {
/* 1023 */     return toString(object, tagName, config, indentFactor, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String indent(int indent) {
/* 1034 */     StringBuilder sb = new StringBuilder();
/* 1035 */     for (int i = 0; i < indent; i++) {
/* 1036 */       sb.append(' ');
/*      */     }
/* 1038 */     return sb.toString();
/*      */   }
/*      */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/XML.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */