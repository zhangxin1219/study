package com.github.zhangxin.beans;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/5 14:12
 * @Description:
 */
@Data
public class Student implements Serializable {
    private Integer stuId;
    private String stuName;
    private String password;
    private Integer classId;
    private Timestamp createTime;
    private Timestamp updateTime;
}
