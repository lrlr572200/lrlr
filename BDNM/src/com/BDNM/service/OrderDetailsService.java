package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.OrderDetails;

/*
 * 
 * 11�����������OrderDetails    ���ݲ����ӿ�
 * 
 * */
public interface OrderDetailsService {
	 //���
	int addOrderDetails(OrderDetails orderDetails);
	//ɾ��
	int delOrderDetailsByOrderNum(String orderNum);
	//�޸�
	int updateOrderDetails(OrderDetails orderDetails);
	//��ѯ���ж�������
	List<OrderDetails> findAllOrderDetails();
	/**
	 * ��ҳ��ѯ
	 * ��������
	 */
	List<OrderDetails> findAllOrderDetailsPaging(int pageIndex,int pageSize);
	/**
	 * ��ѯ������������
	 * ���ݶ������
	 */
	int findOrderDetailsCountByOrderNum(String orderNum);
	
	List<OrderDetails> findOrderDetailsById(String orderNum);

}
