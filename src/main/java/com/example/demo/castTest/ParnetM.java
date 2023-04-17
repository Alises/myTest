package com.example.demo.castTest;

import java.io.Serializable;

/**
 * Create By Gq
 * 2023/3/14
 */
public class ParnetM implements Serializable {
    private static final long serialVersionUID = -3463086526487505351L;

    private String A;

    private String B;

    private String C;


    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }
}
