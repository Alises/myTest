package com.example.demo.sockettest;

import java.io.InputStream;
import java.net.Socket;

/**
 * Create By Gq
 * 2023/3/31
 */
public class SocketClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8800);
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println(read);
        String gbk = new String(bytes, "GBK");
        System.out.println(gbk);
//        int available = inputStream.available();
//        System.out.println(available);
    }
}
