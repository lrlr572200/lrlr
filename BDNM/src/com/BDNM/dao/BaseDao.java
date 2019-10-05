package com.BDNM.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	private static String driver="";
	private static String url="";
	private static String userName="";
	private static String password="";
	//��Ҫ����̳еĳ�Ա����
	protected Connection cn=null;
	protected PreparedStatement ps=null;
	protected ResultSet rs=null;
	//��̬�����
	static{
		init();
	}
	//ͨ����̬������ȡ�����ļ�
	private static void init()
	{
		//1.����������ʵ��
		Properties properties=new Properties();
		//2.���������ļ�������
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("datebase.properties");
		//3.�������ص��������б���
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4.���ݼ���ȡ������Ϣ
		driver=properties.getProperty("driver");
		url=properties.getProperty("url");
		userName=properties.getProperty("userName");
		password=properties.getProperty("password");
	}

	
	//�������Ӷ���(��װ��1,2��)
	public Connection getConnection()
	{
		//1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			cn=DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}//Connection

	//��5�����ͷ���Դ���ر����ж���
	public void closeAll(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(cn!=null){
				cn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//��װ���ݲ���
	//����ɾ����
	public int executeUpdate(String sql,List psList) throws SQLException
	{
		int rel=-1;
		getConnection();//getConnection()�����滻�˵�1,2��
		if(cn!=null){
			//3.��ȡ�������
			try {
				ps=cn.prepareStatement(sql);
					//�в�����ռλ����ֵ
					if(psList!=null){
						for(int i=0;i<psList.size();i++){
							ps.setObject(i+1, psList.get(i));
						}
					}
					
				//4.ִ��
				rel=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return rel;
	}//
	//��ѯ
	public ResultSet executeQuery(String sql,List psList) throws SQLException
	{
		getConnection();
		if(cn!=null){
			//3.
					try {
						ps=cn.prepareStatement(sql);
							//��ֵ
						if(psList!=null){
							for(int i=0;i<psList.size();i++){
								ps.setObject(i+1,psList.get(i));
							}
						}
						//4.
						rs=ps.executeQuery();
					} catch (SQLException e) {
						e.printStackTrace();
						throw e;
					}
		}
		return rs;
	}
}//��
