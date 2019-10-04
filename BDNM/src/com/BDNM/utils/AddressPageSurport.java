package com.BDNM.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.BDNM.entity.Address;



/**
 * 分页工具类
 * @author LiuRen
 *
 */
public class AddressPageSurport {
	private 	int pageSize;//页大小
	private		int pageIndex;//页索引
	private 	int totalCount;//总记录数
	private 	int pageCount;//总页数
	private 	List<Address> dataList=new ArrayList<Address>();//市集合
	private 	List dataListtwo=new ArrayList();//区县集合
	private     int  addId;//所属城市ID
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<Address> getDataList() {
		return dataList;
	}
	public void setDataList(List<Address> dataList) {
		this.dataList = dataList;
	}
	public List getDataListtwo() {
		return dataListtwo;
	}
	public void setDataListtwo(List dataListtwo) {
		this.dataListtwo = dataListtwo;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	
	
	
	
}
