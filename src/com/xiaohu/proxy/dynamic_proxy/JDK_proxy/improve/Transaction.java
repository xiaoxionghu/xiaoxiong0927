package com.xiaohu.proxy.dynamic_proxy.JDK_proxy.improve;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 9:35
 * To change this template use File | Settings | File Templates.
 */
public class Transaction implements Interceptor {

    public void beginTran(){
        System.out.println("begin");
    }

    public void commit(){
        System.out.println("commit");
    }

    public void close(){
        System.out.println("close");
    }

    @Override
    public void interceptor() {
        System.out.println("transaction");
    }
}
