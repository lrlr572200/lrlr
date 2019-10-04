package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.OrdercopView;

public interface OrdercopViewDao {

	//分页+索引查找
	List<OrdercopView> findOrdercopViewPaging(int pageIndex, int pageSize, int userId, String state);
	
	//查找一条订单
	OrdercopView findOrdercopViewById(String orderNum);
}
