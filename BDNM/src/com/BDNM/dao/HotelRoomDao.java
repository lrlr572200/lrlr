package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.HotelRoom;
/*
 * 
 * 5.1���Ƶ귿���HotelRoom ���ݲ����ӿ���
 * 
 * */
public interface HotelRoomDao {
	
	//����
	int addHotelRoom(HotelRoom hotelRoom);
	
	//ɾ�������ݾƵ�ͷ�������
	int delHotelRoomByRmTypeIdAndHtId(int  rmTypeId,int htId);
	
	//�޸�
	int updateHotelRoom(HotelRoom hotelRoom);
	
	//����һ��������Ϣ
	HotelRoom findByRmTypeIdAndHtId(int  rmTypeId,int htId);
	
	List<HotelRoom>  findByHtId( int htId);
	
	//��ѯ�Ƶ�ĸ��ַ����λ��,ͨ���ܼ۳��������ס�������˾�����
		double findAvgPriceByHtId(int htId);
		
		//��ѯĳ�Ƶ��ĳ������������
		int findRoomTypeCountByhtIdAndRmTypeId(int htId,int rmTypeId);

		//��ѯĳ�Ƶ�ĳ�ַ���Ķ�������
		String findSumByHtIdAndRmTypeId(int htId,int rmTypeId);


		int updRmTypeSruplus(int rmTypeSruplus,int rmTypeId, int htId);

}
