package com.szxfd.springboot.web.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.*;
import java.util.Base64;

public class CryptUtilTest {

    private static final String CLASS_NAME = "CryptUtilTest  ";
    private String mPrivateKeyString;
    private String mPublicKeyString;
    private PublicKey mPublic;
    private PrivateKey mPrivate;

    /**
     * 首先要说明的是Base64是编码解码，而不是加密解密，因为加密解密你是需要密钥的，编码是大家都知道怎么解码的，不需要密钥的。
     * base64，将任意的字节数组，通过算法，生成只有（英文大小写（52个字母），数字（10个）+/（2个））内容标识的字符串数据；相当于将任何的内容转换为可见字符串的表示。
     * Base64, 将原始数据按照3个字节一个分组,按位进行分割为每6位一个字节的形式，进行转换，形成新的4个字节，这4个字节的再通过Base64的编码表进行映射。
     * 6位能够表示的字符数就是64所以称为Base64，其实就是字节总长度增加了3分之一。
     */
    @Test
    public void base64Test() {
        /**
         * 最好 使用 encodeToString，不然还要自己转换。
         byte[] encode = Base64.encode("你好".getBytes(), Base64.NO_WRAP);
         String encodeString = new String(encode);
         System.out.println(CLASS_NAME,"你好的Base64 的编码是"+encodeString);
         */

//        //编码
//        String encodeToString = Base64.getEncoder().encodeToString("你好".getBytes());
//        System.out.println(CLASS_NAME + "你好的Base64 的编码是：" + encodeToString);

        String source = "肯定是福克斯快递费ksdkf@#$sdk1263-*/0sd";
        //解码
        //模拟解码的数据
        String fakeString = Base64.getEncoder().encodeToString(source.getBytes());
        System.out.println(CLASS_NAME + "模拟解码数据得到的Base64编码：" + fakeString);

        // 解码时注意事项，第二个参数的取值，应该和编码时一致；
        byte[] decodeStringbytes = Base64.getDecoder().decode(fakeString.getBytes());
        String decodeString = new String(decodeStringbytes);
        System.out.println(CLASS_NAME + "模拟解码数据得到的Base64解码：" + decodeString);
        Assert.assertEquals(source, decodeString);

    }

    public void hexEncodingText() {

    }

    /**
     * URLEncode 简单一句话，URLEncoding 就是为了将网址中的非ASCII码内容，转换成可以传输字符
     * 在编码的时候，保留所有英文字母，数字，以及特定的字符，（这些字符全部都是ASCII中的），除此之外将会转换为十六进制标识，并且在每一个十六进制之前加上%
     * 内容中的' '空格，全部采用加号+替换
     * URLEncoding 的格式，将要转换的内容，用十六进制表示法转换出来，然后每一个字节表示之前，用%开头；例如0x9c字节经过URLEncoding 就变成了%9C
     * 应用场景：所有GET请求，网址用到中文的情况，以及POST请求中，所有的Key 和Value，在提交之前，必须要经过URLEncoding
     */
    @Test
    public void urlEncodingTest() {
        try {
            //URLEncoder的编码
            String source = "这个feel倍爽";
            String encode = URLEncoder.encode(source, "UTF-8");//第二个参数一定要是服务器段支持的格式
            System.out.println(CLASS_NAME + "编码后：" + encode);

            //URLDecoder的解码：
            String decoderString = URLDecoder.decode(encode, "UTF-8");
            System.out.println(CLASS_NAME + "解码后：" + decoderString);
            Assert.assertEquals(source, decoderString);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    //DES 加密解密的测试
    @Test
    public void desTest() {
        String content = "就这么办";
        String password = "abcdefgh";//DES 密钥必须是8个字节的。

        // 加密解密用的都是字节数组
        byte[] contentBytes = content.getBytes();
        byte[] passwordBytes = password.getBytes();
        //加密
        byte[] bytes = CryptUtil.desEncrypt(contentBytes, passwordBytes);
        //TODO  !!! 加密的结果不允许直接 new String() !!!
        String encodeString = Base64.getEncoder().encodeToString(bytes);
        System.out.println(CLASS_NAME + "DES加密后的数据：" + encodeString);

        //解密
        byte[] base64Decodedbytes = Base64.getDecoder().decode(encodeString.getBytes());
        byte[] byteDecode = CryptUtil.desDecrypt(base64Decodedbytes, passwordBytes);
        String decodeString = new String(byteDecode);
        System.out.println(CLASS_NAME + "DES解密后的数据：" + decodeString);
        Assert.assertEquals(content, decodeString);
    }

    //DESede 加密解密的测试
    @Test
    public void desedeTest() {
        String content = "深圳大湾区";
        String password = "abcdefghabcdefghabcdefgh";//DESede 密钥必须是24个字节的。

        // 加密解密用的都是字节数组
        byte[] contentBytes = content.getBytes();
        byte[] passwordBytes = password.getBytes();
        //加密
        byte[] bytes = CryptUtil.desedeEncrypt(contentBytes, passwordBytes);
        //TODO  !!! 加密的结果不允许直接 new String() !!!
        String encodeString = Base64.getEncoder().encodeToString(bytes);
        System.out.println(CLASS_NAME + "DESede加密后的数据：" + encodeString);

        //解密
        byte[] base64Decodedbytes = Base64.getDecoder().decode(encodeString.getBytes());
        byte[] byteDecode = CryptUtil.desedeDecrypt(base64Decodedbytes, passwordBytes);
        String decodeString = new String(byteDecode);
        System.out.println(CLASS_NAME + "DESede解密后的数据：" + decodeString);
        Assert.assertEquals(content, decodeString);
    }

    //AES 加密解密测试
    @Test
    public void aesTest() {
        String content = "AES加密解密demo";
        String password = "abcdefghabcdefgh";//DESede 密钥必须是16个字节的。
        // 加密解密用的都是字节数组
        byte[] contentBytes = content.getBytes();
        byte[] passwordBytes = password.getBytes();
        //加密
        byte[] bytes = CryptUtil.aesEncrypt(contentBytes, passwordBytes);
        //TODO  !!! 加密的结果不允许直接 new String() !!!
        String encodeString = Base64.getEncoder().encodeToString(bytes);
        System.out.println(CLASS_NAME + "AES加密后的数据：" + encodeString);

        //解密
        byte[] base64Decodedbytes = Base64.getDecoder().decode(encodeString.getBytes());
        byte[] byteDecode = CryptUtil.aesDecrypt(base64Decodedbytes, passwordBytes);
        String decodeString = new String(byteDecode);
        System.out.println(CLASS_NAME + "AES解密后的数据：" + decodeString);

    }


    //RSA 的初始化，获得私钥和密钥
    public void rsaInit() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");//RAS 密钥生成器
            kpg.initialize(1024, new SecureRandom());//生成制定长度的密钥
            KeyPair keyPair = kpg.generateKeyPair();//生成密钥对
            mPrivate = keyPair.getPrivate();//获取私钥
            mPublic = keyPair.getPublic();//获取公钥
            //通过getEncoded方法来获取密钥的具体内容
            byte[] privateEncoded = mPrivate.getEncoded();
            byte[] publicEncoded = mPublic.getEncoded();
            //为了防止乱码，使用Base64来转换，这样显示的时候就不会有乱码了
            mPrivateKeyString = Base64.getEncoder().encodeToString(privateEncoded);
            mPublicKeyString = Base64.getEncoder().encodeToString(publicEncoded);

            System.out.println(CLASS_NAME + "RSA私钥：" + mPrivateKeyString);
            System.out.println(CLASS_NAME + "RSA公钥：" + mPublicKeyString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rsaTest() {
        rsaInit();
        String data = "我是RSA加密测试demo";
        byte[] bytes = data.getBytes();
        byte[] encryptByte = CryptUtil.rsaEncrypt(bytes, mPrivate);

        //要使用Base64来进行编码，如果不这样做就会显示乱码
        //String encryptString = new String(encryptByte);//这里产生乱码
        String encryptString = Base64.getEncoder().encodeToString(encryptByte);

        System.out.println(CLASS_NAME + "RSA加密后:" + encryptString);

        //解密：
        //要使用Base64来进行解码，如果不这样做就会显示乱码
        //byte[] sourceBytes = encryptString.getBytes();//这里会报错java.lang.ArrayIndexOutOfBoundsException: too much data for RSA block
        byte[] sourceBytes = Base64.getDecoder().decode(encryptString.getBytes());
        byte[] decryptBytes = CryptUtil.rsaDecrypt(sourceBytes, mPublic);
        String decryptString = new String(decryptBytes);
        System.out.println(CLASS_NAME + "RSA解密后:" + decryptString);
    }


    @Test
    public void md5Test() {
        String source = "abcdef";
        String md5CreatedString = md5String(source);
        System.out.println(CLASS_NAME + "MD5 算法得到的String:" + md5CreatedString);
        System.out.println(CLASS_NAME + "MD5 算法得到的String:" + md5String(md5CreatedString));
    }

    //md5算法生成String
    private String md5String(String url) {
        String ret = null;

        if (url != null) {

            try {
                // 创建MD5的消息摘要算法的类，进行调用
                MessageDigest digest = MessageDigest.getInstance("MD5");

                // 计算出一个唯一识别的信息；
                byte[] data = digest.digest(url.getBytes());

                StringBuilder sb = new StringBuilder();

                // 字节数组转换为十六进制字符串
                for (byte b : data) {
                    int ib = b & 0x0FF;
                    String s = Integer.toHexString(ib);

                    if (ib < 16) {  // 15 -> 0F 0 -> 00
                        sb.append('0');
                    }
                    sb.append(s);
                }

                ret = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
}