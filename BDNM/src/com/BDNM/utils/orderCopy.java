package com.BDNM.utils;

import java.util.Date;

public class orderCopy {
	private String orderNum;//�������
	private int rmTypeId;//����ID
	private String rmTypeName;  //������
	private double rmTypePrice;//����۸�
	private String rmTypePictrue;
	private int htId;  //�Ƶ�ID
	private String htName;//�Ƶ�
	private int num;  //����
	private int userId;//�û�ID
	private double money;  //�������
	private double payment;//ʵ��֧�����
	private String state;//����״̬
	private int nominal;  //��ֵ
	private Date checkTime;//��סʱ��
	private Date leaveTime;//�뿪ʱ��
	private Date subTime;//�����ύʱ��
	private double balance;  //�û����
	
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
