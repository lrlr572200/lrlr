<%@page import="com.BDNM.entity.User"%>
<%@page import="com.BDNM.service.impl.UserServiceImpl"%>
<%@page import="com.BDNM.service.UserService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户列表</title>
	<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
	<script type="text/javascript" src="front/js/jquery-1.12.4.js" ></script>
	<style type="text/css">
		table  tr{width: 120%;}
		table  td{padding-left: 20px;padding-top: 6px}
	</style>
  </head>
 <body>
	  <form action="<%=request.getContextPath() %>/UserServlet?userSign=getUserPaging" method="post">
		   <input type="hidden" id="curPage" name="curPage" value="${pageSurpport.pageIndex}"/>
	  </form>	
	  <h2>用户列表</h2>
	   <table>
	   	<tr>
	   		<td>用户名</td>
	   		<td>密码</td>
	   		<td>手机号</td>
	   		<td>邮箱</td>
	   		<td>性别</td>
	   		<td>姓名</td>
	   		<td>用户类别</td>
	   		<td>余额</td>
	   		<td>优惠劵</td>
	   	</tr>
	  	<c:forEach items="${pageSurpport.dataList }" var="user" varStatus="status">
	   	<tr>
	   		<td>${user.userName }</td>
	   		<td>${user.password }</td>
	   		<td>${user.phone }</td>
	   		<td>${user.email }</td>
	   		<td>${user.sex  }</td>
	   		<td>${user.name }</td>
	   		<td>${user.userTypeId }</td>
	   		<td>${user.balance }</td>
	   		<td>${user.couponNum }</td> 
	   		<td><a href="#" onclick="return del(${user.userId })"  id="del${user.userId }">[删除]</a></td>
	   	</tr>
	    <c:if test="${status.count%3 ==0 }">
	     	   <tr>
	     	   	<td colspan="11"></td>
	     	   </tr>
	    </c:if>
    </c:forEach>
    </table>
    <p align="right"> 当前页数:[${pageSurpport.pageIndex }/${pageSurpport.pageCount }]&nbsp; 
     <c:if test="${pageSurpport.pageIndex>1 }">
     	<a href="javascript:pageNav(1) ">首页</a> 
     	<a href="javascript:pageNav(${pageSurpport.pageIndex-1 })">上一页</a>
     </c:if>
     <c:if test="${pageSurpport.pageIndex<pageSurpport.pageCount }">
     	<a href="javascript:pageNav(${pageSurpport.pageIndex+1 })">下一页</a> 
     	<a href=" javascript:pageNav(${pageSurpport.pageCount }) ">末页</a>
     </c:if>   
    <input type="hidden" id="pageCount" value="${pageSurpport.pageCount }"/>
     <input type="text" id="num" name="num" />
     <input type="button" value="GO" onclick="btnGo();"/>
     </p>
    <script type="text/javascript">
    	//提交表单
       function pageNav(num)
       {
           document.forms[0].curPage.value=num;
           document.forms[0].submit();
       }
      function btnGo(){
      	var num=document.getElementById("num").value;
      	var pagecount=document.getElementById("pageCount").value;
      	var rex=/^[1-9]\d*$/; 
      	if(!rex.test(num))
      	{
      	    alert("您输入的不是数字！");
      	    return ;
      	}
      	if(num>pagecount)
      	{
      	    alert("您输入的页索引大于了总页数！");
      	    return ;
      	}
      	pageNav(num);
      }
    //删除数据--异步删除
	function del(userId){
		if(confirm("是否删除？"))
		{
			var thisA=$("#del"+userId);
			var data="userSign=deleteUser&userId="+userId;
			//发送异步请求
			$.post("UserServlet",data,function(relData){
				if(relData>0){
					thisA.parent().parent().remove();
					alert("删除成功");
					
				}
				else{
					alert("删除失败");
				}
			},"json");
			return true;
		}
		else{
			return false;
		}
	} 
    </script> 
  </body>
</html>
