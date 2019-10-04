package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.OrderDetailsDao;
import com.BDNM.dao.impl.OrderDetailsDaoImpl;
import com.BDNM.entity.OrderDetails;
import com.BDNM.service.OrderDetailsService;

public class OrderDetailsServiceImpl implements OrderDetailsService {

	private OrderDetailsDao orderDetailsService = new OrderDetailsDaoImpl();
	
	@Override
	public int addOrderDetails(OrderDetails orderDetails) {
		return orderDetailsService.addOrderDetails(orderDetails);
	}

	@Override
	public int delOrderDetailsByOrderNum(String orderNum) {
		return orderDetailsService.delOrderDetailsByOrderNum(orderNum);
	}

	@Override
	public int updateOrderDetails(OrderDetails orderDetails) {
		return orderDetailsService.updateOrderDetails(orderDetails);
	}

	@Override
	public List<OrderDetails> findAllOrderDetails() {
		return orderDetailsService.findAllOrderDetails();
	}

	@Override
	public List<OrderDetails> findAllOrderDetailsPaging(int pageIndex,
			int pageSize) {
		return orderDetailsService.findAllOrderDetailsPaging(pageIndex, pageSize);
	}

	@Override
	public int findOrderDetailsCountByOrderNum(String orderNum) {
		return orderDetailsService.findOrderDetailsCountByOrderNum(orderNum);
	}

	@Override
	public List<OrderDetails> findOrderDetailsById(String orderNum) {
		return orderDetailsService.findOrderDetailsById(orderNum);
	}

}
