/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RSATester
 * Author:   admin
 * Date:     2019/4/6 22:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.utils;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/4/6
 * @since 1.0.0
 */

import com.szxfd.springboot.web.rsa.RSAUtils;

import java.util.Map;

public class RSATester {

    static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        test();
//        testSign();
    }

    static void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String source = "这是一行没有任何意义的文字，你看完了等于没看，不是吗,fkskld12352#@%@#%6456可是经典款福克斯款式大方" +
                "思考对方开始考虑到款福克斯的卡夫卡说了带份开始打康复科萨克的卡夫卡洒落的卡夫卡落实到款福克斯开始的开发快速" +
                "深刻的反馈数据库的反馈上课的咖啡机开始的开发快速多家客服接口是开始的开发快速看的反馈了速度快是考虑到付款时刻" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "思考对方开口圣诞快乐福克斯考虑到上课了对方是考虑到卢卡申科的房价快速卡到福克斯打开克里斯多夫就开始看的反馈了" +
                "是考虑到付款时刻来的思考对方开始考虑到卡洛斯的卡夫卡圣诞快乐付款斯柯达上刊登了疯狂开上岛咖啡开始打斯卡拉蒂是的？";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        System.out.println("加密后文字：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
        String target = new String(decodedData);
        System.out.println("解密后文字: \r\n" + target);
    }

    static void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSAUtils.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
        boolean status = RSAUtils.verify(encodedData, publicKey, sign);
        System.err.println("验证结果:\r" + status);
    }

}