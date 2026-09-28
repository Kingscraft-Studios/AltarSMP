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
/*     */ public class ParserConfiguration
/*     */ {
/*     */   public static final int UNDEFINED_MAXIMUM_NESTING_DEPTH = -1;
/*     */   public static final int DEFAULT_MAXIMUM_NESTING_DEPTH = 512;
/*     */   protected boolean keepStrings;
/*     */   protected int maxNestingDepth;
/*     */   
/*     */   public ParserConfiguration() {
/*  36 */     this.keepStrings = false;
/*  37 */     this.maxNestingDepth = 512;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ParserConfiguration(boolean keepStrings, int maxNestingDepth) {
/*  47 */     this.keepStrings = keepStrings;
/*  48 */     this.maxNestingDepth = maxNestingDepth;
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
/*     */   protected ParserConfiguration clone() {
/*  61 */     return new ParserConfiguration(this.keepStrings, this.maxNestingDepth);
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
/*     */   public boolean isKeepStrings() {
/*  74 */     return this.keepStrings;
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
/*     */   public <T extends ParserConfiguration> T withKeepStrings(boolean newVal) {
/*  89 */     ParserConfiguration parserConfiguration = clone();
/*  90 */     parserConfiguration.keepStrings = newVal;
/*  91 */     return (T)parserConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxNestingDepth() {
/* 100 */     return this.maxNestingDepth;
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
/*     */   public <T extends ParserConfiguration> T withMaxNestingDepth(int maxNestingDepth) {
/* 116 */     ParserConfiguration parserConfiguration = clone();
/*     */     
/* 118 */     if (maxNestingDepth > -1) {
/* 119 */       parserConfiguration.maxNestingDepth = maxNestingDepth;
/*     */     } else {
/* 121 */       parserConfiguration.maxNestingDepth = -1;
/*     */     } 
/*     */     
/* 124 */     return (T)parserConfiguration;
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/ParserConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */