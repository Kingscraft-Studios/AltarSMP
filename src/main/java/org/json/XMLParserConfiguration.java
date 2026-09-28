/*     */ package org.json;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XMLParserConfiguration
/*     */   extends ParserConfiguration
/*     */ {
/*  26 */   public static final XMLParserConfiguration ORIGINAL = new XMLParserConfiguration();
/*     */ 
/*     */   
/*  29 */   public static final XMLParserConfiguration KEEP_STRINGS = (new XMLParserConfiguration())
/*  30 */     .withKeepStrings(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String cDataTagName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean convertNilAttributeToNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean closeEmptyTag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, XMLXsiTypeConverter<?>> xsiTypeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<String> forceList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean shouldTrimWhiteSpace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLParserConfiguration() {
/*  79 */     this.cDataTagName = "content";
/*  80 */     this.convertNilAttributeToNull = false;
/*  81 */     this.xsiTypeMap = Collections.emptyMap();
/*  82 */     this.forceList = Collections.emptySet();
/*  83 */     this.shouldTrimWhiteSpace = true;
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
/*     */   @Deprecated
/*     */   public XMLParserConfiguration(boolean keepStrings) {
/*  96 */     this(keepStrings, "content", false);
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
/*     */   @Deprecated
/*     */   public XMLParserConfiguration(String cDataTagName) {
/* 111 */     this(false, cDataTagName, false);
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
/*     */   @Deprecated
/*     */   public XMLParserConfiguration(boolean keepStrings, String cDataTagName) {
/* 126 */     super(keepStrings, 512);
/* 127 */     this.cDataTagName = cDataTagName;
/* 128 */     this.convertNilAttributeToNull = false;
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
/*     */   @Deprecated
/*     */   public XMLParserConfiguration(boolean keepStrings, String cDataTagName, boolean convertNilAttributeToNull) {
/* 145 */     super(keepStrings, 512);
/* 146 */     this.cDataTagName = cDataTagName;
/* 147 */     this.convertNilAttributeToNull = convertNilAttributeToNull;
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
/*     */   private XMLParserConfiguration(boolean keepStrings, String cDataTagName, boolean convertNilAttributeToNull, Map<String, XMLXsiTypeConverter<?>> xsiTypeMap, Set<String> forceList, int maxNestingDepth, boolean closeEmptyTag) {
/* 167 */     super(keepStrings, maxNestingDepth);
/* 168 */     this.cDataTagName = cDataTagName;
/* 169 */     this.convertNilAttributeToNull = convertNilAttributeToNull;
/* 170 */     this.xsiTypeMap = Collections.unmodifiableMap(xsiTypeMap);
/* 171 */     this.forceList = Collections.unmodifiableSet(forceList);
/* 172 */     this.closeEmptyTag = closeEmptyTag;
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
/*     */   protected XMLParserConfiguration clone() {
/* 185 */     XMLParserConfiguration config = new XMLParserConfiguration(this.keepStrings, this.cDataTagName, this.convertNilAttributeToNull, this.xsiTypeMap, this.forceList, this.maxNestingDepth, this.closeEmptyTag);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     config.shouldTrimWhiteSpace = this.shouldTrimWhiteSpace;
/* 195 */     return config;
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
/*     */   public XMLParserConfiguration withKeepStrings(boolean newVal) {
/* 210 */     return super.<XMLParserConfiguration>withKeepStrings(newVal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getcDataTagName() {
/* 221 */     return this.cDataTagName;
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
/*     */   public XMLParserConfiguration withcDataTagName(String newVal) {
/* 235 */     XMLParserConfiguration newConfig = clone();
/* 236 */     newConfig.cDataTagName = newVal;
/* 237 */     return newConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConvertNilAttributeToNull() {
/* 248 */     return this.convertNilAttributeToNull;
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
/*     */   public XMLParserConfiguration withConvertNilAttributeToNull(boolean newVal) {
/* 262 */     XMLParserConfiguration newConfig = clone();
/* 263 */     newConfig.convertNilAttributeToNull = newVal;
/* 264 */     return newConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, XMLXsiTypeConverter<?>> getXsiTypeMap() {
/* 275 */     return this.xsiTypeMap;
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
/*     */   public XMLParserConfiguration withXsiTypeMap(Map<String, XMLXsiTypeConverter<?>> xsiTypeMap) {
/* 288 */     XMLParserConfiguration newConfig = clone();
/* 289 */     Map<String, XMLXsiTypeConverter<?>> cloneXsiTypeMap = new HashMap<>(xsiTypeMap);
/* 290 */     newConfig.xsiTypeMap = Collections.unmodifiableMap(cloneXsiTypeMap);
/* 291 */     return newConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getForceList() {
/* 300 */     return this.forceList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLParserConfiguration withForceList(Set<String> forceList) {
/* 310 */     XMLParserConfiguration newConfig = clone();
/* 311 */     Set<String> cloneForceList = new HashSet<>(forceList);
/* 312 */     newConfig.forceList = Collections.unmodifiableSet(cloneForceList);
/* 313 */     return newConfig;
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
/*     */   public XMLParserConfiguration withMaxNestingDepth(int maxNestingDepth) {
/* 328 */     return super.<XMLParserConfiguration>withMaxNestingDepth(maxNestingDepth);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLParserConfiguration withCloseEmptyTag(boolean closeEmptyTag) {
/* 337 */     XMLParserConfiguration clonedConfiguration = clone();
/* 338 */     clonedConfiguration.closeEmptyTag = closeEmptyTag;
/* 339 */     return clonedConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLParserConfiguration withShouldTrimWhitespace(boolean shouldTrimWhiteSpace) {
/* 350 */     XMLParserConfiguration clonedConfiguration = clone();
/* 351 */     clonedConfiguration.shouldTrimWhiteSpace = shouldTrimWhiteSpace;
/* 352 */     return clonedConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCloseEmptyTag() {
/* 361 */     return this.closeEmptyTag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldTrimWhiteSpace() {
/* 370 */     return this.shouldTrimWhiteSpace;
/*     */   }
/*     */ }


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/org/json/XMLParserConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */