package com.example.demo.design.flyweight;

/**
 * 2020/1/17 create by Gq
 */

public class FlyWeightTest {


    public static void main(String[] args) {
        WeiqiFactory weiqiFactory = WeiqiFactory.INSTANCE();
        ChessPieces wPieces = weiqiFactory.getPieces(1);
        wPieces.downPieces(10, 10);
        wPieces.show();

        ChessPieces bPieces = weiqiFactory.getPieces(2);
        bPieces.downPieces(10,11);
        bPieces.show();

        ChessPieces wPieces2 = weiqiFactory.getPieces(1);
        wPieces2.downPieces(11,11);
        wPieces2.show();

        ChessPieces bPieces2 = weiqiFactory.getPieces(2);
        bPieces2.downPieces(12, 12);
        bPieces2.show();

        System.out.println("===================");
        wPieces.show();
        bPieces.show();
        wPieces2.show();
        bPieces2.show();
    }
}
