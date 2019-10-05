package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.HotelDetails;

/*
 *4�� �Ƶ���Ϣ��HotelDetails   ���ݲ����ӿ���
 * 
 * */
public interface HotelDetailsDao {
	
	//���һ���Ƶ���Ϣ
	int addHotelDetails(HotelDetails hotelDetails);
	
	//ɾ��һ�������ݱ��
	int delHotelDetailsById(int htId);
	
	//�޸ľƵ���Ϣ
	int updateHotelDetails(HotelDetails hotelDetails);
	
	//����ȫ��
	List<HotelDetails> findAllHotelDetails();
	
	//����һ����¼�����ݱ��
	HotelDetails findHotelDetailsById(int htId);
	
	//ģ�����ң����ݾƵ����ͻ�Ƶ���
	List<HotelDetails> findHotelDetailsByTypeOrName(int htTypeId,String htName);
	
	/**
	 * ��ѯ�Ƶ���Ϣ������
	 * @return
	 */
	int findHotelDetailsCount();
	
	/**
	 * ��ҳ��ѯ
	 */
	List<HotelDetails> findHotelDetailsPaging(int pageIndex,int pageSize);

	
	/**
	 * ������ʾ�Ƶ���Ϣ
	 */
	List<HotelDetails> showHotelDetailsPCCT(String City,String countyName,int Type,int pageIndex,int pageSize);
	/**
	 * ������ʾ�Ƶ�����
	 */
	int findHotelDetailsCountFive(String City,String countyName,int Type);

	
	
}
