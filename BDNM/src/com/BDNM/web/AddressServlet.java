package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BDNM.entity.Address;
import com.BDNM.service.AddressService;
import com.BDNM.service.impl.AddressServiceImpl;
import com.BDNM.utils.AddressPageSurport;
import com.BDNM.utils.PageSurport;
import com.alibaba.fastjson.JSON;


public class AddressServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddressServlet() {
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
		AddressService adService=new AddressServiceImpl();
		String opt=request.getParameter("opt");
		/**
		 * 添加
		 */
		if("addAddress".equals(opt)){
			if("addCity".equals(request.getParameter("add"))){
				String addName=request.getParameter("city");
				Address ads=new Address();
				ads.setMunicipalAddName(addName);
				ads.setMunicipalParentId(0);
				int rel=adService.addAddress(ads);
				if(rel>0){
					out.print("<script>alert('添加成功');location.href='after/addAddress.jsp'</script>");
				}
			}
			else{
				String addName=request.getParameter("county");
				int parentId=Integer.parseInt(request.getParameter("parentCity"));
				Address ads=new Address();
				ads.setMunicipalAddName(addName);
				ads.setMunicipalParentId(parentId);
				int rel=adService.addAddress(ads);
				if(rel>0){
					out.print("<script>alert('添加成功');location.href='after/addAddress.jsp'</script>");
				}
			}
		}//添加
		
		//删除市
		if("delAddress".equals(opt)){
			int id=Integer.parseInt(request.getParameter("id"));
			adService.delAllCountyByParentId(id);
			int rel=adService.delAddressByAddId(id);
			out.print(rel);
			out.flush();
			out.close();
			return;
		}
		
		//修改一个市名
		if("updateAddress".equals(opt)){
			String addName=request.getParameter("addName");
			int addId=Integer.parseInt(request.getParameter("addId"));
			Address address=new Address();
			address.setMunicipalAddId(addId);
			address.setMunicipalAddName(addName);
			int rel=adService.updateCityByAddId(address);
			if(rel>0){
				out.print("<script>alert('修改成功');location.href='AddressServlet?opt=getAddress'</script>");
			}
			else{
				out.print("<script>alert('修改失败');location.href='AddressServlet?opt=getAddress'</script>");
			}
		}
		
		/**
		 * 查询
		 */
		if("getAddress".equals(opt)){
			AddressPageSurport pageSurport=new AddressPageSurport();
			List<Address> cityList=adService.findAllCity();//获取所有的城市
			pageSurport.setDataList(cityList);//设置城市集合
			
			int addId=1;//城市ID初始化(默认北京)
			if(request.getParameter("citys")!=null && !request.getParameter("citys").equals("")){
				 addId=Integer.parseInt(request.getParameter("citys"));//获取城市ID
			}
			//查询addId下的所有区县
			List countyList=adService.findAllAddressByAddId(addId);
			pageSurport.setDataListtwo(countyList);
			pageSurport.setAddId(addId);//保存区县所属市
			
			
			//将数据放到域中
			request.setAttribute("pageSurport",pageSurport);
			request.getRequestDispatcher("after/editAddress.jsp").forward(request,response);
			
		}//查询
		
		/**
		 * 显示区、县
		 */
		if("showCounty".equals(opt)){
			String addName=request.getParameter("cityName");//获取城市名
			if(request.getParameter("cityName")==null || request.getParameter("cityName").equals("")){
				addName="济南";
			}
			int addId=adService.findAddIdByAddName(addName);//查询城市ID
			List<Address> countyList= adService.findAllAddressByAddId(addId);//查询该城市及所属地区
			String jsonStr=JSON.toJSONString(countyList);
			out.print(jsonStr);
			out.flush();
			out.close();
			return;
		}//显示区、县
	}//doGet

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
