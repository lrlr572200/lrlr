package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.RoomType;

/*
 * 
 * 5、房间类型表RoomType数据操作接口类
 * 
 * */
public interface RoomTypeDao {
	
	
	//查找房间名，根据房间类型
	String findRmTypeNameById(int rmTypeId);

	//根据编号查找房间
	RoomType findAllRoomTypeById(int rmTypeId);
	

}
