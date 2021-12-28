package com.example.demo.design.chain;

/**
 * Create 2021/12/28 by Gq
 * 具体责任链处理类： 小组长
 */
public class HandmanHandler extends AbstractHandler<Integer> {

    /**
     * 具体处理类实现的逻辑
     */
    @Override
    public void handlerRequest(Integer data) {
        System.out.println("小组长：请假我批了！～");
        // 如果请假时间大于等于3天  需要向上级报批
        if(data >= 3 && getNext() != null) {
            getNext().handlerRequest(data);
        }
    }
}
