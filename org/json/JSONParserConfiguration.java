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
/*    */ public class JSONParserConfiguration
/*    */   extends ParserConfiguration
/*    */ {
/*    */   protected JSONParserConfiguration clone() {
/* 17 */     return new JSONParserConfiguration();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JSONParserConfiguration withMaxNestingDepth(int maxNestingDepth) {
/* 23 */     return super.<JSONParserConfiguration>withMaxNestingDepth(maxNestingDepth);
/*    */   }
/*    */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/JSONParserConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */