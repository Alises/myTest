package com.example.demo.design.visitor;

/**
 * Create 2021/12/30 by Gq
 * 年底，CEO和CTO开始评定员工一年的工作绩效，员工分为工程师和经理，CTO关注工程师的代码量、经理的新产品数量；CEO关注的是工程师的KPI和经理的KPI以及新产品数量。
 * 由于CEO和CTO对于不同员工的关注点是不一样的，这就需要对不同员工类型进行不同的处理。
 */
public class VisitorTest {
    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}
