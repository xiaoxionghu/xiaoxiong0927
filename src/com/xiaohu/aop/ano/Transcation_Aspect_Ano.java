package com.xiaohu.aop.ano;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/8
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
@Component("transcation")
@Aspect
public class Transcation_Aspect_Ano {
    @Pointcut("execution(* com.xiaohu.aop.ano.AddDaoImpl.*(..))")
    public void sign(){}

    @Before("sign()")
    public void beginTran(){
        System.out.println("begin");
    }

    @AfterReturning("sign()")
    public void commitTran(){
        System.out.println("commit");
    }
}
