package com.BDNM.utils;

import java.util.Date;

/**
 * 显示评论工具类
 * @author LiuRen
 *
 */
public class ShowCommen {
	private int htId;//酒店Id
	private String userName;//用户名
	private String htName;//酒店名
	private String commen;//评论
	private int grade;//评分
	private Date commenTime;//评论时间
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
