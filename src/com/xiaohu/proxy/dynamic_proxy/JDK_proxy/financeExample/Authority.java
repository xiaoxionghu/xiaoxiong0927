package com.xiaohu.proxy.dynamic_proxy.JDK_proxy.financeExample;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 14:01
 * To change this template use File | Settings | File Templates.
 */
public class Authority implements Function {
    private String name;

    public Authority(String name){
        super();
        this.name=name;
    }
    @Override
    public void function() {
        if ("admin".equals(name)){
            System.out.println("look up salary");
        }else {
            System.out.println("have no access to look up salary");
        }
    }
}
