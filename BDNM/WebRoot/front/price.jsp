<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link  rel="stylesheet" href="css/price.css" />
    <title>My JSP 'price.jsp' starting page</title>
    
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

  <h1>糯米钱包</h1>
		<div id="left">
			<img  id="tu" />
		</div>
		<input type="hidden" name="userId" value="${user.userId }"    id=userId /><!-- 用户ID隐藏域 -->
		<div id="right">
			<h3>您的当前余额为：<span id="money"></span>元</h3>
			<div id="form">
				<form action="../UserServlet?userSign=upBalance" method="post">
					<input type="hidden" name="userId" value="${user.userId }"  /><!-- 用户ID隐藏域 -->
					<span id="p1">老板！</span>
					<p id="p2">请输入您要充值的金额：</p>
					<input type="text" name="chongzhi"  />￥<p></p>
					<input type="submit" value="提交" />
					<input type="reset" value="重置" />
				</form>
			</div>

 </div>
  </body>
  <script type="text/javascript">
  		
			
					top["search"]. quan();
					quan2();
					function quan2(){
							var userId = $("#userId").val();
							var data = "opt=findUserCoupon&userid="+userId;
							var spanA = $("#money");
							$.post("../CouponServlet",data,function(numArr){
									spanA.html("");
									spanA.html(numArr[1]);
								if(numArr[1]>=500){
									$("#tu").attr("src","img/price/youqian.png");
								}
								if(numArr[1]<500){
									$("#tu").attr("src","img/price/meiqian.png");	
								}	
						},"json");
					}
					
	</script>
</html>
