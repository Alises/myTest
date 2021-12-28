package com.example.demo.design.chain;

/**
 * Create 2021/12/28 by Gq
 * 具体处理类： CEO 老板
 */
public class CEOHandler extends AbstractHandler<Integer> {
    /**
     * 具体处理类实现的逻辑
     */
    @Override
    public void handlerRequest(Integer data) {
        System.out.println("老板： 请假申请我批了！ ");
        // 如果有处理顺序 知道这级是最后一级 可以不再写后面的判断
        // 假如是没有顺序的处理， 则需要再判断后面时候还有其他处理逻辑
    }
}
