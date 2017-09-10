package com.xiaohu.proxy.dynamic_proxy.JDK_proxy;

import com.xiaohu.proxy.PersonDao;
import com.xiaohu.proxy.static_proxy.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */

/**
 * 拦截器
 *    1、目标类导入进来
 *    2、事务导入进来
 *    3、invoke完成
 *        1、开启事务
 *        2、调用目标对象的方法
 *        3、事务的提交
 * 动态代理的局限：
 *      在拦截器中除了能调用目标对象的目标方法以外，实现的功能比较单一
 *      invoke方法if判断 一旦多个方法if需要写很多。
 */
public class MyInterceptor implements InvocationHandler {

    private Object target;
    private Transaction transaction;

    public MyInterceptor(Object target, Transaction transaction) {
        super();
        this.target = target;
        this.transaction = transaction;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if("insert".equals(name)||"update".equals(name)||"delete".equals(name)){
            transaction.beginTran();
            //PersonDao target = (PersonDao) this.target;
            //target.insert();
            method.invoke(target); //调用目标方法
            transaction.commit();
            transaction.close();
        }else{
            method.invoke(target);
        }

        return null;
    }
}
