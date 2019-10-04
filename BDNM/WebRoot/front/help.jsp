<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>百度帐号问题反馈中心</title>
		<link rel="stylesheet" href="css/register.css" />
		<script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
		<script>
			$(function(){
		  		$("#register1 tr").hover(
		  			function(){
		  				$(this).css("background-color","white");
		  				$(this).children().css("border-top","1px solid #DDDDDD");
		  				$(this).children().css("border-bottom","1px solid #DDDDDD");
		  				$(this).children().css("border-left","1px solid #4A97E3");
		  			},
		  			function(){
		  				$(this).css("background-color","#FCFCFC");
		  				$(this).children().css("border-top","none");
		  				$(this).children().css("border-bottom","none");
		  				$(this).children().css("border-left","none");
		  			}		
	  			);
	  			$("#register2").click(function(){
	  				$("#mainRight2").show();
	  			});
	  			$(".chooses input").click(function(){
	  				if($(this).is(':checked')){
	  					$(this).parent().parent().find("div").hide();
	  					$(this).parent().next().show();	
	  					
	  				}
	  			});
			})
		</script>
	</head>
	<body>
		<!--帮助中心头部-->
		<div id="header1"><img src="img/zhuce/jietu001.png"/></div>
		
		<!--帮助中心主体-->
		<div id="main1">
			<div id="mainLeft"><a href="#"><img src="img/zhuce/robot.gif"/></a></div>
			<div id="mainCenter1">
				<h4 style="text-align: center;padding-top: 30px;">帐号反馈中心</h4>
				<table id="register1">
					<tr>
						<td id="register2">&gt;&nbsp;注册</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;登录</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;帐号注销</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;解换绑</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;冻结/解冻/封禁</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;帐号保护</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;身份认证</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;帐号申诉</td>
					</tr>
					<tr>
						<td>&gt;&nbsp;其他</td>
					</tr>
				</table>
			</div>
			<div  id="mainRight2">
				<h4>注册百度帐号时遇到问题了？</h4>
				<p class="chooses"><input type="radio" name="choose"/>&nbsp;&nbsp;&nbsp;如何注册百度帐号？ </p>
				<div class="question">您可以在PC端点击【登录】-【立即注册】根据提示注册百度帐号。</div>
				<p  class="chooses"><input type="radio" name="choose"/>&nbsp;&nbsp;&nbsp;新办理的手机已被注册，使用手机登录时提示因安全原因被封禁，怎么办？ </p>
				<div class="question">
					请您发送邮件至pass_help@baidu.com.请在邮件内提供以下信息<br />
					手机号码：<br />
					号码开始使用时间：<br />
					报错截图：<br />
					问题详细描述：<br />
				</div>
				<p class="chooses"><input type="radio" name="choose"/>&nbsp;&nbsp;&nbsp;注册时，提示用户名已被使用，怎么办？ </p>
				<div class="question">亲爱的百度用户，百度帐号用户名是唯一的，不可重复设置，且设置成功后无法修改，建议您编辑其他名称设置用户名。</div>
				<p class="chooses"><input type="radio" name="choose"/>&nbsp;&nbsp;&nbsp;手机号已注册百度帐号，如何重新注册百度帐号？ </p>
				<div class="question">
					您使用新购买的手机号登录时提示已注册帐号，选择登录时选择【以上都不是，重新注册】即可，如没有【重新注册】选项，请<br/>
					您发送邮件至pass_help@baidu.com.请在邮件内提供以下信息<br/>
					用户名：<br/>
					注册时间：<br/>
					注册地点：<br/>
					注册手机号码：<br/>
					注册邮箱：<br/>
					历史绑定手机号码：<br/>
					历史绑定邮箱：<br/>
					实名信息：<br/>
					历史实名信息：<br/>
					报错截图：<br/>
					问题详细描述：<br/>
				</div>
			</div>
		</div>
		<!--帮助中心底部-->
		<div id="footer">2019&copy;Baidu</div>
	</body>
</html>

