package com.mybatis.mapper;

import java.util.List;
import com.mybatis.entity.Order;
import com.mybatis.entity.User;

public interface OrderMapper {
	
	
//	查询订单表order的所有数据

	public List<Order> selectOrdersList();
	
	//一对一关联 查询  以订单为中心 关联用户
	public List<Order> selectOrders();
	
	//一对多关联
	public List<User> selectUserList();
	
}
