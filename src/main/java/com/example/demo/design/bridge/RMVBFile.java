package com.example.demo.design.bridge;

/**
 * 2019/12/25 create by Gq
 */

public class RMVBFile implements VideoFile {

    @Override
    public void decode(String systemVersion, String fileName) {
        System.out.println(systemVersion + "播放" + fileName + ".rmvb");
    }
}
