package com.BDNM.utils;

import java.util.ArrayList;
import java.util.List;
//��ҳ������
public class PageSurpport<T> {
	
	private int pageSize;//ҳ������С
	 private int pageIndex;//ҳ������
	 private int totalCount;//�ܼ�¼��
	 private int pageCount;//ҳ������
	 
	 private List<T> dataList=new ArrayList<T>();   //��ǰҳ����
	 
	//ҳ��С
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//ҳ����
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	//�ܼ�¼��
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	//��ҳ��
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
	
	//��ǰҳ����
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	

}
