package com.xiaohu.aop.example1;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/6
 * Time: 9:49
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void insert() {
        System.out.println("insert");
    }

    @Override
    public String add() {
        //int i = 1/0;  //异常通知
        System.out.println("add");
        return "hello";
    }

}
