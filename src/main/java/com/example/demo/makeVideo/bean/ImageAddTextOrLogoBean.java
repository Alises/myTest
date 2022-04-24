package com.example.demo.makeVideo.bean;

import lombok.Data;

import java.awt.*;

/**
 * Create 2022/4/19 by Gq
 */
@Data
public class ImageAddTextOrLogoBean {
    private String imageUrl;
    private int x;
    private int y;
    private Position_X positon_X;
    private Position_Y positon_Y;
    private String watermark;
    private int state;
    private int toMinSize;
    private Font font;
    private Color color;
}
