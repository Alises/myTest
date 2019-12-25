package com.example.demo.design.builder;

/**
 * 2019/12/24 create by Gq
 */

public class Product {
    private String partA;
    private String partB;
    private String partC;
    private String partD;


    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public String getPartD() {
        return partD;
    }

    public void setPartD(String partD) {
        this.partD = partD;
    }

    public void show() {
        System.out.println("具体产品展示，细节如下：");
        System.out.println("PartA : " + partA);
        System.out.println("PartB : " + partB);
        System.out.println("PartC : " + partC);
        System.out.println("PartD : " + partD);
    }
}
