package com.example.demo.castTest;

import java.io.Serializable;

/**
 * Create By Gq
 * 2023/3/14
 */
public class ChildrenA extends ParnetM implements Serializable {
    private static final long serialVersionUID = 1L;

    private int F;

    private String D;

    private int E;

    private String G;

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public String getG() {
        return G;
    }

    public void setG(String g) {
        G = g;
    }
}
