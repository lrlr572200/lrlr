package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BDNM.service.CouponService;
import com.BDNM.service.UserService;
import com.BDNM.service.impl.CouponServiceImpl;
import com.alibaba.fastjson.JSON;

public class CouponServlet extends HttpServlet {

	public CouponServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	CouponService  couponSer  = new CouponServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String opt = request.getParameter("opt");
		if("findUserCoupon".equals(opt)){
			String useId = request.getParameter("userid");
			int userid = 0;
			if(useId==null ||useId.equals("") ){
				userid = 0;
			}else{
				userid=Integer.parseInt(useId);
			}
			double nominal = couponSer.findCouponNominal(userid, 1);
			UserServlet userSlet = new UserServlet();
			double userMoney = userSlet.findUserById(userid).getBalance();
			double [] money = new double[]{nominal,userMoney};
			if(money.length<=0){
				money = new double[2];
			}
			String json = JSON.toJSONStringWithDateFormat(money, "yyyy-MM-dd HH:mm:ss");
			out.print(json);
			out.close();
			out.flush();
			
			return;
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
	}

}
