package com.github.zhangxin.dao;

import com.github.zhangxin.beans.Student;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/5 14:22
 * @Description:
 */
public interface StudentDao {
    Student getStudentByStuId(Integer stuId);
}

