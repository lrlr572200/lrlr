<%@page import="com.BDNM.entity.HotelType"%>
<%@page import="com.BDNM.service.impl.HotelTypeServiceImpl"%>
<%@page import="com.BDNM.service.HotelTypeService"%>
<%@page import="com.BDNM.entity.HotelDetails"%>
<%@page import="com.BDNM.service.impl.HotelDetailsServiceImpl"%>
<%@page import="com.BDNM.service.HotelDetailsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	int id=Integer.parseInt(request.getParameter("id"));//获取ID
	HotelDetailsService hdService=new HotelDetailsServiceImpl();//创建实现类对象
	HotelDetails hotel= hdService.findHotelDetailsById(id);//查询对象
	request.setAttribute("hotel",hotel);
	HotelTypeService htService =new HotelTypeServiceImpl();
	List<HotelType> htList= htService.findAllHotelType();
	request.setAttribute("htList",htList);
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>My JSP 'updateHotelDetails.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/updateHotel/updateHotel.css"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  <div id="div1">
  <div id="div2">
  <span id="size">更新酒店信息</span>
  </div>
  <div id="div3">
    <form action="HotelDetailsServlet?opt=updateHotel" method="post" enctype="multipart/form-data" >
		<a class="size">酒&nbsp;&nbsp;店&nbsp;&nbsp;名：</a><input type="text" name="hotelName" value="${hotel.htName }" />
		<p></p>
		<a class="size">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</a><input type="text" name="address"  value="${hotel.htAddress }"/>
		<p></p>
		<a class="size">酒店类型： </a><select name="htType">
				<c:forEach items="${htList }" var="hts">
					<option value="${hts.htTypeId }"
						<c:if test="${hts.htTypeId==hotel.htTypeId }" >
						selected="selected"
						</c:if>
					>${hts.htTypeName }</option>
				</c:forEach>
			</select>
			<p></p>
		<a class="size">封&nbsp;&nbsp;面&nbsp;&nbsp;图：</a><input type="file" name="picture"  value="${hotel.htPictrue }"/>
		<p></p>
		<a class="size">简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介：</a><input type="text" name="intro"  value="${hotel.htIntro }"/>
		<p></p>
		<a class="size">前台电话：</a><input type="text" name="phone" value="${hotel.htPhone }" /><br />
		<input type="hidden" name="id" value="${hotel.htId }">
		<input type="submit" value="修改">
	</form>
	</div>
	</div>
  </body>
</html>

