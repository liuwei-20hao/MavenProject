package com.mybatis.mapper;

import com.mybatis.entity.QueryVo;
import com.mybatis.entity.User;

import java.util.List;

public interface UserMapper {
    //遵循四个原则
    //接口 方法名  == User.xml 中 id 名
    //返回值类型  与  Mapper.xml文件中返回值类型要一致
    //方法的入参类型 与Mapper.xml中入参的类型要一致
    //命名空间 绑定此接口
    public User findUserById(Integer id);
    public List<User> findUserByQueryVo(QueryVo queryVo);
    public Integer countUser();
    public QueryVo findQueryVoById(Integer id);
    public User findUserByIdAndName(User user);
    public List<User> findQueryVoByIds(QueryVo queryVo);

}
