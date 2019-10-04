package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.HotelRoom;

/*
 * 
 * 5.1、酒店房间表HotelRoom 数据操作接口类
 * 
 * */
public interface HotelRoomService {

	//增加
	int addHotelRoom(HotelRoom hotelRoom);
	
	//删除，根据酒店和房间类型
	int delHotelRoomByRmTypeIdAndHtId(int  rmTypeId,int htId);
	
	//修改
	int updateHotelRoom(HotelRoom hotelRoom);
	
	//查找一条房间信息
	HotelRoom findByRmTypeIdAndHtId(int  rmTypeId,int htId);

	List<HotelRoom>  findByHtId( int htId);
	
	double findAvgPriceByHtId(int htId);
	
	int updRmTypeSruplus(int rmTypeSruplus,int rmTypeId, int htId);
	
	//查询某酒店的某房间类型总数量
		int findRoomTypeCountByhtIdAndRmTypeId(int htId,int rmTypeId);
		
		//查询某酒店某种房间的订购数量
		String findSumByHtIdAndRmTypeId(int htId,int rmTypeId);

}
