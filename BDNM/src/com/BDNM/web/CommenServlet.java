package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BDNM.entity.Commen;
import com.BDNM.service.CommenService;
import com.BDNM.service.UserService;
import com.BDNM.service.impl.CommenServiceImpl;
import com.BDNM.service.impl.UserServiceImpl;
import com.BDNM.utils.PageSurport;
import com.BDNM.utils.ShowCommen;
import com.alibaba.fastjson.JSON;

public class CommenServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommenServlet() {
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
		CommenService comService=new CommenServiceImpl();
		String opt=request.getParameter("opt");
		
		/**
		 * 获取酒店平均评分
		 */
		if("getAvgGrade".equals(opt)){
			int htId;
			if(request.getParameter("htId")!=null && !request.getParameter("htId").equals("")){
				htId=Integer.parseInt(request.getParameter("htId"));
			}else{
				htId=0;
			}
			int grade=comService.findCommenAvgGradeByHtId(htId);
			out.print(grade);
			out.flush();
			out.close();
		}
		
		//查询评论的总量
		if("getCount".equals(opt)){
			int htId;
			if(request.getParameter("htId")!=null && !request.getParameter("htId").equals("")){
				htId=Integer.parseInt(request.getParameter("htId"));
			}else{
				htId=0;
			}
			int count=comService.findCommenCountByHtId(htId);
			out.print(count);
			out.flush();
			out.close();
		}
		/**
		 * 分页展示评论
		 */
		if("showCommen".equals(opt)){
			int htId;
			if(request.getParameter("htId")!=null && !request.getParameter("htId").equals("")){
				htId=Integer.parseInt(request.getParameter("htId"));
			}else{
				htId=0;
			}
			int totalCount=comService.findCommenCountByHtId(htId);
			PageSurport<ShowCommen> pageSurport=new PageSurport<ShowCommen>();
			//页索引
			int pageIndex=1;
			//获取当前页
			if(request.getParameter("curpage")!=null && !request.getParameter("curpage").equals("")){
				pageIndex=Integer.parseInt(request.getParameter("curpage"));
			}
			pageSurport.setPageSize(5);//设置页大小
			pageSurport.setTotalCount(totalCount);//设置总记录数
			//处理页异常
			if(pageIndex<1){
				pageIndex=1;
			}
			if(pageIndex>pageSurport.getPageCount()){
				pageIndex=pageSurport.getPageCount();
			}
			pageSurport.setPageIndex(pageIndex);//设置页码
			List<ShowCommen> showList=comService.findHHUCGCByHtId(htId, pageSurport.getPageIndex(), pageSurport.getPageSize());
			
			pageSurport.setDataList(showList);
			//将pageSurport对象转换为Json串输出
			String jsonStr=JSON.toJSONStringWithDateFormat(pageSurport, "yyyy-MM--dd HH:mm:ss");
			out.print(jsonStr);
			out.flush();
			out.close();
			return ;
		}
		
		//添加评论
		if("addCommen".equals(opt)){
			int htId=Integer.parseInt(request.getParameter("htId"));
			int userId=Integer.parseInt(request.getParameter("userId"));
			int grade=Integer.parseInt(request.getParameter("radio"));
			String comText=request.getParameter("comText");
			Commen commen=new Commen();
			commen.setHtId(htId);
			commen.setUserId(userId);
			commen.setGrade(grade);
			commen.setCommen(comText);
			Date date=new Date();
			commen.setCommenTime(date);
			int rel=comService.addCommen(commen);
			if(rel>0){
				out.print("<script>alert('已评论');location.href='front/buy.jsp'</script>");
			}
		}
		
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
