package com.BDNM.utils;
//酒店信息实体类副本
public class HotelDetailsCopy {
	private int htId;//酒店ID
	private String htName;//酒店名
	private String htAddress;//酒店地址
	private String htTypeName;//酒店类型
	private String htPictrue;//酒店封面图
	private String htIntro;//酒店简介
	private String htPhone;//前台电话
	private double avgGrade;  //人均评分
	private int gradeCot; //评论数量
	private double avgMoney;  //人均价格
	
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
	public String getHtAddress() {
		return htAddress;
	}
	public void setHtAddress(String htAddress) {
		this.htAddress = htAddress;
	}
	public String getHtTypeName() {
		return htTypeName;
	}
	public void setHtTypeName(String htTypeName) {
		this.htTypeName = htTypeName;
	}
	public String getHtPictrue() {
		return htPictrue;
	}
	public void setHtPictrue(String htPictrue) {
		this.htPictrue = htPictrue;
	}
	public String getHtIntro() {
		return htIntro;
	}
	public void setHtIntro(String htIntro) {
		this.htIntro = htIntro;
	}
	public String getHtPhone() {
		return htPhone;
	}
	public void setHtPhone(String htPhone) {
		this.htPhone = htPhone;
	}
	public double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	public double getAvgMoney() {
		return avgMoney;
	}
	public void setAvgMoney(double avgMoney) {
		this.avgMoney = avgMoney;
	}
	public int getGradeCot() {
		return gradeCot;
	}
	public void setGradeCot(int gradeCot) {
		this.gradeCot = gradeCot;
	}
	
	
}
