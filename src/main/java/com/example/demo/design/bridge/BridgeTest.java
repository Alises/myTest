package com.example.demo.design.bridge;

/**
 * 2019/12/25 create by Gq
 */

public class BridgeTest {

    public static void main(String[] args) {
        VideoFile file = new Mp4File();
        SystemVersion system = new LinuxSystem();
        system.setFile(file);
        system.play("泰坦尼克号");

        VideoFile file2 = new RMVBFile();
        SystemVersion system2 = new MacOs();
        system2.setFile(file2);
        system2.play("珍珠港");
    }
}
