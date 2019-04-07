///**
// * Copyright (C), 2015-2019, XXX有限公司
// * FileName: RSAUtil
// * Author:   admin
// * Date:     2019/4/1 22:25
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.szxfd.springboot.web.utils;
//
//import javax.crypto.Cipher;
//import java.security.KeyFactory;
//import java.security.PublicKey;
//import java.security.spec.KeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author admin
// * @create 2019/4/1
// * @since 1.0.0
// */
//public class RSAUtil {
//
//    private byte[] encryptRASData(byte[] encryptData, String key) {
//        try {
//            //Base64编码
//            byte data[] = Base64.decode(key.getBytes(), Base64.DEFAULT);
//            KeySpec keySpec = new X509EncodedKeySpec(data);
//            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);
//            //RSA加密
//            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
//            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//            //因为RSA加密只能加密比公钥长度小于1/8的字符串，所以这里分段加密
//            int blockSize = cipher.getBlockSize();
//            byte finalResult[] = null;
//            for (int i = 0; i < encryptData.length; i = i + blockSize) {
//                int len = encryptData.length - i > blockSize ? blockSize : encryptData.length - i;
//                byte byteSub[] = subBytes(encryptData, i, len);
//                byte result[] = cipher.doFinal(byteSub);
//                if (finalResult == null) {
//                    finalResult = result;
//                } else {
//                    finalResult = byteMerger(finalResult, result);
//                }
//            }
//            return finalResult;
//        } catch (Exception e) {
//            return new byte[]{};
//        }
//    }
//
//}