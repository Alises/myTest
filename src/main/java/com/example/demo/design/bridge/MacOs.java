package com.example.demo.design.bridge;

/**
 * 2019/12/25 create by Gq
 */

public class MacOs extends SystemVersion{

    @Override
    public void play(String fileName) {
        String macOS = "mac OS";
        this.file.decode(macOS, fileName);
    }
}
