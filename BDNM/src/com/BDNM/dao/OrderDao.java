package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.Order;

/*
 * 
 * 10、订单表Order数据操作接口
 * 
 * */
public interface OrderDao {
	
    	//添加
		int addOrder(Order order);
		//删除(通过订单编号)
		int delOrderByOrderNum(String orderNum);
		//修改
		int updateOrderByOrderNum(Order order);
		//查询
		List<Order> findAllOrder();
		/**
		 * 分页查询
		 * 订单
		 */
		List<Order> findAllOrderPaging(int pageIndex,int pageSize,int userId,String state);
		/**
		 * 订单总记录数，根据用户
		 */
		int findOrderCount(int userId,String state);
		
		List<Integer> findNowOrder(int htId);
		
		Order findOrderByOrderNum(String orderNum);

}
