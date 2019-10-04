package ssmCHp01.dao.impl;

import java.io.IOException;
import java.io.InputStream;




import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ssmCHp01.dao.RoleDao;
import ssmCHp01.entity.Role;

public class RoleDaoImpl implements RoleDao{
	/**
	 * Ìí¼Ó
	 */
	@Override
	public int addRole(Role role) {
		int rel=-1;
		SqlSession session=null;
		try {
			InputStream is= Resources.getResourceAsStream("mybatis_config.xml");
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			session=fact.openSession();
			rel=session.getMapper(RoleDao.class).addRole(role);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return rel;
	}
	/**
	 * ÐÞ¸Ä
	 */
	@Override
	public int updateRoleById(Role role) {
		int rel=-1;
		SqlSession session=null;
		try {
			InputStream is= Resources.getResourceAsStream("mybatis_config.xml");
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			session=fact.openSession();
			rel=session.getMapper(RoleDao.class).updateRoleById(role);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return rel;
	}
	@Override
	public int delRoleById(int Id) {
		int rel=-1;
		SqlSession session=null;
		try {
			InputStream is=Resources.getResourceAsStream("mybatis_config.xml");
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			session=fact.openSession();
			rel=session.getMapper(RoleDao.class).delRoleById(Id);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return rel;
	}
	/**
	 * ²éÑ¯
	 */
	@Override
	public List<Role> findAllRole() {
		List<Role> roList=new ArrayList<Role>();
		SqlSession session=null;
		try {
			InputStream is=Resources.getResourceAsStream("mybatis_config.xml");
			SqlSessionFactory fact=new SqlSessionFactoryBuilder().build(is);
			session=fact.openSession();
			roList=session.getMapper(RoleDao.class).findAllRole();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return roList;
	}

}
