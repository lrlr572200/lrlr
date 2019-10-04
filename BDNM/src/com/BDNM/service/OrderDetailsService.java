package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.OrderDetails;

/*
 * 
 * 11、订单详情表OrderDetails    数据操作接口
 * 
 * */
public interface OrderDetailsService {
	 //添加
	int addOrderDetails(OrderDetails orderDetails);
	//删除
	int delOrderDetailsByOrderNum(String orderNum);
	//修改
	int updateOrderDetails(OrderDetails orderDetails);
	//查询所有订单详情
	List<OrderDetails> findAllOrderDetails();
	/**
	 * 分页查询
	 * 订单详情
	 */
	List<OrderDetails> findAllOrderDetailsPaging(int pageIndex,int pageSize);
	/**
	 * 查询订单详情总数
	 * 根据订单编号
	 */
	int findOrderDetailsCountByOrderNum(String orderNum);
	
	List<OrderDetails> findOrderDetailsById(String orderNum);

}
