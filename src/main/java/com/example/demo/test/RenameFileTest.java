package com.example.demo.test;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Create 2022/3/17 by Gq
 */
public class RenameFileTest {

    private static final String fileDirPath = "/Volumes/Sine/sources/other/atlas";

    private static final String fileSuffix = ".atlas";

    private static Set<String> nameContainer = new HashSet<>();


    public static void main(String[] args) throws IOException {
        reNameFile();
    }

    private static void reNameFile() throws IOException {
        File dir = new File(fileDirPath);
        if(dir.isDirectory()) {
            System.out.println("进入文件夹");
            File[] files = dir.listFiles();
            if(files != null) {
                System.out.println("文件数量：" + files.length);
                for (File file : files) {
                    if(!file.getName().contains(fileSuffix)) {
                        continue;
                    }
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        if(StringUtils.isEmpty(line)) {
                            continue;
                        }
                        System.out.println(line);
                        line = line.replace(".png", "");
                        if(nameContainer.contains(line)) {
                            System.out.println("----------------------------------已经包含: " + line);
                            line += ("_" + new Random().nextInt());
                        }
                        nameContainer.add(line);
                        boolean b = file.renameTo(new File(fileDirPath + File.separatorChar + line + fileSuffix));
                        System.out.println("改名成功：" + line + "    "  + b);
                        break;
                    }
                }
            }
        }

    }
}
