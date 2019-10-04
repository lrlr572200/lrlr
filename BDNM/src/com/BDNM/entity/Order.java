package com.BDNM.entity;

import java.util.Date;

/**
 * 订单实体类
 * @author LiuRen
 *
 */
public class Order {
	private String orderNum;//订单编号
	private int userId;//用户ID
	private int comId;//商品类别ID
	private int htId;//商品ID
	private double ordMoney;  //订单金额
	private double payment;//实际支付金额
	private String state;//订单状态
	private Date checkTime;//入住时间
	private Date leaveTime;//离开时间
	private Date subTime;//订单提交时间
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public int getHtId() {
		return htId;
	}
	public void setHtId(int htId) {
		this.htId = htId;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Date getSubTime() {
		return subTime;
	}
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
	public double getOrdMoney() {
		return ordMoney;
	}
	public void setOrdMoney(double ordMoney) {
		this.ordMoney = ordMoney;
	}
	
}
