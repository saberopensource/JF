package com.taifutech.util;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Scanner;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/5
 * If you don't konw it,Please ask Google
 */
public class Base64 {
    public String Base64Encoder(String url){
        BASE64Encoder encoder = new BASE64Encoder();
        String encoderstring = encoder.encode(url.getBytes());
        return encoderstring;
    }
    public String Base64Decoder(String url) throws Exception{
        BASE64Decoder decoder = new BASE64Decoder();
        String decoderString = new String(decoder.decodeBuffer(url));
        return decoderString;
    }
    //Base64 加密  db用户名和密码 ** 替换你要用的用户名和密码获取加密后字段
    @Test
    public void test(){
        String a = Base64Encoder("*********");
        System.out.println("加密后：" + a);
        try {
            String b = Base64Decoder(a);
            System.out.println("解密后："+b);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常是："+e);
        }
        System.out.println("-----------------------");
    }
}
