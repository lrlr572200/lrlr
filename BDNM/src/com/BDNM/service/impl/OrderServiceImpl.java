package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.OrderDao;
import com.BDNM.dao.impl.OrderDaoImpl;
import com.BDNM.entity.Order;
import com.BDNM.service.OrderService;

/*
 * 
 * 10、订单表Order数据操作接口
 * 
 * */
public class OrderServiceImpl implements OrderService {

	private OrderDao orderService = new OrderDaoImpl();
	
	@Override
	public int addOrder(Order order) {
		return orderService.addOrder(order);
	}

	@Override
	public int delOrderByOrderNum(String orderNum) {
		return orderService.delOrderByOrderNum(orderNum);
	}

	@Override
	public int updateOrderByOrderNum(Order order) {
		return orderService.updateOrderByOrderNum(order);
	}

	@Override
	public List<Order> findAllOrder() {
		return orderService.findAllOrder();
	}

	@Override
	public List<Order> findAllOrderPaging(int pageIndex, int pageSize,int userId,String state) {
		return orderService.findAllOrderPaging(pageIndex, pageSize,userId,state);
	}

	@Override
	public int findOrderCount(int userId,String state) {
		return orderService.findOrderCount(userId,state);
	}

	@Override
	public List<Integer> findNowOrder(int htId) {
		return orderService.findNowOrder(htId);
	}

	@Override
	public Order findOrderByOrderNum(String orderNum) {
		return orderService.findOrderByOrderNum(orderNum);
	}

}
