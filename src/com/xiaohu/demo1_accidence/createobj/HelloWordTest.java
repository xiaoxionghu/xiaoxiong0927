package com.xiaohu.demo1_accidence.createobj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/4
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class HelloWordTest {

    @Test
    public void run(){
        ApplicationContext cpxa = new ClassPathXmlApplicationContext("haha.xml");
        HelloWord hw = (HelloWord) cpxa.getBean("helloworld");
        hw.say();
    }

    @Test
    public void run2(){
        ApplicationContext cpxa = new ClassPathXmlApplicationContext("haha.xml");
        HelloWord hw = (HelloWord) cpxa.getBean("helloworld2");
        hw.say();
    }
}
