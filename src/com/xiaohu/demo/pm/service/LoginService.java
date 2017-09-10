package com.xiaohu.demo.pm.service;

import com.xiaohu.demo.pm.action.BasedAction;
import com.xiaohu.demo.pm.dao.BasedDao;
import com.xiaohu.demo.pm.dao.LoginDao;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/6
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class LoginService implements BasedService {

    private BasedDao loginDao;

    public void setLoginDao(BasedDao loginDao) {
        this.loginDao = loginDao;
    }

    public void setName(int i){
        loginDao.insert(i);
    }
}
