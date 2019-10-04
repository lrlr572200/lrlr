<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>百度糯米管理系统</title>
		<style>
			 *{margin: 0;}
			/*div{border: 1px solid blue;}*/
			/*
			#main{width: 1200px;height:600px; margin: 0 auto;}
			#d1{width: 1200px;height: 100px;line-height: 100px;font-size: 30px;text-align: center;}
			#d2{width: 200px;height: 500px;display: inline-block;float: left;}
			#d2 ul li{list-style-type: none;}
			a:link{text-decoration: none;color: black;}
			#d3{width: 990px;height: 500px;display: inline-block;float: right;}
			iframe{border-style: none;} */
		</style>
		<link rel="stylesheet" type="text/css" href="css/adminSystem/adminIndexSystem.css"/>
	</head>
	<body>
		<div id="main">
			<div id="d1"  style="background-image: url(img/adminIndex/jietuback.png);">欢迎使用百度糯米管理系统</div>
			<p>
			<c:if test="${adminUser==null }">
			<!-- <a href="adminLogin.jsp">管理员登录</a> -->
			<script type="text/javascript">
			alert("请进行管理员登录！")
			location.href="adminLogin.jsp";
			</script>
			</c:if>
			
			<c:if test="${adminUser!=null }">
			<span>管理员：${adminUser.userName } 您好</span>&nbsp;&nbsp;&nbsp;
			<a href="../UserServlet?userSign=adminUserLogout" >注销</a>
			</c:if>
			</p>
			<div id="d2">
				<ul>
					<li><a href="addUser.jsp" target="frameMain">添加用户</a></li>
					<li><a href="../UserServlet?userSign=getUserPaging" target="frameMain">编辑用户</a></li>
					<li><a href="addHotelDetails.jsp" target="frameMain">添加商品</a></li>
					<li><a href="../HotelDetailsServlet?opt=getHotelPaging" target="frameMain">编辑商品</a></li>
					<li><a href="zanwu.jsp" target="frameMain">添加评论</a></li>
					<%-- <li><a href="<%=request.getContextPath() %>/CommenServlet?opt=CommenByHtIdPaging" target="frameMain">编辑评论</a></li> --%>
					<li><a href="zanwu.jsp" target="frameMain">编辑评论</a></li>
					<li><a href="zanwu.jsp" target="frameMain">添加订单</a></li>
					<li><a href="zanwu.jsp" target="frameMain">编辑订单</a></li>
				</ul>
			</div>
			<div id="d3">
				<iframe name="frameMain" width="980px" height="490px">
					
				</iframe>
			</div>
		</div>
	</body>
</html>
