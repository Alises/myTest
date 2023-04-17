package com.example.demo.castTest;

import java.io.Serializable;

/**
 * Create By Gq
 * 2023/3/14
 */
public class ChildrenB extends ParnetM implements Serializable {
    private static final long serialVersionUID = 1L;

    private int E;

    private String D;

    private int X;

    private String Y;


    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }
}
