package com.xiaohu.demo.aspect;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/7
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class Handle_Exception {

    /**
     * 异常通知
     * @param ex
     */
    public void getException(Throwable ex) {
        System.out.println(ex.getMessage());
    }
}
