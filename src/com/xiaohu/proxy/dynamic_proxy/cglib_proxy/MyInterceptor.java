package com.xiaohu.proxy.dynamic_proxy.cglib_proxy;

import com.xiaohu.proxy.static_proxy.Transaction;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public class MyInterceptor implements MethodInterceptor {
    private Object target;
    private Transaction transaction;

    public MyInterceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    public Object createProxy(){
        //代码增强类
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);  //参数为拦截器
        enhancer.setSuperclass(target.getClass());  //生成的代理类的父类是目标类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.transaction.beginTran();
        method.invoke(target);
        this.transaction.commit();
        this.transaction.close();

        return null;
    }
}
