package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.ComType;

/*
 * 1、商品类别表ComType   数据操作接口类
 * 
 * */
public interface ComTypeDao {
	
	//增加一条
	int addComType(ComType comType);
	
	//删除一条，根据ID
	int delComTypeById(int comId);
	
	//修改数据
	int updateComTypeById(ComType comType);
	
	//查找全部
	List<ComType> findAllComType();
	
	

}
