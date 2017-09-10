package com.xiaohu.demo.pm.pojo;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/8
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class TimeBean {

    public TimeBean() {
    }

    private String className;
    private String menthodName;
    private long exctueTime;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMenthodName() {
        return menthodName;
    }

    public void setMenthodName(String menthodName) {
        this.menthodName = menthodName;
    }

    public long getExctueTime() {
        return exctueTime;
    }

    public void setExctueTime(long exctueTime) {
        this.exctueTime = exctueTime;
    }

    @Override
    public String toString() {
        return "TimeBean{" +
                "className='" + className + '\'' +
                ", menthodName='" + menthodName + '\'' +
                ", exctueTime=" + exctueTime +
                '}';
    }
}
