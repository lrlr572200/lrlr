package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.HotelRoomDao;
import com.BDNM.entity.HotelRoom;

/**
 * 5.�Ƶ귿����Ϣ��--���ݲ���ʵ����
 * @author ����
 *
 */
public class HotelRoomDaoImpl extends BaseDao implements HotelRoomDao{

	//��ӾƵ귿����Ϣ
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
	//����idɾ��һ���Ƶ귿����Ϣ
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
	//�޸ľƵ귿����Ϣ
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
	//����id��ѯ�ƶȷ�����Ϣ
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
	
	//���ݾƵ�id��ѯ�ƶȷ�����Ϣ
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
		 * ��ѯ�Ƶ�ĸ��ַ����λ��
		 * ͨ���ܼ۳��������ס�������˾�����
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
		
		//�޸ľƵ귿��ʣ�������ķ���
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
		 * ��ѯĳ�Ƶ�ĳ�������͵�������
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
		 * ��ѯĳ�Ƶ�ĳ�ַ���Ķ�������
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
