package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.RoomType;

/*
 * 
 * 5���������ͱ�RoomType���ݲ����ӿ���
 * 
 * */
public interface RoomTypeService {
	
	//���ݷ����Ų��ҷ�����
	String findRmTypeNameById(int rmTypeId);
	
	RoomType findAllRoomTypeById(int rmTypeId);

}
