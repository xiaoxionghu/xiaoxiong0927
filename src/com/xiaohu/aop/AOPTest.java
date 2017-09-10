package com.xiaohu.aop;

import com.xiaohu.aop.ano.AddDao;
import com.xiaohu.aop.example1.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/6
 * Time: 9:55
 * To change this template use File | Settings | File Templates.
 */
public class AOPTest {

    /**
     * 原理
     *     当spring容器启动时，加载2个bean，对2个bean进行实例化
     *     当spring容器解析到aop:config时候：将切入点表达式解析出来，匹配spring容器内容的bean；匹配成功则为该bean创建对象，如果没有则返回本身
     *
     */

    @Test
    public void run(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("AOP1.xml");
        UserDao ud = (UserDao) ac.getBean("userDao");
        //ud.insert();
        ud.add();
    }

    /**
     * 注解的测试
     * JDK1.8版本不支持 spring 中的springframework.context
     *      spring的版本太低导致的
     *      java.lang.IllegalStateException: Context namespace element 'component-scan' and its parser class
     */
    @Test
    public void runAno(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ano_test.xml");
        AddDao ad = (AddDao)ac.getBean("addDao");
        ad.add();
    }
}
