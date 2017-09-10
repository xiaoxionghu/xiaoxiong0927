package com.xiaohu.aop.trans;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/6
 * Time: 9:54
 * To change this template use File | Settings | File Templates.
 */
public class Trans {

/*    public void beginTran(){
        System.out.println("begin transcation");
    }

    public void commit(){
        System.out.println("commit");
    }

    */

    /**
     * 前置通知
     * @param joinPoint
     */
    public void beginTran(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("连接点的方法名："+ methodName);
        System.out.println("target:"+joinPoint.getTarget().getClass());

        System.out.println("begin transcation");
    }

    /**
     * 后置通知
     */
    public void commit(JoinPoint joinPoint,Object val){
        System.out.println("目标方法的返回值：" +val);
        System.out.println("commit");
    }

    /**
     * 异常通知
     *  参数的类型依照@AfterThrowing所描述的方法强制匹配
     */
    public void throwingMethod(JoinPoint joinPoint,Throwable ex){
        ex.getMessage();
    }

    /**
     * 最终通知
     * @param joinPoint
     */
    public void finalyAdv(JoinPoint joinPoint){
        System.out.println("finally adv");
    }

    /**
     *
     */
    public void around(ProceedingJoinPoint pjp){

    }
}
