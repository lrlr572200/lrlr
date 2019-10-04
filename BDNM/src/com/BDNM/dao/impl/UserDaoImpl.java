package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.UserDao;
import com.BDNM.entity.User;

/**
 * 7.用户表--数据操作实现类
 * @author 凯凯
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao{
	//添加用户信息
	@Override
	public int addUser(User user) {
		int rel=-1;
		String sql="INSERT INTO `user` (userName,`password`,phone,email,sex,`name`,userTypeId,balance,couponNum) VALUES(?,?,?,?,?,?,?,?,?);";
		List<Object> psList=new ArrayList<Object>();
		psList.add(user.getUserName());
		psList.add(user.getPassword());
		psList.add(user.getPhone());
		psList.add(user.getEmail());
		psList.add(user.getSex());
		psList.add(user.getName());
		psList.add(1);
		psList.add(user.getBalance());
		psList.add(user.getCouponNum());
		try {
			rel=executeUpdate(sql, psList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	//根据id删除用户信息
	@Override
	public int delUserById(int userId) {
		int rel=-1;
		String sql="DELETE FROM `user` WHERE userId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(userId);
		try {
			rel=executeUpdate(sql, psList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	//修改用户信息
	@Override
	public int updateUser(User user) {
		int rel=-1;
		String sql="UPDATE `user` SET userName=?,`password`=?,phone=?,email=?,sex=?,`name`=?,userTypeId=?,balance=?,couponNum=? WHERE userId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(user.getUserName());
		psList.add(user.getPassword());
		psList.add(user.getPhone());
		psList.add(user.getEmail());
		psList.add(user.getSex());
		psList.add(user.getName());
		psList.add(user.getUserTypeId());
		psList.add(user.getBalance());
		psList.add(user.getCouponNum());
		psList.add(user.getUserId());
		try {
			rel=executeUpdate(sql, psList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	//查询所有用户信息
	@Override
	public List<User> findAllUser() {
		List<User> userList=new ArrayList<User>();
		String sql="SELECT userId,userName,`password`,phone,email,sex,`name`,userTypeId,balance,couponNum FROM `user`;";
		try {
			rs=this.executeQuery(sql, null);
			User user=null;
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setName(rs.getString("name"));
				user.setUserTypeId(rs.getInt("userTypeId"));
				user.setBalance(rs.getDouble("balance"));
				user.setCouponNum(rs.getInt("couponNum"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return userList;
	}
	//有用户名和密码查询用户信息
	@Override
	public User findUserLogin(String userName, String password) {
		User user=null;
		String sql="SELECT userId,userName,`password`,phone,email,sex,`name`,userTypeId,balance,couponNum FROM `user` WHERE userName=? AND `password`=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(userName);
		psList.add(password);
		try {
			rs=this.executeQuery(sql, psList);
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setName(rs.getString("name"));
				user.setUserTypeId(rs.getInt("userTypeId"));
				user.setBalance(rs.getDouble("balance"));
				user.setCouponNum(rs.getInt("couponNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return user;
	}
	//根据id查询用户信息
	@Override
	public User findUserById(int userId) {
		User user=new User();
		String sql="SELECT userId,userName,`password`,phone,email,sex,`name`,userTypeId,balance,couponNum FROM `user` WHERE userId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(userId);
		try {
			rs=this.executeQuery(sql, psList);
			if(rs.next()){
				user=new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setName(rs.getString("name"));
				user.setUserTypeId(rs.getInt("userTypeId"));
				user.setBalance(rs.getDouble("balance"));
				user.setCouponNum(rs.getInt("couponNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return user;
	}
	@Override
	public int findUserName(String userName) {
		int srt = 0;
		try {
			String sql="SELECT userId FROM `user` WHERE userName=?";
			List<Object> psList=new ArrayList<Object>();
			psList.add(userName);
			this.rs=this.executeQuery(sql, psList);
			if(this.rs.next()){
				srt=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return srt;
	}
	@Override
	public int updUserBalanceById(double balance,int userId) {
		int rel = 0;
		try {
			String sql="UPDATE `user` SET balance=?  WHERE userId=?";
			List<Object> psList=new ArrayList<Object>();
			psList.add(balance);
			psList.add(userId);
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<User> findAllUserPaging(int pageIndex, int pageSize) {
		User user=null;
		List<User> listUser=new ArrayList<User>();
		String sql="SELECT * FROM `user` LIMIT ?,?";
		List<Object> psList=new ArrayList<Object>();
		psList.add((pageIndex-1)*pageSize);
		psList.add(pageSize);
		try {
			rs=this.executeQuery(sql, psList);
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setName(rs.getString("name"));
				user.setUserTypeId(rs.getInt("userTypeId"));
				user.setBalance(rs.getDouble("balance"));
				user.setCouponNum(rs.getInt("couponNum"));
				listUser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return listUser;
	}
	/**
	 * 查询用户总数量
	 */
	@Override
	public int findUserCount(){
		int rel=0;
		String sql="SELECT COUNT(0) FROM `user`";
		try {
			rs=this.executeQuery(sql, null);
			if(rs.next()){
				rel=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return rel;
	}
	//管理员添加用户
	@Override
	public int adminAddUser(User user) {
		int rel=-1;
		String sql="INSERT INTO `user` (userName,`password`,phone,email,sex,`name`,"
				+ "userTypeId,balance,couponNum) VALUES(?,?,?,?,?,?,?,?,?)";
		List<Object> psList=new ArrayList<Object>();
		psList.add(user.getUserName());
		psList.add(user.getPassword());
		psList.add(user.getPhone());
		psList.add(user.getEmail());
		psList.add(user.getSex());
		psList.add(user.getName());
		psList.add(user.getUserTypeId());
		psList.add(user.getBalance());
		psList.add(user.getCouponNum());
		try {
			rel=executeUpdate(sql, psList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}

}
