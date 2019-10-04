package com.BDNM.entity;
/**
 * 优惠券实体类
 * @author LiuRen
 *
 */
public class Coupon {
	private int couponId;//优惠券ID
	private int comId;//商品类别ID
	private double nominal;//面值
	private int userId;//用户ID
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public double getNominal() {
		return nominal;
	}
	public void setNominal(double nominal) {
		this.nominal = nominal;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
