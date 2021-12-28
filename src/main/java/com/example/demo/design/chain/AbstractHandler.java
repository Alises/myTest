package com.example.demo.design.chain;

/**
 * Create 2021/12/28 by Gq
 * 抽象处理类   范型可以让此类处理多种数据
 */
public abstract class AbstractHandler<T> {
    private AbstractHandler next;

    public AbstractHandler getNext() {
        return next;
    }

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    /**
     * 具体处理类实现的逻辑
     * @param data
     */
    public abstract void handlerRequest(T data);
}
