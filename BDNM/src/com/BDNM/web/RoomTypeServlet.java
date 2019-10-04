package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BDNM.entity.RoomType;
import com.BDNM.service.RoomTypeService;
import com.BDNM.service.impl.RoomTypeServiceImpl;

public class RoomTypeServlet extends HttpServlet {

	
	public RoomTypeServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}
	
	RoomTypeService roomTypeService  = new RoomTypeServiceImpl();
	
	//根据编号查找房间的方法
	public String findRoomTypeName(int rmTypeId){
		RoomType rom = roomTypeService.findAllRoomTypeById(rmTypeId);
		String name = rom.getRmTypeName();
		return name;
	}

}
