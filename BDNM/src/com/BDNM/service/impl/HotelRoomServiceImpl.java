package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.HotelRoomDao;
import com.BDNM.dao.impl.HotelRoomDaoImpl;
import com.BDNM.entity.HotelRoom;
import com.BDNM.service.HotelRoomService;

/*
 * 
 * 5.1、酒店房间表HotelRoom 数据操作接口类
 * 
 * */
public class HotelRoomServiceImpl implements HotelRoomService {

	private HotelRoomDao hotelRoomService = new HotelRoomDaoImpl();
	@Override
	public int addHotelRoom(HotelRoom hotelRoom) {
		return hotelRoomService.addHotelRoom(hotelRoom);
	}

	@Override
	public int delHotelRoomByRmTypeIdAndHtId(int rmTypeId, int htId) {
		return hotelRoomService.delHotelRoomByRmTypeIdAndHtId(rmTypeId, htId);
	}

	@Override
	public int updateHotelRoom(HotelRoom hotelRoom) {
		return hotelRoomService.updateHotelRoom(hotelRoom);
	}

	@Override
	public HotelRoom findByRmTypeIdAndHtId(int rmTypeId, int htId) {
		return hotelRoomService.findByRmTypeIdAndHtId(rmTypeId, htId);
	}

	@Override
	public List<HotelRoom> findByHtId(int htId) {
		return hotelRoomService.findByHtId(htId);
	}
	
	@Override
	public double findAvgPriceByHtId(int htId) {
		return hotelRoomService.findAvgPriceByHtId(htId);
	}

	@Override
	public int updRmTypeSruplus(int rmTypeSruplus, int rmTypeId, int htId) {
		return hotelRoomService.updRmTypeSruplus(rmTypeSruplus, rmTypeId, htId);
	}

	@Override
	public int findRoomTypeCountByhtIdAndRmTypeId(int htId, int rmTypeId) {
		return hotelRoomService.findRoomTypeCountByhtIdAndRmTypeId(htId, rmTypeId);
	}

	@Override
	public String findSumByHtIdAndRmTypeId(int htId, int rmTypeId) {
		return hotelRoomService.findSumByHtIdAndRmTypeId(htId, rmTypeId);
	}

}
