package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.OrdercopView;
/*
 * 订单表视图接口表
 * */
public interface OrdercopViewService {
	
	List<OrdercopView> findOrdercopViewPaging(int pageIndex, int pageSize, int userId, String state);
	
	//查找一条订单
		OrdercopView findOrdercopViewById(String orderNum);

}
