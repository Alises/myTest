package com.example.demo.design.facade;

/**
 * 2019/12/29 create by Gq
 * 外观角色
 * 客户去当地房产局办理房产证过户要遇到的相关部门
 * "登记信息、验证协议"窗口 --> "房地产估价"窗口 --> "公证"窗口 --> "私房交易"窗口 --> "契税、印花税"窗口
 * --> "产权登记发证"窗口
 * 如果可以提供一个综合服务中心直接办理全部的业务
 *
 */

public class Facade {

    private Service1 service1 = new Service1();
    private Service2 service2 = new Service2();
    private Service3 service3 = new Service3();
    private Service4 service4 = new Service4();
    private Service5 service5 = new Service5();
    private Service6 service6 = new Service6();

    public String method() {

        service1.method();
        service2.method();
        service3.method();
        service4.method();
        service5.method();
        service6.method();

        return "办完了";
    }
}
