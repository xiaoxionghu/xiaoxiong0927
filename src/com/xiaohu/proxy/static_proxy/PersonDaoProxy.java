package com.xiaohu.proxy.static_proxy;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 9:32
 * To change this template use File | Settings | File Templates.
 */

import com.xiaohu.proxy.PersonDao;

/**
 * 静态代理的局限性
 *      1，代码的冗余度高，不利于复用
 *      2，要增强多少类就会对应的有多少代理类，
 *      3，对应顶层的接口的修改对应的proxy（对应多个实现）也要修改 例如：BasedDao的方法修改，会导致对应的代理类的修改，不利于维护和修改，程序的耦合度太高
 *      4，如果是对类的增强会占用extends继承位
 *
 */
public class PersonDaoProxy implements PersonDao {

    private PersonDao personDao;
    private Transaction transaction;

    public PersonDaoProxy(PersonDao personDao, Transaction transaction){
        super();
        this.personDao=personDao;
        this.transaction=transaction;
    }

    @Override
    public void insert() {
        /**
         * 开启事物
         */
        transaction.beginTran();
        personDao.insert();
        transaction.commit();
        transaction.close();
    }

    @Override
    public void query() {


    }

    @Override
    public void upadate() {

    }

    @Override
    public void delte() {

    }
}
