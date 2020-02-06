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
 * @Date: 2020/2/6 12:15
 * @Description: MyBatis二级缓存测试
 */
public class MyBatis2LevelCacheTest {
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
        StudentDao studentDao = sqlSession1.getMapper(StudentDao.class);
        Student student1 = studentDao.getStudentByStuId(1218094208);
        System.out.println(student1);
        sqlSession1.commit();


        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        StudentDao studentDao2 = sqlSession2.getMapper(StudentDao.class);
        Student student2 = studentDao2.getStudentByStuId(1218094208);
        System.out.println(student2);

        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        StudentDao studentDao3 = sqlSession3.getMapper(StudentDao.class);
        Student student3 = new Student();
        student3.setPassword("1234567");
        student3.setStuId(1218094201);
        studentDao3.updateStudent(student3);
        sqlSession3.commit();

        SqlSession sqlSession4 = sqlSessionFactory.openSession();
        StudentDao studentDao4 = sqlSession4.getMapper(StudentDao.class);
        Student student4 = studentDao4.getStudentByStuId(1218094208);
        System.out.println(student4);

    }
}
