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
		<style>
			span{color: red;}
		</style>
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	</head>
	<body>
		<form action="../UserServlet?userSign=adminAddUser" method="post">
		请输入用户名：<input type="text" name="userName" id="userName"/><br />
		<span id="user_prompt"></span>
		<p></p>
		请输入密码：&nbsp;&nbsp;&nbsp;<input type="password" name="pwd" id="pwd"/><br />
		<span id="pwd_prompt"></span>
		<p></p>
		请选择用户身份：<select name="role" id="role">
						<option value="3">管理员</option>
						<option value="2">商户</option>
						<option value="1">普通用户</option>
					</select><br />
					<p></p>
				<input type="submit" value="添加" id="btn"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置" />
		</form>			
	</body>
	<script type="text/javascript">
		$(function(){
			
			$("#btn").click(function(){
				//判断用户名
				var reg=/^[a-zA-Z0-9]{4,10}$/
				if(reg.test($("#userName").val())==true){
				$("#user_prompt").text("")
				}
				else{
				$("#user_prompt").text("用户名不能少于4位")
				return false;
				}
				//判断密码
				var regPwd=/^[a-zA-Z0-9]{4,10}$/
				if(regPwd.test($("#pwd").val())==true){
				$("#pwd_prompt").text("")
				}
				else{
				$("#pwd_prompt").text("密码不能少于4位")
				return false;
				}
			
			
			
			
			
			
			
			
			})
			
		})
	</script>
</html>
