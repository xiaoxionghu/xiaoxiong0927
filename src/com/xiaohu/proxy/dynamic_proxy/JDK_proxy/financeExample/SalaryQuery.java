package com.xiaohu.proxy.dynamic_proxy.JDK_proxy.financeExample;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class SalaryQuery implements FinanceSystem {


    @Override
    public void searchSalary() {

        System.out.println("find salary");
    }
}
