package com.example.demo.design.flyweight;

/**
 * 2020/1/17 create by Gq
 */

public class BlackPieces implements ChessPieces {
    private int x;
    private int y;

    /**
     * 落棋方法
     * @param x
     * @param y
     */
    @Override
    public void downPieces(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return 1;
    }

    public void show() {
        System.out.println("黑棋落在横" + x + " 竖" + y);
    }
}
