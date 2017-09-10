package com.xiaohu.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.util.Date;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/6
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */

/**
 * 计算每一个类中每个方法的执行时间
 */
public class Calculate_Method_RunningTime {

    private Date beginTime = null;
    private Date endTime = null;
    private Long second=0L;
    private String methodName=null;

    /**
     *  前置通知
     *      获取
     *
     */
    public void startTime(JoinPoint jp){
        beginTime=new Date();
        //
        Signature signature = jp.getSignature();
        Object target = jp.getTarget();
        methodName=target.getClass().getName()+signature.getName();
        System.out.println("前置通知"+methodName);
    }

    /**
     *  后置通知
     *
     */
    public void endTime(){
        endTime = new Date();
        second = endTime.getTime()-beginTime.getTime();
        System.out.println(methodName+"执行花了"+second+"毫秒");
    }

    /**
     * 最终通知
     *
     */
    public void finalTime(){

    }

}
