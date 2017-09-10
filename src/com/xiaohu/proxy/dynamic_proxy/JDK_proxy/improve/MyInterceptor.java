package com.xiaohu.proxy.dynamic_proxy.JDK_proxy.improve;

import com.xiaohu.proxy.static_proxy.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

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
    //除了目标类以外的所有的功能都抽象为Interceptor
    private List<Interceptor> interceptors;

    public MyInterceptor(Object target, List<Interceptor> list) {
        super();
        this.target = target;
        this.interceptors = list;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       for(Interceptor interceptor:interceptors){
           interceptor.interceptor();
       }
        method.invoke(target);

        return null;
    }
}
