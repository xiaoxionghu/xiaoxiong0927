package com.xiaohu.demo.pm.action;

import com.xiaohu.demo.annotation.PrivilegeInfo;
import com.xiaohu.demo.pm.service.BasedService;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/6
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction implements BasedAction {

    private BasedService loginService;

    public void setLoginService(BasedService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void login() {
        for (int i =0 ;i<100;i++){
            loginService.setName(i);
        }
    }

    @PrivilegeInfo(name = "admin")
    public void saveUser(){
        System.out.println("++++++++++");
    }
}
