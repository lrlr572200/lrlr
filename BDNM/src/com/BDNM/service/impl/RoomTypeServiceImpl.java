package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.RoomTypeDao;
import com.BDNM.dao.impl.RoomTypeDaoImpl;
import com.BDNM.entity.RoomType;
import com.BDNM.service.RoomTypeService;

/*
 * 
 * 5���������ͱ�RoomType���ݲ����ӿ���
 * 
 * */
public class RoomTypeServiceImpl implements RoomTypeService {

	private RoomTypeDao roomTypeService = new RoomTypeDaoImpl();

	@Override
	public String findRmTypeNameById(int rmTypeId) {
		return roomTypeService.findRmTypeNameById(rmTypeId);
	}

	@Override
	public RoomType findAllRoomTypeById(int rmTypeId) {
		return roomTypeService.findAllRoomTypeById(rmTypeId);
	}
	
	

}
