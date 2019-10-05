package com.BDNM.service;

import java.util.List;

import com.BDNM.entity.User;

/*
 * 
 *7�� �û���User    ���ݲ����ӿ���
 * 
 * */
public interface UserService {
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
		
		 boolean register(User user);
		 
		 int updUserBalanceById(double balance,int userId);
		 
		//��ҳ��ѯ�û�
			List<User> findAllUserPaging(int pageIndex,int pageSize);
			
			//��ѯ�û�����
			int findUserCount();
			
			//����Ա����û�
			int adminAddUser(User user);
}
