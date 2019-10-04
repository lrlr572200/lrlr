<%@page import="com.BDNM.entity.HotelType"%>
<%@page import="com.BDNM.service.impl.HotelTypeServiceImpl"%>
<%@page import="com.BDNM.service.HotelTypeService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	HotelTypeService htService =new HotelTypeServiceImpl();
	List<HotelType> htList= htService.findAllHotelType();
	request.setAttribute("htList",htList);
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>酒店信息</title>
		<link rel="stylesheet" href="css/addHotelDetails.css" />
	</head>
	<body>
		<div id="header"><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加酒店信息</h2></div>
		<div id="main">
			<form action="../HotelDetailsServlet?opt=addHotel" method="post" enctype="multipart/form-data" >
			&nbsp;&nbsp;&nbsp;&nbsp;酒店名：<input type="text" name="hotelName" /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：<input type="text" name="address" /><br />
			&nbsp;酒店类型：<select name="htType">
					<c:forEach items="${htList }" var="hts">
							<option value="${hts.htTypeId }">${hts.htTypeName }</option>
					</c:forEach>
				</select><br />
			&nbsp;&nbsp;&nbsp;&nbsp;封面图：<input type="file" name="picture" /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;简介：<input type="text" name="intro" /><br />
			前台电话：<input type="text" name="phone" /><br />
			<input type="submit" value="添加">
			</form>
		</div>
	</body>
</html>