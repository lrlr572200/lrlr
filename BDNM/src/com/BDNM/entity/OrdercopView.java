package com.BDNM.entity;

import java.util.Date;

public class OrdercopView {
	private String orderNum;//¶©µ¥±àºÅ
	private int userId;
	private String userName;
	private int comid;
	private String comName;
	private int htId;
	private String htname;
	private double ordMoney;
	private double payment;
	private String state;
	private Date checkTime;
	private Date leaveTime;
	private Date subtime;
	private String htPictrue;
	private int count;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public int getHtId() {
		return htId;
	}
	public void setHtId(int htId) {
		this.htId = htId;
	}
	public String getHtname() {
		return htname;
	}
	public void setHtname(String htname) {
		this.htname = htname;
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
	public Date getSubtime() {
		return subtime;
	}
	public void setSubtime(Date subtime) {
		this.subtime = subtime;
	}
	public String getHtPictrue() {
		return htPictrue;
	}
	public void setHtPictrue(String htPictrue) {
		this.htPictrue = htPictrue;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getOrdMoney() {
		return ordMoney;
	}
	public void setOrdMoney(double ordMoney) {
		this.ordMoney = ordMoney;
	}
	
	
	


}
