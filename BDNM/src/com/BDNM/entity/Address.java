package com.BDNM.entity;
/**
 * ��ַʵ����
 * @author LiuRen
 *
 */
public class Address {
	private int MunicipalAddId;//�м�����ID
	private String MunicipalAddName;//�м�������
	private int MunicipalParentId;//�м�������ID
	private int regionalAddId;  //��������ID
	private String regionalAddName;  //����������
	private int regionalParentId;  //����������ID
	
	
	public int getMunicipalAddId() {
		return MunicipalAddId;
	}
	public void setMunicipalAddId(int municipalAddId) {
		MunicipalAddId = municipalAddId;
	}
	public String getMunicipalAddName() {
		return MunicipalAddName;
	}
	public void setMunicipalAddName(String municipalAddName) {
		MunicipalAddName = municipalAddName;
	}
	public int getMunicipalParentId() {
		return MunicipalParentId;
	}
	public void setMunicipalParentId(int municipalParentId) {
		MunicipalParentId = municipalParentId;
	}
	public int getRegionalAddId() {
		return regionalAddId;
	}
	public void setRegionalAddId(int regionalAddId) {
		this.regionalAddId = regionalAddId;
	}
	public String getRegionalAddName() {
		return regionalAddName;
	}
	public void setRegionalAddName(String regionalAddName) {
		this.regionalAddName = regionalAddName;
	}
	public int getRegionalParentId() {
		return regionalParentId;
	}
	public void setRegionalParentId(int regionalParentId) {
		this.regionalParentId = regionalParentId;
	}
	
	
	
}
