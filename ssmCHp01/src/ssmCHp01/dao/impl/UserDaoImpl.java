package ssmCHp01.dao.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ssmCHp01.dao.UserDao;
import ssmCHp01.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public int findUserCount() {
		int rel=-1;
		SqlSession session=null;
	 try {
//			>1.读取加载配置文件--->资源材料
		InputStream is=	Resources.getResourceAsStream("mybatis_config.xml");
// 			>2.创建工厂
		SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
// 			>3.创建会话--一次生产
		session= fac.openSession();
// 			>4.使用会话进行数据操作
		//		直接执行sql语句的方式：老版本，容易出错
//	rel=	session.selectOne("org.mybatis.userMapper.findUserCount");
		//		基于接口的方式--利用反射技术
	rel=	session.getMapper(UserDao.class).findUserCount();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally{
		 session.close();//关闭会话
	 }
		return rel;
	}

	
	
	@Override
	public User findUserByID(int userID) {
		User user =null;
		SqlSession session=null;
		//
		try {
			InputStream is= Resources.getResourceAsStream("mybatis_config.xml");
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			session=fact.openSession();
			user=session.getMapper(UserDao.class).findUserByID(userID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return user;
	}



	@Override
	public int insertUser(User user) {
		int rel=-1;
		SqlSession session=null;
		try {
			InputStream is= Resources.getResourceAsStream("mybatis_config.xml");
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			session=fact.openSession();
			rel=session.getMapper(UserDao.class).insertUser(user);
			session.commit();//提交事务
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return rel;
	}

	
}
