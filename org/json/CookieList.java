/*    */ package org.json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CookieList
/*    */ {
/*    */   public static JSONObject toJSONObject(String string) throws JSONException {
/* 34 */     JSONObject jo = new JSONObject();
/* 35 */     JSONTokener x = new JSONTokener(string);
/* 36 */     while (x.more()) {
/* 37 */       String name = Cookie.unescape(x.nextTo('='));
/* 38 */       x.next('=');
/* 39 */       jo.put(name, Cookie.unescape(x.nextTo(';')));
/* 40 */       x.next();
/*    */     } 
/* 42 */     return jo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String toString(JSONObject jo) throws JSONException {
/* 55 */     boolean isEndOfPair = false;
/* 56 */     StringBuilder sb = new StringBuilder();
/*    */     
/* 58 */     for (String key : jo.keySet()) {
/* 59 */       Object value = jo.opt(key);
/* 60 */       if (!JSONObject.NULL.equals(value)) {
/* 61 */         if (isEndOfPair) {
/* 62 */           sb.append(';');
/*    */         }
/* 64 */         sb.append(Cookie.escape(key));
/* 65 */         sb.append("=");
/* 66 */         sb.append(Cookie.escape(value.toString()));
/* 67 */         isEndOfPair = true;
/*    */       } 
/*    */     } 
/* 70 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/CookieList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */