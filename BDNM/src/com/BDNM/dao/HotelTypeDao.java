package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.HotelType;

/*
 * 3���Ƶ����ͱ�HotelType   ���ݲ����ӿ���
 * 
 * */
public interface HotelTypeDao {
	
	//����һ���Ƶ�����
	int addHotelType(HotelType hotelType);
	
	//ɾ��һ��������ID
	int delHotelTypeById(int htTypeId);
	
	//�޸�
	int updateHotelTypeById(HotelType hotelType);
	
	//����ȫ��
	List<HotelType> findAllHotelType();
	
	//���ҾƵ����͸��ݱ��
	String findHotelTypeNameById(int htTypeId);
	
}
