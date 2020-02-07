package com.github.zhangxin;

import com.github.zhangxin.bean.SchoolBean;
import com.github.zhangxin.bean.StudentBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/7 14:19
 * @Description:
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("spring-beans.xml");
        StudentBean studentBean1 = (StudentBean) beanFactory.getBean("mike");
        StudentBean studentBean2 = (StudentBean) beanFactory.getBean("nike");
        StudentBean peter = (StudentBean) beanFactory.getBean("peter");
        SchoolBean school1 = (SchoolBean) beanFactory.getBean("school1");
        SchoolBean school2 = (SchoolBean) beanFactory.getBean("school2");
        SchoolBean school3 = (SchoolBean) beanFactory.getBean("school3");
        System.out.println();
    }
}
