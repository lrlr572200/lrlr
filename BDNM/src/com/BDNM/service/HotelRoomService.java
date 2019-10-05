package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.HotelRoom;

/*
 * 
 * 5.1���Ƶ귿���HotelRoom ���ݲ����ӿ���
 * 
 * */
public interface HotelRoomService {

	//����
	int addHotelRoom(HotelRoom hotelRoom);
	
	//ɾ�������ݾƵ�ͷ�������
	int delHotelRoomByRmTypeIdAndHtId(int  rmTypeId,int htId);
	
	//�޸�
	int updateHotelRoom(HotelRoom hotelRoom);
	
	//����һ��������Ϣ
	HotelRoom findByRmTypeIdAndHtId(int  rmTypeId,int htId);

	List<HotelRoom>  findByHtId( int htId);
	
	double findAvgPriceByHtId(int htId);
	
	int updRmTypeSruplus(int rmTypeSruplus,int rmTypeId, int htId);
	
	//��ѯĳ�Ƶ��ĳ��������������
		int findRoomTypeCountByhtIdAndRmTypeId(int htId,int rmTypeId);
		
		//��ѯĳ�Ƶ�ĳ�ַ���Ķ�������
		String findSumByHtIdAndRmTypeId(int htId,int rmTypeId);

}
