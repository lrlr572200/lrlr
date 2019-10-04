<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String htId=request.getParameter("htId");
	request.setAttribute("htId",htId);
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/comment/comment.css"/>
	</head>
	<body>
		<div id="div1">
			<table>
				<tr>
					<td width="100px"></td>
					<td width="600px"><a id="s1">济南</a>
					<a href="#" style="text-decoration: none; color: #73ABC9;font-size: 13px;">&nbsp;&nbsp;[切换城市]</a></td>
					<td width="105px"></td>
					<td width="20px"><img src="img/comment/QQ20190830120734.png"/></td>
					<td width="70px"><a class="s1" href="#">我的订单</a></td>
					<td width="15px"><img src="img/comment/QQ20190830120734.png"/></td>
					<td width="75px"><a class="s1" href="#">&nbsp;我的糯米</a><div id="me"><img src="img/comment/QQ20190830150006.png"/></div></td>
					<td width="10px"><img src="img/comment/QQ20190830120734.png"/></td>
					<td><a class="s1" href="#">退出</a></td>
				</tr>
			</table>
		</div>
	<form action="../CommenServlet?opt=addCommen" method="post">
		<div id="div2">
			<div id="div3">
				<table style="background-color: #FF4400;">
					<td width="150px" height="35px" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: white;">评价宝贝</span></td>
				</table>
			</div>
			<div id="buyer">
				<table>
					<tr>
						<td></td>
						<td style="text-align: right;">	买家ID：<input type="text" name="userId" value="${user.userId }" readonly="readonly"/></td>
					</tr>
				</table>
				<input type="hidden" name="htId"  value="${htId }">
				</div>
		</div>
		<div id="div4">
			<table>
				<tr >
					<td rowspan="3" width="400px">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="img/comment/7d67bb139b1a4a45847e6251641c1260.gif"/>
					</td>
				</tr>
				<tr>
					<td>
						<span style="font-size: 25px; color: mediumvioletred;">
							请评论~
						</span>
						<textarea name="comText" rows="14" cols="50" placeholder="亲，写点评价吧！您的期望，我们的追求！" style="font-size: 15px;"></textarea>
					</td>
				</tr>
			</table>
			<div>
			<span style="font-size: 15px; color: brown;">请评分：</span>
			<input type="radio" name="radio" value="1"/>1分
			<input type="radio" name="radio" value="2"/>2分
			<input type="radio" name="radio" value="3"/>3分
			<input type="radio" name="radio" value="4"/>4分
			<input type="radio" name="radio" value="5"/>5分
			</div>
			<div id="publish">
			<input type="image" src="img/comment/QQ20190904153009.png" />
			</div>
	</form>			
			<table id="table1">
					<tr>
						<td>
							<a href="#" style="font-size: 12px;" class="a">关于百度糯米</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/comment/截图33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a">常见问题</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/comment/截图33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a">违规投诉</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/comment/截图33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a">开放平台</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/comment/截图33.png" />&nbsp;&nbsp;</td>
						<td>
							<a href="#" style="font-size: 12px;" class="a">用户协议</a>
						</td>
						<td>&nbsp;&nbsp;<img src="img/comment/截图33.png" />&nbsp;&nbsp;</td>
						<td>
							<a style="font-size: 12px;">客服电话：<span style="color: hotpink;">400-9216-66</span>&nbsp;&nbsp;(每天9:00-22:00)</a>
						</td>
					</tr>
				</table>
				<table id="table2">
						<tr>
							<td><span style="color: #DBDBDB;font-size:11px;">©2015&nbsp;&nbsp;&nbsp;&nbsp;nuomi.com&nbsp;&nbsp;&nbsp;&nbsp;京ICP证030173号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;京公网安备11010802014106号</span></td>
						</tr>
				</table>

	</body>
</html>
