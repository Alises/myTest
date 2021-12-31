package com.example.demo.design.interpreter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Create 2021/12/31 by Gq
 * 终结符表达式类
 */
public class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        set.addAll(Arrays.asList(data));
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}
