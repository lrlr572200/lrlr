package com.BDNM.utils;

import java.util.Date;

public class orderCopy {
	private String orderNum;//订单编号
	private int rmTypeId;//类型ID
	private String rmTypeName;  //房间名
	private double rmTypePrice;//房间价格
	private String rmTypePictrue;
	private int htId;  //酒店ID
	private String htName;//酒店
	private int num;  //数量
	private int userId;//用户ID
	private double money;  //订单金额
	private double payment;//实际支付金额
	private String state;//订单状态
	private int nominal;  //面值
	private Date checkTime;//入住时间
	private Date leaveTime;//离开时间
	private Date subTime;//订单提交时间
	private double balance;  //用户余额
	
	public int getRmTypeId() {
		return rmTypeId;
	}
	public void setRmTypeId(int rmTypeId) {
		this.rmTypeId = rmTypeId;
	}
	public String getRmTypeName() {
		return rmTypeName;
	}
	public void setRmTypeName(String rmTypeName) {
		this.rmTypeName = rmTypeName;
	}
	public double getRmTypePrice() {
		return rmTypePrice;
	}
	public void setRmTypePrice(double rmTypePrice) {
		this.rmTypePrice = rmTypePrice;
	}
	public int getHtId() {
		return htId;
	}
	public void setHtId(int htId) {
		this.htId = htId;
	}
	public String getHtName() {
		return htName;
	}
	public void setHtName(String htName) {
		this.htName = htName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getNominal() {
		return nominal;
	}
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	public String getRmTypePictrue() {
		return rmTypePictrue;
	}
	public void setRmTypePictrue(String rmTypePictrue) {
		this.rmTypePictrue = rmTypePictrue;
	}
	public double getMoney() {
		return this.money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	
	
}
