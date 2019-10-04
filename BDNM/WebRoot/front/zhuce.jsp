<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册百度账号</title>
		<link rel="stylesheet" href="css/register.css" />
		<style>
			/*增加警告x*/
			.zhuce{
				background-image:url(img/zhuce/jietu00.png);
				background-repeat: no-repeat;
				background-position-y: 23px;
				text-indent: 18px;
			}
		</style>
		<script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<!--头部部分-->
		<div id="header">
			<div id="headerLeft">
				<a href="#"><img src="img/zhuce/jietu23.png"/><img src="img/zhuce/jietu34.png"><span id="headerspan">注册百度账号</span></a>
			</div>
			<div id="headerRight">
				<span>我已注册，现在就</span><a href="denglu.jsp"><img src="img/zhuce/jietu35.png"/></a>
			</div>
		</div>
		<hr id="hrs"/>
		
		<!--主体部分-->
		<div id="main">
			<!--主体左图-问题-->
			<div id="mainLeft"><img src="img/zhuce/robot.gif"/></div>
			<!--主体表单内容-->
			<form action="../UserServlet?userSign=userEnroll" method="post" id="formsub">
				<div id="mainCenter">
					<table id="register">
						<tr>
							<td class="main1">用户名</td>
							<td><input type="text" name="user" placeholder="请设置用户名" class="main2"/></td>
							<td id="userName">设置后不可更改<br/>中英文均可，最长14个英文或7个汉字</td>
						</tr>
						<tr>
							<td class="main1">手机号</td>
							<td><input type="text" name="phone" placeholder="可用于登录或找回密码" class="main2"/></td>
							<td id="phone">请输入中国大陆手机号，其他用户不可见</td>
						</tr>
						<tr>
							<td class="main1">密码</td>
							<td><input type="password" name="pwd" placeholder="请设置登录密码" class="main2"/></td>
							<td id="pwd"><ul type="circle"><li>长度为4~14个字符</li><li>支持数字、大小写字母和标点符号</li><li>不允许有空格</li></ul></td>
						</tr>
						<tr>
							<td class="main1">验证码</td>
							<td><input type="text" name="yanzheng" placeholder="请输入验证码" id="yz"/><a><img src="img/zhuce/jietu36.png"/></a></td>
							<td id="yanzheng"></td>
						</tr>
						<tr>
							<td></td>
							<td id="checkbox"><input type="checkbox" name="agree" />阅读并接受<a href="#">《百度用户协议》</a>及<a href="#">《百度隐私权保护声明》</a>&nbsp;&nbsp;</td>
							<td id="agree"></td>
						</tr>
						<tr>
							<td></td>
							<td  id="zc"><input type="image" src="img/zhuce/jietu37.png" id="sbt" /></td>
							<td></td>
						</tr>
					</table>
				</div>
			</form>
			<!--主体右图-帮助中心-->
			<div id="mainRight"><a href="help.jsp" target="_blank"><img src="img/zhuce/jietu38.png"/></a></div>
		</div>
		<!--底部部分-->
		<div id="footer">2019&copy;Baidu</div>
	</body>
	<script type="text/javascript">
	
	
	$(function(){
		/*边框获得和失去焦点边框变色和显示文字*/
		$("input[name='user']").focus(function(){
			$("#userName").show();
			$(this).css("outline-color","deeppink");
		}); 
		$("input[name='user']").blur(function(){
			$("#userName").hide();
		});
		$("input[name='phone']").focus(function(){
			$("#phone").show();
			$(this).css("outline-color","deeppink");
		});
		$("input[name='phone']").blur(function(){
			$("#phone").hide();
		});
		$("input[name='pwd']").focus(function(){
			$("#pwd").show();
			$(this).css("outline-color","deeppink");
		});
		$("input[name='pwd']").blur(function(){
			$("#pwd").hide();
		});
		$("input[name='yanzheng']").focus(function(){
			$(this).css("outline-color","deeppink");
		});
	});
	//表单校验
	 function checkName(){
			var user = $("input[name='user']").val();
			if(user==null || user==""){
					$("#userName").show(); 
					$("#userName").addClass("zhuce");
					$("#userName").html("请您输入用户名");
					$("#userName").css("color","red");
					return false;
			}else{
					 $("#userName").hide(); 
					$.post("../UserServlet?userSign=userNameFind","user="+user,function(da){
								if(da!="0"){
										$("#userName").addClass("zhuce");
										$("#userName").html("用户名重复");
										$("#userName").css("color","red");
										$("#userName").show();
								}else{
										$("#userName").hide();
										return false;
								}
							});
					return true;	
				}	
	}
	function checkPhone(){
			var phone = $("input[name='phone']").val();
			var regPhone=/^1\d{10}$/;
			if(phone==null || phone==""){
					$("#phone").show();
					$("#phone").addClass("zhuce");
					$("#phone").html("请您输入手机号");
					$("#phone").css("color","red");
					return false;
			}else{
					$("#phone").hide();
					if(regPhone.test(phone)==false){
						$("#phone").show();
						$("#phone").addClass("zhuce");
						$("#phone").html("手机号格式不正确");
						$("#phone").css("color","red");
						return false;
					}
					return true;
			}
	}
	
	function checkPwd(){
			var pwd = $("input[name='pwd']").val();
			if(pwd==null || pwd==""){
					$("#pwd").show();
					$("#pwd").addClass("zhuce");
					$("#pwd").html("请输入密码");
					$("#pwd").css("color","red");
					return false;
			}else{
					$("#pwd").hide();
					if(pwd.length<4){
						$("#pwd").show();
						$("#pwd").addClass("zhuce");
						$("#pwd").html("密码必须等于或大于4位数");
						$("#pwd").css("color","red");
						return false;
					}
					return true;
			}
	}
	
	function checkYanzheng(){
			var yanzheng = $("input[name='yanzheng']").val();
			if(yanzheng==null || yanzheng==""){
				$("#yanzheng").show();
				$("#yanzheng").addClass("zhuce");
				$("#yanzheng").html("请您输入验证码");
				$("#yanzheng").css("color","red");
					return false;
			}else{
					$("#yanzheng").hide();
					return true;
			}
	}
	
	function checkAgree(){
			var agree = $("input[name='agree']");
			if(agree.prop("checked")){
					$("#agree").hide();
					return true;
			}else{
					$("#agree").addClass("zhuce");
					$("#agree").html("请勾选阅读并接受百度用户协议");
					$("#agree").css("color","red");	
					$("#agree").show();
					return false;
			}
			
	} 
	
	$(function(){
			$("input[name='user']").blur(checkName);
			$("input[name='phone']").blur(checkPhone);
			$("input[name='pwd']").blur(checkPwd);
			$("input[name='yanzheng']").blur(checkYanzheng);
			$("#formsub").submit(function(){
					var flg = true;
					if(!checkName()){
							flg=false;
					}
					if(!checkPhone()){
							flg=false;
					}
					if(!checkPwd()){
							flg=false;
					}
					if(!checkYanzheng()){
							flg=false;
					}
					if(!checkAgree()){
							flg=false;
					}
					return flg;
			});
	});
	</script>
</html>

