package ssmCHp02.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import ssmCHp02.entity.User;

public interface UserDao {
	int findUserCount();
	
	User findUserByID(int id);
	/**
	 * 1.查询所有用户
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * 2.模糊查询用户信息
	 * @return
	 */
	List<User> findUserByName(String userName);
	/**
	 * 3.根据用户名和角色查询用户，多个参数 解决方案一：加别名
	 * @param userName
	 * @param roleId
	 * @return
	 */
	List<User> findUserByNameRole(@Param("userName") String userName, @Param("roleID") int roleID);
	
	/**
	 * 4.根据用户名和角色查询用户，多个参数 解决方案二：多个参数封装成实体
	 */
	List<User> findUserByNameRolePOJO(User user);
	
	/**
	 * 5.根据用户名和角色查询用户，多个参数 解决方案三：封装为Map集合
	 */
	List<User> findUserByNameRoleMap(Map map);
	
	/**
	 * 6.获取所有用户，结果中有角色名称，用户连接查询 
	 */
	List<User> findAllUser_RoleName();
	/**
	 * 7.根据ID获取用户信息和角色信息
	 * @param userID
	 * @return
	 */
	User findUserByID_user_role(int userID);
	
	/**
	 * 8.根据ID获取用户信息和地址信息
	 * @param userID
	 * @return
	 */
	User findUserByID_user_Address(int userID);
	/**
	 * 9.添加用户
	 * @return
	 */
	int addUser(User user);
}
