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
 * ���������ݲ�����
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
		//��ҳ��ʾ����
		if(orderSign.equals("orderShow")){
			this.ordShow(req, out);
			return;
		}
		//����һ������
		if(orderSign.equals("theOrder")){
			this.theOrder(req,out);
			return;
		}
		
		//ɾ��һ������
		if("delOrder".equals(orderSign)){
			this.delOrder(req,out);
			return;
		}
		
		//��Ӷ����ķ���
		if("addOrder".equals(orderSign)){
			this.addOrder(req, resp,out);
			return;
		}
		
		
	}
	
	
	//��Ӷ����ķ���
	public void addOrder(HttpServletRequest req, HttpServletResponse resp,PrintWriter out){
	
		String tape = req.getParameter("tape");
		int ind = 0;
		if(tape==null || tape.equals("")){
			out.print("<script>alert('����!');location.href='front/pay.jsp';</script>");
		}else{
			ind=Integer.parseInt(tape);
		}
		HttpSession session = req.getSession();
		orderCopy ordc = (orderCopy)session.getAttribute("ordc");
		Date chetim = null;
		String str = "������";
		double payment = 0;
		if(ind==2){
			str="�Ѹ���";
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
			out.print("<script>alert('�����ύʧ�ܣ��������ύ��');location.href='front/pay.jsp';</script>");
		}else{
			try {
				if(ind==2){
					//�޸��û����
					UserService userSer = new UserServiceImpl();
					User user = userSer.findUserById(ordc.getUserId());
					System.out.println("ԭ��"+user.getBalance());
					double bal = user.getBalance()- orders.getPayment();
					System.out.println("���ڽ�"+bal);
					/*if(user.getBalance()<=0 || bal<=0 ){
						order.delOrderByOrderNum(orders.getOrderNum());
						out.print("<script>alert('���㣬���ֵ��');location.href='front/personalCenter.jsp';</script>");
						return;
					}*/
					int ordStep = userSer.updUserBalanceById(bal, ordc.getUserId());
					System.out.println("�޸�����Ƿ�ɹ���"+ordStep);
				}
					resp.sendRedirect("OrderDetailsServlet?ordDetSign=addDetails&orderNum="+orders.getOrderNum()+"&step="+ind );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//ɾ�������ķ���
	public void delOrder(HttpServletRequest req,PrintWriter out){
		String orderNum = req.getParameter("orderNum");
		if(orderNum==null || "".equals(orderNum) ){
			orderNum="0";
		}
		System.out.println("�������"+orderNum);
		OrderDetailsServlet ods = new OrderDetailsServlet();
		int count = 0;
		int cot = ods.delOrderDetailsByOrderId(orderNum);
		System.out.println("�Ƿ�ɾ���������飺"+cot);
		if(cot>=0){
			count = order.delOrderByOrderNum(orderNum);
		}
		System.out.println("�����Ƿ�ɾ��"+count);
		System.out.println("+++++++++++++++++++++++=");
		String json = JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
	}
	
	//����һ���ķ���
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
	
	//��ҳ��ʾ�����ķ���
	public void ordShow(HttpServletRequest req,PrintWriter out){
		String userID = req.getParameter("userid");  //�û�ID
		String indx = req.getParameter("index");    // ҳ����
		String state = req.getParameter("state");  //����״̬
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
		ordPage.setTotalCount(cot);  //�����ܼ�¼��
		ordPage.setPageSize(4);  //����ҳ����
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
		ordPage.setPageIndex(pageIndex); //����ҳ����		
		int pagSize = ordPage.getPageSize();
		int pagIndex = ordPage.getPageIndex();
		List<OrdercopView> ordList = orderView.findOrdercopViewPaging(pagIndex, pagSize, userid, state);
		if(ordList ==null){
			return ;
		}
		
		ordPage.setDataList(ordList);
		System.out.println("index:"+ordPage.getPageIndex());
		System.out.println("count:"+ordPage.getPageCount());
		System.out.println("����:"+ordPage.getTotalCount());
		System.out.println("״̬��"+state);
		System.out.println("��������"+ordPage.getDataList().size());
		System.out.println("________________________________________");
		String json = JSON.toJSONStringWithDateFormat(ordPage, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
		return;
		
	}
	
}
