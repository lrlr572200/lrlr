package com.BDNM.entity;
/**
 * ��������ʵ����
 * @author LiuRen
 *
 */
public class HotelRoom {
	private int rmTypeId;//����ID
	private double rmTypePrice;//����۸�
	private int rmTypeCount;//��������
	private int rmTypeSruplus;//ʣ������
	private int htId;//�Ƶ�ID
	private String rmTypePictrue;//��������ͼ
	private String rmTypeIntro;//������
	
	
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
