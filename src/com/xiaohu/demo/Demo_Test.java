package com.xiaohu.demo;

import com.xiaohu.demo.aspect.Access;
import com.xiaohu.demo.pm.action.BasedAction;
import com.xiaohu.demo.pm.action.LoginAction;
import com.xiaohu.demo.pm.pojo.Privilege;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/6
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class Demo_Test {

    /**
     * 计算每层代码花费的时间  前置+后置
     */
    @Test
    public void count_time(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("count_time.xml");
        BasedAction ba = (BasedAction)ac.getBean("basedAction");
        ba.login();
    }

    /**
     * 对上面代码的优化：切面为TimeAspect  环绕通知去做的
     *
     */
    @Test
    public void time_improve(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("time_improve.xml");
        BasedAction ba = (BasedAction)ac.getBean("basedAction");
        ba.login();
    }

    /**
     * 权限管理的思路：
     *  1、创建service层的类和接口
     *  2、自定义一个注解
     *  3、自定义一个注解解析器
     *  4、写一个权限类Privilege
     *  5、写一个切面，写一个环绕通知
     */

    @Test
    public void access(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("privilege.xml");
        Access access =(Access) ac.getBean("access");
        Privilege privilege = new Privilege();
        privilege.setName("admin");

        access.getPrivileges().add(privilege);
        LoginAction la = (LoginAction)ac.getBean("basedAction");
        la.saveUser();

    }
}
