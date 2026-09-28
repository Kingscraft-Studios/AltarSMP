package pl;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.bukkit.plugin.java.JavaPlugin;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bz {
  private static final String[] a;
  
  private static final String[] b;
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(JavaPlugin paramJavaPlugin, String paramString1, String paramString2, File paramFile) {
    // Byte code:
    //   0: invokestatic randomUUID : ()Ljava/util/UUID;
    //   3: invokevirtual toString : ()Ljava/lang/String;
    //   6: astore #4
    //   8: invokestatic randomUUID : ()Ljava/util/UUID;
    //   11: invokevirtual toString : ()Ljava/lang/String;
    //   14: astore #5
    //   16: aload_1
    //   17: getstatic java/nio/charset/StandardCharsets.UTF_8 : Ljava/nio/charset/Charset;
    //   20: invokevirtual toString : ()Ljava/lang/String;
    //   23: invokestatic encode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: ldc '+'
    //   28: sipush #32634
    //   31: sipush #24243
    //   34: invokestatic a : (II)Ljava/lang/String;
    //   37: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   40: astore #6
    //   42: aload_2
    //   43: getstatic java/nio/charset/StandardCharsets.UTF_8 : Ljava/nio/charset/Charset;
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: invokestatic encode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: ldc '+'
    //   54: sipush #32584
    //   57: sipush #4550
    //   60: invokestatic a : (II)Ljava/lang/String;
    //   63: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore #7
    //   68: sipush #32576
    //   71: sipush #-25389
    //   74: invokestatic a : (II)Ljava/lang/String;
    //   77: iconst_2
    //   78: anewarray java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload #6
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload #7
    //   90: aastore
    //   91: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: aload #4
    //   96: aload #5
    //   98: sipush #32633
    //   101: sipush #-19471
    //   104: invokestatic a : (II)Ljava/lang/String;
    //   107: dup_x2
    //   108: pop
    //   109: sipush #32636
    //   112: sipush #-6473
    //   115: invokestatic a : (II)Ljava/lang/String;
    //   118: swap
    //   119: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   124: astore #8
    //   126: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : ()Ljava/lang/String;
    //   129: astore #9
    //   131: aload #9
    //   133: ifnull -> 166
    //   136: aload #8
    //   138: aload #9
    //   140: getstatic java/nio/charset/StandardCharsets.UTF_8 : Ljava/nio/charset/Charset;
    //   143: invokevirtual toString : ()Ljava/lang/String;
    //   146: invokestatic encode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   149: sipush #32603
    //   152: sipush #13726
    //   155: invokestatic a : (II)Ljava/lang/String;
    //   158: swap
    //   159: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: astore #8
    //   166: new java/net/URL
    //   169: dup
    //   170: aload #8
    //   172: invokespecial <init> : (Ljava/lang/String;)V
    //   175: astore #10
    //   177: aload #10
    //   179: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   182: checkcast java/net/HttpURLConnection
    //   185: astore #11
    //   187: aload #11
    //   189: sipush #32602
    //   192: sipush #-21737
    //   195: invokestatic a : (II)Ljava/lang/String;
    //   198: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   201: aload #11
    //   203: sipush #5000
    //   206: invokevirtual setConnectTimeout : (I)V
    //   209: aload #11
    //   211: sipush #5000
    //   214: invokevirtual setReadTimeout : (I)V
    //   217: new java/io/BufferedReader
    //   220: dup
    //   221: new java/io/InputStreamReader
    //   224: dup
    //   225: aload #11
    //   227: invokevirtual getResponseCode : ()I
    //   230: sipush #400
    //   233: if_icmplt -> 248
    //   236: aload #11
    //   238: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   241: goto -> 253
    //   244: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   247: athrow
    //   248: aload #11
    //   250: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   253: invokespecial <init> : (Ljava/io/InputStream;)V
    //   256: invokespecial <init> : (Ljava/io/Reader;)V
    //   259: astore #13
    //   261: new java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial <init> : ()V
    //   268: astore #14
    //   270: aload #13
    //   272: invokevirtual readLine : ()Ljava/lang/String;
    //   275: dup
    //   276: astore #15
    //   278: ifnull -> 296
    //   281: aload #14
    //   283: aload #15
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: goto -> 270
    //   292: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   295: athrow
    //   296: aload #14
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: astore #12
    //   303: aload #13
    //   305: invokevirtual close : ()V
    //   308: goto -> 333
    //   311: astore #14
    //   313: aload #13
    //   315: invokevirtual close : ()V
    //   318: goto -> 330
    //   321: astore #15
    //   323: aload #14
    //   325: aload #15
    //   327: invokevirtual addSuppressed : (Ljava/lang/Throwable;)V
    //   330: aload #14
    //   332: athrow
    //   333: aload #11
    //   335: invokevirtual getResponseCode : ()I
    //   338: sipush #200
    //   341: if_icmpeq -> 533
    //   344: sipush #32581
    //   347: sipush #31886
    //   350: invokestatic a : (II)Ljava/lang/String;
    //   353: astore #13
    //   355: aload #13
    //   357: aload_0
    //   358: invokevirtual getName : ()Ljava/lang/String;
    //   361: new org/json/JSONObject
    //   364: dup
    //   365: aload #12
    //   367: invokespecial <init> : (Ljava/lang/String;)V
    //   370: sipush #32638
    //   373: sipush #-19548
    //   376: invokestatic a : (II)Ljava/lang/String;
    //   379: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   382: aload #13
    //   384: astore #24
    //   386: astore #25
    //   388: astore #26
    //   390: sipush #32580
    //   393: sipush #1352
    //   396: invokestatic a : (II)Ljava/lang/String;
    //   399: aload #26
    //   401: sipush #32591
    //   404: sipush #14132
    //   407: invokestatic a : (II)Ljava/lang/String;
    //   410: aload #25
    //   412: ldc ')'
    //   414: aload #24
    //   416: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   421: astore #14
    //   423: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/logging/Logger;
    //   426: aload #14
    //   428: invokevirtual info : (Ljava/lang/String;)V
    //   431: invokestatic getOnlinePlayers : ()Ljava/util/Collection;
    //   434: invokeinterface iterator : ()Ljava/util/Iterator;
    //   439: astore #15
    //   441: aload #15
    //   443: invokeinterface hasNext : ()Z
    //   448: ifeq -> 492
    //   451: aload #15
    //   453: invokeinterface next : ()Ljava/lang/Object;
    //   458: checkcast org/bukkit/entity/Player
    //   461: astore #16
    //   463: aload #16
    //   465: invokeinterface isOp : ()Z
    //   470: ifne -> 480
    //   473: goto -> 441
    //   476: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   479: athrow
    //   480: aload #16
    //   482: aload #14
    //   484: invokeinterface sendMessage : (Ljava/lang/String;)V
    //   489: goto -> 441
    //   492: goto -> 531
    //   495: astore #13
    //   497: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/logging/Logger;
    //   500: aload_0
    //   501: invokevirtual getName : ()Ljava/lang/String;
    //   504: sipush #32596
    //   507: sipush #-16104
    //   510: invokestatic a : (II)Ljava/lang/String;
    //   513: swap
    //   514: sipush #32607
    //   517: sipush #-17524
    //   520: invokestatic a : (II)Ljava/lang/String;
    //   523: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   528: invokevirtual info : (Ljava/lang/String;)V
    //   531: iconst_0
    //   532: ireturn
    //   533: new org/json/JSONObject
    //   536: dup
    //   537: aload #12
    //   539: invokespecial <init> : (Ljava/lang/String;)V
    //   542: astore #13
    //   544: aload #13
    //   546: sipush #32605
    //   549: sipush #-24197
    //   552: invokestatic a : (II)Ljava/lang/String;
    //   555: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   558: aload #5
    //   560: invokevirtual equals : (Ljava/lang/Object;)Z
    //   563: ifne -> 602
    //   566: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/logging/Logger;
    //   569: aload_0
    //   570: invokevirtual getName : ()Ljava/lang/String;
    //   573: sipush #32577
    //   576: sipush #8619
    //   579: invokestatic a : (II)Ljava/lang/String;
    //   582: swap
    //   583: sipush #32600
    //   586: sipush #7289
    //   589: invokestatic a : (II)Ljava/lang/String;
    //   592: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   597: invokevirtual info : (Ljava/lang/String;)V
    //   600: iconst_0
    //   601: ireturn
    //   602: aload #13
    //   604: sipush #32637
    //   607: sipush #24885
    //   610: invokestatic a : (II)Ljava/lang/String;
    //   613: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   616: aload_2
    //   617: invokevirtual equals : (Ljava/lang/Object;)Z
    //   620: ifeq -> 651
    //   623: aload #13
    //   625: sipush #32593
    //   628: sipush #14775
    //   631: invokestatic a : (II)Ljava/lang/String;
    //   634: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   637: aload_1
    //   638: invokevirtual equals : (Ljava/lang/Object;)Z
    //   641: ifne -> 687
    //   644: goto -> 651
    //   647: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   650: athrow
    //   651: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/logging/Logger;
    //   654: aload_0
    //   655: invokevirtual getName : ()Ljava/lang/String;
    //   658: sipush #32577
    //   661: sipush #8619
    //   664: invokestatic a : (II)Ljava/lang/String;
    //   667: swap
    //   668: sipush #32601
    //   671: sipush #-10964
    //   674: invokestatic a : (II)Ljava/lang/String;
    //   677: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   682: invokevirtual info : (Ljava/lang/String;)V
    //   685: iconst_0
    //   686: ireturn
    //   687: aload #13
    //   689: sipush #32595
    //   692: sipush #-2573
    //   695: invokestatic a : (II)Ljava/lang/String;
    //   698: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   701: astore #14
    //   703: new org/json/JSONObject
    //   706: dup
    //   707: invokespecial <init> : ()V
    //   710: astore #15
    //   712: aload #15
    //   714: sipush #32589
    //   717: sipush #1713
    //   720: invokestatic a : (II)Ljava/lang/String;
    //   723: aload #13
    //   725: sipush #32589
    //   728: sipush #1713
    //   731: invokestatic a : (II)Ljava/lang/String;
    //   734: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   737: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   740: pop
    //   741: aload #15
    //   743: sipush #32632
    //   746: sipush #-11397
    //   749: invokestatic a : (II)Ljava/lang/String;
    //   752: aload #13
    //   754: sipush #32632
    //   757: sipush #-11397
    //   760: invokestatic a : (II)Ljava/lang/String;
    //   763: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   766: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   769: pop
    //   770: aload #15
    //   772: sipush #32606
    //   775: sipush #-9443
    //   778: invokestatic a : (II)Ljava/lang/String;
    //   781: aload #13
    //   783: sipush #32579
    //   786: sipush #-6135
    //   789: invokestatic a : (II)Ljava/lang/String;
    //   792: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   795: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   798: pop
    //   799: aload #15
    //   801: sipush #32592
    //   804: sipush #10468
    //   807: invokestatic a : (II)Ljava/lang/String;
    //   810: aload #13
    //   812: sipush #32592
    //   815: sipush #10468
    //   818: invokestatic a : (II)Ljava/lang/String;
    //   821: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   824: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   827: pop
    //   828: aload #15
    //   830: sipush #32597
    //   833: sipush #-5847
    //   836: invokestatic a : (II)Ljava/lang/String;
    //   839: aload #13
    //   841: sipush #32597
    //   844: sipush #-5847
    //   847: invokestatic a : (II)Ljava/lang/String;
    //   850: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   853: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   856: pop
    //   857: sipush #32582
    //   860: aload #15
    //   862: invokevirtual toString : ()Ljava/lang/String;
    //   865: astore #16
    //   867: sipush #-4640
    //   870: invokestatic a : (II)Ljava/lang/String;
    //   873: sipush #32594
    //   876: sipush #29895
    //   879: invokestatic a : (II)Ljava/lang/String;
    //   882: ldc ''
    //   884: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   887: sipush #32583
    //   890: sipush #-2772
    //   893: invokestatic a : (II)Ljava/lang/String;
    //   896: ldc ''
    //   898: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   901: ldc '\\n'
    //   903: ldc ''
    //   905: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   908: astore #17
    //   910: sipush #32635
    //   913: invokestatic getDecoder : ()Ljava/util/Base64$Decoder;
    //   916: aload #17
    //   918: invokevirtual decode : (Ljava/lang/String;)[B
    //   921: astore #18
    //   923: sipush #8154
    //   926: new java/security/spec/X509EncodedKeySpec
    //   929: dup
    //   930: aload #18
    //   932: invokespecial <init> : ([B)V
    //   935: astore #19
    //   937: invokestatic a : (II)Ljava/lang/String;
    //   940: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyFactory;
    //   943: astore #20
    //   945: sipush #32585
    //   948: aload #20
    //   950: aload #19
    //   952: invokevirtual generatePublic : (Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   955: astore #21
    //   957: sipush #8020
    //   960: invokestatic a : (II)Ljava/lang/String;
    //   963: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/Signature;
    //   966: astore #22
    //   968: aload #22
    //   970: aload #21
    //   972: invokevirtual initVerify : (Ljava/security/PublicKey;)V
    //   975: aload #22
    //   977: aload #16
    //   979: getstatic java/nio/charset/StandardCharsets.UTF_8 : Ljava/nio/charset/Charset;
    //   982: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   985: invokevirtual update : ([B)V
    //   988: aload #22
    //   990: invokestatic getDecoder : ()Ljava/util/Base64$Decoder;
    //   993: aload #14
    //   995: invokevirtual decode : (Ljava/lang/String;)[B
    //   998: invokevirtual verify : ([B)Z
    //   1001: istore #23
    //   1003: iload #23
    //   1005: ifne -> 1044
    //   1008: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/logging/Logger;
    //   1011: aload_0
    //   1012: invokevirtual getName : ()Ljava/lang/String;
    //   1015: sipush #32577
    //   1018: sipush #8619
    //   1021: invokestatic a : (II)Ljava/lang/String;
    //   1024: swap
    //   1025: sipush #32578
    //   1028: sipush #7135
    //   1031: invokestatic a : (II)Ljava/lang/String;
    //   1034: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokevirtual info : (Ljava/lang/String;)V
    //   1042: iconst_0
    //   1043: ireturn
    //   1044: aload_0
    //   1045: aload_1
    //   1046: aload_2
    //   1047: aload #4
    //   1049: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/plugin/java/JavaPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1052: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/logging/Logger;
    //   1055: aload_0
    //   1056: invokevirtual getName : ()Ljava/lang/String;
    //   1059: sipush #32598
    //   1062: sipush #14589
    //   1065: invokestatic a : (II)Ljava/lang/String;
    //   1068: swap
    //   1069: ldc '!'
    //   1071: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1076: invokevirtual info : (Ljava/lang/String;)V
    //   1079: iconst_1
    //   1080: ireturn
    //   1081: astore #4
    //   1083: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/util/logging/Logger;
    //   1086: aload_0
    //   1087: invokevirtual getName : ()Ljava/lang/String;
    //   1090: sipush #32577
    //   1093: sipush #8619
    //   1096: invokestatic a : (II)Ljava/lang/String;
    //   1099: swap
    //   1100: sipush #32639
    //   1103: sipush #28970
    //   1106: invokestatic a : (II)Ljava/lang/String;
    //   1109: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1114: invokevirtual info : (Ljava/lang/String;)V
    //   1117: aload #4
    //   1119: invokevirtual printStackTrace : ()V
    //   1122: iconst_0
    //   1123: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	532	1081	java/lang/Exception
    //   187	244	244	java/lang/Throwable
    //   261	303	311	java/lang/Throwable
    //   278	292	292	java/lang/Throwable
    //   313	318	321	java/lang/Throwable
    //   344	492	495	java/lang/Exception
    //   463	476	476	java/lang/Throwable
    //   533	601	1081	java/lang/Exception
    //   602	644	647	java/lang/Throwable
    //   602	686	1081	java/lang/Exception
    //   687	1043	1081	java/lang/Exception
    //   1044	1080	1081	java/lang/Exception
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(JavaPlugin paramJavaPlugin, String paramString) {
    try {
      File file = new File(paramJavaPlugin.getDataFolder(), a(32588, 18733));
      String str1 = "";
      try {
        if (!file.exists()) {
          paramJavaPlugin.getDataFolder().mkdirs();
          file.createNewFile();
        } else {
          str1 = (new String(Files.readAllBytes(Paths.get(file.getPath(), new String[0])), StandardCharsets.UTF_8)).trim();
        } 
      } catch (Exception exception) {
        throw a(null);
      } 
      String str2 = str1;
      if (str2.isEmpty()) {
        String str = MarketplaceProvider.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
        if (str != null) {
          str2 = str;
        } else {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info(a(32586, -993) + a(32586, -993) + paramJavaPlugin.getName());
          return false;
        } 
      } 
      boolean bool = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramJavaPlugin, paramString, str2, file);
      try {
        if (bool)
          try {
            if (!str2.equals(str1))
              Files.write(file.toPath(), str2.getBytes(StandardCharsets.UTF_8), new java.nio.file.OpenOption[0]); 
          } catch (Exception exception) {
            throw a(null);
          }  
      } catch (Exception exception) {
        throw a(null);
      } 
      try {
        if (bool) {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = String.valueOf(System.currentTimeMillis());
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = String.valueOf(Runtime.getRuntime().freeMemory());
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764by.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = String.valueOf(Thread.activeCount());
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = String.valueOf(System.nanoTime());
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bu.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = String.valueOf(Runtime.getRuntime().totalMemory());
        } 
      } catch (Exception exception) {
        throw a(null);
      } 
      return bool;
    } catch (Exception exception) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info(a(32577, 8619) + a(32577, 8619) + paramJavaPlugin.getName());
      exception.printStackTrace();
      return false;
    } 
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(JavaPlugin paramJavaPlugin, String paramString1, String paramString2) {
    try {
      File file = new File(paramJavaPlugin.getDataFolder(), a(32604, -21897));
      try {
        if (!file.exists()) {
          paramJavaPlugin.getDataFolder().mkdirs();
          file.createNewFile();
        } 
      } catch (Exception exception) {
        throw a(null);
      } 
      Files.write(file.toPath(), paramString2.getBytes(StandardCharsets.UTF_8), new java.nio.file.OpenOption[0]);
      return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramJavaPlugin, paramString1, paramString2, file);
    } catch (Exception exception) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bv.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.info(a(32590, -25206) + a(32590, -25206) + paramJavaPlugin.getName());
      exception.printStackTrace();
      return false;
    } 
  }
  
  private static Throwable a(Throwable paramThrowable) {
    return paramThrowable;
  }
  
  static {
    // Byte code:
    //   0: bipush #40
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'ó{[F`ê®mjç½Kª]â?ÃvÌ¼)ÊkB8°;À<à£r\\fLÔ84lõÐ À¨hÉüNõ£ ¿Zé\äÇ¹%uP·S¬p\\r=±ñí£T6+=¯2óáê©& 8bBù%ÔWA¡¢l$´Ye:Òßd\\tfx_÷­?W!J\\bõ;çâÃ!ëbJ]Ý\\n_<Ò*>¨j7ãR&¾ÔÓ=äOg¸¾õÄ hk-Ã Â¡âr$_¼íÙxMMïPvçæK¥¤|:quíÖÔ°®OQ;\\naé¢ä@CÙ²Míûuý¨-YörU6Èø¹ÈNÚ8Ø:­pºüEÉ3çvàê¯\\byDuØÎÀÖ&2ÛÖhRô\\n±ö8+(hqÂ503\\r)¨!QÀmMF`_zlµ3úÿ\\rZ&\\bÁÿT®!MKL(¾¨¯Í÷*ñT£Ø$s ©íiaa×9R}F4;þúÒN\KpCÙñp\\r(ñSå÷U¼¥z9Ñu¯ç¦û")Ê`AÉcÙÎ¿®Ù{ù3(H½Æ\\r\\bY»T¶Cp<¡Û%C¢&«´ ÜU¸úJ´ÝË¯\\t)P&\\tÕ¼mRÛÑGÊE=Eì²f/ÞÈ$¬4§EÔÃǂBQ3¿¯}äeÄÜ¡FÇðneXP5G\w×BJ÷Éø½¦Ò~ØÈTíøB`ÞcYôÏÜºóïÇ\ÝßÀðRQ?Ë_DÑHóPzó£UAÑ¥¢¢fFû-ÐIÔ(¬Ù]9&ÆÏhöò.¸±xÉmqW{`þ;N?#<øIhïiSlº2Dà£ò$coù*åî<ÿS+ü2_RQáq64yGßÐÁæeò9Ùà\\b[ð¸ºþb¿¼£d±í±¤Û*m\\f¶$Õ#¶éijTãh9-óôxÑÉß£¶r ÔÁ<dsÑ¶ùGøöì¨¹ñ2+%>ý²¬Ç«=º(ç3¸}°úf÷ÏÕ+;@0õÏÂ¼YFsêC¥ùÒ¾Ó·Þ´ûãÔM<æ$cÛ%óMxn2³\O5Ò\\fj´¥^º0,XoBkjz£ºÍ+²af}^,`9\\n0nZrÖ¦Il¹ÎxÇµ+FN\\nßÿÎF÷=qÑ×:î]&,2léQ¿·×î¯rÝ¤D0ú¹®aøqsf*Y¹2rx.viæç³Ï&ÁpÇbÙ"f½Q^hÄîÁ,~ÇÛ4í¬\\r2ÙZÉ5«d\\n¶ZI:1ºïîuBEÇ@\\b'1Í¹<\\bøè|Cl wÆìÁðìð»;±ÇIö@g2 ëÄ.'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: iconst_3
    //   19: istore_1
    //   20: iconst_m1
    //   21: istore_0
    //   22: bipush #54
    //   24: iinc #0, 1
    //   27: aload_2
    //   28: iload_0
    //   29: dup
    //   30: iload_1
    //   31: iadd
    //   32: invokevirtual substring : (II)Ljava/lang/String;
    //   35: iconst_m1
    //   36: goto -> 142
    //   39: aload #5
    //   41: swap
    //   42: iload_3
    //   43: iinc #3, 1
    //   46: swap
    //   47: aastore
    //   48: iload_0
    //   49: iload_1
    //   50: iadd
    //   51: dup
    //   52: istore_0
    //   53: iload #4
    //   55: if_icmpge -> 67
    //   58: aload_2
    //   59: iload_0
    //   60: invokevirtual charAt : (I)C
    //   63: istore_1
    //   64: goto -> 22
    //   67: ldc '#&º´ba{L<'
    //   69: dup
    //   70: astore_2
    //   71: invokevirtual length : ()I
    //   74: istore #4
    //   76: bipush #7
    //   78: istore_1
    //   79: iconst_m1
    //   80: istore_0
    //   81: bipush #58
    //   83: iinc #0, 1
    //   86: aload_2
    //   87: iload_0
    //   88: dup
    //   89: iload_1
    //   90: iadd
    //   91: invokevirtual substring : (II)Ljava/lang/String;
    //   94: iconst_0
    //   95: goto -> 142
    //   98: aload #5
    //   100: swap
    //   101: iload_3
    //   102: iinc #3, 1
    //   105: swap
    //   106: aastore
    //   107: iload_0
    //   108: iload_1
    //   109: iadd
    //   110: dup
    //   111: istore_0
    //   112: iload #4
    //   114: if_icmpge -> 126
    //   117: aload_2
    //   118: iload_0
    //   119: invokevirtual charAt : (I)C
    //   122: istore_1
    //   123: goto -> 81
    //   126: aload #5
    //   128: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bz.a : [Ljava/lang/String;
    //   131: bipush #40
    //   133: anewarray java/lang/String
    //   136: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bz.b : [Ljava/lang/String;
    //   139: goto -> 300
    //   142: dup_x2
    //   143: pop
    //   144: invokevirtual toCharArray : ()[C
    //   147: dup_x1
    //   148: arraylength
    //   149: dup_x2
    //   150: pop
    //   151: iconst_0
    //   152: istore #6
    //   154: dup2_x1
    //   155: pop2
    //   156: dup_x2
    //   157: iconst_1
    //   158: if_icmpgt -> 260
    //   161: dup2
    //   162: swap
    //   163: iload #6
    //   165: dup2_x1
    //   166: caload
    //   167: swap
    //   168: iload #6
    //   170: bipush #7
    //   172: irem
    //   173: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #9
    //   214: goto -> 244
    //   217: bipush #23
    //   219: goto -> 244
    //   222: bipush #15
    //   224: goto -> 244
    //   227: bipush #34
    //   229: goto -> 244
    //   232: bipush #72
    //   234: goto -> 244
    //   237: bipush #8
    //   239: goto -> 244
    //   242: bipush #113
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 165
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 161
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 39, 0 -> 98
    //   300: return
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x7F5A) & 0xFFFF;
    if (b[i] == null) {
      char[] arrayOfChar = a[i].toCharArray();
      switch (arrayOfChar[0] & 0xFF) {
        case 0:
        
        case 1:
        
        case 2:
        
        case 3:
        
        case 4:
        
        case 5:
        
        case 6:
        
        case 7:
        
        case 8:
        
        case 9:
        
        case 10:
        
        case 11:
        
        case 12:
        
        case 13:
        
        case 14:
        
        case 15:
        
        case 16:
        
        case 17:
        
        case 18:
        
        case 19:
        
        case 20:
        
        case 21:
        
        case 22:
        
        case 23:
        
        case 24:
        
        case 25:
        
        case 26:
        
        case 27:
        
        case 28:
        
        case 29:
        
        case 30:
        
        case 31:
        
        case 32:
        
        case 33:
        
        case 34:
        
        case 35:
        
        case 36:
        
        case 37:
        
        case 38:
        
        case 39:
        
        case 40:
        
        case 41:
        
        case 42:
        
        case 43:
        
        case 44:
        
        case 45:
        
        case 46:
        
        case 47:
        
        case 48:
        
        case 49:
        
        case 50:
        
        case 51:
        
        case 52:
        
        case 53:
        
        case 54:
        
        case 55:
        
        case 56:
        
        case 57:
        
        case 58:
        
        case 59:
        
        case 60:
        
        case 61:
        
        case 62:
        
        case 63:
        
        case 64:
        
        case 65:
        
        case 66:
        
        case 67:
        
        case 68:
        
        case 69:
        
        case 70:
        
        case 71:
        
        case 72:
        
        case 73:
        
        case 74:
        
        case 75:
        
        case 76:
        
        case 77:
        
        case 78:
        
        case 79:
        
        case 80:
        
        case 81:
        
        case 82:
        
        case 83:
        
        case 84:
        
        case 85:
        
        case 86:
        
        case 87:
        
        case 88:
        
        case 89:
        
        case 90:
        
        case 91:
        
        case 92:
        
        case 93:
        
        case 94:
        
        case 95:
        
        case 96:
        
        case 97:
        
        case 98:
        
        case 99:
        
        case 100:
        
        case 101:
        
        case 102:
        
        case 103:
        
        case 104:
        
        case 105:
        
        case 106:
        
        case 107:
        
        case 108:
        
        case 109:
        
        case 110:
        
        case 111:
        
        case 112:
        
        case 113:
        
        case 114:
        
        case 115:
        
        case 116:
        
        case 117:
        
        case 118:
        
        case 119:
        
        case 120:
        
        case 121:
        
        case 122:
        
        case 123:
        
        case 124:
        
        case 125:
        
        case 126:
        
        case 127:
        
        case 128:
        
        case 129:
        
        case 130:
        
        case 131:
        
        case 132:
        
        case 133:
        
        case 134:
        
        case 135:
        
        case 136:
        
        case 137:
        
        case 138:
        
        case 139:
        
        case 140:
        
        case 141:
        
        case 142:
        
        case 143:
        
        case 144:
        
        case 145:
        
        case 146:
        
        case 147:
        
        case 148:
        
        case 149:
        
        case 150:
        
        case 151:
        
        case 152:
        
        case 153:
        
        case 154:
        
        case 155:
        
        case 156:
        
        case 157:
        
        case 158:
        
        case 159:
        
        case 160:
        
        case 161:
        
        case 162:
        
        case 163:
        
        case 164:
        
        case 165:
        
        case 166:
        
        case 167:
        
        case 168:
        
        case 169:
        
        case 170:
        
        case 171:
        
        case 172:
        
        case 173:
        
        case 174:
        
        case 175:
        
        case 176:
        
        case 177:
        
        case 178:
        
        case 179:
        
        case 180:
        
        case 181:
        
        case 182:
        
        case 183:
        
        case 184:
        
        case 185:
        
        case 186:
        
        case 187:
        
        case 188:
        
        case 189:
        
        case 190:
        
        case 191:
        
        case 192:
        
        case 193:
        
        case 194:
        
        case 195:
        
        case 196:
        
        case 197:
        
        case 198:
        
        case 199:
        
        case 200:
        
        case 201:
        
        case 202:
        
        case 203:
        
        case 204:
        
        case 205:
        
        case 206:
        
        case 207:
        
        case 208:
        
        case 209:
        
        case 210:
        
        case 211:
        
        case 212:
        
        case 213:
        
        case 214:
        
        case 215:
        
        case 216:
        
        case 217:
        
        case 218:
        
        case 219:
        
        case 220:
        
        case 221:
        
        case 222:
        
        case 223:
        
        case 224:
        
        case 225:
        
        case 226:
        
        case 227:
        
        case 228:
        
        case 229:
        
        case 230:
        
        case 231:
        
        case 232:
        
        case 233:
        
        case 234:
        
        case 235:
        
        case 236:
        
        case 237:
        
        case 238:
        
        case 239:
        
        case 240:
        
        case 241:
        
        case 242:
        
        case 243:
        
        case 244:
        
        case 245:
        
        case 246:
        
        case 247:
        
        case 248:
        
        case 249:
        
        case 250:
        
        case 251:
        
        case 252:
        
        case 253:
        
        case 254:
        
        default:
          break;
      } 
      byte b1 = 95;
      int j = (paramInt2 & 0xFF) - b1;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - b1;
      if (k < 0)
        k += 256; 
      for (byte b2 = 0; b2 < arrayOfChar.length; b2++) {
        int m = b2 % 2;
        if (m == 0) {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b2]) & 0xFF;
        } else {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b2]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bz.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */