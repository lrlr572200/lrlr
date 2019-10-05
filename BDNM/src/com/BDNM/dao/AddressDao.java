package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.Address;

/*
 *   2�� ��ַ��Address   ���ݲ����ӿ���
 * 
 * */
public interface AddressDao {
	
	//����һ��
	int addAddress(Address address);
	
	//����ȫ��
	List<Address> findAllAddress();
	
	//����ȫ��ĳ���ؼ������������������ر��
	List<Address> findAllAddressByAddId(int addressId);
	

//��ѯ���е���
	List<Address> findAllCity();


	//������ID��ѯ����������
	int findCountyCountByParentId(int id);
	
	//ɾ��һ����
	int delAddressByAddId(int addId);
	
	//ɾ���й�Ͻ����������
	int delAllCountyByParentId(int parentId);
	
	//�޸�һ������
	int updateCityByAddId(Address address);
	
	//���ݳ�������ѯ����ID
	int findAddIdByAddName(String AddName);
	
	//ͨ������ID��ѯ������
	String findCountyNameByCountyId(int countyId);
}
