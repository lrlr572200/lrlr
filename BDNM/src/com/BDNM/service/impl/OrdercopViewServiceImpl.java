package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.OrdercopViewDao;
import com.BDNM.dao.impl.OrdercopViewDaoImpl;
import com.BDNM.entity.OrdercopView;
import com.BDNM.service.OrdercopViewService;

public class OrdercopViewServiceImpl implements OrdercopViewService {
 
	 private OrdercopViewDao orderView = new OrdercopViewDaoImpl();
	@Override
	public List<OrdercopView> findOrdercopViewPaging(int pageIndex,
			int pageSize, int userId, String state) {
		return orderView.findOrdercopViewPaging(pageIndex, pageSize, userId, state);
	}
	@Override
	public OrdercopView findOrdercopViewById(String orderNum) {
		return orderView.findOrdercopViewById(orderNum);
	}

}
