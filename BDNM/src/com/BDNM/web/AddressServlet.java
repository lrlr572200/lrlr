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
		 * ���
		 */
		if("addAddress".equals(opt)){
			if("addCity".equals(request.getParameter("add"))){
				String addName=request.getParameter("city");
				Address ads=new Address();
				ads.setMunicipalAddName(addName);
				ads.setMunicipalParentId(0);
				int rel=adService.addAddress(ads);
				if(rel>0){
					out.print("<script>alert('��ӳɹ�');location.href='after/addAddress.jsp'</script>");
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
					out.print("<script>alert('��ӳɹ�');location.href='after/addAddress.jsp'</script>");
				}
			}
		}//���
		
		//ɾ����
		if("delAddress".equals(opt)){
			int id=Integer.parseInt(request.getParameter("id"));
			adService.delAllCountyByParentId(id);
			int rel=adService.delAddressByAddId(id);
			out.print(rel);
			out.flush();
			out.close();
			return;
		}
		
		//�޸�һ������
		if("updateAddress".equals(opt)){
			String addName=request.getParameter("addName");
			int addId=Integer.parseInt(request.getParameter("addId"));
			Address address=new Address();
			address.setMunicipalAddId(addId);
			address.setMunicipalAddName(addName);
			int rel=adService.updateCityByAddId(address);
			if(rel>0){
				out.print("<script>alert('�޸ĳɹ�');location.href='AddressServlet?opt=getAddress'</script>");
			}
			else{
				out.print("<script>alert('�޸�ʧ��');location.href='AddressServlet?opt=getAddress'</script>");
			}
		}
		
		/**
		 * ��ѯ
		 */
		if("getAddress".equals(opt)){
			AddressPageSurport pageSurport=new AddressPageSurport();
			List<Address> cityList=adService.findAllCity();//��ȡ���еĳ���
			pageSurport.setDataList(cityList);//���ó��м���
			
			int addId=1;//����ID��ʼ��(Ĭ�ϱ���)
			if(request.getParameter("citys")!=null && !request.getParameter("citys").equals("")){
				 addId=Integer.parseInt(request.getParameter("citys"));//��ȡ����ID
			}
			//��ѯaddId�µ���������
			List countyList=adService.findAllAddressByAddId(addId);
			pageSurport.setDataListtwo(countyList);
			pageSurport.setAddId(addId);//��������������
			
			
			//�����ݷŵ�����
			request.setAttribute("pageSurport",pageSurport);
			request.getRequestDispatcher("after/editAddress.jsp").forward(request,response);
			
		}//��ѯ
		
		/**
		 * ��ʾ������
		 */
		if("showCounty".equals(opt)){
			String addName=request.getParameter("cityName");//��ȡ������
			if(request.getParameter("cityName")==null || request.getParameter("cityName").equals("")){
				addName="����";
			}
			int addId=adService.findAddIdByAddName(addName);//��ѯ����ID
			List<Address> countyList= adService.findAllAddressByAddId(addId);//��ѯ�ó��м���������
			String jsonStr=JSON.toJSONString(countyList);
			out.print(jsonStr);
			out.flush();
			out.close();
			return;
		}//��ʾ������
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
