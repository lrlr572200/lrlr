package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.User;

/*
 * 
 *7、 用户表User    数据操作接口类
 * 
 * */
public interface UserDao {

	//增加用户
	int addUser(User user);
	
	//删除用户，根据用户ID
	int delUserById(int userId);
	
	//修改
	int updateUser(User user);
	
	//查找全部
	List<User> findAllUser();
	
	//登录查找
	User findUserLogin(String userName,String password);
	
	//根据用户ID查找
	User findUserById(int userId);
	
	//查找用户名
	int findUserName(String userName);
	
	//分页查询用户
		List<User> findAllUserPaging(int pageIndex,int pageSize);
		
		//查询用户数量
		int findUserCount();
	
	//修改用户余额
	int updUserBalanceById(double balance,int userId);
	
	//管理员添加用户
	int adminAddUser(User user);
	
}
