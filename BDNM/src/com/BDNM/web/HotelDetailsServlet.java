package com.BDNM.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.BDNM.entity.Commen;
import com.BDNM.entity.HotelDetails;
import com.BDNM.entity.HotelRoom;
import com.BDNM.service.AddressService;
import com.BDNM.service.CommenService;
import com.BDNM.service.HotelDetailsService;
import com.BDNM.service.HotelRoomService;
import com.BDNM.service.HotelTypeService;
import com.BDNM.service.impl.AddressServiceImpl;
import com.BDNM.service.impl.CommenServiceImpl;
import com.BDNM.service.impl.HotelDetailsServiceImpl;
import com.BDNM.service.impl.HotelRoomServiceImpl;
import com.BDNM.service.impl.HotelTypeServiceImpl;
import com.BDNM.utils.HotelDetailsCopy;
import com.BDNM.utils.PageSurport;
import com.alibaba.fastjson.JSON;

public class HotelDetailsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HotelDetailsServlet() {
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
	
	HotelDetailsService hdService=new HotelDetailsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String opt=request.getParameter("opt");//获取操作
		PrintWriter out = response.getWriter();
		/**
		 * 添加酒店
		 */
		if("addHotel".equals(opt)){
			int rel=0;
			//1.检查类型，是否是文件上传
			if(ServletFileUpload.isMultipartContent(request))
			{
				//2.创建文件对象
				//a.创建工厂
		  		FileItemFactory factory=new DiskFileItemFactory();
		  		//b.通过工厂创建文件上传对象
		  		ServletFileUpload upload=new ServletFileUpload(factory);
		  		//3.解析上传的数据	
		  	    List<FileItem> fileItemList;
		  	    try {
					fileItemList = upload.parseRequest(request);
				
		  	    // 4.处理数据.普通数据，取出，封装成实体,文件数据进行上传操作
		  	    HotelDetails htds=new HotelDetails();//存放数据的实体  
		  	    String picPath="default.jpeg"; //如果不上传默认的文件
		  	    String newFilename="";//新文件名
		  	//遍历表单数据
				for(FileItem item:fileItemList){
						if(item.isFormField())//普通字段数据
						{
								String fieldName=  item.getFieldName();//获取表单名称
								if("hotelName".equals(fieldName))  //判断是否是酒店名数据
				  		        {
				  		           htds.setHtName(item.getString("utf-8"));
				  		        }
				  		        else if("address".equals(fieldName))//判断是否是地址数据
					  		    {
					  		       htds.setHtAddress(item.getString("utf-8"));
					  		    }
					  		     else if("htType".equals(fieldName))//判断是否是酒店类型数据
					  		    {
					  		       htds.setHtTypeId(Integer.parseInt(item.getString("utf-8")));
					  		    }
					  		    else if("picture".equals(fieldName))//判断是否是文件数据
					  		    {
					  		    	htds.setHtPictrue(item.getString("utf-8"));
					  		    }
					  		    else if("intro".equals(fieldName))
					  		    {
					  		    	htds.setHtIntro(item.getString("utf-8"));
					  		    }
					  		    else if("phone".equals(fieldName))
					  		    {
					  		    	htds.setHtPhone(item.getString("utf-8"));
					  		    }
						}
						else{//文件域上传文件
							if(item.getSize()>0)
							{
								//文件数据
								//1.防止重名获取时间，精确到毫秒，随机数+"上传文件的扩展名"
								//2.通过通过扩展名判断用户上传的是否是图片：gif,png,jpg,jpeg
								Random ran=new Random();
								int rans=ran.nextInt(100000);//随机数
								Date date=new Date();
								SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
								String now=format.format(date);
								String fileName=  item.getName();//上传的文件名
								 int index=fileName.lastIndexOf(".");//返回最后一个"."的索引
					  		     String a= fileName.substring(index);//截取子串
					  		     newFilename=now+rans+a;
					  		   fileName=newFilename;//将新文件名赋值给上传文件
				  		       File fullFile=new File(fileName);//创建文件对象
				  		       //获取服务器端的路径
				  		       //获取“upload”目录所在的物理全路径
				  		       this.getServletContext();
				  		     String uploadPath=  this.getServletContext().getRealPath("upload/");
				  		       System.out.println(uploadPath+fullFile.getName());
				  		       File uploadFile=new File(uploadPath+"/"+fullFile.getName());       		      
				  		        //5.上传文件 	
								item.write(uploadFile);
				  		       picPath=fullFile.getName();//保存新文件名
							}
						}//else
					}
					htds.setHtPictrue(picPath);
					rel=hdService.addHotelDetails(htds);
		  	  } catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}//返回true||false
			if(rel>0){
			out.print("<script>alert('成功！');location.href='after/addHotelDetails.jsp'</script>");//跳转到目标路径，弹窗
			}
		}//添加
		
		//删除
		if("delHotel".equals(opt)){
			int id=Integer.parseInt(request.getParameter("id"));
			int rel=hdService.delHotelDetailsById(id);
			out.print(rel);
			out.flush();
			//out.print("<script>location.href='editHotelDetails.jsp'</script>");
			out.close();
			return;
		}
		
	
		
		
		//修改
		
		if("updateHotel".equals(opt)){
			int rel=0;
			//1.检查类型，是否是文件上传
			if(ServletFileUpload.isMultipartContent(request))
			{
				//2.创建文件对象
				//a.创建工厂
		  		FileItemFactory factory=new DiskFileItemFactory();
		  		//b.通过工厂创建文件上传对象
		  		ServletFileUpload upload=new ServletFileUpload(factory);
		  		//3.解析上传的数据	
		  	    List<FileItem> fileItemList;
		  	    try {
					fileItemList = upload.parseRequest(request);
				
		  	    // 4.处理数据.普通数据，取出，封装成实体,文件数据进行上传操作
		  	    HotelDetails htds=new HotelDetails();//存放数据的实体  
		  	    String picPath="default.jpeg"; //如果不上传默认的文件
		  	    String newFilename="";//新文件名
		  	//遍历表单数据
				for(FileItem item:fileItemList){
						if(item.isFormField())//普通字段数据
						{
								String fieldName=  item.getFieldName();//获取表单名称
								if("id".equals(fieldName)){
										htds.setHtId(Integer.parseInt(item.getString("utf-8")));
								}
								else if("hotelName".equals(fieldName))  //判断是否是酒店名数据
				  		        {
				  		           htds.setHtName(item.getString("utf-8"));
				  		        }
				  		        else if("address".equals(fieldName))//判断是否是地址数据
					  		    {
					  		       htds.setHtAddress(item.getString("utf-8"));
					  		    }
					  		     else if("htType".equals(fieldName))//判断是否是酒店类型数据
					  		    {
					  		       htds.setHtTypeId(Integer.parseInt(item.getString("utf-8")));
					  		    }
					  		    else if("picture".equals(fieldName))//判断是否是文件数据
					  		    {
					  		    	htds.setHtPictrue(item.getString("utf-8"));
					  		    }
					  		    else if("intro".equals(fieldName))
					  		    {
					  		    	htds.setHtIntro(item.getString("utf-8"));
					  		    }
					  		    else if("phone".equals(fieldName))
					  		    {
					  		    	htds.setHtPhone(item.getString("utf-8"));
					  		    }
						}
						else{//文件域上传文件
							if(item.getSize()>0)
							{
								//文件数据
								//1.防止重名获取时间，精确到毫秒，随机数+"上传文件的扩展名"
								//2.通过通过扩展名判断用户上传的是否是图片：gif,png,jpg,jpeg
								Random ran=new Random();
								int rans=ran.nextInt(100000);//随机数
								Date date=new Date();
								SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
								String now=format.format(date);
								String fileName=  item.getName();//上传的文件名
								 int index=fileName.lastIndexOf(".");//返回最后一个"."的索引
					  		     String a= fileName.substring(index);//截取子串
					  		     newFilename=now+rans+a;
					  		   fileName=newFilename;//将新文件名赋值给上传文件
				  		       File fullFile=new File(fileName);//创建文件对象
				  		       //获取服务器端的路径
				  		       //获取“upload”目录所在的物理全路径
				  		       this.getServletContext();
				  		     String uploadPath=  this.getServletContext().getRealPath("upload/");
				  		       System.out.println(uploadPath+fullFile.getName());
				  		       File uploadFile=new File(uploadPath+"/"+fullFile.getName());       		      
				  		        //5.上传文件 	
								item.write(uploadFile);
				  		       picPath=fullFile.getName();//保存新文件名
							}
						}//else
					}
					htds.setHtPictrue(picPath);
					rel=hdService.updateHotelDetails(htds);
		  	  } catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}//返回true||false
			if(rel>0){
			out.print("<script>alert('修改成功！');location.href='HotelDetailsServlet?opt=getHotelPaging'</script>");//跳转到目标路径，弹窗
			}
		}//添加
		
		/**
		 * 查询酒店
		 * 分页
		 */
		if("getHotelPaging".equals(opt)){
			int totalCount=hdService.findHotelDetailsCount();//获取总记录数
			PageSurport<HotelDetails> pageSurport=new PageSurport<HotelDetails>();//创建工具类对象
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
			//分页数据
			List<HotelDetails> hotelList=hdService.findHotelDetailsPaging(pageSurport.getPageIndex(),pageSurport.getPageSize());
			pageSurport.setDataList(hotelList);
			//将分页数据保存到域中
			request.setAttribute("pageSurport",pageSurport);
			//转发到editHotelDetails.jsp界面
			request.getRequestDispatcher("after/editHotelDetails.jsp").forward(request,response);
			
		}//分页查询
		/**
		 * 显示界面
		 */
	/*	if("showHotelPaging".equals(opt)){
			int totalCount=hdService.findHotelDetailsCount();//获取总记录数
			PageSurport<HotelDetails> pageSurport=new PageSurport<HotelDetails>();//创建工具类对象
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
			//分页数据
			List<HotelDetails> hotelList=hdService.findHotelDetailsPaging(pageSurport.getPageIndex(),pageSurport.getPageSize());
			
			pageSurport.setDataList(hotelList);
			//将pageSurport对象转换为Json串输出
			String jsonStr=JSON.toJSONString(pageSurport);
			out.print(jsonStr);
			out.flush();
			out.close();
			return ;
		}//分页显示
*/		
		
		if("showHotelPaging".equals(opt)){
			String City=request.getParameter("city");//获取城市
			int CountyId;//定义区县ID
			int Type;//定义类型ID
			//获取区县ID
			if(request.getParameter("countyId")!=null &&!request.getParameter("countyId").equals("")){
				CountyId=Integer.parseInt(request.getParameter("countyId"));
			}
			else{
				CountyId=0;
			}
			if(request.getParameter("typeId")!=null && !request.getParameter("typeId").equals("")){
				Type=Integer.parseInt(request.getParameter("typeId")); 
			}
			else{
				Type=0;
			}
			AddressService adService=new AddressServiceImpl();//创建获取区县实现类对象
			String countyName= adService.findCountyNameByCountyId(CountyId);//获取区县名
			int totalCount=hdService.findHotelDetailsCountFive(City, countyName, Type);//获取总记录数
			PageSurport<HotelDetails> pageSurport=new PageSurport<HotelDetails>();//创建工具类对象
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
			//分页数据
			List<HotelDetails> hotelList=hdService.showHotelDetailsPCCT(City, countyName, Type, pageSurport.getPageIndex(),pageSurport.getPageSize());
			
			pageSurport.setDataList(hotelList);
			//将pageSurport对象转换为Json串输出
			String jsonStr=JSON.toJSONString(pageSurport);
			out.print(jsonStr);
			out.flush();
			out.close();
			return ;
		}//分页显示
		
		
		
		//根据id查找一条
		if("findHotelById".equals(opt)){
			findHotelById(request,out);
			return;
		}
		
	}//doGet
	
	public void findHotelById(HttpServletRequest request,PrintWriter out){
		String htid = request.getParameter("hotelid");
		int hotelid = 0;
		if(htid==null || "".equals(htid)){
			hotelid = 0;
		}else{
			hotelid = Integer.parseInt(htid);
		}
		HotelDetails hd =hdService.findHotelDetailsById(hotelid);
		HotelTypeService hotelType = new HotelTypeServiceImpl();
		HotelRoomService hotelRoom = new HotelRoomServiceImpl();
		CommenService commen = new CommenServiceImpl();
		List<Commen>  comList  =  commen.findCommenByHtId(hotelid);
		int gradeCot = comList.size();
		int gradeNum = 0;
		if(gradeCot==0){
			gradeNum = 0;
		}else{
			for(Commen co:comList){
				gradeNum += co.getGrade();
			}
			gradeNum = gradeNum/gradeCot;
		}
		List<HotelRoom> roomList =  hotelRoom.findByHtId(hotelid);
		int roomCot = 0;
		double moneySum = 0;
		for(HotelRoom hr:roomList){
			moneySum += hr.getRmTypePrice();
			if(hr.getRmTypeId()==1){
				roomCot += 1;
			}else if(hr.getRmTypeId()==2){
				roomCot += 2;
			}else if(hr.getRmTypeId()==3){
				roomCot += 3;
			}
		}
		HotelDetailsCopy hdCopy = new HotelDetailsCopy();
		hdCopy.setHtId(hd.getHtId());
		hdCopy.setHtName(hd.getHtName());
		hdCopy.setHtAddress(hd.getHtAddress());
		hdCopy.setHtTypeName(hotelType.findHotelTypeNameById(hd.getHtTypeId()));
		hdCopy.setHtPictrue(hd.getHtPictrue());
		hdCopy.setHtIntro(hd.getHtIntro());
		hdCopy.setHtPhone(hd.getHtPhone());
		hdCopy.setAvgGrade(gradeNum);
		hdCopy.setGradeCot(gradeCot);
		hdCopy.setAvgMoney(moneySum/roomCot);
		String json = JSON.toJSONStringWithDateFormat(hdCopy, "yyyy-MM-dd HH:mm:ss");
		out.print(json);
		out.close();
		out.flush();
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
