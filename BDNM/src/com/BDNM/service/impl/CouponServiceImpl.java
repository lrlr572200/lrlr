package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.CouponDao;
import com.BDNM.dao.impl.CouponDaoImpl;
import com.BDNM.entity.Coupon;
import com.BDNM.service.CouponService;

/*
 * 
 * 8、优惠券表Coupon   数据操作接口类
 * 
 * */
public class CouponServiceImpl implements CouponService {

	private CouponDao couponService = new CouponDaoImpl();
	
	@Override
	public int addCoupon(Coupon coupon) {
		return couponService.addCoupon(coupon);
	}

	@Override
	public int delCouponById(int couponId) {
		return couponService.delCouponById(couponId);
	}

	@Override
	public int updateCoupon(Coupon coupon) {
		return couponService.updateCoupon(coupon);
	}

	@Override
	public List<Coupon> findAllCoupon() {
		return couponService.findAllCoupon();
	}

	@Override
	public List<Coupon> findCouponByUserIdOrComId(int userId, int comId) {
		return couponService.findCouponByUserIdOrComId(userId, comId);
	}

	@Override
	public int findCouponCount(int userId, int comId) {
		return couponService.findCouponCount(userId, comId);
	}

	@Override
	public int findCouponNominal(int userId, int comId) {
		return couponService.findCouponNominal(userId, comId);
	}

}
