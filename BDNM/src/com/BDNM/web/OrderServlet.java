package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import com.BDNM.entity.Order;
import com.BDNM.entity.OrderDetails;
import com.BDNM.entity.OrdercopView;
import com.BDNM.entity.User;
import com.BDNM.service.HotelRoomService;
import com.BDNM.service.OrderDetailsService;
import com.BDNM.service.OrderService;
import com.BDNM.service.OrdercopViewService;
import com.BDNM.service.UserService;
import com.BDNM.service.impl.HotelRoomServiceImpl;
import com.BDNM.service.impl.OrderDetailsServiceImpl;
import com.BDNM.service.impl.OrderServiceImpl;
import com.BDNM.service.impl.OrdercopViewServiceImpl;
import com.BDNM.service.impl.UserServiceImpl;
import com.BDNM.utils.PageSurport;
import com.BDNM.utils.StaticUtils;
import com.BDNM.utils.orderCopy;
import com.alibaba.fastjson.JSON;

/**
 * 订单表数据操作层
 */
public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	private OrdercopViewService orderView = new OrdercopViewServiceImpl();
	private OrderService order = new OrderServiceImpl();
	private PageSurport<OrdercopView> ordPage = new PageSurport<OrdercopView>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String orderSign = req.getParameter("orderSign");
		//分页显示订单
		if(orderSign.equals("orderShow")){
			this.ordShow(req, out);
			return;
		}
		//查找一个订单
		if(orderSign.equals("theOrder")){
			this.theOrder(req,out);
			return;
		}
		
		//删除一条订单
		if("delOrder".equals(orderSign)){
			this.delOrder(req,out);
			return;
		}
		
		//添加订单的方法
		if("addOrder".equals(orderSign)){
			this.addOrder(req, resp,out);
			return;
		}
		
		
	}
	
	
	//添加订单的方法
	public void addOrder(HttpServletRequest req, HttpServletResponse resp,PrintWriter out){
	
		String tape = req.getParameter("tape");
		int ind = 0;
		if(tape==null || tape.equals("")){
			out.print("<script>alert('错误!');location.href='front/pay.jsp';</script>");
		}else{
			ind=Integer.parseInt(tape);
		}
		HttpSession session = req.getSession();
		orderCopy ordc = (orderCopy)session.getAttribute("ordc");
		Date chetim = null;
		String str = "待付款";
		double payment = 0;
		if(ind==2){
			str="已付款";
			chetim = new Date();
			payment = ordc.getMoney();
		}
		Random random = new Random();
		int num = random.nextInt(9002)+999;
		Date date = new Date();
		SimpleDateFormat dat = new SimpleDateFormat("yyyyMMddHHmmss");
		String ordID =dat.format(date)+num;
		Order orders = new Order();
		orders.setOrderNum(ordID);
		orders.setUserId(ordc.getUserId());
		orders.setComId(1);
		orders.setHtId(ordc.getHtId());
		orders.setPayment(payment);
		orders.setState(str);
		orders.setSubTime(new Date());
		orders.setCheckTime(chetim);
		orders.setOrdMoney(ordc.getMoney());
		int ins = order.addOrder(orders);
		if(ins<0){
			out.print("<script>alert('订单提交失败，请重新提交！');location.href='front/pay.jsp';</script>");
		}else{
			try {
				if(ind==2){
					//修改用户余额
					UserService userSer = new UserServiceImpl();
					User user = userSer.findUserById(ordc.getUserId());
					System.out.println("原金额："+user.getBalance());
					double bal = user.getBalance()- orders.getPayment();
					System.out.println("现在金额："+bal);
					/*if(user.getBalance()<=0 || bal<=0 ){
						order.delOrderByOrderNum(orders.getOrderNum());
						out.print("<script>alert('余额不足，请充值！');location.href='front/personalCenter.jsp';</script>");
						return;
					}*/
					int ordStep = userSer.updUserBalanceById(bal, ordc.getUserId());
					System.out.println("修改余额是否成功："+ordStep);
				}
					resp.sendRedirect("OrderDetailsServlet?ordDetSign=addDetails&orderNum="+orders.getOrderNum()+"&step="+ind );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//删除订单的方法
	public void delOrder(HttpServletRequest req,PrintWriter out){
		String orderNum = req.getParameter("orderNum");
		if(orderNum==null || "".equals(orderNum) ){
			orderNum="0";
		}
		System.out.println("订单编号"+orderNum);
		OrderDetailsServlet ods = new OrderDetailsServlet();
		int count = 0;
		int cot = ods.delOrderDetailsByOrderId(orderNum);
		System.out.println("是否删除订单详情："+cot);
		if(cot>=0){
			count = order.delOrderByOrderNum(orderNum);
		}
		System.out.println("订单是否删除"+count);
		System.out.println("+++++++++++++++++++++++=");
		String json = JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
	}
	
	//查找一个的方法
	public void theOrder(HttpServletRequest req,PrintWriter out){
		String orderId = req.getParameter("ordid");
		if(orderId==null || orderId.equals("")){
			orderId="0";
		}
		OrdercopView ovi = orderView.findOrdercopViewById(orderId);
		String json = JSON.toJSONStringWithDateFormat(ovi, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
		return;
	}
	
	//分页显示订单的方法
	public void ordShow(HttpServletRequest req,PrintWriter out){
		String userID = req.getParameter("userid");  //用户ID
		String indx = req.getParameter("index");    // 页索引
		String state = req.getParameter("state");  //订单状态
		if(state==null || "".equals(state)){
			state=null;
		}
		int userid = 0;
		if(userID==null || userID.equals("")){
			userid = 0;
		}else{
			userid = Integer.parseInt(userID);
		}
		int cot = order.findOrderCount(userid,state);
		ordPage.setTotalCount(cot);  //设置总记录数
		ordPage.setPageSize(4);  //设置页容量
		int pageCount = ordPage.getPageCount();
		int pageIndex = 1;
		if(indx==null || indx.equals("")){
			pageIndex = 1;
		}else{
			pageIndex = Integer.parseInt(indx);
			if(pageIndex<1){
				pageIndex = 1;
			}
			if(pageIndex>pageCount){
				pageIndex = pageCount;
			}
		}
		ordPage.setPageIndex(pageIndex); //设置页索引		
		int pagSize = ordPage.getPageSize();
		int pagIndex = ordPage.getPageIndex();
		List<OrdercopView> ordList = orderView.findOrdercopViewPaging(pagIndex, pagSize, userid, state);
		if(ordList ==null){
			return ;
		}
		
		ordPage.setDataList(ordList);
		System.out.println("index:"+ordPage.getPageIndex());
		System.out.println("count:"+ordPage.getPageCount());
		System.out.println("总量:"+ordPage.getTotalCount());
		System.out.println("状态："+state);
		System.out.println("数据量："+ordPage.getDataList().size());
		System.out.println("________________________________________");
		String json = JSON.toJSONStringWithDateFormat(ordPage, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
		return;
		
	}
	
}
