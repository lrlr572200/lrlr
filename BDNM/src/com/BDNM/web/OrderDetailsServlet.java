package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BDNM.entity.HotelRoom;
import com.BDNM.entity.OrderDetails;
import com.BDNM.entity.User;
import com.BDNM.service.HotelRoomService;
import com.BDNM.service.OrderDetailsService;
import com.BDNM.service.OrderService;
import com.BDNM.service.UserService;
import com.BDNM.service.impl.HotelRoomServiceImpl;
import com.BDNM.service.impl.OrderDetailsServiceImpl;
import com.BDNM.service.impl.OrderServiceImpl;
import com.BDNM.service.impl.UserServiceImpl;
import com.BDNM.utils.OrderDetailsCopy;
import com.BDNM.utils.StaticUtils;
import com.BDNM.utils.orderCopy;
import com.alibaba.fastjson.JSON;

public class OrderDetailsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderDetailsServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}



	OrderDetailsService ordDetailServlet = new OrderDetailsServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		String orderDetailsSign  = request.getParameter("ordDetSign");
		
		
		
		//查找某个用户的某个订单的订单详情
		if(orderDetailsSign.equals("showOrdDet")){
			this.showOrdDet(request, out);
			return;
		}
		
		//添加订单详情的方法
		if(orderDetailsSign.equals("addDetails")){
			addDetails(request, response, out);
			return;
		}
		
	}
	
	
	//添加订单详情的方法
	public void addDetails(HttpServletRequest request, HttpServletResponse response,PrintWriter out){
		String orderNum = request.getParameter("orderNum");
		HttpSession session = request.getSession();
		orderCopy ordc = (orderCopy)session.getAttribute("ordc");
		OrderDetails ordedet = new OrderDetails();
		ordedet.setOrderNum(orderNum);
		ordedet.setRmTypeId(ordc.getRmTypeId());
		ordedet.setUnit(ordc.getRmTypePrice());
		ordedet.setNum(ordc.getNum());
		ordedet.setNominal(ordc.getNominal());
		int ods = ordDetailServlet.addOrderDetails(ordedet);
		String stp = request.getParameter("step");
		if(stp==null || stp.equals("")){
			ordDetailServlet.delOrderDetailsByOrderNum(orderNum);
			out.print("<script>alert('错误');location.href='front/pay.jsp';</script>");
			return;
		}
		int step = Integer.parseInt(stp);
		if(step>3){ 
			ordDetailServlet.delOrderDetailsByOrderNum(orderNum);
			out.print("<script>alert('错误');location.href='front/pay.jsp';</script>");
			return;
		}else{
			if(step==1){
				out.print("<script>location.href='front/personalCenter.jsp'</script>");
			}else if(step==2){
				//修改房间剩余数量
				HotelRoomService htsel = new HotelRoomServiceImpl();
				int rmTypeId = ordedet.getRmTypeId();
				int htId = ordc.getHtId();
				int rmSruplus = htsel.findByRmTypeIdAndHtId(rmTypeId, htId).getRmTypeSruplus();
				OrderService orderSer = new OrderServiceImpl();
				System.out.println("原来剩余:"+rmSruplus);
				int nowNum = ordedet.getNum();
				int rmTypeSruplus = rmSruplus-nowNum;
				System.out.println("现在数量"+rmTypeSruplus);
				if(rmSruplus<=0 || rmTypeSruplus<=0){
					//删除所有订单
					ordDetailServlet.delOrderDetailsByOrderNum(orderNum);
					orderSer.delOrderByOrderNum(orderNum);
					//用户金额修改
					UserService userSer = new UserServiceImpl();
					User user = userSer.findUserById(ordc.getUserId());  //用户金额
					double bal = user.getBalance()+ ordc.getPayment();
					int ordStep = userSer.updUserBalanceById(bal, ordc.getUserId());
					System.out.println("修改余额回滚是否成功："+ordStep);
					out.print("<script>alert('代金券剩余"+rmSruplus+"张，数量不足');location.href='front/pay.jsp';</script>");
					return;
				}
				int htrmStep = htsel.updRmTypeSruplus(rmTypeSruplus, rmTypeId, htId);
				System.out.println(htrmStep);
				out.print("<script>location.href='front/pay.jsp'</script>");
			}else if(step==3){
				out.print("<script>location.href='front/pay.jsp'</script>");
			}
		}
	}
	
	
	//查找某个用户的某个订单的订单详情
	public void showOrdDet(HttpServletRequest request,PrintWriter out){
		String orderNum = request.getParameter("orderNum");
		List<OrderDetails> ordDetList = ordDetailServlet.findOrderDetailsById(orderNum);
		
		if(ordDetList!=null){
			
			RoomTypeServlet rts = new RoomTypeServlet();
			List<OrderDetailsCopy> odList = new ArrayList<OrderDetailsCopy>();
			int sizeO = ordDetList.size()-1;
			double moneyCot = 0;
			OrderDetailsCopy odc = null;
			int a = 0;
			for(OrderDetails od : ordDetList){
				odc = new OrderDetailsCopy();
				odc.setOrderNum(od.getOrderNum());
				odc.setRmTypeName(rts.findRoomTypeName(od.getRmTypeId()) );
				odc.setRmTypePrice(od.getUnit());
				odc.setNum(od.getNum());
				odc.setMoney(odc.getRmTypePrice()*odc.getNum());
				moneyCot += odc.getMoney();
				if(a==sizeO){
					moneyCot =moneyCot-od.getNominal();
				}
				odc.setMoneyCot(moneyCot);
				odList.add(odc);
				a++;
			}
			String json = JSON.toJSONStringWithDateFormat(odList, "yyyy-MM-dd HH:mm:ss");
			out.print(json);
			out.close();
			out.flush();
		}
	}
	
	//删除同一个编号的订单详情的方法
		public int delOrderDetailsByOrderId(String orderId){
			int cot = ordDetailServlet.delOrderDetailsByOrderNum(orderId);
			return cot;
		}
}
