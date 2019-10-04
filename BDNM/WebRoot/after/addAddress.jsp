<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		
		<form action="../AddressServlet?opt=addAddress" method="post">
			<input type="radio" name="add" value="addCity"/>
			添加市：<input type="text" name="city" />

			<br />
			
			<input type="radio" name="add" value="addCounty"/>
			添加区/县：<input type="text" name="county" />
			<select name="parentCity">
				<option value="1">北京市</option>
				<option value="58">济南市</option>
				<option value="68">伊春市</option>
			</select>
			<br />
			<input type="submit" value="添加" />
		</form>
	</body>
</html>