package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.ComType;

/*
 * 1����Ʒ����ComType   ���ݲ����ӿ���
 * 
 * */
public interface ComTypeDao {
	
	//����һ��
	int addComType(ComType comType);
	
	//ɾ��һ��������ID
	int delComTypeById(int comId);
	
	//�޸�����
	int updateComTypeById(ComType comType);
	
	//����ȫ��
	List<ComType> findAllComType();
	
	

}
