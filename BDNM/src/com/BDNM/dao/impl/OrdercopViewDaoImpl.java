package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.OrdercopViewDao;
import com.BDNM.entity.OrdercopView;

public class OrdercopViewDaoImpl extends BaseDao implements OrdercopViewDao {

	
	//·ÖÒ³+Ë÷Òý²éÕÒ
	@Override
	public List<OrdercopView> findOrdercopViewPaging(int pageIndex,
			int pageSize, int userId, String state) {
		List<OrdercopView> ordViewList = new ArrayList<OrdercopView>();
		List<Object> psList=new ArrayList<Object>();
		try {
			String sql = "SELECT  * "
					+ " FROM ordercop WHERE 1=1 ";
			if(userId!=0){
				sql += " AND `userId`="+userId;
			}
			if(state==null || state.equals("null") ){
				
			}else{
				sql += " AND state='"+state+"'" ;
			}
			sql += "  LIMIT ?,?";
			
			psList.add((pageIndex-1)*pageSize);
			psList.add(pageSize);
			rs=this.executeQuery(sql, psList);
			OrdercopView ordView = null;
			while(this.rs.next()){
				ordView = new OrdercopView();
				ordView.setOrderNum(rs.getString("orderNum"));
				ordView.setUserId(rs.getInt("userId"));
				ordView.setUserName(rs.getString("userName"));
				ordView.setComid(rs.getInt("comid"));
				ordView.setComName(rs.getString("comName"));
				ordView.setHtId(rs.getInt("htId"));
				ordView.setHtname(rs.getString("htname"));
				ordView.setOrdMoney(rs.getDouble("ordMoney"));
				ordView.setPayment(rs.getDouble("payment"));
				ordView.setState(rs.getString("state"));
				ordView.setCheckTime(rs.getTimestamp("checkTime"));
				ordView.setLeaveTime(rs.getTimestamp("leaveTime"));
				ordView.setSubtime(rs.getTimestamp("subtime"));
				ordView.setHtPictrue(rs.getString("htPictrue"));
				ordView.setCount(rs.getInt("count"));
				ordViewList.add(ordView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return ordViewList;
	}

	@Override
	public OrdercopView findOrdercopViewById(String orderNum) {
		List<Object> psList=new ArrayList<Object>();
		OrdercopView ordView = null;
		try {
			String sql = "SELECT  * FROM ordercop WHERE orderNum=? ";
			psList.add(orderNum);
			rs=this.executeQuery(sql, psList);
			while(this.rs.next()){
				ordView = new OrdercopView();
				ordView.setOrderNum(rs.getString("orderNum"));
				ordView.setUserId(rs.getInt("userId"));
				ordView.setUserName(rs.getString("userName"));
				ordView.setComid(rs.getInt("comid"));
				ordView.setComName(rs.getString("comName"));
				ordView.setHtId(rs.getInt("htId"));
				ordView.setHtname(rs.getString("htname"));
				ordView.setOrdMoney(rs.getDouble("ordMoney"));
				ordView.setPayment(rs.getDouble("payment"));
				ordView.setState(rs.getString("state"));
				ordView.setCheckTime(rs.getTimestamp("checkTime"));
				ordView.setLeaveTime(rs.getTimestamp("leaveTime"));
				ordView.setSubtime(rs.getTimestamp("subtime"));
				ordView.setHtPictrue(rs.getString("htPictrue"));
				ordView.setCount(rs.getInt("count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return ordView;
	}

}
