package com.xiaohu.demo.aspect;

import com.xiaohu.demo.annotation.AnnotationParse;
import com.xiaohu.demo.pm.pojo.Privilege;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/7
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class Access {
    private List<Privilege> privileges=new ArrayList<Privilege>();

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public void isAccessMethod(ProceedingJoinPoint pjp) throws Throwable {
        /**
         * 1、获取访问目标方法应该具备的权限
         *      得到
         *          1、目标类的class形式
         *          2、方法的名称
         */
        Class targetClass = pjp.getTarget().getClass();
        String methodName = pjp.getSignature().getName();
        String privilegeName = AnnotationParse.parse(targetClass, methodName);
        boolean flag = false;
        for (Privilege privilege:privileges){
            String name=privilege.getName();
            //if(name==privilegeName){
            if (name.equals(privilegeName)){ //引用对象==比较的是地址值，看2个引用对象的值是否相等用equals方法
                flag=true;
            }
        }

        if (flag){
            pjp.proceed(); //执行目标方法
        }else{
            System.out.println("have no access to visit");
        }
    }

}
