<%@page import="com.BDNM.entity.Address"%>
<%@page import="com.BDNM.service.impl.AddressServiceImpl"%>
<%@page import="com.BDNM.service.AddressService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	AddressService service=new AddressServiceImpl();
	List<Address> list= service.findAllCity();
	request.setAttribute("list",list);
 %>
<!DOCTYPE html>
<html>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			li{list-style-type: none;display: inline-block;}
			a:link{text-decoration: none;color: black;}
		</style>
	</head>
	<body>
		<h2>市</h2>
		<form action="AddressServlet?opt=getAddress"  method="post">	
				<ul>
						<c:forEach items="${pageSurport.dataList }" var="city" varStatus="statu">
								<a href="javascript:get(${city.municipalAddId})" >${city.municipalAddName }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="after/updateAddCity.jsp?addId=${city.municipalAddId}">修改</a>
								&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="return del(${city.municipalAddId})">删除</a>&nbsp;&nbsp;
								<c:if test="${statu.count%3==0 }">
								<br/>
								</c:if>
						</c:forEach>
				</ul>
				<input type="hidden" name="citys" id="citys" value="${city.municipalAddId}"> 
		</form>
	<h2>区、县</h2>	
		<ul>
			<c:forEach items="${pageSurport.dataListtwo }" var="county">
				<li>${county.regionalAddName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#">删除</a></li>
			</c:forEach>
		</ul>
	</body>
	<script type="text/javascript">
	
		function get(num){
			document.forms[0].citys.value=num;//设置页码隐藏域 
			document.forms[0].submit();//提交表单
		}
	
		function del(id){
			if(confirm("是否删除?"))
			{
				//定义参数
				var data="opt=delAddress&id="+id;
				//发送异步请求
				$.post("AddressServlet",data,function(relData){
					if(relData>0){
						alert("删除成功")
					}
					else{
						alert("删除失败")
					}
				},"json");
				return true;
			}
			else{
				return false;
			}
			
		}
		
	</script>
</html>
