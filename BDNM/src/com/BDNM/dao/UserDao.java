package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.User;

/*
 * 
 *7�� �û���User    ���ݲ����ӿ���
 * 
 * */
public interface UserDao {

	//�����û�
	int addUser(User user);
	
	//ɾ���û��������û�ID
	int delUserById(int userId);
	
	//�޸�
	int updateUser(User user);
	
	//����ȫ��
	List<User> findAllUser();
	
	//��¼����
	User findUserLogin(String userName,String password);
	
	//�����û�ID����
	User findUserById(int userId);
	
	//�����û���
	int findUserName(String userName);
	
	//��ҳ��ѯ�û�
		List<User> findAllUserPaging(int pageIndex,int pageSize);
		
		//��ѯ�û�����
		int findUserCount();
	
	//�޸��û����
	int updUserBalanceById(double balance,int userId);
	
	//����Ա����û�
	int adminAddUser(User user);
	
}
