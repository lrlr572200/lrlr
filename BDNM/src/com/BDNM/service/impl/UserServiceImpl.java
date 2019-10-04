package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.UserDao;
import com.BDNM.dao.impl.UserDaoImpl;
import com.BDNM.entity.User;
import com.BDNM.service.UserService;

/*
 * 
 *7、 用户表User    数据操作接口类
 * 
 * */
public class UserServiceImpl implements UserService {
	
	private UserDao userDao=new UserDaoImpl();
	private User user=new User();
	
	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int delUserById(int userId) {
		return userDao.delUserById(userId);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public User findUserLogin(String userName, String password) {
		return userDao.findUserLogin(userName, password);
	}

	@Override
	public User findUserById(int userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public boolean register(User user) {
		int users=userDao.addUser(user);
		if(users==1){
			return true;
		}else{
		return false;
		}
	}

	@Override
	public int findUserName(String userName) {
		return userDao.findUserName(userName);
	}

	@Override
	public int updUserBalanceById(double balance, int userId) {
		return userDao.updUserBalanceById(balance, userId);
	}

	@Override
	public List<User> findAllUserPaging(int pageIndex, int pageSize) {
		return userDao.findAllUserPaging(pageIndex, pageSize);
	}

	@Override
	public int findUserCount() {
		return userDao.findUserCount();
	}

	@Override
	public int adminAddUser(User user) {
		return userDao.adminAddUser(user);
	}
	
	

}
