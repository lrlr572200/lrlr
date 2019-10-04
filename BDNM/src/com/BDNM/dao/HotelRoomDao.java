package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.HotelRoom;
/*
 * 
 * 5.1、酒店房间表HotelRoom 数据操作接口类
 * 
 * */
public interface HotelRoomDao {
	
	//增加
	int addHotelRoom(HotelRoom hotelRoom);
	
	//删除，根据酒店和房间类型
	int delHotelRoomByRmTypeIdAndHtId(int  rmTypeId,int htId);
	
	//修改
	int updateHotelRoom(HotelRoom hotelRoom);
	
	//查找一条房间信息
	HotelRoom findByRmTypeIdAndHtId(int  rmTypeId,int htId);
	
	List<HotelRoom>  findByHtId( int htId);
	
	//查询酒店的各种房间价位和,通过总价除以最大入住人数求人均消费
		double findAvgPriceByHtId(int htId);
		
		//查询某酒店的某房间类型总量
		int findRoomTypeCountByhtIdAndRmTypeId(int htId,int rmTypeId);

		//查询某酒店某种房间的订购数量
		String findSumByHtIdAndRmTypeId(int htId,int rmTypeId);


		int updRmTypeSruplus(int rmTypeSruplus,int rmTypeId, int htId);

}
