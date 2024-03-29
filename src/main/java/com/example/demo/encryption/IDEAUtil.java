package com.example.demo.encryption;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * Create By Gq
 * 2022/11/4
 */
public class IDEAUtil {
    public static void main(String args[]) {
        bcIDEA();
    }

    public static void bcIDEA() {
        String src = "www.xttblog.com security ideawww.xttblog.com security ideawww.xttblog.com security idea";
        try {
            Security.addProvider(new BouncyCastleProvider());
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("IDEA");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();
            //转换密钥
            Key key = new SecretKeySpec(keyBytes, "IDEA");

            //加密
            Cipher cipher = Cipher.getInstance("IDEA/ECB/ISO10126Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("bc idea encrypt : " + Base64.encodeBase64String(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
            System.out.println("bc idea decrypt : " + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
