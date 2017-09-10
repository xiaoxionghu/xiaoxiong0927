package com.xiaohu.proxy;

import com.xiaohu.proxy.dynamic_proxy.JDK_proxy.MyInterceptor;
import com.xiaohu.proxy.dynamic_proxy.JDK_proxy.financeExample.*;
import com.xiaohu.proxy.dynamic_proxy.JDK_proxy.improve.Interceptor;
import com.xiaohu.proxy.static_proxy.PersonDaoProxy;
import com.xiaohu.proxy.static_proxy.Transaction;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    @org.junit.Test
    public void staticProxy(){
        PersonDao personDao = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        PersonDaoProxy personDaoProxy = new PersonDaoProxy(personDao,transaction);
        personDaoProxy.insert();
    }

    /**
     *  1、拦截器的invoke方法是在时候执行的？
     *         代理对象调用方法时
     *  2、代理对象的方法体的内容是什么？
     *         拦截器的invoke方法的内容就是代理对象的方法的内容
     *  3、拦截器中的invoke方法中的参数method是谁在什么时候传递过来的？
     *         代理对象调用方法的时候，进入了拦截器中的invoke方法，所以invoke方法中的参数method就是代理对象调用的方法
     *
     */

    @org.junit.Test
    public void jdkProxy(){
        PersonDao personDao = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        MyInterceptor myInterceptor = new MyInterceptor(personDao, transaction);
        PersonDao pd = (PersonDao)Proxy.newProxyInstance(personDao.getClass().getClassLoader(), personDao.getClass().getInterfaces(), myInterceptor);
        pd.insert();
    }

    /**
     *  对功能进行了扩展
     */
    @org.junit.Test
    public void jdkProxy_prove(){
        PersonDao personDao = new PersonDaoImpl();
        List<Interceptor> list = new ArrayList<>();
        list.add(new com.xiaohu.proxy.dynamic_proxy.JDK_proxy.improve.Transaction());
        com.xiaohu.proxy.dynamic_proxy.JDK_proxy.improve.MyInterceptor myInterceptor = new com.xiaohu.proxy.dynamic_proxy.JDK_proxy.improve.MyInterceptor(personDao, list);
        PersonDao pd = (PersonDao)Proxy.newProxyInstance(personDao.getClass().getClassLoader(), personDao.getClass().getInterfaces(), myInterceptor);
        pd.insert();
    }

    /**
     * 对小案例进行测试
     */
    @org.junit.Test
    public void finance_test(){
        FinanceSystem financeSystem = new SalaryQuery();
        List<Function> functionList = new ArrayList<>();
        functionList.add(new StartLog());
        functionList.add(new Security());
        functionList.add(new Authority("admin1"));
        EnhanceTool enhance = new EnhanceTool(financeSystem,functionList);
        FinanceSystem fs = (FinanceSystem)Proxy.newProxyInstance(financeSystem.getClass().getClassLoader(), financeSystem.getClass().getInterfaces(), enhance);
        fs.searchSalary();
    }


    /**
     * 通过cglib产生的代理对象，代理类是目标类的子类
     */
    @org.junit.Test
    public void cglib_test(){
        Object target = new com.xiaohu.proxy.dynamic_proxy.cglib_proxy.PersonDaoImpl();
        Transaction transaction = new Transaction();
        com.xiaohu.proxy.dynamic_proxy.cglib_proxy.MyInterceptor myInterceptor = new com.xiaohu.proxy.dynamic_proxy.cglib_proxy.MyInterceptor(target, transaction);
        com.xiaohu.proxy.dynamic_proxy.cglib_proxy.PersonDaoImpl proxy = (com.xiaohu.proxy.dynamic_proxy.cglib_proxy.PersonDaoImpl)myInterceptor.createProxy();
        proxy.insert();
    }

}
