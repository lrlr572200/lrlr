package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.OrdercopView;
/*
 * ��������ͼ�ӿڱ�
 * */
public interface OrdercopViewService {
	
	List<OrdercopView> findOrdercopViewPaging(int pageIndex, int pageSize, int userId, String state);
	
	//����һ������
		OrdercopView findOrdercopViewById(String orderNum);

}
