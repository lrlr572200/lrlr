package ssmCHp01.dao;

import ssmCHp01.entity.User;

public interface UserDao {
		/**
		 * 获取用户数
		 * @return
		 */
		int findUserCount();
		
		/**
		 * 根据用户编号，获取用户信息
		 */
		User findUserByID(int userID);
		
		/**
		 * 添加一条数据
		 */
		int insertUser(User user);
}
