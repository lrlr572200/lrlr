package com.BDNM.utils;

import java.util.ArrayList;
import java.util.List;
//分页工具类
public class PageSurpport<T> {
	
	private int pageSize;//页容量大小
	 private int pageIndex;//页码索引
	 private int totalCount;//总记录数
	 private int pageCount;//页码数量
	 
	 private List<T> dataList=new ArrayList<T>();   //当前页数据
	 
	//页大小
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//页索引
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	//总记录数
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	//总页数
	public int getPageCount() {
		if(totalCount%pageSize==0)
		{
			pageCount=totalCount/pageSize;
		}else{
			pageCount=totalCount/pageSize+1;
		}
		return pageCount;
	}
	/*public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}*/
	
	//当前页数据
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	

}
