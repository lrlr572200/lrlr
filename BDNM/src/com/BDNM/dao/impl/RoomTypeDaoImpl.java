package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.RoomTypeDao;
import com.BDNM.entity.RoomType;

/*
 * 
 * 5、 房间类型表RoomType    数据操作实现类
 * 
 * */
public class RoomTypeDaoImpl extends BaseDao implements RoomTypeDao {

	private int count=-1;
	private String sql=null;
	private List<Object> DMlist = new ArrayList<Object>();
	@Override
	public String findRmTypeNameById(int rmTypeId) {
		DMlist.clear();
		String name = null;
		try {
			sql="SELECT rmTypeName FROM roomtype WHERE rmtypeid=?";
			DMlist.add(rmTypeId);
			this.rs=this.executeQuery(sql, DMlist);
			if(rs.next()){
				name=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return name;
	}
	@Override
	public RoomType findAllRoomTypeById(int rmTypeId) {
		DMlist.clear();
		RoomType room = null;
		try {
			sql = "SELECT rmtypeid,rmTypeName FROM roomtype WHERE rmtypeid=?";
			DMlist.add(rmTypeId);
			this.rs=this.executeQuery(sql, DMlist);
			if(rs.next()){
				room = new RoomType();
				room.setRmTypeId(rs.getInt(1));
				room.setRmTypeName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return room;
	}
	
	

}
