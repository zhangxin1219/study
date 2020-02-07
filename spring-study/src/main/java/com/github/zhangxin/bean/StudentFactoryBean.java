package com.github.zhangxin.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/7 14:46
 * @Description:
 */
public class StudentFactoryBean implements FactoryBean<StudentBean> {
    private String studentInfo;

    @Override
    public StudentBean getObject() throws Exception {
        StudentBean studentBean = new StudentBean();
        String[] infos = studentInfo.split(",");
        studentBean.setName(infos[0]);
        studentBean.setAge(Integer.valueOf(infos[1]));
        return studentBean;
    }

    @Override
    public Class<?> getObjectType() {
        return StudentBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }
}
