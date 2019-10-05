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
	
		String opt=request.getParameter("opt");//��ȡ����
		PrintWriter out = response.getWriter();
		/**
		 * ��ӾƵ�
		 */
		if("addHotel".equals(opt)){
			int rel=0;
			//1.������ͣ��Ƿ����ļ��ϴ�
			if(ServletFileUpload.isMultipartContent(request))
			{
				//2.�����ļ�����
				//a.��������
		  		FileItemFactory factory=new DiskFileItemFactory();
		  		//b.ͨ�����������ļ��ϴ�����
		  		ServletFileUpload upload=new ServletFileUpload(factory);
		  		//3.�����ϴ�������	
		  	    List<FileItem> fileItemList;
		  	    try {
					fileItemList = upload.parseRequest(request);
				
		  	    // 4.��������.��ͨ���ݣ�ȡ������װ��ʵ��,�ļ����ݽ����ϴ�����
		  	    HotelDetails htds=new HotelDetails();//������ݵ�ʵ��  
		  	    String picPath="default.jpeg"; //������ϴ�Ĭ�ϵ��ļ�
		  	    String newFilename="";//���ļ���
		  	//����������
				for(FileItem item:fileItemList){
						if(item.isFormField())//��ͨ�ֶ�����
						{
								String fieldName=  item.getFieldName();//��ȡ������
								if("hotelName".equals(fieldName))  //�ж��Ƿ��ǾƵ�������
				  		        {
				  		           htds.setHtName(item.getString("utf-8"));
				  		        }
				  		        else if("address".equals(fieldName))//�ж��Ƿ��ǵ�ַ����
					  		    {
					  		       htds.setHtAddress(item.getString("utf-8"));
					  		    }
					  		     else if("htType".equals(fieldName))//�ж��Ƿ��ǾƵ���������
					  		    {
					  		       htds.setHtTypeId(Integer.parseInt(item.getString("utf-8")));
					  		    }
					  		    else if("picture".equals(fieldName))//�ж��Ƿ����ļ�����
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
						else{//�ļ����ϴ��ļ�
							if(item.getSize()>0)
							{
								//�ļ�����
								//1.��ֹ������ȡʱ�䣬��ȷ�����룬�����+"�ϴ��ļ�����չ��"
								//2.ͨ��ͨ����չ���ж��û��ϴ����Ƿ���ͼƬ��gif,png,jpg,jpeg
								Random ran=new Random();
								int rans=ran.nextInt(100000);//�����
								Date date=new Date();
								SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
								String now=format.format(date);
								String fileName=  item.getName();//�ϴ����ļ���
								 int index=fileName.lastIndexOf(".");//�������һ��"."������
					  		     String a= fileName.substring(index);//��ȡ�Ӵ�
					  		     newFilename=now+rans+a;
					  		   fileName=newFilename;//�����ļ�����ֵ���ϴ��ļ�
				  		       File fullFile=new File(fileName);//�����ļ�����
				  		       //��ȡ�������˵�·��
				  		       //��ȡ��upload��Ŀ¼���ڵ�����ȫ·��
				  		       this.getServletContext();
				  		     String uploadPath=  this.getServletContext().getRealPath("upload/");
				  		       System.out.println(uploadPath+fullFile.getName());
				  		       File uploadFile=new File(uploadPath+"/"+fullFile.getName());       		      
				  		        //5.�ϴ��ļ� 	
								item.write(uploadFile);
				  		       picPath=fullFile.getName();//�������ļ���
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
			}//����true||false
			if(rel>0){
			out.print("<script>alert('�ɹ���');location.href='after/addHotelDetails.jsp'</script>");//��ת��Ŀ��·��������
			}
		}//���
		
		//ɾ��
		if("delHotel".equals(opt)){
			int id=Integer.parseInt(request.getParameter("id"));
			int rel=hdService.delHotelDetailsById(id);
			out.print(rel);
			out.flush();
			//out.print("<script>location.href='editHotelDetails.jsp'</script>");
			out.close();
			return;
		}
		
	
		
		
		//�޸�
		
		if("updateHotel".equals(opt)){
			int rel=0;
			//1.������ͣ��Ƿ����ļ��ϴ�
			if(ServletFileUpload.isMultipartContent(request))
			{
				//2.�����ļ�����
				//a.��������
		  		FileItemFactory factory=new DiskFileItemFactory();
		  		//b.ͨ�����������ļ��ϴ�����
		  		ServletFileUpload upload=new ServletFileUpload(factory);
		  		//3.�����ϴ�������	
		  	    List<FileItem> fileItemList;
		  	    try {
					fileItemList = upload.parseRequest(request);
				
		  	    // 4.��������.��ͨ���ݣ�ȡ������װ��ʵ��,�ļ����ݽ����ϴ�����
		  	    HotelDetails htds=new HotelDetails();//������ݵ�ʵ��  
		  	    String picPath="default.jpeg"; //������ϴ�Ĭ�ϵ��ļ�
		  	    String newFilename="";//���ļ���
		  	//����������
				for(FileItem item:fileItemList){
						if(item.isFormField())//��ͨ�ֶ�����
						{
								String fieldName=  item.getFieldName();//��ȡ������
								if("id".equals(fieldName)){
										htds.setHtId(Integer.parseInt(item.getString("utf-8")));
								}
								else if("hotelName".equals(fieldName))  //�ж��Ƿ��ǾƵ�������
				  		        {
				  		           htds.setHtName(item.getString("utf-8"));
				  		        }
				  		        else if("address".equals(fieldName))//�ж��Ƿ��ǵ�ַ����
					  		    {
					  		       htds.setHtAddress(item.getString("utf-8"));
					  		    }
					  		     else if("htType".equals(fieldName))//�ж��Ƿ��ǾƵ���������
					  		    {
					  		       htds.setHtTypeId(Integer.parseInt(item.getString("utf-8")));
					  		    }
					  		    else if("picture".equals(fieldName))//�ж��Ƿ����ļ�����
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
						else{//�ļ����ϴ��ļ�
							if(item.getSize()>0)
							{
								//�ļ�����
								//1.��ֹ������ȡʱ�䣬��ȷ�����룬�����+"�ϴ��ļ�����չ��"
								//2.ͨ��ͨ����չ���ж��û��ϴ����Ƿ���ͼƬ��gif,png,jpg,jpeg
								Random ran=new Random();
								int rans=ran.nextInt(100000);//�����
								Date date=new Date();
								SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
								String now=format.format(date);
								String fileName=  item.getName();//�ϴ����ļ���
								 int index=fileName.lastIndexOf(".");//�������һ��"."������
					  		     String a= fileName.substring(index);//��ȡ�Ӵ�
					  		     newFilename=now+rans+a;
					  		   fileName=newFilename;//�����ļ�����ֵ���ϴ��ļ�
				  		       File fullFile=new File(fileName);//�����ļ�����
				  		       //��ȡ�������˵�·��
				  		       //��ȡ��upload��Ŀ¼���ڵ�����ȫ·��
				  		       this.getServletContext();
				  		     String uploadPath=  this.getServletContext().getRealPath("upload/");
				  		       System.out.println(uploadPath+fullFile.getName());
				  		       File uploadFile=new File(uploadPath+"/"+fullFile.getName());       		      
				  		        //5.�ϴ��ļ� 	
								item.write(uploadFile);
				  		       picPath=fullFile.getName();//�������ļ���
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
			}//����true||false
			if(rel>0){
			out.print("<script>alert('�޸ĳɹ���');location.href='HotelDetailsServlet?opt=getHotelPaging'</script>");//��ת��Ŀ��·��������
			}
		}//���
		
		/**
		 * ��ѯ�Ƶ�
		 * ��ҳ
		 */
		if("getHotelPaging".equals(opt)){
			int totalCount=hdService.findHotelDetailsCount();//��ȡ�ܼ�¼��
			PageSurport<HotelDetails> pageSurport=new PageSurport<HotelDetails>();//�������������
			//ҳ����
			int pageIndex=1;
			//��ȡ��ǰҳ
			if(request.getParameter("curpage")!=null && !request.getParameter("curpage").equals("")){
				pageIndex=Integer.parseInt(request.getParameter("curpage"));
			}
			pageSurport.setPageSize(5);//����ҳ��С
			pageSurport.setTotalCount(totalCount);//�����ܼ�¼��
			//����ҳ�쳣
			if(pageIndex<1){
				pageIndex=1;
			}
			if(pageIndex>pageSurport.getPageCount()){
				pageIndex=pageSurport.getPageCount();
			}
			pageSurport.setPageIndex(pageIndex);//����ҳ��
			//��ҳ����
			List<HotelDetails> hotelList=hdService.findHotelDetailsPaging(pageSurport.getPageIndex(),pageSurport.getPageSize());
			pageSurport.setDataList(hotelList);
			//����ҳ���ݱ��浽����
			request.setAttribute("pageSurport",pageSurport);
			//ת����editHotelDetails.jsp����
			request.getRequestDispatcher("after/editHotelDetails.jsp").forward(request,response);
			
		}//��ҳ��ѯ
		/**
		 * ��ʾ����
		 */
	/*	if("showHotelPaging".equals(opt)){
			int totalCount=hdService.findHotelDetailsCount();//��ȡ�ܼ�¼��
			PageSurport<HotelDetails> pageSurport=new PageSurport<HotelDetails>();//�������������
			//ҳ����
			int pageIndex=1;
			//��ȡ��ǰҳ
			if(request.getParameter("curpage")!=null && !request.getParameter("curpage").equals("")){
				pageIndex=Integer.parseInt(request.getParameter("curpage"));
			}
			pageSurport.setPageSize(5);//����ҳ��С
			pageSurport.setTotalCount(totalCount);//�����ܼ�¼��
			//����ҳ�쳣
			if(pageIndex<1){
				pageIndex=1;
			}
			if(pageIndex>pageSurport.getPageCount()){
				pageIndex=pageSurport.getPageCount();
			}
			pageSurport.setPageIndex(pageIndex);//����ҳ��
			//��ҳ����
			List<HotelDetails> hotelList=hdService.findHotelDetailsPaging(pageSurport.getPageIndex(),pageSurport.getPageSize());
			
			pageSurport.setDataList(hotelList);
			//��pageSurport����ת��ΪJson�����
			String jsonStr=JSON.toJSONString(pageSurport);
			out.print(jsonStr);
			out.flush();
			out.close();
			return ;
		}//��ҳ��ʾ
*/		
		
		if("showHotelPaging".equals(opt)){
			String City=request.getParameter("city");//��ȡ����
			int CountyId;//��������ID
			int Type;//��������ID
			//��ȡ����ID
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
			AddressService adService=new AddressServiceImpl();//������ȡ����ʵ�������
			String countyName= adService.findCountyNameByCountyId(CountyId);//��ȡ������
			int totalCount=hdService.findHotelDetailsCountFive(City, countyName, Type);//��ȡ�ܼ�¼��
			PageSurport<HotelDetails> pageSurport=new PageSurport<HotelDetails>();//�������������
			//ҳ����
			int pageIndex=1;
			//��ȡ��ǰҳ
			if(request.getParameter("curpage")!=null && !request.getParameter("curpage").equals("")){
				pageIndex=Integer.parseInt(request.getParameter("curpage"));
			}
			pageSurport.setPageSize(5);//����ҳ��С
			pageSurport.setTotalCount(totalCount);//�����ܼ�¼��
			//����ҳ�쳣
			if(pageIndex<1){
				pageIndex=1;
			}
			if(pageIndex>pageSurport.getPageCount()){
				pageIndex=pageSurport.getPageCount();
			}
			pageSurport.setPageIndex(pageIndex);//����ҳ��
			//��ҳ����
			List<HotelDetails> hotelList=hdService.showHotelDetailsPCCT(City, countyName, Type, pageSurport.getPageIndex(),pageSurport.getPageSize());
			
			pageSurport.setDataList(hotelList);
			//��pageSurport����ת��ΪJson�����
			String jsonStr=JSON.toJSONString(pageSurport);
			out.print(jsonStr);
			out.flush();
			out.close();
			return ;
		}//��ҳ��ʾ
		
		
		
		//����id����һ��
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
