package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.OrdercopView;

public interface OrdercopViewDao {

	//��ҳ+��������
	List<OrdercopView> findOrdercopViewPaging(int pageIndex, int pageSize, int userId, String state);
	
	//����һ������
	OrdercopView findOrdercopViewById(String orderNum);
}
