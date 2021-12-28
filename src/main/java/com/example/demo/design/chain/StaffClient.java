package com.example.demo.design.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * Create 2021/12/28 by Gq
 * 客户端类： 员工
 */
@SuppressWarnings("unchecked")
public class StaffClient {

    private static List<AbstractHandler> handlers = new ArrayList<>();
    private static AbstractHandler handler;
    static {
        handlers.add(new HandmanHandler());
        handlers.add(new ManagerHandler());
        handlers.add(new CEOHandler());
        initHandler();
    }

    public static void main(String[] args) {
        System.out.println("领导，我要请1天假，回家探亲。");
        handler.handlerRequest(1);
        System.out.println("--------------------------");

        System.out.println("领导，我要请3天假，回家探亲。");
        handler.handlerRequest(3);
        System.out.println("--------------------------");

        System.out.println("领导，我要请5天假，回家探亲。");
        handler.handlerRequest(5);
        System.out.println("--------------------------");
    }

    private static void initHandler() {
        for (int i = handlers.size() - 1; i > -1; i--) {
            if(i == handlers.size() - 1) continue;
            handler = handlers.get(i);
            handler.setNext(handlers.get(i + 1));
        }
    }
}
