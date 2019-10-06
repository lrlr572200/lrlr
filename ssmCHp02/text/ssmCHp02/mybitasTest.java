package ssmCHp02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import ssmCHp02.dao.UserDao;
import ssmCHp02.entity.Address;
import ssmCHp02.entity.User;
import ssmCHp02.util.MybatisUtil;

public class mybitasTest {
	//添加
	@Test
	public void testaddUser(){
		User user=new User();
		user.setUserCode("lisi");
		user.setUserName("李四");
		user.setUserPassword("572200");
		SqlSession session=null;
		int rel=-1;
		try{
			session=MybatisUtil.getSqlSessionFactory().openSession();
		 rel=session.getMapper(UserDao.class).addUser(user);
		session.commit();//提交事务
		}catch(Exception e){
			session.rollback();//回滚事务
		}
		finally{
			session.close();
		}
		if(rel>0){
			System.out.println(user.getId()+"插入成功");
		}else{
			System.out.println("失败");
		}
		
	}
	@Test
	public void testfindUserByID_user_Address(){
		SqlSession session=MybatisUtil.getSqlSessionFactory().openSession();
		User user=session.getMapper(UserDao.class).findUserByID_user_Address(1);
		System.out.println(user.getUserName());
		for(Address addr: user.getAddressList() ){
			System.out.println(addr.getAddressDesc());
		}
		session.close();
	}
	
	@Test
	public void testfindUserByID_user_role(){
		SqlSession session=MybatisUtil.getSqlSessionFactory().openSession();
		User user=session.getMapper(UserDao.class).findUserByID_user_role(1);
		System.out.println(user.getUserName()+"-"+user.getRole().getRoleName());
		
	}
	
	@Test
	public void testfindAllUser_RoleName(){
		SqlSession session=MybatisUtil.getSqlSessionFactory().openSession();
		List<User> userList= session.getMapper(UserDao.class).findAllUser_RoleName();
		for(User u:userList){
			System.out.println(u.getUserName()+"--"+u.getUserRoleName());
		}
	}
	
	@Test
	public void testfindUserByNameRoleMap(){
		Map map=new HashMap();
		map.put("name","孙");
		map.put("role",3);
		SqlSession session=MybatisUtil.getSqlSessionFactory().openSession();
		List<User> userList= session.getMapper(UserDao.class).findUserByNameRoleMap(map);
		for(User u:userList){
			System.out.println(u.getUserName());
		}
	}
	
	@Test
	public void testFindUserByNameRolePOJO(){
		User user=new User();
		user.setUserName("孙");
		user.setUserRole(3);
		SqlSession session=MybatisUtil.getSqlSessionFactory().openSession();
		List<User> userList= session.getMapper(UserDao.class).findUserByNameRolePOJO(user);
		for(User u:userList){
			System.out.println(u.getUserName());
		}
	}
		
	
		@Test
		public void testFindUserByNameRole(){
			SqlSession session=MybatisUtil.getSqlSessionFactory().openSession();
			List<User> userList= session.getMapper(UserDao.class).findUserByNameRole("孙",3);
			for(User u:userList){
				System.out.println(u.getUserName());
			}
		}
		
		
		
		@Test
		public void testFindAllUser2(){
			SqlSession session=MybatisUtil.getSqlSessionFactory().openSession();
			List<User> userList=session.getMapper(UserDao.class).findAllUser();
			
			for(User u:userList){
				System.out.println(u.getUserName());
			}
		}
}
