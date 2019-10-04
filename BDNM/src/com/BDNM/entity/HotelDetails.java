package com.BDNM.entity;
/**
 * 酒店信息实体类
 * @author LiuRen
 *
 */
public class HotelDetails {
	private int htId;//酒店ID
	private String htName;//酒店名
	private String htAddress;//酒店地址
	private int htTypeId;//酒店类型
	private String htPictrue;//酒店封面图
	private String htIntro;//酒店简介
	private String htPhone;//前台电话
	
	
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
	public int getHtTypeId() {
		return htTypeId;
	}
	public void setHtTypeId(int htTypeId) {
		this.htTypeId = htTypeId;
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
	
	
}
