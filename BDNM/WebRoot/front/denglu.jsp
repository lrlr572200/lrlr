<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>百度糯米</title>
		
		<script type="text/javascript" src="js/jquery-1.12.4.js">
		</script>
		<link rel="stylesheet" type="text/css" href="css/denglu.css"/>
	</head>

	<body>
		<div id="div">
			<div id="up">
				<table>
					<tr>
						<td><img id="t1" src="img/denglu/jietu23.png"></td>
						<td id="p" width="100px"><img id="t2" src="img/denglu/jietu31.png" height="25px">&nbsp;&nbsp;&nbsp;<span>登录</span></td>

						<td align="right" width="700px">
							<a id="sz1">还没有百度糯米账号</a>
						</td>
						<td>
							<a href="zhuce.jsp"><img src="img/denglu/jietu32.png"></a>
						</td>
					</tr>
				</table>
			</div>

			<div id="middle">

				<div id="left">
					<img src="img/denglu/jietu24.png" />
				</div>
				<div id="right">
				<form action="../UserServlet?userSign=userlogin" method="post">
					<table height="355px" width="300px" border="0" cellpadding="0" cellspacing="0" >
						<tr >
							<td>&nbsp;&nbsp;&nbsp;<span style="font-size: 17px; color: #666666;" id="dl"><strong>登录百度糯米</strong></span></td>
						</tr>
						<tr>
							<td id="imga">
								<span style="font-size: 13px;"><a href="#" id="a1">短信快捷登录</a></span></td>
						</tr>
						<tr style="margin-bottom: 30px;">
							<td id="imgb"><div><input type="text"  name='name'  id="text" placeholder="用户名" style="color: #DBDBDB;" /></div>
							</td>
						</tr>
						<tr style="margin-top: 10px;">
							<td id="imgc"><div><input type="password"  name='pwd'  id="password"  placeholder="密码"></div>
							</td>
						</tr>
						
						<tr>
							<td id="macc">
								<div>
								<input type="checkbox" value="下次自动登录" id="xz" checked="checked">
								下次自动登录
								</div>
								<div>
								<a href="#"><span style="font-size: 12px;" id="a2">登录遇到问题</span></a>
								</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;
								<a href="#">
								<input type="image" src="img/denglu/jietu25.png" />
								</a>
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;
								<a href="#"><img src="img/denglu/jietu27.png" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="#"><img src="img/denglu/jietu28.png" /></a>
							</td>
						</tr>
					</table>
					</form>
				</div>
			</div>
			<div id="down">
				<table id="table1">
					<tr>
						<td>
							<a href="#" style="font-size: 12px;" class="a3">关于百度糯米</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/denglu/jietu33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a3">常见问题</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/denglu/jietu33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a3">违规投诉</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/denglu/jietu33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a3">开放平台</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/denglu/jietu33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a3">用户协议</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/denglu/jietu33.png" />&nbsp;&nbsp;</td>
						<td>
							<a style="font-size: 12px;">客服电话：<span style="color: hotpink;">400-9216-66</span>&nbsp;&nbsp;(每天9:00-22:00)</a>
						</td>
					</tr>
				</table>
				<table id="table2">
						<tr>
							<td><span style="color: #DBDBDB;font-size:11px;">©2015&nbsp;&nbsp;nuomi.com&nbsp;&nbsp;京ICP证030173号&nbsp;&nbsp;&nbsp;京公网安备11010802014106号</span></td>
						</tr>
				</table>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(function() {
			$("input[id='text']").focus(function() {
				$("#text").css("outline-color", "deeppink")
			});
			$("#text").blur(function() {
				$("#text").css("outline-color", "gainsboro")
			});
			$("input[id='password']").focus(function() {
				$("#password").css("outline-color", "deeppink")
			});
			$("#password").blur(function() {
				$("#password").css("outline-color", "gainsboro")
			});
			
		});
		
	</script>

</html>