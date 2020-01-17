package com.example.demo.design.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/1/17 create by Gq
 */

public class WeiqiFactory {

    private static WeiqiFactory INSTANCE;
    private List<ChessPieces> chessPieces;

    private WeiqiFactory() {
        chessPieces = new ArrayList<>();
        chessPieces.add(new WhitePieces());
        chessPieces.add(new BlackPieces());
    }

    public ChessPieces getPieces(int type) {
        for(ChessPieces chessPieces : chessPieces) {
            if(chessPieces.getType() == type) {
                return  chessPieces;
            }
        }

        return null;
    }

    public static WeiqiFactory INSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new WeiqiFactory();
        }
        return INSTANCE;
    }
}