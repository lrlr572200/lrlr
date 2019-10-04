package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.ComTypeDao;
import com.BDNM.entity.ComType;

/*
 * 
 * 1、商品类别表ComType的    数据操作实现类
 * 
 * */
public class ComTypeDaoImpl extends BaseDao implements ComTypeDao {
	
	private int count=-1;
	private String sql=null;
	private List<Object> DMlist = new ArrayList<Object>();

	//增加一条
	@Override
	public int addComType(ComType comType) {
		count=-1;
		DMlist.clear();
		try {
			sql="INSERT INTO ComType(comName) VALUES (?);";
			DMlist.add(comType.getComName());
			count=this.executeUpdate(sql, DMlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return this.count;
	}

	//删除一条，根据ID
	@Override
	public int delComTypeById(int comId) {
		count=-1;
		DMlist.clear();
		try {
			sql="DELETE FROM comtype WHERE comId=?;";
			DMlist.add(comId);
			count=this.executeUpdate(sql, DMlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return count;
	}

	//修改数据
	@Override
	public int updateComTypeById(ComType comType) {
		count=-1;
		DMlist.clear();
		try {
			sql="UPDATE comtype SET comName=? WHERE comId=?;";
			DMlist.add(comType.getComName());
			DMlist.add(comType.getComId());
			count=this.executeUpdate(sql, DMlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return count;
	}

	//查找全部
	@Override
	public List<ComType> findAllComType() {
		count=-1;
		DMlist.clear();
		List<ComType> comTypeList = new ArrayList<ComType>();
		try {
			sql="SELECT comId,comName FROM comtype;";
			this.rs=this.executeQuery(sql, null);
			ComType comType = null;
			while(this.rs.next()){
				comType = new ComType();
				comType.setComId(this.rs.getInt("comId"));
				comType.setComName(this.rs.getString("comName"));
				comTypeList.add(comType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return comTypeList;
	}
	
	

}
