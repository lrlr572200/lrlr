package com.BDNM.utils;

import java.util.ArrayList;
import java.util.List;



/**
 * 分页工具类
 * @author LiuRen
 *
 */
public class PageSurport<T> {
	private 	int pageSize;//页大小
	private		int pageIndex;//页索引
	private 	int totalCount;//总记录数
	private 	int pageCount;//总页数
	private 	List<T> dataList=new ArrayList<T>();//当前页数据
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
	
	
	public int getPageCount()//计算总页数，注释set方法变成只读
	{
		if(totalCount%pageSize==0)
		{
			pageCount=totalCount/pageSize;
		}
		else{
			pageCount=totalCount/pageSize+1;
		}
		return pageCount;
	}
	/*public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}*/
	
	
	
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
}
