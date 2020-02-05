package com.github.zhangxin;

import com.github.zhangxin.beans.Student;
import com.github.zhangxin.dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/5 14:25
 * @Description:
 */
public class MyBatisTest {
    private SqlSession sqlSession;

    @Before
    public void start() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void destroy() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void test() {
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student1 = studentDao.getStudentByStuId(1218094208);
//        studentDao.getStudentByStuId(1218094201);
        Student student = new Student();
        student.setPassword("123456");
        student.setStuId(1218094208);
        studentDao.updateStudent(student);
        Student student2 = studentDao.getStudentByStuId(1218094208);
        System.out.println(student1 == student2);
    }

}
