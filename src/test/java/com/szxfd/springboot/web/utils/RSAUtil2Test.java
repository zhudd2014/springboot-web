package com.szxfd.springboot.web.utils;

import org.junit.Test;

import java.util.Map;

public class RSAUtil2Test {

    private String sourceData = "开发时卡到福克斯卡到福克斯贷款方开始开电风扇的开发快速";

    @Test
    public void test() {
        Map<String, String> keys = RSAUtil2.createKeys(1024);
        RSAUtil2 rsaUtil2 = new RSAUtil2(keys.get("publicKey"), keys.get("privateKey"));
        String s = rsaUtil2.publicEncrypt(sourceData);
        System.out.println("s:" + s);
        String s1 = rsaUtil2.privateDecrypt(s);
        System.out.println("s1:" + s1);
    }

}