package com.xiaohu.demo.aspect;

import com.xiaohu.demo.pm.pojo.TimeBean;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/8
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
public class TimeAspect {

    public Map<String, TimeBean> map = new HashMap<>();
    public static int index=0;

    /**
     * 环绕通知
     *
     * @param pjp
     */
    public void methodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        TimeBean tb = new TimeBean();

        Class target = pjp.getTarget().getClass();
        String className = target.getName();
        String methodName = pjp.getSignature().getName();

        long preTime = System.currentTimeMillis();
        pjp.proceed();
        long aftTime = System.currentTimeMillis();
        long executTime = aftTime - preTime;

        System.out.println("当前类：" + className + "   的方法：" + methodName + "执行了" + executTime);
        System.out.println("当前方法的开始时间:" + preTime + ",");
        System.out.println("当前方法的执行时间:" + aftTime);
        tb.setClassName(className);
        tb.setMenthodName(methodName);
        tb.setExctueTime(executTime);

        index++;

        map.put(index+className+methodName,tb);

    }
}
