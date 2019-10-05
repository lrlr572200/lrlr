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
//			>1.��ȡ���������ļ�--->��Դ����
		InputStream is=	Resources.getResourceAsStream("mybatis_config.xml");
// 			>2.��������
		SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
// 			>3.�����Ự--һ������
		session= fac.openSession();
// 			>4.ʹ�ûỰ�������ݲ���
		//		ֱ��ִ��sql���ķ�ʽ���ϰ汾�����׳���
//	rel=	session.selectOne("org.mybatis.userMapper.findUserCount");
		//		���ڽӿڵķ�ʽ--���÷��似��
	rel=	session.getMapper(UserDao.class).findUserCount();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally{
		 session.close();//�رջỰ
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
			session.commit();//�ύ����
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
