package com.BDNM.entity;
/**
 * 订单详情实体类
 * @author LiuRen
 *
 */
public class OrderDetails {
	private int detailsId;  //订单详情ID
	private String orderNum;//订单编号
	private int rmTypeId;//商品名
	private double unit;//单价
	private int num;//数量
	private int nominal;//优惠券面值
	private String phone;//手机号
	
	public int getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getRmTypeId() {
		return rmTypeId;
	}
	public void setRmTypeId(int rmTypeId) {
		this.rmTypeId = rmTypeId;
	}
	public double getUnit() {
		return unit;
	}
	public void setUnit(double unit) {
		this.unit = unit;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNominal() {
		return nominal;
	}
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
