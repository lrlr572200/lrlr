package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.Coupon;

/*
 * 
 * 8���Ż�ȯ��Coupon   ���ݲ����ӿ���
 * 
 * */
public interface CouponService {
	
	//����Ż�ȯ
		int addCoupon(Coupon coupon);
		
		//ɾ���Ż�ȯ
		int delCouponById(int couponId);
		
		//�޸��Ż�ȯ
		int updateCoupon(Coupon coupon);
		
		//����ȫ��
		List<Coupon> findAllCoupon();
		
		//����  �û�����Ʒ����  �����Ż�ȯ
		List<Coupon> findCouponByUserIdOrComId (int userId,int comId);
		
		//ͳ���û��Ż�ȯ�������ݴ�����ֵ
		int findCouponCount(int userId,int comId);
		
		int findCouponNominal(int userId, int comId);

}
