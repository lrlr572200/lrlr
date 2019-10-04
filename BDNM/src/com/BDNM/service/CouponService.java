package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.Coupon;

/*
 * 
 * 8、优惠券表Coupon   数据操作接口类
 * 
 * */
public interface CouponService {
	
	//添加优惠券
		int addCoupon(Coupon coupon);
		
		//删除优惠券
		int delCouponById(int couponId);
		
		//修改优惠券
		int updateCoupon(Coupon coupon);
		
		//查找全部
		List<Coupon> findAllCoupon();
		
		//根据  用户或商品类型  查找优惠券
		List<Coupon> findCouponByUserIdOrComId (int userId,int comId);
		
		//统计用户优惠券数量根据传来的值
		int findCouponCount(int userId,int comId);
		
		int findCouponNominal(int userId, int comId);

}
