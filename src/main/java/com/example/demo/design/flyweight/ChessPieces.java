package com.example.demo.design.flyweight;

/**
 * 2020/1/17 create by Gq
 * 五子棋的抽象享元角色
 */

public interface ChessPieces {
    /**
     * 落棋方法
     * @param x
     * @param y
     */
    void downPieces(int x, int y);

    /**
     * 获取棋子类型 黑白  int可用 enum
     * @return
     */
    int getType();

    /**
     * 展示
     */
    void show();
}
