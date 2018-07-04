package com.mybatis;

import com.mybatis.entity.Order;
import com.mybatis.entity.QueryVo;
import com.mybatis.entity.User;
import com.mybatis.mapper.OrderMapper;
import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class OrderMapperTest {
    @Test
    public void OrderMapper() throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
     /*   public List<Order> selectOrdersList();*/
        /*List<Order> orders = mapper.selectOrdersList();
        for (Order o: orders){
            System.out.println(o);
        }*/

       /* public List<User> selectUserList()*/
       /* List<Order> o = mapper.selectOrders();
        for (Order i: o){
            System.out.println(i);
        }*/

        /*public List<User> selectUserList();*/
       /* List<User> users = mapper.selectUserList();
        for (User u: users){
            System.out.println(u);
        }*/
    }
}
