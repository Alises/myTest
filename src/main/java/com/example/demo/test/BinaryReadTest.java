package com.example.demo.test;


import java.io.*;

/**
 * Create By Gq
 * 2023/3/30
 */
public class BinaryReadTest {

    public static void main(String[] args) throws IOException {
        String str = "123456najqwenknasd1";
        byte[] bytes = str.getBytes();
//        InputStream in = null;
        try (InputStream in = new ByteArrayInputStream(bytes)) {
            while (true) {
                byte[] re = new byte[6];
                int k = in.read(re);
                System.out.println(k);
                if(k < 0) {
                    break;
                }
                String s = new String(re);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
