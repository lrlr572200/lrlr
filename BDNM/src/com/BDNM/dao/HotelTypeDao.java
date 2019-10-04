package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.HotelType;

/*
 * 3、酒店类型表HotelType   数据操作接口类
 * 
 * */
public interface HotelTypeDao {
	
	//增加一个酒店类型
	int addHotelType(HotelType hotelType);
	
	//删除一条，根据ID
	int delHotelTypeById(int htTypeId);
	
	//修改
	int updateHotelTypeById(HotelType hotelType);
	
	//查找全部
	List<HotelType> findAllHotelType();
	
	//查找酒店类型根据编号
	String findHotelTypeNameById(int htTypeId);
	
}
