package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.HotelType;

/*
 * 3���Ƶ����ͱ�HotelType   ���ݲ����ӿ���
 * 
 * */
public interface HotelTypeService {

	//����һ���Ƶ�����
	int addHotelType(HotelType hotelType);
	
	//ɾ��һ��������ID
	int delHotelTypeById(int htTypeId);
	
	//�޸�
	int updateHotelTypeById(HotelType hotelType);
	
	//����ȫ��
	List<HotelType> findAllHotelType();
	
	String findHotelTypeNameById(int htTypeId);
	

}
