package com.BDNM.utils;

import java.util.Date;

/**
 * ��ʾ���۹�����
 * @author LiuRen
 *
 */
public class ShowCommen {
	private int htId;//�Ƶ�Id
	private String userName;//�û���
	private String htName;//�Ƶ���
	private String commen;//����
	private int grade;//����
	private Date commenTime;//����ʱ��
	public int getHtId() {
		return htId;
	}
	public void setHtId(int htId) {
		this.htId = htId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHtName() {
		return htName;
	}
	public void setHtName(String htName) {
		this.htName = htName;
	}
	public String getCommen() {
		return commen;
	}
	public void setCommen(String commen) {
		this.commen = commen;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getCommenTime() {
		return commenTime;
	}
	public void setCommenTime(Date commenTime) {
		this.commenTime = commenTime;
	}
	
}
