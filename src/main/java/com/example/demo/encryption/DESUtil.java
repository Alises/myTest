package com.example.demo.encryption;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class DESUtil {

    public static byte[] desCrypto(byte[] datasource, String password) {
        try{
            SecureRandom random = new SecureRandom(password.getBytes());
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            KeyGenerator des = KeyGenerator.getInstance("DES");
            des.init(new SecureRandom(password.getBytes()));
            SecretKey secretKey = des.generateKey();
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] decrypt(byte[] src, String password) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        KeyGenerator des = KeyGenerator.getInstance("DES");
        des.init(new SecureRandom(password.getBytes()));
        SecretKey secretKey = des.generateKey();
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }

    public static void main(String[] args) {
        //待加密内容
        String str = "123";
        //密码，长度要是8的倍数
        String password = "12345678";
        byte[] result = desCrypto(str.getBytes(),password);
        System.out.println("加密后内容为："+new String(Base64.getEncoder().encode(result)));
        //直接将如上内容解密
        try {
            byte[] decryResult = decrypt(result, password);
            System.out.println("加密后内容为："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
