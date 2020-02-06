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
 * @Date: 2020/2/6 13:37
 * @Description:
 */
public class MyBatis1LevelCacheTest {
    private SqlSession sqlSession1;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void start() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
        sqlSession1 = sqlSessionFactory.openSession();
    }

    @After
    public void destroy() {
        if (sqlSession1 != null) {
            sqlSession1.close();
        }
    }

    @Test
    public void test() {
        StudentDao studentDao1 = sqlSession1.getMapper(StudentDao.class);
        Student student1 = studentDao1.getStudentByStuId(1218094208);
        System.out.println(student1);
        //sqlSession1.commit();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        StudentDao studentDao2 = sqlSession2.getMapper(StudentDao.class);
        Student student2 = new Student();
        student2.setPassword("123456");
        student2.setStuId(1218094208);
        studentDao2.updateStudent(student2);
        sqlSession2.commit();
        student2 = studentDao2.getStudentByStuId(1218094208);
        System.out.println(student2);

        Student student3 = studentDao1.getStudentByStuId(1218094208);
        System.out.println(student3);
        System.out.println(student1==student3);

    }
}
