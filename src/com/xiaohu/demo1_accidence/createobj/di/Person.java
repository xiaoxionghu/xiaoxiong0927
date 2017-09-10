package com.xiaohu.demo1_accidence.createobj.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/4
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    public int getId() {
        return id;
    }

    public void setId(int pid) {
        this.id = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public List getL() {
        return l;
    }

    public void setL(List l) {
        this.l = l;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    private int id;
    private String name;
    private Student stu;
    private List l;
    private Map map;
    private Properties properties;
    private Set set;
}
