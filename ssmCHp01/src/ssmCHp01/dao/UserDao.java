package ssmCHp01.dao;

import ssmCHp01.entity.User;

public interface UserDao {
		/**
		 * ��ȡ�û���
		 * @return
		 */
		int findUserCount();
		
		/**
		 * �����û���ţ���ȡ�û���Ϣ
		 */
		User findUserByID(int userID);
		
		/**
		 * ���һ������
		 */
		int insertUser(User user);
}
