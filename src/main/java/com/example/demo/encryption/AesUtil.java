package com.example.demo.encryption;


import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class AesUtil {
    private static String str = "guomjqwnekj{snd\"ak\"s}ndaksndz,guomjqwnekj{snd\"ak\"s}ndaksndz,guomjqwnekj{snd\"ak\"s}ndaksndz";
    /**
     * aes对称加密
     * @param args
     */
    public static void main(String[] args) {
        //下面方法中需要使用base64 encode将生成的加密串做转码，先省略
        aesByRandomKey();
        System.out.println("--------------------------");
        aesByUsingKey("12345iqnsqna5678");
//        aesByUsingKey("ERUYTHMHUIWOPPOHTABKKWPSJ");
    }

    /**
     * 使用随机生成的key加密
     */
    private static void aesByRandomKey(){
        try {
            //生成密钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //初始化密钥长度
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            //生成后base64加密
            byte[] encodedKey = secretKey.getEncoded();
            System.out.println("key: " + Hex.encodeHexString(encodedKey));

            //key转换，上面的key可以直接指定一个随机字符串，然后base64加密传入下面方法
            Key key = new SecretKeySpec(encodedKey, "AES");

            //进行加密，指定模式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptBytes = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            System.out.println(Hex.encodeHexString(encryptBytes));

            //进行解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptBytes = cipher.doFinal(encryptBytes);
            System.out.println(new String(decryptBytes));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 使用自定义的key加密
     * @param keyStr
     */
    private static void aesByUsingKey(String keyStr){
        try {
            //key转换，上面的key可以直接指定一个随机字符串，然后base64加密传入下面方法
            Key key = new SecretKeySpec(keyStr.getBytes(StandardCharsets.UTF_8), "AES");

            //进行加密，指定模式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptBytes = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            System.out.println(Hex.encodeHexString(encryptBytes));

            //进行解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptBytes = cipher.doFinal(encryptBytes);
            System.out.println(new String(decryptBytes, StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
