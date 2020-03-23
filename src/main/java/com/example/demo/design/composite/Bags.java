package com.example.demo.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Create 2020/3/23 By Gq
 */
public class Bags implements Articles {
    private List<Articles> goods = new ArrayList<>();

    public Bags(String name) {
    }

    public void add(Articles articles) {
        goods.add(articles);
    }

    public void remove(Articles articles) {
        goods.remove(articles);
    }

    public Articles getChild(int index) {
        return goods.get(index);
    }

    @Override
    public float calculation() {
        float s = 0;
        for(Articles articles : goods){
            s += articles.calculation();
        }
        return s;
    }

    @Override
    public void show() {
        for(Articles articles : goods) {
            articles.show();
        }
    }
}
