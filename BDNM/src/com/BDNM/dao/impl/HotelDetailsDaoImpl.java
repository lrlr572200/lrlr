package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.HotelDetailsDao;
import com.BDNM.entity.HotelDetails;
/*
 * 
 * 4、 酒店信息表HotelDetails   数据操作实现类
 * 
 * */
public class HotelDetailsDaoImpl extends BaseDao implements HotelDetailsDao {
	
	private int count=-1;
	private String sql=null;
	private List<Object> DMlist = new ArrayList<Object>();

	//添加一条酒店信息
	@Override
	public int addHotelDetails(HotelDetails hotelDetails) {
		count=-1;
		DMlist.clear();
		try {
			sql="INSERT INTO hoteldetails(htName,htAddress,htTypeId,htPictrue,htIntro,htPhone)"
					+ " VALUES(?,?,?,?,?,?)";
			DMlist.add(hotelDetails.getHtName());
			DMlist.add(hotelDetails.getHtAddress());
			DMlist.add(hotelDetails.getHtTypeId());
			DMlist.add(hotelDetails.getHtPictrue());
			DMlist.add(hotelDetails.getHtIntro());
			DMlist.add(hotelDetails.getHtPhone());
			count=this.executeUpdate(sql, DMlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return count;
	}

	//删除一条，根据编号
	@Override
	public int delHotelDetailsById(int htId) {
		count=-1;
		DMlist.clear();
		try {
			sql="DELETE FROM hoteldetails WHERE htId=?";
			DMlist.add(htId);
			count=this.executeUpdate(sql, DMlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return count;
	}

	//修改酒店信息
	@Override
	public int updateHotelDetails(HotelDetails hotelDetails) {
		count=-1;
		DMlist.clear();
		try {
			sql="UPDATE hoteldetails SET htName=?,htAddress=?,htTypeId=?,htPictrue=?,htIntro=?,htPhone=?"
					+ " WHERE htId=?";
			DMlist.add(hotelDetails.getHtName());
			DMlist.add(hotelDetails.getHtAddress());
			DMlist.add(hotelDetails.getHtTypeId());
			DMlist.add(hotelDetails.getHtPictrue());
			DMlist.add(hotelDetails.getHtIntro());
			DMlist.add(hotelDetails.getHtPhone());
			DMlist.add(hotelDetails.getHtId());
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
	public List<HotelDetails> findAllHotelDetails() {
		DMlist.clear();
		List<HotelDetails> allHotelDetails = new ArrayList<HotelDetails>();
		try {
			sql="SELECT htId,htName,htAddress,htTypeId,htPictrue,htIntro,htPhone FROM hoteldetails";
			this.rs=this.executeQuery(sql, null);
			HotelDetails htDetails = null;
			while(this.rs.next()){
				htDetails = new HotelDetails();
				htDetails.setHtId(rs.getInt(1));
				htDetails.setHtName(rs.getString(2));
				htDetails.setHtAddress(rs.getString(3));
				htDetails.setHtTypeId(rs.getInt(4));
				htDetails.setHtPictrue(rs.getString(5));
				htDetails.setHtIntro(rs.getString(6));
				htDetails.setHtPhone(rs.getString(7));
				allHotelDetails.add(htDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return allHotelDetails;
	}

	//查找一条记录，根据编号
	@Override
	public HotelDetails findHotelDetailsById(int htId) {
		DMlist.clear();
		HotelDetails hDetails = null;
		try {
			sql="SELECT htId,htName,htAddress,htTypeId,htPictrue,htIntro,htPhone "
					+ "FROM hoteldetails WHERE  htId=? ";
			DMlist.add(htId);
			this.rs=this.executeQuery(sql, DMlist);
			if(this.rs.next()){
				hDetails = new HotelDetails();
				hDetails.setHtId(rs.getInt(1));
				hDetails.setHtName(rs.getString(2));
				hDetails.setHtAddress(rs.getString(3));
				hDetails.setHtTypeId(rs.getInt(4));
				hDetails.setHtPictrue(rs.getString(5));
				hDetails.setHtIntro(rs.getString(6));
				hDetails.setHtPhone(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return hDetails;
	}

	//模糊查找，根据酒店类型或酒店名
	@Override
	public List<HotelDetails> findHotelDetailsByTypeOrName(int htTypeId,
			String htName) {
		DMlist.clear();
		List<HotelDetails> hDetailsList = new ArrayList<HotelDetails>();
		try {
			sql="SELECT htId,htName,htAddress,htTypeId,htPictrue,htIntro,htPhone FROM hoteldetails WHERE 1=1";
			if(htTypeId>0  ){
				sql += " AND htTypeId="+htTypeId;
			}
			if(htName!=null && !htName.equals("")){
				sql += " AND htName like  '%"+htName+"%'";
			}
			this.rs=this.executeQuery(sql, null);
			HotelDetails hdetails = null;
			while(this.rs.next()){
				hdetails = new HotelDetails();
				hdetails.setHtId(rs.getInt(1));
				hdetails.setHtName(rs.getString(2));
				hdetails.setHtAddress(rs.getString(3));
				hdetails.setHtTypeId(rs.getInt(4));
				hdetails.setHtPictrue(rs.getString(5));
				hdetails.setHtIntro(rs.getString(6));
				hdetails.setHtPhone(rs.getString(7));
				hDetailsList.add(hdetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return hDetailsList;
	}
	
	/**
	 * 查询酒店信息总数量
	 */
	@Override
	public int findHotelDetailsCount() {
		int rel=0;
		sql="select count(0) from hoteldetails";
		try {
			rs=this.executeQuery(sql,null);
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
	/**
	 * 分页查询
	 */
	@Override
	public List<HotelDetails> findHotelDetailsPaging(int pageIndex, int pageSize) {
		List<HotelDetails> hotelList=new ArrayList<HotelDetails>();
		sql="select * from hoteldetails LIMIT ?,?";
		List<Object> psList=new ArrayList<Object>();
		psList.add((pageIndex-1)*pageSize);
		psList.add(pageSize);
		try {
			HotelDetails hotel=null;
			rs=this.executeQuery(sql, psList);
			while(rs.next()){
				hotel=new HotelDetails();
				hotel.setHtAddress(rs.getString("htAddress"));
				hotel.setHtId(rs.getInt("htId"));
				hotel.setHtIntro(rs.getString("htIntro"));
				hotel.setHtName(rs.getString("htName"));
				hotel.setHtPhone(rs.getString("htPhone"));
				hotel.setHtPictrue(rs.getString("htPictrue"));
				hotel.setHtTypeId(rs.getInt("htTypeId"));
				hotelList.add(hotel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return hotelList;
	}
	
	/**
	 * 过滤显示酒店信息
	 */
	@Override
	public List<HotelDetails> showHotelDetailsPCCT(String City, String countyName,int Type,int pageIndex,int pageSize) {
		List<HotelDetails> hdList=new ArrayList<HotelDetails>();
		sql=" select * from hoteldetails where 1=1 ";
		if(City!=null && !City.equals("")){
			if(countyName!=null && !countyName.equals("")){
				sql+="  and htAddress like '%"+City+"%"+countyName+"%'";
			}
			else{
				sql+=" and htAddress like '%"+City+"%'";
			}
		}
		if(Type>0){
			sql+=" and htTypeId="+Type+"";
		}
		sql+=" LIMIT ?,? ";
		List<Object> psList=new ArrayList<Object>();
		psList.add((pageIndex-1)*pageSize);
		psList.add(pageSize);
		try {
			rs=this.executeQuery(sql,psList);
			HotelDetails hd=null;
			while(rs.next()){
				hd=new HotelDetails();
				hd.setHtAddress(rs.getString("htAddress"));
				hd.setHtId(rs.getInt("htId"));
				hd.setHtIntro(rs.getString("htIntro"));
				hd.setHtName(rs.getString("htName"));
				hd.setHtPhone(rs.getString("htPhone"));
				hd.setHtPictrue(rs.getString("htPictrue"));
				hd.setHtTypeId(rs.getInt("htTypeId"));
				hdList.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return hdList;
	}
	/**
	 * 过滤显示酒店总量
	 */
	@Override
	public int findHotelDetailsCountFive(String City,String countyName, int Type) {
		int rel=-1;
		sql="select count(0) from hoteldetails where 1=1";
		if(City!=null &&!City.equals("")){
			if(countyName!=null && !countyName.equals("")){
				sql+="  and htAddress like '%"+City+"%"+countyName+"%'";
			}else{
				sql+="  and htAddress like '%"+City+"%'";
			}	
		}
		if(Type>0){
			sql+=" AND htTypeId="+Type+"";
		}
		try {
			rs=this.executeQuery(sql,null);
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

}
