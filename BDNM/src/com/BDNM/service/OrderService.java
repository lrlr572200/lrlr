package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.Order;

/*
 * 
 * 10��������Order���ݲ����ӿ�
 * 
 * */
public interface OrderService {


	//���
	int addOrder(Order order);
	//ɾ��(ͨ���������)
	int delOrderByOrderNum(String orderNum);
	//�޸�
	int updateOrderByOrderNum(Order order);
	//��ѯ
	List<Order> findAllOrder();
	/**
	 * ��ҳ��ѯ
	 * ����
	 */
	List<Order> findAllOrderPaging(int pageIndex,int pageSize,int userId,String state);
	/**
	 * �����ܼ�¼��
	 */
	int findOrderCount(int userId,String state);
	
	List<Integer> findNowOrder(int htId);
	
	Order findOrderByOrderNum(String orderNum);
}
