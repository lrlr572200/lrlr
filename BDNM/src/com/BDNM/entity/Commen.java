package com.BDNM.entity;

import java.util.Date;

/**
 * �û�����ʵ����
 * @author LiuRen
 *
 */
public class Commen {
	private int comId;  //����ID
	private int htId;//�Ƶ�ID
	private int userId;//�û�ID
	private int grade;//����
	private String commen;//����
	private Date commenTime;//����ʱ��
	public int getHtId() {
		return htId;
	}
	public void setHtId(int htId) {
		this.htId = htId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCommen() {
		return commen;
	}
	public void setCommen(String commen) {
		this.commen = commen;
	}
	public Date getCommenTime() {
		return commenTime;
	}
	public void setCommenTime(Date commenTime) {
		this.commenTime = commenTime;
	}
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	
}
