/*    */ package org.json;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Properties;
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
/*    */ public class Property
/*    */ {
/*    */   public static JSONObject toJSONObject(Properties properties) throws JSONException {
/* 32 */     JSONObject jo = new JSONObject();
/* 33 */     if (properties != null && !properties.isEmpty()) {
/* 34 */       Enumeration<?> enumProperties = properties.propertyNames();
/* 35 */       while (enumProperties.hasMoreElements()) {
/* 36 */         String name = (String)enumProperties.nextElement();
/* 37 */         jo.put(name, properties.getProperty(name));
/*    */       } 
/*    */     } 
/* 40 */     return jo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Properties toProperties(JSONObject jo) throws JSONException {
/* 50 */     Properties properties = new Properties();
/* 51 */     if (jo != null)
/*    */     {
/* 53 */       for (String key : jo.keySet()) {
/* 54 */         Object value = jo.opt(key);
/* 55 */         if (!JSONObject.NULL.equals(value)) {
/* 56 */           properties.put(key, value.toString());
/*    */         }
/*    */       } 
/*    */     }
/* 60 */     return properties;
/*    */   }
/*    */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/Property.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */