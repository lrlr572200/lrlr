package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.OrderDetailsDao;
import com.BDNM.entity.OrderDetails;

public class OrderDetailsDaoImpl extends BaseDao implements OrderDetailsDao {
	/**
	 * 添加订单详情
	 */
	@Override
	public int addOrderDetails(OrderDetails orderDetails) {
		int rel=-1;
		String sql="insert INTO OrderDetails(orderNum,rmTypeId,unit,num,nominal,phone) VALUES "
				+ "(?,?,?,?,?,?)";
		List<Object> psList=new ArrayList<Object>();
		psList.add(orderDetails.getOrderNum());
		psList.add(orderDetails.getRmTypeId());
		psList.add(orderDetails.getUnit());
		psList.add(orderDetails.getNum());
		psList.add(orderDetails.getNominal());
		psList.add(orderDetails.getPhone());
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
	 * 删除订单详情
	 */
	@Override
	public int delOrderDetailsByOrderNum(String orderNum) {
		int rel=-1;
		String sql="delete from OrderDetails where orderNum=? ";
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
	 * 修改订单详情
	 */
	@Override
	public int updateOrderDetails(OrderDetails orderDetails) {
		int rel=-1;
		String sql="UPDATE OrderDetails set orderNum=?,rmTypeId=?,unit=?,num=?,"
				+ "nominal=?,phone=? where detailsId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(orderDetails.getOrderNum());
		psList.add(orderDetails.getRmTypeId());
		psList.add(orderDetails.getUnit());
		psList.add(orderDetails.getNum());
		psList.add(orderDetails.getNominal());
		psList.add(orderDetails.getPhone());
		psList.add(orderDetails.getDetailsId());
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
	 * 查询全部订单详情
	 */
	@Override
	public List<OrderDetails> findAllOrderDetails() {
		List<OrderDetails> orderList=new ArrayList<OrderDetails>();
		String sql="select * from orderDetails";
		try {
			rs=this.executeQuery(sql,null);
			OrderDetails order=null;
			while(rs.next()){
				order=new OrderDetails();
				order.setDetailsId(rs.getInt("detailsId"));
				order.setNominal(rs.getInt("nominal"));
				order.setNum(rs.getInt("num"));
				order.setOrderNum(rs.getString("orderNum"));
				order.setPhone(rs.getString("phone"));
				order.setRmTypeId(rs.getInt("rmTypeId"));
				order.setUnit(rs.getDouble("unit"));
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
	 * 分页查询订单详情
	 */
	@Override
	public List<OrderDetails> findAllOrderDetailsPaging(int pageIndex,
			int pageSize) {
		List<OrderDetails> orderList=new ArrayList<OrderDetails>();
		String sql="select * from OrderDetails LIMIT ?,?";
		List<Object> psList=new ArrayList<Object>();
		psList.add((pageIndex-1)*pageSize);
		psList.add(pageSize);
		try {
			rs=this.executeQuery(sql, psList);
			OrderDetails order=null;
			while(rs.next()){
				order=new OrderDetails();
				order.setDetailsId(rs.getInt("detailsId"));
				order.setNominal(rs.getInt("nominal"));
				order.setNum(rs.getInt("num"));
				order.setOrderNum(rs.getString("orderNum"));
				order.setPhone(rs.getString("phone"));
				order.setRmTypeId(rs.getInt("rmTypeId"));
				order.setUnit(rs.getDouble("unit"));
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
	 * 根据订单编号查询详情总数量
	 */
	@Override
	public int findOrderDetailsCountByOrderNum(String orderNum) {
		int rel=0;
		String sql="select count(0) from OrderDetails where orderNum=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(orderNum);
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
	
	
	@Override
	public List<OrderDetails> findOrderDetailsById(String orderNum) {
		List<OrderDetails> ordDetList = new ArrayList<OrderDetails>();
		List<Object> psList=new ArrayList<Object>();
		try {
			String sql="select * from OrderDetails where orderNum=?";
			psList.add(orderNum);
			rs=this.executeQuery(sql, psList);
			OrderDetails order=null;
			while(rs.next()){
				order=new OrderDetails();
				order.setDetailsId(rs.getInt("detailsId"));
				order.setNominal(rs.getInt("nominal"));
				order.setNum(rs.getInt("num"));
				order.setOrderNum(rs.getString("orderNum"));
				order.setPhone(rs.getString("phone"));
				order.setRmTypeId(rs.getInt("rmTypeId"));
				order.setUnit(rs.getDouble("unit"));
				ordDetList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return ordDetList;
	}

}
