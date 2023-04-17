package com.example.demo.image;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Create 2022/9/16 by Gq
 * 压缩图片
 */
public class CompressImage {
    private static final int x = 220;
    private static final int y = 800;
    public static void main(String[] args) {
        try {
            File file = new File("");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String filePath = line.split("\\t")[0];
                boolean b = compressImage(new File(filePath), filePath);
                System.out.println("处理成功: " + b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean compressImage(File file, String savePath) {
        BufferedImage orginalImage;
        boolean success = true;
        try {
            orginalImage = ImageIO.read(file);
            if(null == orginalImage) {
                success = false;
            } else {
                BufferedImage temp = Scalr.resize(orginalImage, Scalr.Method.ULTRA_QUALITY,
                        Scalr.Mode.FIT_TO_WIDTH, x, y, Scalr.OP_ANTIALIAS);
                ImageIO.write(temp, getFileSuffix(file.getName()), new File(savePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }

    private static String getFileSuffix(String fileName) {
        return fileName.substring(fileName.indexOf(".") + 1);
    }
}
