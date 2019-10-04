package com.BDNM.entity;
/**
 * 房间类型实体类
 * @author LiuRen
 *
 */
public class HotelRoom {
	private int rmTypeId;//类型ID
	private double rmTypePrice;//房间价格
	private int rmTypeCount;//房间数量
	private int rmTypeSruplus;//剩余数量
	private int htId;//酒店ID
	private String rmTypePictrue;//房间详情图
	private String rmTypeIntro;//房间简介
	
	
	public int getRmTypeId() {
		return rmTypeId;
	}
	public void setRmTypeId(int rmTypeId) {
		this.rmTypeId = rmTypeId;
	}

	public double getRmTypePrice() {
		return rmTypePrice;
	}
	public void setRmTypePrice(double rmTypePrice) {
		this.rmTypePrice = rmTypePrice;
	}
	public int getRmTypeCount() {
		return rmTypeCount;
	}
	public void setRmTypeCount(int rmTypeCount) {
		this.rmTypeCount = rmTypeCount;
	}
	public int getRmTypeSruplus() {
		return rmTypeSruplus;
	}
	public void setRmTypeSruplus(int rmTypeSruplus) {
		this.rmTypeSruplus = rmTypeSruplus;
	}
	public int getHtId() {
		return htId;
	}
	public void setHtId(int htId) {
		this.htId = htId;
	}
	public String getRmTypePictrue() {
		return rmTypePictrue;
	}
	public void setRmTypePictrue(String rmTypePictrue) {
		this.rmTypePictrue = rmTypePictrue;
	}
	public String getRmTypeIntro() {
		return rmTypeIntro;
	}
	public void setRmTypeIntro(String rmTypeIntro) {
		this.rmTypeIntro = rmTypeIntro;
	}
	
}
