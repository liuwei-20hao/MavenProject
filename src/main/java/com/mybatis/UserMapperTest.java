package com.mybatis;

import com.mybatis.entity.QueryVo;
import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserMapperTest {
    @Test
    public void UserMapper() throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        /*QueryVo q = new QueryVo();
        User u = new User();
        u.setUsername("l");
        q.setUser(u);
        List<User> l = mapper.findUserByQueryVo(q);
        System.out.println(l.toString());*/

        /*Integer integer = mapper.countUser();
        System.out.println(integer);*/

        /*QueryVo queryVoById = mapper.findQueryVoById(1);
        System.out.println(queryVoById.getUser().toString());*/

        User u = new User();
        u.setUsername("lw");
        u.setId(1);
        User ud = mapper.findUserByIdAndName(u);
        System.out.println(ud);
    }
}
