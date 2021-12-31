package com.example.demo.design.interpreter;

/**
 * Create 2021/12/31 by Gq
 * 非终结符表达式类
 */
public class AndExpression implements Expression {
    private Expression city;
    private Expression person;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String s[] = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}
