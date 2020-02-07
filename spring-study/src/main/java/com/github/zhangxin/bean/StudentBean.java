package com.github.zhangxin.bean;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/7 14:21
 * @Description:
 */
public class StudentBean {
    private String name;
    private Integer age;
    private SchoolBean school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SchoolBean getSchool() {
        return school;
    }

    public void setSchool(SchoolBean school) {
        this.school = school;
    }
}
