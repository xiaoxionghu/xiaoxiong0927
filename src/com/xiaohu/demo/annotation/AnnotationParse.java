package com.xiaohu.demo.annotation;

import java.lang.reflect.Method;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/7
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class AnnotationParse {

    /**
     *  解析注解工具类
     *
     * @param targetClass 目标类的class形式
     * @param methodName 在客户端调用哪个方法，methodName就代表哪个方法
     * @return
     */
    public static String parse(Class targetClass,String methodName) throws NoSuchMethodException {
        String methodNameAccess="";

        Method method = targetClass.getMethod(methodName);
        //判断方法上面是否存在PrivilegeInfo注解
        if (method.isAnnotationPresent(PrivilegeInfo.class)){
            //得到方法上面的注解
            PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
            methodNameAccess = privilegeInfo.name();
        }

        return methodNameAccess;
    }
}
