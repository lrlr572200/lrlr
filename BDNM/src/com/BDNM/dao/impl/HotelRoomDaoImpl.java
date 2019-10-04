package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.HotelRoomDao;
import com.BDNM.entity.HotelRoom;

/**
 * 5.酒店房间信息表--数据操作实现类
 * @author 凯凯
 *
 */
public class HotelRoomDaoImpl extends BaseDao implements HotelRoomDao{

	//添加酒店房间信息
	@Override
	public int addHotelRoom(HotelRoom hotelRoom) {
		int rel=-1;
		String sql="INSERT INTO hotelroom (rmTypeId, rmTypePrice,rmTypeCount,rmTypeSruplus,htId,rmTypePictrue,rmTypeIntro) VALUES(?,?,?,?,?,?,?);";
		List<Object> psList=new ArrayList<Object>();
		psList.add(hotelRoom.getRmTypeId());
		psList.add(hotelRoom.getRmTypePrice());
		psList.add(hotelRoom.getRmTypeCount());
		psList.add(hotelRoom.getRmTypeSruplus());
		psList.add(hotelRoom.getHtId());
		psList.add(hotelRoom.getRmTypePictrue());
		psList.add(hotelRoom.getRmTypeIntro());
		try {
			rel=executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	//根据id删除一条酒店房间信息
	@Override
	public int delHotelRoomByRmTypeIdAndHtId(int rmTypeId, int htId) {
		int rel=-1;
		String sql="DELETE FROM hotelroom WHERE rmTypeId=? AND htId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(rmTypeId);
		psList.add(htId);
		try {
			rel=executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	//修改酒店房间信息
	@Override
	public int updateHotelRoom(HotelRoom hotelRoom) {
		int rel=-1;
		String sql="UPDATE hotelroom SET rmTypePrice=?,rmTypeCount=?,rmTypeSruplus=?,htId=?,rmTypePictrue=?,rmTypeIntro=? WHERE rmTypeId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(hotelRoom.getRmTypePrice());
		psList.add(hotelRoom.getRmTypeCount());
		psList.add(hotelRoom.getRmTypeSruplus());
		psList.add(hotelRoom.getHtId());
		psList.add(hotelRoom.getRmTypePictrue());
		psList.add(hotelRoom.getRmTypeIntro());
		psList.add(hotelRoom.getRmTypeId());
		try {
			rel=executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	//根据id查询酒度房间信息
	@Override
	public HotelRoom findByRmTypeIdAndHtId(int rmTypeId, int htId) {
		HotelRoom hotelRoom=null;
		String sql="SELECT rmTypeId, rmTypePrice,rmTypeCount,rmTypeSruplus,htId,rmTypePictrue,rmTypeIntro FROM hotelroom WHERE rmTypeId=? AND htId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(rmTypeId);
		psList.add(htId);
		try {
			rs=this.executeQuery(sql, psList);
			if(rs.next()){
				hotelRoom=new HotelRoom();
				hotelRoom.setRmTypeId(rs.getInt("rmTypeId"));
				hotelRoom.setRmTypePrice(rs.getDouble("rmTypePrice"));
				hotelRoom.setRmTypeCount(rs.getInt("rmTypeCount"));
				hotelRoom.setRmTypeSruplus(rs.getInt("rmTypeSruplus"));
				hotelRoom.setHtId(rs.getInt("htId"));
				hotelRoom.setRmTypePictrue(rs.getString("rmTypePictrue"));
				hotelRoom.setRmTypeIntro(rs.getString("rmTypeIntro"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return hotelRoom;
	}
	
	//根据酒店id查询酒度房间信息
		@Override
		public List<HotelRoom>  findByHtId( int htId) {
			HotelRoom hotelRoom=null;
			String sql="SELECT rmTypeId, rmTypePrice,rmTypeCount,rmTypeSruplus,htId,rmTypePictrue,rmTypeIntro FROM hotelroom WHERE  htId=?;";
			List<Object> psList=new ArrayList<Object>();
			List<HotelRoom> htList = new ArrayList<HotelRoom>();
			psList.add(htId);
			try {
				rs=this.executeQuery(sql, psList);
				while(rs.next()){
					hotelRoom=new HotelRoom();
					hotelRoom.setRmTypeId(rs.getInt("rmTypeId"));
					hotelRoom.setRmTypePrice(rs.getDouble("rmTypePrice"));
					hotelRoom.setRmTypeCount(rs.getInt("rmTypeCount"));
					hotelRoom.setRmTypeSruplus(rs.getInt("rmTypeSruplus"));
					hotelRoom.setHtId(rs.getInt("htId"));
					hotelRoom.setRmTypePictrue(rs.getString("rmTypePictrue"));
					hotelRoom.setRmTypeIntro(rs.getString("rmTypeIntro"));
					htList.add(hotelRoom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll();
			}
			return htList;
		}
		
		/**
		 * 查询酒店的各种房间价位和
		 * 通过总价除以最大入住人数求人均消费
		 */
		@Override
		public double findAvgPriceByHtId(int htId) {
			double rel=0;
			String sql="select sum(rmTypePrice) from hotelroom where htId=?";
			List<Object> psList=new ArrayList<Object>();
			psList.add(htId);
			try {
				rs=this.executeQuery(sql, psList);
				if(rs.next()){
					rel=rs.getDouble(1);
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
		
		//修改酒店房间剩余数量的方法
		public int updRmTypeSruplus(int rmTypeSruplus,int rmTypeId, int htId){
			int rel=-1;
			String sql="UPDATE `hotelroom` SET rmTypeSruplus=? WHERE rmTypeId=? AND htId=? ";
			List<Object> psList=new ArrayList<Object>();
			psList.add(rmTypeSruplus);
			psList.add(rmTypeId);
			psList.add(htId);
			try {
				rel=executeUpdate(sql, psList);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll();
			}
			return rel;
		}
		
		/**
		 * 查询某酒店某房间类型的总数量
		 */
		@Override
		public int findRoomTypeCountByhtIdAndRmTypeId(int htId, int rmTypeId) {
			int rel=-1;
			String sql="select rmTypeCount from hotelroom where htId=? and rmTypeId=?";
			List<Object> psList=new ArrayList<Object>();
			psList.add(htId);
			psList.add(rmTypeId);	
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
		/**
		 * 查询某酒店某种房间的订购数量
		 */
		@Override
		public String findSumByHtIdAndRmTypeId(int htId, int rmTypeId) {
			String rel=null;
			String sql="select sum(num) from `order` a join orderdetails b on a.orderNum=b.orderNum where "
					+ "rmTypeId=? and htId=?";
			List<Object> psList=new ArrayList<Object>();
			psList.add(rmTypeId);
			psList.add(htId);
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
