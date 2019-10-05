package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.CouponDao;
import com.BDNM.entity.Coupon;
/**
 * �Ż�ȯ��--���ݲ���ʵ����
 * @author ����
 *
 */
public class CouponDaoImpl extends BaseDao implements CouponDao{
	//����Ż�ȯ��Ϣ
	@Override
	public int addCoupon(Coupon coupon) {
		int rel=-1;
		String sql="INSERT INTO coupon (comId,nominal,userId ) VALUES(?,?,?);";
		List<Object> psList=new ArrayList<Object>();
		psList.add(coupon.getComId());
		psList.add(coupon.getNominal());
		psList.add(coupon.getUserId());
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
	//����idɾ���Ż�ȯ��Ϣ
	@Override
	public int delCouponById(int couponId) {
		int rel=-1;
		String sql="DELETE FROM coupon WHERE couponId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(couponId);
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
	//�޸��Ż�ȯ��Ϣ
	@Override
	public int updateCoupon(Coupon coupon) {
		int rel=-1;
		String sql="UPDATE coupon SET comId=?,nominal=?,userId=? WHERE couponId=?;";
		List<Object> psList=new ArrayList<Object>();
		psList.add(coupon.getComId());
		psList.add(coupon.getNominal());
		psList.add(coupon.getUserId());
		psList.add(coupon.getCouponId());
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
	//�������е��Ż�ȯ��Ϣ
	@Override
	public List<Coupon> findAllCoupon() {
		Coupon coupon=null;
		List<Coupon> couponList=new ArrayList<Coupon>();
		String sql="SELECT couponId,comId,nominal,userId FROM coupon;";
		try {
			rs=this.executeQuery(sql, null);
			coupon=new Coupon();
			while(rs.next()){
				coupon.setCouponId(rs.getInt("couponId"));
				coupon.setComId(rs.getInt("comId"));
				coupon.setNominal(rs.getDouble("nominal"));
				coupon.setUserId(rs.getInt("userId"));
				couponList.add(coupon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return couponList;
	}
	//����  �û�����Ʒ����  �����Ż�ȯ
	@Override
	public List<Coupon> findCouponByUserIdOrComId(int userId, int comId) {
		List<Coupon> couponList=new ArrayList<Coupon>();
		List<Object> psList=new ArrayList<Object>();
		String sql="SELECT couponId,comId,nominal,userId FROM coupon WHERE 1=? ";
		psList.add(1);
		if(comId>0){
			sql += " AND comId=?";
			psList.add(comId);
		}
		if(userId>0){
			sql += " AND userId=?";
			psList.add(userId);
		}
		try {
			rs=this.executeQuery(sql, psList);
			Coupon coupon=null;
			while(rs.next()){
				coupon=new Coupon();
				coupon.setComId(rs.getInt("comId"));
				coupon.setUserId(rs.getInt("userId"));
				couponList.add(coupon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return couponList;
	}
	//ͳ���û��Ż�ȯ�������ݴ�����ֵ
	@Override
	public int findCouponCount(int userId, int comId) {
		int rel=0;
		List<Object> psList=new ArrayList<Object>();
		String sql="SELECT COUNT(0) FROM coupon WHERE 1=?";
		psList.add(1);
		if(comId>0){
			sql += " AND comId=?";
			psList.add(comId);
		}
		if(userId>0){
			sql += " AND userId=?";
			psList.add(userId);
		}
		try {
			rs=this.executeQuery(sql, psList);
			Coupon coupon=null;
			while(rs.next()){
				coupon=new Coupon();
				rel=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return rel;
	}
	
	public int findCouponNominal(int userId, int comId){
		int nominal = 0;
		List<Object> psList=new ArrayList<Object>();
		try {
			String sql="SELECT nominal FROM coupon WHERE userId=? AND comId=?";
			psList.add(userId);
			psList.add(comId);
			rs=executeQuery(sql, psList);
			if(rs.next()){
				nominal=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return nominal;
	}

}
