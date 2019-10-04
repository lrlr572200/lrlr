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
	//需要子类继承的成员变量
	protected Connection cn=null;
	protected PreparedStatement ps=null;
	protected ResultSet rs=null;
	//静态代码块
	static{
		init();
	}
	//通过静态代码块读取配置文件
	private static void init()
	{
		//1.创建属性类实体
		Properties properties=new Properties();
		//2.加载配置文件生成流
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("datebase.properties");
		//3.将流加载到属性类列表中
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4.根据键读取配置信息
		driver=properties.getProperty("driver");
		url=properties.getProperty("url");
		userName=properties.getProperty("userName");
		password=properties.getProperty("password");
	}

	
	//创建连接对象(封装第1,2步)
	public Connection getConnection()
	{
		//1.加载驱动
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

	//第5步，释放资源，关闭所有对象
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

	//封装数据操作
	//增，删，改
	public int executeUpdate(String sql,List psList) throws SQLException
	{
		int rel=-1;
		getConnection();//getConnection()方法替换了第1,2步
		if(cn!=null){
			//3.获取命令对象
			try {
				ps=cn.prepareStatement(sql);
					//有参数给占位符赋值
					if(psList!=null){
						for(int i=0;i<psList.size();i++){
							ps.setObject(i+1, psList.get(i));
						}
					}
					
				//4.执行
				rel=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return rel;
	}//
	//查询
	public ResultSet executeQuery(String sql,List psList) throws SQLException
	{
		getConnection();
		if(cn!=null){
			//3.
					try {
						ps=cn.prepareStatement(sql);
							//赋值
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
}//类
