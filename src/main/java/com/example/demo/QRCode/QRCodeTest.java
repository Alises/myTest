package com.example.demo.QRCode;

/**
 * Create 2021/12/1 by Gq
 */
public class QRCodeTest {
    public static void main(String[] args) throws Exception {
//        // 存放在二维码中的内容
        String text = "http://192.168.125.115:8011/client/program/qrcode.m";
//        // 嵌入二维码的图片路径
        String imgPath = "/Users/gaoqian/Downloads/QQ图片20190927160449.jpg";
//        // 生成的二维码的路径及名称
        long l = System.currentTimeMillis();
        String destPath = "/Users/gaoqian/Downloads/Movie/IMG_674323o.jpg";
//        // 生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        System.out.println(System.currentTimeMillis() - l);
        // 解析二维码
//        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
//        System.out.println(str);
    }
}
