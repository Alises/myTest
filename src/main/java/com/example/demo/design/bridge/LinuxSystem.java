package com.example.demo.design.bridge;

/**
 * 2019/12/25 create by Gq
 */

public class LinuxSystem extends SystemVersion {

    @Override
    public void play(String fileName) {
        String linux = "linux 系统";

        this.file.decode(linux, fileName);
    }

}
