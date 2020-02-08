package com.github.zhangxin.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/7 18:55
 * @Description:
 */
public class SchoolBean implements BeanNameAware, InitializingBean {
    private String name;
    private int studentNum;
    private String beanName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println(this.beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
