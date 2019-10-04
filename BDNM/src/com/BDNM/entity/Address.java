package com.BDNM.entity;
/**
 * 地址实体类
 * @author LiuRen
 *
 */
public class Address {
	private int MunicipalAddId;//市级地区ID
	private String MunicipalAddName;//市级地区名
	private int MunicipalParentId;//市级所属地ID
	private int regionalAddId;  //区级地区ID
	private String regionalAddName;  //区级地区名
	private int regionalParentId;  //区级所属地ID
	
	
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
