package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.OrderDao;
import com.BDNM.entity.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
	
	/**
	 * 添加订单
	 */
	@Override
	public int addOrder(Order order) {
		int rel=-1;
		String sql="INSERT INTO `order`(orderNum,userId,comId,htId,ordMoney,payment,state,checkTime,leaveTime,subTime) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		List<Object> psList=new ArrayList<Object>();
		psList.add(order.getOrderNum());
		psList.add(order.getUserId());
		psList.add(order.getComId());
		psList.add(order.getHtId());
		psList.add(order.getOrdMoney());
		psList.add(order.getPayment());
		psList.add(order.getState());
		psList.add(order.getCheckTime());
		psList.add(order.getLeaveTime());
		psList.add(order.getSubTime());
		try {
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	/**
	 * 删除订单
	 */
	@Override
	public int delOrderByOrderNum(String orderNum) {
		int rel=-1;
		String sql="delete from `order` where orderNum=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(orderNum);
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
	/**
	 * 修改订单
	 */
	@Override
	public int updateOrderByOrderNum(Order order) {
		int rel=-1;
		String sql="UPDATE `order` set userId=?,comId=?,htId=?,ordMoney=?,payment=?,state=?,"
				+ "checkTime=?,leaveTime=?,subTime=? where orderNum=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(order.getUserId());
		psList.add(order.getComId());
		psList.add(order.getHtId());
		psList.add(order.getOrdMoney());
		psList.add(order.getPayment());
		psList.add(order.getState());
		psList.add(order.getCheckTime());
		psList.add(order.getLeaveTime());
		psList.add(order.getSubTime());
		psList.add(order.getOrderNum());
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
	/**
	 * 查询订单
	 */
	@Override
	public List<Order> findAllOrder() {
		List<Order> orderList=new ArrayList<Order>();
		String sql="select * from `Order`";
		try {
			rs=this.executeQuery(sql,null);
			Order order=null;
			while(rs.next()){
				order=new Order();
				order.setCheckTime(rs.getTimestamp( "CheckTime"));
				order.setComId(rs.getInt("comId"));
				order.setHtId(rs.getInt("htId"));
				order.setLeaveTime(rs.getTimestamp( "leaveTime"));
				order.setOrderNum(rs.getString("orderNum"));
				order.setOrdMoney(rs.getDouble("ordMoney"));
				order.setPayment(rs.getDouble("payment"));
				order.setState(rs.getString("state"));
				order.setSubTime(rs.getTimestamp( "subTime"));
				order.setUserId(rs.getInt("userId"));
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return orderList;
	}
	/**
	 * 分页查询订单
	 */
	@Override
	public List<Order> findAllOrderPaging(int pageIndex, int pageSize,int userId,String state) {
		List<Order> orderList=new ArrayList<Order>();
		String sql="select * from `order` WHERE userId=? ";
		if(state!=null && !state.equals("")){
			sql += "AND state='"+state+"' ";
		}
		sql += " LIMIT ?,? ";
		List<Object> psList=new ArrayList<Object>();
		psList.add(userId);
		psList.add((pageIndex-1)*pageSize);
		psList.add(pageSize);
		try {
			rs=this.executeQuery(sql, psList);
			Order order=null;
			while(rs.next()){
				order=new Order();
				order.setCheckTime(rs.getTimestamp("checkTime"));
				order.setComId(rs.getInt("comId"));
				order.setHtId(rs.getInt("htId"));
				order.setLeaveTime(rs.getTimestamp("leaveTime"));
				order.setOrderNum(rs.getString("orderNum"));
				order.setOrdMoney(rs.getDouble("ordMoney"));
				order.setPayment(rs.getDouble("payment"));
				order.setState(rs.getString("state"));
				order.setSubTime(rs.getTimestamp("subTime"));
				order.setUserId(rs.getInt("userId"));
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return orderList;
	}
	/**
	 * 查询订单总数量
	 */
	@Override
	public int findOrderCount(int userId,String state) {
		int rel=0;
		List<Object> psList=new ArrayList<Object>();
		String sql="SELECT COUNT(1) FROM `order` WHERE userId=? ";
		if( !"null".equals(state) && state!=null  && !state.equals("")){
			sql += "  AND state='"+state+"'";
		}
		psList.add(userId);
		try {
			rs=this.executeQuery(sql,psList);
			if(rs.next()){
				rel=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	
	//查找订单中为当前入住状态的
	public List<Integer> findNowOrder(int htId){
		List<Integer> num = new ArrayList<Integer>();
		List<Object> psList=new ArrayList<Object>();
		try {
			String sql = "SELECT orderNum FROM `order` WHERE htId=? AND  checkTime<NOW() AND leaveTime>NOW()";
			psList.add(htId);
			int id = 0;
			rs=this.executeQuery(sql, psList);
			while(rs.next()){
				id=rs.getInt(1);
				num.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return num;
	}
	
	//查找一个订单
	public Order findOrderByOrderNum(String orderNum){
		Order order = null;
		List<Object> psList=new ArrayList<Object>();
		try {
			String sql="select * from `order` WHERE orderNum=? ";
			psList.add(orderNum);
			rs=this.executeQuery(sql, psList);
			if(rs.next()){
				order=new Order();
				order.setCheckTime(rs.getTimestamp("checkTime"));
				order.setComId(rs.getInt("comId"));
				order.setHtId(rs.getInt("htId"));
				order.setLeaveTime(rs.getTimestamp("leaveTime"));
				order.setOrderNum(rs.getString("orderNum"));
				order.setOrdMoney(rs.getDouble("ordMoney"));
				order.setPayment(rs.getDouble("payment"));
				order.setState(rs.getString("state"));
				order.setSubTime(rs.getTimestamp("subTime"));
				order.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return order;
		
	}
	
}
