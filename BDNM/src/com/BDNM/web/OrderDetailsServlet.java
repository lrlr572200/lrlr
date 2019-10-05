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
		
		
		
		//����ĳ���û���ĳ�������Ķ�������
		if(orderDetailsSign.equals("showOrdDet")){
			this.showOrdDet(request, out);
			return;
		}
		
		//��Ӷ�������ķ���
		if(orderDetailsSign.equals("addDetails")){
			addDetails(request, response, out);
			return;
		}
		
	}
	
	
	//��Ӷ�������ķ���
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
			out.print("<script>alert('����');location.href='front/pay.jsp';</script>");
			return;
		}
		int step = Integer.parseInt(stp);
		if(step>3){ 
			ordDetailServlet.delOrderDetailsByOrderNum(orderNum);
			out.print("<script>alert('����');location.href='front/pay.jsp';</script>");
			return;
		}else{
			if(step==1){
				out.print("<script>location.href='front/personalCenter.jsp'</script>");
			}else if(step==2){
				//�޸ķ���ʣ������
				HotelRoomService htsel = new HotelRoomServiceImpl();
				int rmTypeId = ordedet.getRmTypeId();
				int htId = ordc.getHtId();
				int rmSruplus = htsel.findByRmTypeIdAndHtId(rmTypeId, htId).getRmTypeSruplus();
				OrderService orderSer = new OrderServiceImpl();
				System.out.println("ԭ��ʣ��:"+rmSruplus);
				int nowNum = ordedet.getNum();
				int rmTypeSruplus = rmSruplus-nowNum;
				System.out.println("��������"+rmTypeSruplus);
				if(rmSruplus<=0 || rmTypeSruplus<=0){
					//ɾ�����ж���
					ordDetailServlet.delOrderDetailsByOrderNum(orderNum);
					orderSer.delOrderByOrderNum(orderNum);
					//�û�����޸�
					UserService userSer = new UserServiceImpl();
					User user = userSer.findUserById(ordc.getUserId());  //�û����
					double bal = user.getBalance()+ ordc.getPayment();
					int ordStep = userSer.updUserBalanceById(bal, ordc.getUserId());
					System.out.println("�޸����ع��Ƿ�ɹ���"+ordStep);
					out.print("<script>alert('����ȯʣ��"+rmSruplus+"�ţ���������');location.href='front/pay.jsp';</script>");
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
	
	
	//����ĳ���û���ĳ�������Ķ�������
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
	
	//ɾ��ͬһ����ŵĶ�������ķ���
		public int delOrderDetailsByOrderId(String orderId){
			int cot = ordDetailServlet.delOrderDetailsByOrderNum(orderId);
			return cot;
		}
}
