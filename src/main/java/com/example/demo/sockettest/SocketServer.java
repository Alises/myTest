package com.example.demo.sockettest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Service
public class SocketServer {
    private Logger logger = LoggerFactory.getLogger(SocketServer.class);
    private String port = "9527";
    private boolean flag = true;

    public void init() throws NumberFormatException, IOException{
        logger.info("开始启动socket服务器。。。");
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
        //循环监听等待客户的连接
        while(flag){
            //调用accept()方法开始监听，等待客户端的连接
            Socket socket = serverSocket.accept();
            SocketThread thread = new SocketThread(socket);
            logger.info(thread.getId() + "");
            //执行逻辑
            thread.start();
        }
    }

    @PostConstruct
    public void startUp(){
        Thread thread = new Thread(new SocketServerThread());
        thread.start();
    }

    private class SocketServerThread implements Runnable{

        @Override
        public void run() {
           try{
               init();
           } catch (Exception e) {
               logger.error("启动服务器出错：" + e.getMessage());
           }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.init();
    }
}
