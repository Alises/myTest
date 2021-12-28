package com.example.demo.design.chain;

/**
 * Create 2021/12/28 by Gq
 * 具体处理者： 经理
 */
public class ManagerHandler extends AbstractHandler<Integer> {
    /**
     * 具体处理类实现的逻辑
     */
    @Override
    public void handlerRequest(Integer data) {
        System.out.println("经理： 请假申请我批了～");

        // 如果请假时间大于等于5天  需要向上级报批
        if(data >= 5 && getNext() != null) {
            getNext().handlerRequest(data);
        }
    }
}
