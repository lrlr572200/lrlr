package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.RoomType;

/*
 * 
 * 5���������ͱ�RoomType���ݲ����ӿ���
 * 
 * */
public interface RoomTypeDao {
	
	
	//���ҷ����������ݷ�������
	String findRmTypeNameById(int rmTypeId);

	//���ݱ�Ų��ҷ���
	RoomType findAllRoomTypeById(int rmTypeId);
	

}
