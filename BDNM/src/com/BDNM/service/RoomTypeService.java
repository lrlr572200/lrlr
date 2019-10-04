package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.RoomType;

/*
 * 
 * 5、房间类型表RoomType数据操作接口类
 * 
 * */
public interface RoomTypeService {
	
	//根据房间编号查找房间名
	String findRmTypeNameById(int rmTypeId);
	
	RoomType findAllRoomTypeById(int rmTypeId);

}
