package com.mybatis;

import mybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Test
    public void testQueryUser() throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /*
        5. 执行SqlSession对象执行查询，获取结果User
        */
        /*List<mybatis.User> user = sqlSession.selectList("queryUser");
        //第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        String username = sqlSession.selectOne("queryUserNameById",1);*/

        mybatis.User user = new User();
        //user.setId(4);
        user.setUsername("1");
        user.setSex("1");
        //user.setBirthday(new Date());
        user.setAddress("1");
        sqlSession.insert("saveUser",user);
        // 6. 打印结果
        /*System.out.println(user.toString());
        System.out.println(username);*/
        System.out.println(user.toString());
        // 7. 释放资源
        sqlSession.commit();
        sqlSession.close();
    }

}
