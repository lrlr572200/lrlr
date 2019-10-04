package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BDNM.entity.HotelType;
import com.BDNM.service.HotelTypeService;
import com.BDNM.service.impl.HotelDetailsServiceImpl;
import com.BDNM.service.impl.HotelTypeServiceImpl;
import com.alibaba.fastjson.JSON;

public class HotelTypeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HotelTypeServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String opt=request.getParameter("opt");
		HotelTypeService htService=new HotelTypeServiceImpl();
		
		/**
		 * 显示酒店类型
		 */
		if("showHotelType".equals(opt)){
			List<HotelType> htList= htService.findAllHotelType();//获取所有类型
			String jsonStr=JSON.toJSONString(htList);
			out.print(jsonStr);
			out.flush();
			out.close();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


doGet(request, response);
	}

}
