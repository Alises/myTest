package com.example.demo.design.visitor;

/**
 * Create 2021/12/30 by Gq
 * 访问者接口
 */
public interface Visitor {

    void visit(Engineer engineer);

    void visit(Manager manager);
}
