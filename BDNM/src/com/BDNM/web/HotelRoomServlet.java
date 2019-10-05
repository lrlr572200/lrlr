package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import javax.servlet.http.HttpSession;

import com.BDNM.entity.HotelRoom;
import com.BDNM.entity.User;
import com.BDNM.service.CouponService;
import com.BDNM.service.HotelDetailsService;
import com.BDNM.service.HotelRoomService;
import com.BDNM.service.RoomTypeService;
import com.BDNM.service.impl.CouponServiceImpl;
import com.BDNM.service.impl.HotelDetailsServiceImpl;
import com.BDNM.service.impl.HotelRoomServiceImpl;
import com.BDNM.service.impl.RoomTypeServiceImpl;
import com.BDNM.utils.HotelRoomCopy;
import com.BDNM.utils.orderCopy;
import com.alibaba.fastjson.JSON;

public class HotelRoomServlet extends HttpServlet {

	
	public HotelRoomServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

	
	HotelRoomService htRoomService = new HotelRoomServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opt = request.getParameter("opt");
		PrintWriter out = response.getWriter();
		
		/**
		 * ��ѯĳ�Ƶ�ĳ�ַ�������ʣ������
		 */
		if("getSruplus".equals(opt)){
			int htId;
			int rmTypeId;
			if(request.getParameter("htId")!=null && !request.getParameter("htId").equals("")){
				htId=Integer.parseInt(request.getParameter("htId"));
			}else{
				htId=0;
			}
			if(request.getParameter("rmTypeId")!=null && !request.getParameter("rmTypeId").equals("")){
				rmTypeId=Integer.parseInt(request.getParameter("rmTypeId"));
			}else{
				rmTypeId=0;
			}
			int count=htRoomService.findRoomTypeCountByhtIdAndRmTypeId(htId, rmTypeId);
			String sum=htRoomService.findSumByHtIdAndRmTypeId(htId, rmTypeId);
			int Surplus;
			if(sum!=null && !sum.equals("")){	
				Surplus=count-Integer.parseInt(sum);
			}else{
				Surplus=count;
			}
			out.print(Surplus);
			out.flush();
			out.close();
		}

		
		
		//��ʾĳ���Ƶ�����з�����Ϣ�ķ���
		if("showRoomInfo".equals(opt)){
			showRoomInfo(request, out);
			return;
		}
		
		//�ҵ�һ���Ƶ�
		if("findRoom".equals(opt)){
			findRoom(request, out);
			return;
		}
		
		/**
		 * ��ѯ�Ƶ�ƽ������
		 */
		if("getAvgPrice".equals(opt)){
			int htId;
			if(request.getParameter("htId")!=null && !request.getParameter("htId").equals("")){
				htId=Integer.parseInt(request.getParameter("htId"));
			}else{
				htId=0;
			}
			double price=htRoomService.findAvgPriceByHtId(htId);
			NumberFormat nbf=NumberFormat.getInstance();
			nbf.setMaximumFractionDigits(2);
			String avgPrice=nbf.format(price/6);
			out.print(avgPrice);
			out.flush();
			out.close();
			return;
		}
		
		if("willComOrd".equals(opt)){
			willComOrd(request,out,response);
			return;
		}

	}
	
	
	//Ԥ��ʾ�����ķ���
		public void willComOrd(HttpServletRequest request,PrintWriter out,HttpServletResponse response){
			String hotelId = request.getParameter("hotelid");
			String roomId = request.getParameter("roomid");
			String count = request.getParameter("cot");
			int hotelid = 0;
			int roomid = 0;
			int cot = 0;
			if(hotelId==null || hotelId.equals("")){
					hotelid = 0;
			}else{
					hotelid = Integer.parseInt(hotelId);
			}
			if(roomId==null || roomId.equals("")){
					roomid = 0;
			}else{
					roomid = Integer.parseInt(roomId);
			}
			if(count==null || count.equals("")){
					cot = 0;
			}else{
					cot = Integer.parseInt(count);
			}
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			int userid=0;
			if(user==null || user.equals("")){
				userid=0;
			}else{
				userid=user.getUserId();
			}
			RoomTypeService rts = new RoomTypeServiceImpl();
			CouponService cou = new CouponServiceImpl();
			HotelDetailsService hd = new  HotelDetailsServiceImpl();  //�Ƶ���Ϣ
			HotelRoom hrm = htRoomService.findByRmTypeIdAndHtId(roomid, hotelid);
			orderCopy ordc = new orderCopy();
			ordc.setRmTypeId(hrm.getRmTypeId());  //��������
			ordc.setRmTypeName(rts.findRmTypeNameById(hrm.getRmTypeId()));   //������
			ordc.setRmTypePrice(hrm.getRmTypePrice());   //����۸�
			ordc.setHtId(hrm.getHtId());   //�Ƶ�ID
			ordc.setHtName(hd.findHotelDetailsById(hrm.getHtId()).getHtName());  //�Ƶ���
			ordc.setNum(cot);  //��������
			ordc.setNominal(cou.findCouponNominal(userid, 1));  //�Ż���ֵ
			ordc.setRmTypePictrue(hrm.getRmTypePictrue());  //����ͼƬ
			ordc.setUserId(userid);  //�û�ID
			ordc.setMoney(ordc.getRmTypePrice()*ordc.getNum()-ordc.getNominal());  //�������
			session.setAttribute("ordc", ordc);
			out.print("<script>location.href='front/pay.jsp'</script>");
			out.close();
			out.flush();
		}
	
	//��ʾĳ�Ƶ�һ���������͵���Ϣ
	public void findRoom(HttpServletRequest request,PrintWriter out){
		String htId = request.getParameter("hotelid");
		int hotelid = 0;
		if(htId==null || htId.equals("")){
			 hotelid = 0;
		}else{
			hotelid = Integer.parseInt(htId);
		}
		String rmId = request.getParameter("roomid");
		int roomid = 0;
		if(rmId==null || rmId.equals("")){
			roomid = 0;
		}else{
			roomid = Integer.parseInt(rmId);
		}
		HotelDetailsService hd = new  HotelDetailsServiceImpl();  //�Ƶ���Ϣ
		RoomTypeService rts = new RoomTypeServiceImpl();
		HotelRoom hroom = htRoomService.findByRmTypeIdAndHtId(roomid, hotelid);
		HotelRoomCopy hrc = new HotelRoomCopy();
		hrc.setRmTypeId(hroom.getRmTypeId()); //����ID
		hrc.setRmTypeName(rts.findRmTypeNameById(hroom.getRmTypeId()));//������
		hrc.setRmTypePrice(hroom.getRmTypePrice());//����۸�
		hrc.setRmTypeCount(hroom.getRmTypeCount());//��������
		hrc.setRmTypeSruplus(hroom.getRmTypeSruplus());//ʣ������
		hrc.setHtName(hd.findHotelDetailsById(hroom.getHtId()).getHtName());//�Ƶ�
		hrc.setRmTypePictrue(hroom.getRmTypePictrue());//��������ͼ
		hrc.setRmTypeIntro(hroom.getRmTypeIntro());//������
		String json = JSON.toJSONStringWithDateFormat(hrc, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
	}
	
	//��ʾĳ���Ƶ�����з�����Ϣ�ķ���
	public void showRoomInfo(HttpServletRequest request,PrintWriter out){
		String htId = request.getParameter("hotelid");
		int hotelid = 0;
		if(htId==null || htId.equals("")){
			 hotelid = 0;
		}else{
			hotelid = Integer.parseInt(htId);
		}
		HotelDetailsService hd = new  HotelDetailsServiceImpl();  //�Ƶ���Ϣ
		RoomTypeService rts = new RoomTypeServiceImpl();
		List<HotelRoom> rmList = htRoomService.findByHtId(hotelid);  //��þƵ귿�伯��
		HotelRoomCopy hrc = null;
		List<HotelRoomCopy> hrcList = new ArrayList<HotelRoomCopy>();
		for(HotelRoom room:rmList){  //�����Ƶ귿�伯�ϣ�Ϊ�Ƶ귿�丱����ֵ
			hrc = new HotelRoomCopy();  //��ȡ�Ƶ귿�丱��
			hrc.setRmTypeId(room.getRmTypeId()); //����ID
			hrc.setRmTypeName(rts.findRmTypeNameById(room.getRmTypeId()));//������
			hrc.setRmTypePrice(room.getRmTypePrice());//����۸�
			hrc.setRmTypeCount(room.getRmTypeCount());//��������
			hrc.setRmTypeSruplus(room.getRmTypeSruplus());//ʣ������
			hrc.setHtName(hd.findHotelDetailsById(room.getHtId()).getHtName());//�Ƶ�
			hrc.setRmTypePictrue(room.getRmTypePictrue());//��������ͼ
			hrc.setRmTypeIntro(room.getRmTypeIntro());//������
			hrcList.add(hrc);
		}
		String json = JSON.toJSONStringWithDateFormat(hrcList, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
		
	}
	
	
}
