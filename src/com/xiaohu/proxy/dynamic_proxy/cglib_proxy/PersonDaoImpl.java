package com.xiaohu.proxy.dynamic_proxy.cglib_proxy;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class PersonDaoImpl implements PersonDao {

    @Override
    public void insert() {
        System.out.println("add");
    }

}
