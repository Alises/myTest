package com.example.demo.sockettest;

import sun.misc.BASE64Decoder;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SocketServerTest {

    public static void main1(String[] args) throws Exception {
//        writePdf();
    }
    public static  void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",9527);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        String reqXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<Message>" +
                    "<Sys_Head>" +
                       "<TradeCode>00017</TradeCode>" +
                    "</Sys_Head>" +
                    "<Body>" +
                      "<trxCode>3004</trxCode>" +
                    "</Body>" +
               "</Message>";
        System.out.println(reqXml.length());
        pw.write("00000" + reqXml.length() + reqXml);
        pw.flush();
        socket.shutdownOutput();

        InputStream in =  socket.getInputStream();
//        int available = in.available();
//        System.out.println("----------" + available);
        byte[] lengthdata = new byte[6];
        in.read(lengthdata);
        String lengthstr = (new String(lengthdata)).trim();
        int length = Integer.parseInt(lengthstr);
        byte[] rcv = new byte[length - 6];
        in.read(rcv);
        String s = new String(rcv);
        System.out.println("報文：" + s);
        FileOutputStream fos = new FileOutputStream(new File("/Users/gaoqian/Downloads/out/temPdf.pdf"));
        while (true) {
            System.out.println("读取字节....");
            byte[] bytes = new byte[8192];
            int k = in.read(bytes);
            fos.write(bytes);
            fos.flush();
            if(k < 0) {
                System.out.println("-------流读取完毕");
                fos.close();
                break;
            }
        }

//        FileInputStream fis = new FileInputStream(new File("D:\\temPdf.pdf"));
//        int size = fis.available();
//        byte[] bytes = new byte[size];






//        depdf();



        /*BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info;
        StringBuffer infoBuffer = new StringBuffer();
        while((info = br.readLine()) != null){
            infoBuffer.append(info);
        }
        System.out.println("收到的返回报文为====:"+ infoBuffer.toString());*/
        //br.close();
        in.close();
        pw.close();
        os.close();
        socket.close();
    }

    public static void depdf() {
        // 存放pdf的base64
        Path path = Paths.get("D:\\pdf.txt");
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 读取文件转换为String
        String collect = lines.collect(Collectors.joining(System.lineSeparator()));
        String encodedBytes = collect;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodedBytes = new byte[0];
        try {
            decodedBytes = decoder.decodeBuffer(encodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("D:\\newfile.pdf");
        FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(file);
            fop.write(decodedBytes);
            fop.flush();
            fop.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void writePdf(String sb) throws Exception {
//        File txtF = new File("D:\\pdf.txt");
//        BufferedReader reader = new BufferedReader(new FileReader(txtF));
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(sb);
        System.out.println("數組長度： " + bytes.length);
        String path = "D:\\pdf.pdf";
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }
}
