package com.BDNM.entity;

import java.util.Date;

/**
 * ����ʵ����
 * @author LiuRen
 *
 */
public class Order {
	private String orderNum;//�������
	private int userId;//�û�ID
	private int comId;//��Ʒ���ID
	private int htId;//��ƷID
	private double ordMoney;  //�������
	private double payment;//ʵ��֧�����
	private String state;//����״̬
	private Date checkTime;//��סʱ��
	private Date leaveTime;//�뿪ʱ��
	private Date subTime;//�����ύʱ��
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
