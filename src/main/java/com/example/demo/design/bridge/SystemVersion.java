package com.example.demo.design.bridge;

/**
 * 2019/12/25 create by Gq
 */

public abstract class SystemVersion {
    protected VideoFile file;

    public void setFile(VideoFile file) {
        this.file = file;
    }

    public abstract void play(String fileName);
}
