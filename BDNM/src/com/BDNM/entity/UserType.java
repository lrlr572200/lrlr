package com.BDNM.entity;
/**
 * 用户类别实体类
 * @author LiuRen
 *
 */
public class UserType {
	private int userTypeId;//用户类别ID
	private String userTypeName;//类别名
	
	
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	
}
