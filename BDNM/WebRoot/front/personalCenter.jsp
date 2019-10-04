<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>百度糯米——个人中心</title>
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/personalCenterCSS.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
	</head>
	<body>
		<div> <!--整体盒子-->
		
		<!--个人中心头部-->
		<header>
			<div id="hd1">
				<ul>
					<li>Hi，欢迎来到百度糯米</li>
					<c:if test="${user==null }">
					<script>
					alert("请先登录！");
					location.replace("index.jsp");
					</script>
					</c:if>
					<c:if test="${user!=null }">
					<li><a>${user.userName }</a>您好</li>
					<li id="hi3"><a href="../UserServlet?userSign=userlogout">注销</a></li>
					</c:if>
					<li><a href="personalCenter.jsp">个人中心</a></li>
					<li id="i5"><a href="#">最近浏览<img src="img/zhuye/jietu11.png"></a></li>
					<li><img src="img/zhuye/jietu22.png"></li>
					<li><a href="#">糯米APP<img src="img/zhuye/jietu11.png"></a></li>
					<li id="i7"><a href="#">我是商家<img src="img/zhuye/jietu11.png"></a></li>
					<li><img src="img/zhuye/jietu22.png"></li>
					<li><a href="help.jsp">帮助中心</a></li>
					<li><a href="#">食品安全</a></li>
				</ul>
			</div>
			<div id="hd2">
				<table id="t1" >
					<tr id="t11">

						<td id="t111">
							<a href="#">
							<img src="commonImg/zhuye/re-logo_7c90a10.png" width="158px" height="47px">
							</a>
						</td>
						<td id="t112"><img src="commonImg/zhuye/jietu16.png">济南<img src="commonImg/zhuye/jietu18.png">
						<iframe  src="city.jsp" >
							
						</iframe>
							</td>
						<td id="t113">
							<input type="text" name="sousuo" value="搜索商家/地点" />
							<input type="image" src="commonImg/zhuye/QQtupian20190724162410.png" 
								name="sousuo" value="sousuo" />
						</td>
						<td id="t114">
							<div>
							<a href="#"><img src="commonImg/zhuye/jietu13.png" id="im1"/></a>
							<img src="commonImg/zhuye/jietu23.png" id="im4"/>
							<a href="#"><img src="commonImg/zhuye/jietu12.png" id="im2"/></a>
							<img src="commonImg/zhuye/jietu23.png" id="im5"/>
							<a href="#"><img src="commonImg/zhuye/jietu14.png" id="im3"></a>
							</div>
						</td>
					</tr>
					<tr id="t12">
						<td colspan="4">
							<ul>
								<li><a href="#">推拿按摩全身</a></li>
								<li><a href="#">聚优惠餐饮</a></li>
								<li><a href="#">自助</a></li>
								<li><a href="#">儿童摄影</a></li>
								<li><a href="#">海鲜烧烤</a></li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<div id="hd3">
				<table id="t2" >
					<tr>
						<td id="td1"><p>全部分类<img src="commonImg/zhuye/jietu19.png"></p></td>
						<td id="td2">
							<ul>
								<li><a href="index.jsp">首页</a></li>
								<li><a href="hotel.jsp">酒店</a></li>
								<li><a href="#">出行<img src="commonImg/zhuye/jietu11.png"></a></li>
								<li><a href="#">电影<img src="commonImg/zhuye/jietu15.png" id="img1"></a></li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</header>
	
	
	
		<!--个人中心主体部分-->
		<section id="personal-center-section">
			<input type="hidden"   name="userId"  value="${user.userId }"  id="userId"  />
			<!--个人中心主体部分上部-->
			<div id="perCen-secTop">
				
				<!--左部-->
				<div id="perCen-secTop-left">
					<span>尊敬的用户</span>
					<span>${user.userName }</span>
					<span>（ID: ${user.userId }）</span>
					<span>您好！</span>
					<span >欢迎登录</span>
				</div>
				
				<!--右部-->
				<div id="perCen-secTop-right">
					<span>我的余额</span>
					<span class="RMB">¥</span>
					<span class="balance" id="balanA"></span>
					<span>&nbsp;|&nbsp;</span>
					<span>优惠券</span>
					<span class="balance" id="couponA">
					
					</span>
					<span class="RMB">元</span>
				</div>
			</div>
			
			
			<!--个人中心主体部分下部-->
			<div id="perCen-secBottom">
				
				<!--左部-->
				<div id="perCen-secBot-left">
					<div id="list1">
						
						<dl>
							<dt class="menu0">我的订单</dt>
							<dd>
								<ul>
									<li class="menuList0"><span>•</span>团购订单</li>
									<li class="menuList"><span>•</span>储值卡</li>
									<li class="menuList"><span>•</span>物流单</li>
									<li class="menuList"><span>•</span>电影选座</li>
								</ul>
							</dd>
							<dt class="menu">我的评价</dt>
							<dd>
								<ul>
									<li class="menuList"><span>•</span>待评价</li>
									<li class="menuList"><span>•</span>已评价</li>
								</ul>
							</dd>
							<dt class="menu">我的收藏</dt>
							<dt class="menu">我的账户</dt>
							<dd>
								<ul>
									<li class="menuList"><span>•</span>账户设置</li>
									<li class="menuList"><span>•</span>余额充值</li>
									<li class="menuList"><span>•</span>优惠券</li>
									<li class="menuList"><span>•</span>百度钱包余额</li>
								</ul>
							</dd>
						</dl>
					</div>
					<div id="list2">
						<p>客服电话</p>
						<p>400-9216-666</p>
						<p>
							<span>国内通话报销话费</span><br />
							<span>周一至周日 9:00-22:00</span>
						</p>
						<div></div>
					</div>
				</div>
				
				<!--右部-->
				<div id="perCen-secBot-right">
					
					<!--右部中间-->
					<div id="perCen-secBot-right-page">
						
						<!--右部分中间    团购订单页面-->
						<div id="group-buy">
							<iframe src="groupBuy.jsp" width="100%" height="100%" name="mframe">
								
								
							</iframe>
							<iframe src="orderDetails.jsp" width="100%" height="100%" >
								
								
							</iframe>
							
						</div>
						<!--本功能暂未开通页面-->
						<div id="not-open">
							<p>此功能暂未开通，敬请期待.....</p>
							
						</div>
						<div id="show-price">
							<iframe src="price.jsp" width="100%" height="100%"  id="price" >
							</iframe>
						</div>
						
					</div>
				</div>
			</div>
			
		</section>
		
		
		
		<!--底部-->
		<footer>
			<table id="tf"  width="1212px">
				<tr>
					<td>用户帮助</td>
					<td>手机百度助手</td>
					<td>商务合作</td>
					<td>公司信息</td>
					<td>400-9216-666</td>
				</tr>
				<tr>
					<td><a href="#">常见团购问题</a></td>
					<td><a href="#">百度糯米触屏版</a></td>
					<td><a href="#">友情链接</a></td>
					<td><a href="#">关于百度糯米</a></td>
					<td>周一至周日 9:00-22:00</td>
				</tr>
				<tr>
					<td><a href="#">开放API</a></td>
					<td><a href="#">下载手机版</a></td>
					<td><a href="#">市场合作</a></td>
					<td><a href="#">百度糯米新浪微博</a></td>
					<td>客服电话 免长途费</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="#">业务投诉</a></td>
					<td><a href="#"><img src="commonImg/zhuye/jietu10.png"></a></td>
				</tr>
				<tr>
					<td colspan="5">
						<a href="#">
						<img src="commonImg/zhuye/jietu17.png">
						京公网安备 11000002000001号
						</a>
					</td>
				</tr>
			</table>
		</footer>
		
		
		</div>
		
		
	</body>
	<script type="text/javascript" src="js/personalCenterJS.js" ></script>
	
	<script type="text/javascript">
					top["search"] = window;
					quan();
					function quan(){
							var userId = $("#userId").val();
							var data = "opt=findUserCoupon&userid="+userId;
							var spanA = $("#couponA");
							var spanB = $("#balanA");
							$.post("../CouponServlet",data,function(numArr){
									spanB.html("");
									spanA.html("");
									spanA.html(numArr[0]);
									spanB.html(numArr[1]);
							},"json");
					}
					
	$(function(){
		$("#perCen-secBot-right-page>#show-price").hide();
	});
	
	
	/* function del(obj){
		var flg = confirm("是否确认注销账户？");
		if(flg){
			location.href="../UserServlet?userSign=delUser&userid="+obj ;
		}
	} */
	
	</script>
</html>

