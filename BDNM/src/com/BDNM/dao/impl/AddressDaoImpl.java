package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.AddressDao;
import com.BDNM.dao.BaseDao;
import com.BDNM.entity.Address;

/*
 * 
 * 2、 地址表Address    数据操作实现类
 * 
 * */
public class AddressDaoImpl extends BaseDao implements AddressDao {
	
	private int count=-1;
	private String sql=null;
	private List<Object> DMlist = new ArrayList<Object>();

	//增加一条
	@Override
	public int addAddress(Address address) {
		count=-1;
		DMlist.clear();
		try {
			sql="INSERT INTO address(addName,parentId) VALUES(?,?);";
			DMlist.add(address.getMunicipalAddName());
			DMlist.add(address.getMunicipalParentId());
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
	public List<Address> findAllAddress() {
		DMlist.clear();
		List<Address> addressList = new ArrayList<Address>();
		try {
			sql="SELECT a.`addId`,a.addName,a.parentId,b.`addId`,b.`addName`,b.`parentId` "
					+ "  FROM address a JOIN address b ON a.`addId`=b.`parentId` ;";
			this.rs=executeQuery(sql, null);
			Address address = null;
			while(this.rs.next()){
				address = new Address();
				address.setMunicipalAddId(rs.getInt(1));
				address.setMunicipalAddName(rs.getString(2));
				address.setMunicipalParentId(rs.getInt(3));
				address.setRegionalAddId(rs.getInt(4));
				address.setRegionalAddName(rs.getString(5));
				address.setRegionalParentId(rs.getInt(6));
				addressList.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return addressList;
	}

	//查找全部某属地及其行政区，根据属地编号
	@Override
	public List<Address> findAllAddressByAddId(int addressId) {
		DMlist.clear();
		List<Address> addressList = new ArrayList<Address>();
		try {
			sql="SELECT a.`addId`,a.addName,a.parentId,b.`addId`,b.`addName`,b.`parentId`  "
					+ "FROM address a JOIN address b ON a.`addId`=b.`parentId` WHERE b.`parentId`=?;";
			DMlist.add(addressId);
			this.rs=executeQuery(sql, DMlist);
			Address address = null;
			while(this.rs.next()){
				address = new Address();
				address.setMunicipalAddId(rs.getInt(1));
				address.setMunicipalAddName(rs.getString(2));
				address.setMunicipalParentId(rs.getInt(3));
				address.setRegionalAddId(rs.getInt(4));
				address.setRegionalAddName(rs.getString(5));
				address.setRegionalParentId(rs.getInt(6));
				addressList.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return addressList;
	}
	/**
	 * 查找全部市
	 */
	@Override
	public List<Address> findAllCity() {
		List<Address> addList=new ArrayList<Address>();
		sql="select * from address where parentId=0";
		try {
			Address ads=null;
			rs=this.executeQuery(sql, null);
			while(rs.next()){
				ads=new Address();
				ads.setMunicipalAddId(rs.getInt("addId"));
				ads.setMunicipalAddName(rs.getString("addName"));
				ads.setMunicipalParentId(rs.getInt("parentId"));
				addList.add(ads);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return addList;
	}
	/**
	 * 通过市ID查询区县总数量
	 * 
	 */
	@Override
	public int findCountyCountByParentId(int id) {
		int rel=0;
		sql="select count(0) from address where parentId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(id);
		try {
			rs=this.executeQuery(sql, psList);
			if(rs.next()){
				rel=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	//删除一个市
	@Override
	public int delAddressByAddId(int addId) {
		int rel=-1;
		sql="delete from address where addId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(addId);
		try {
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	//删除市管辖的所有区县
	@Override
	public int delAllCountyByParentId(int parentId) {
		int rel=-1;
		sql="delete from address where parentId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(parentId);
		try {
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	//修改一个市名
	@Override
	public int updateCityByAddId(Address address) {
		int rel=-1;
		sql="update address set addName=? where addId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(address.getMunicipalAddName());
		psList.add(address.getMunicipalAddId());
		try {
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	//根据城市名查询城市ID
	@Override
	public int findAddIdByAddName(String AddName) {
		int rel=-1;
		sql="select addId from address where addName=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(AddName);
		try {
			rs=this.executeQuery(sql, psList);
			if(rs.next()){
				rel=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	//通过区县ID查询区县名

	@Override
	public String findCountyNameByCountyId(int countyId) {
		String rel=null;
		sql="select addName from address where addId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(countyId);
		try {
			rs=this.executeQuery(sql, psList);
			if(rs.next()){
				rel=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	
	

}
