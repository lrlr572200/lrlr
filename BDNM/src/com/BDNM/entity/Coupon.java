package com.BDNM.entity;
/**
 * �Ż�ȯʵ����
 * @author LiuRen
 *
 */
public class Coupon {
	private int couponId;//�Ż�ȯID
	private int comId;//��Ʒ���ID
	private double nominal;//��ֵ
	private int userId;//�û�ID
	
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
