package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.HotelTypeDao;
import com.BDNM.entity.HotelType;

/*
 * 
 * 3、 酒店类型表HotelType   数据操作实现类
 * 
 * */
public class HotelTypeDaoImpl extends BaseDao implements HotelTypeDao {
	
	private int count=-1;
	private String sql=null;
	private List<Object> DMlist = new ArrayList<Object>();

	//增加一个酒店类型
	@Override
	public int addHotelType(HotelType hotelType) {
		count=-1;
		DMlist.clear();
		try {
			sql="INSERT INTO hoteltype(htTypeName) VALUES(?);";
			DMlist.add(hotelType.getHtTypeName());
			count=executeUpdate(sql, DMlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return count;
	}

	//删除一条，根据ID
	@Override
	public int delHotelTypeById(int htTypeId) {
		count=-1;
		DMlist.clear();
		try {
			sql="DELETE FROM hoteltype WHERE htTypeId=?;";
			DMlist.add(htTypeId);
			count=this.executeUpdate(sql, DMlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return count;
	}

	//修改
	@Override
	public int updateHotelTypeById(HotelType hotelType) {
		count=-1;
		DMlist.clear();
		try {
			sql="UPDATE hoteltype SET htTypeName=? WHERE htTypeId=?";
			DMlist.add(hotelType.getHtTypeName());
			DMlist.add(hotelType.getHtTypeId());
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
	public List<HotelType> findAllHotelType() {
		DMlist.clear();
		List<HotelType> hotelTypeList = new ArrayList<HotelType>();
		try {
			sql="SELECT htTypeId,htTypeName FROM hoteltype";
			this.rs=this.executeQuery(sql, null);
			HotelType hotelType = null;
			while(this.rs.next()){
				hotelType = new HotelType();
				hotelType.setHtTypeId(rs.getInt(1));
				hotelType.setHtTypeName(rs.getString(2));
				hotelTypeList.add(hotelType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return hotelTypeList;
	}

	@Override
	public String findHotelTypeNameById(int htTypeId) {
		DMlist.clear();
		String name = null;
		try {
			sql="SELECT htTypeName FROM hoteltype WHERE htTypeId=?";
			DMlist.add(htTypeId);
			this.rs=this.executeQuery(sql, DMlist);
			if(rs.next()){
				name = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return name;
	}
	
	
	

}
