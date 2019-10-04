package com.BDNM.entity;

import java.util.Date;

/**
 * 用户评论实体类
 * @author LiuRen
 *
 */
public class Commen {
	private int comId;  //评论ID
	private int htId;//酒店ID
	private int userId;//用户ID
	private int grade;//评分
	private String commen;//评论
	private Date commenTime;//评论时间
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
