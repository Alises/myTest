package com.example.demo.sockettest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;

public class SocketThread extends Thread{
    private Logger logger = LoggerFactory.getLogger(SocketThread.class);
    private Socket socket = null;

    private InputStream is = null;
    private InputStreamReader isr = null;
    private BufferedReader br = null;
    private OutputStream os = null;
    private int lengthSize = 8 ; //报文的长度位数

    public SocketThread (){}
    public SocketThread(Socket socket){
        this.socket = socket;
    }

    //执行用户操作
    @Override
    public void run(){
        String msg = readMessage();
        logger.info("请求报文:" + msg);
        String tradeCode = msg.substring(msg.indexOf("<TradeCode>") + 11 ,msg.indexOf("</TradeCode>"));
        String responseXml = "";
        if("00017".equals(tradeCode)){
            responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>" +
             "<head>"  +
             "</head>" +
            "</root>";
        }

        //计算长度
        if(StringUtils.isEmpty(responseXml)){
            int len = responseXml.getBytes().length;
            logger.info("读取数据的len:"+ len ) ;
            logger.info("读取数据的len:"+ String.format("%06d",len)) ;
            String lengthStr = String.format("%0" + lengthSize + "d",len);
            responseXml = lengthStr + responseXml;
        }
        response(responseXml);
        close();
    }

    //读取客户端的信息
    private String readMessage(){
        StringBuffer msg = new StringBuffer();
        try{
            is = socket.getInputStream();
            //读取报文头，读取报文长度
            byte[] length = readHead(lengthSize);
            //获取报文长度
            int pLent = Integer.parseInt(new String(length));
            //根据报文长度读取相关报文
            byte[] b = new byte[pLent];
            is.read(b);
            msg.append(new String(b));
            //关闭输入流
            socket.shutdownInput();
        }catch (IOException e){
            logger.error("读取数据失败：" + e.getMessage());
        }
        return msg.toString();
    }

    //读取报文头
    private byte[] readHead(int headLength) throws IOException{

        byte headbuf[] = new byte[headLength];
        int off = 0;
        for(off = 0;off < headLength;){
            off = is.read(headbuf,off,headLength-off);
            if(off < 0){
                throw new IOException("Read package head error");
            }
        }
        return headbuf;
    }

    //向客户端进行响应
    private void response(String res){
        OutputStream os = null;
        try{
            int len = res.getBytes().length;
            System.out.println(len + "");
            res = "112   <?xml version=\"1.0\" encoding=\"gb2312\"?><packet><head><transCode>WJ12</transCode><signFlag>1</signFlag>";
//            int l = res.getBytes().length;
//            System.out.println( "==========" + l );
//            res = l + 6 +  "   " + res + "kkkkjjjjjjjjjjjjjjjiuuuKoEcz1UGAQQCAaCBzgSByzxib2R5PjxmaWxlTGVuZ3RoPjIxMjc3NTwvZmlsZUxl";
            os = socket.getOutputStream();
            byte[] bytes1 = res.getBytes("UTF-8");
            os.write(bytes1);
            FileInputStream fis = new FileInputStream(new File("/Users/gaoqian/Desktop/011002100511-71162942.pdf"));
            int count = bytes1.length;
            while (true) {
                byte[] bytes = new byte[8192];
                int read = fis.read(bytes);
                if(read < 0) {
                    System.out.println("文件輸出完畢");
                    break;
                }
                count += read;
                os.write(bytes, 0, read);
            }
            System.out.println("全長：" + count);
            os.flush();
        } catch (IOException e) {
            logger.error("初始化流出错：" + e.getMessage());
        }
    }

    private void close(){
        try{
            if(is != null){
                is.close();
            }
            if(isr != null){
                isr.close();
            }
            if(br != null){
                br.close();
            }
            if(os != null){
                os.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch (IOException e) {
            logger.error("流关闭异常：" + e.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
