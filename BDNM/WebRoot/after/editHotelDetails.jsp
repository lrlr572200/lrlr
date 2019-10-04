<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			li{list-style-type: none;}
			a:link{text-decoration: none; color:black;}
			div{display: inline-block;width: 450px;}
			
		</style>
	</head>
	<body>
		<form action="HotelDetailsServlet?opt=getHotelPaging" method="post">
			<input type="hidden" name="curpage"  id="curpage" value="${pageSurport.pageIndex }">
		</form>
		<ul>
		<c:forEach items="${pageSurport.dataList }" var="hotels">
				<li>
				<div>酒店名：${hotels.htName }</div>
				<a href="after/updateHotelDetails.jsp?id=${hotels.htId }" >修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" onclick="return del(${hotels.htId})"  id="del${hotels.htId }">删除</a>
			</li>
			<br/>
		</c:forEach>
			<li>
				<a href="javascript:pageNav(1)">首页</a>
				<a href="javascript:pageNav(${pageSurport.pageIndex-1 })">上一页</a>
				当前页数${pageSurport.pageIndex }/${pageSurport.pageCount }
				<a href="javascript:pageNav(${pageSurport.pageIndex+1})">下一页</a>
				<a href="javascript:pageNav(${pageSurport.pageCount})">尾页</a>
			</li>
		</ul>
	</body>
	<script type="text/javascript">
			//同步表单提交
			function pageNav(num){
				document.forms[0].curpage.value=num;//设置隐藏域
				document.forms[0].submit();//提交表单
			}
			//删除数据
			function del(id){
				if(confirm("是否删除？"))
				{
					var thisA=$("#del"+id);
					
					var data="opt=delHotel&id="+id;
					//发送异步请求
					$.post("HotelDetailsServlet",data,function(relData){
						if(relData>0){
							thisA.parent().remove();
							alert("删除成功");
						}
						else{
							alert("删除失败");
						}
					})
					return true;
				}
				else{
					return false;
				}
			} 
	</script>
</html>