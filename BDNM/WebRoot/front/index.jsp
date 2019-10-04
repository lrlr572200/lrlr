<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<link type="text/css" rel="stylesheet" href="css/header.css" />
		<link type="text/css" rel="stylesheet" href="css/section.css" />
		<link type="text/css" rel="stylesheet" href="css/footer.css" />
		
	</head>
	<body>
		<!--头部-->
		<header>
			<div id="hd1">
				<ul>
					<li>Hi，欢迎来到百度糯米</li>
					<c:if test="${user==null }">
					<li><a href="denglu.jsp">请登录</a></li>
					<li id="hi3"><a href="zhuce.jsp">免费注册</a></li>
					</c:if>
					<c:if test="${user!=null }">
					<li>尊敬的用户<a>${user.userName }</a>您好</li>
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
				<table id="t1">
					<tr id="t11">

						<td id="t111">
							<a href="#">
							<img src="img/zhuye/re-logo_7c90a10.png" width="158px" height="47px">
							</a>
						</td>
						<td id="t112"><img src="img/zhuye/jietu16.png">济南<img src="img/zhuye/jietu18.png">
						<iframe src="city.jsp">
							
						</iframe>
							</td>
						<td id="t113">
							<input type="text" name="sousuo" value="搜索商家/地点" />
							<input type="image" src="img/zhuye/QQtupian20190724162410.png" 
								name="sousuo" value="sousuo" />
						</td>
						<td id="t114">
							<div>
							<a href="#"><img src="img/zhuye/jietu13.png" id="im1"/></a>
							<img src="img/zhuye/jietu23.png" id="im4"/>
							<a href="#"><img src="img/zhuye/jietu12.png" id="im2"/></a>
							<img src="img/zhuye/jietu23.png" id="im5"/>
							<a href="#"><img src="img/zhuye/jietu14.png" id="im3"></a>
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
						<td id="td1"><p>全部分类<img src="img/zhuye/jietu19.png"></p></td>
						<td id="td2">
							<ul>
								<li><a href="index.jsp">首页</a></li>
								<li><a href="hotel.jsp">酒店</a></li>
								<li><a href="#">出行<img src="img/zhuye/jietu11.png"></a></li>
								<li><a href="#">电影<img src="img/zhuye/jietu15.png" id="img1"></a></li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</header>
		<!--正文-->
		<section>
			<div id="s1">
				<div id="left">
					<table id="t3" border="0" cellspacing="0">
						<tr id="t31" >
							<td class="left" id="l1"><a>酒店</a></td>
							<td class="right"><a >济南</a>&nbsp;/&nbsp;<a >北京</a>&nbsp;/&nbsp;<a >上海</a></td>
						</tr>
						<tr id="t32">
							<td class="left" id="l2"><a >电影</a></td>
							<td class="right"><a >看电影</a>&nbsp;/&nbsp;<a >找影院</a></td>
						</tr>
						<tr id="t33">
							<td class="left" id="l3"><a >美食</a></td>
							<td class="right"><a >小吃快餐</a>&nbsp;/&nbsp;<a >自助餐</a>&nbsp;/&nbsp;<a >火锅</a></td>
						</tr>
						<tr id="t34">
							<td class="left" id="l4"><a >休闲娱乐</a></td>
							<td class="right"><a >游乐园</a>&nbsp;/&nbsp;<a >水上乐园</a></td>
						</tr>
						<tr id="t35">
							<td class="left" id="l5"><a >生活服务</a></td>
							<td class="right"><a >配镜</a>&nbsp;/&nbsp;<a >鲜花</a></td>
						</tr>
						<tr id="t36">
							<td class="left" id="l6"><a >丽人</a></td>
							<td class="right"><a >美发</a>&nbsp;/&nbsp;<a >美容SPA</a>&nbsp;/&nbsp;<a >美甲</a></td>
						</tr>
						<tr id="t37">
							<td class="left" id="l7"><a >亲子</a></td>
							<td class="right"><a >早教</a>&nbsp;/&nbsp;<a >儿童摄影</a></td>
						</tr>
						<tr id="t38">
							<td class="left" id="l8"><a >健康养生</a></td>
							<td class="right"><a >足疗按摩</a>&nbsp;/&nbsp;<a >运动健身</a></td>
						</tr>
					</table>
				</div>
				<div id="right">
					<table id="t4" >
						<tr id="t41">
							<td rowspan="2" >
								<iframe src="ifream/moren.html"></iframe>
							</td>
							<td id="t412">
								<img src="img/zhuye/right-banner-new_450c41c.jpg" width="253px"/>
							</td>
						</tr>
						<tr id="t42">
							<td id="t421">
								<img src="img/zhuye/jietu00.png" width="253px" />
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="s2">
				<table  id="t5">
					<tr>
						<td id="t511">热映电影</td>
						<td id="t512"><span><a href="#">看影片</a></span>/
							<span><a href="#">找影院</a></span>/
							<span><a href="#">看票房</a></span> 
							<a href="#">查看全部&nbsp;<img src="img/zhuye/jietu21.png"></a>
						</td>
					</tr>
				</table>
			<a href="#">	
				<div class="film" id="fi1"><img src="img/zhuye/jietu01.png" class="c1"/>
					<p>哪吒之魔童降世</p>
					<div><img src="img/zhuye/jietu07.png" class="c2"/></div>
				</div>
			</a>	
			<a href="#">
				<div class="film" id="fi2"><img src="img/zhuye/jietu05.png" class="c1"/>
					<p>烈火英雄</p>
					<div><img src="img/zhuye/jietu07.png"  class="c2"/></div>
				</div>
			</a>
			<a href="#">
				<div class="film" id="fi3"><img src="img/zhuye/jietu48.png" class="c1"/>
					<p>使徒行者2：谍影行动</p>
					<div><img src="img/zhuye/jietu07.png"  class="c2"/></div>
				</div>
			</a>
			<a href="#">
				<div class="film" id="fi4"><img src="img/zhuye/jietu24.png"  class="c1"/>
					<p>鼠胆英雄</p>
					<div><img src="img/zhuye/jietu07.png"  class="c2"/></div>
				</div>
			</a>
			<a href="#">
				<div class="film" id="fi5"><img src="img/zhuye/jietu25.png"  class="c1"/>
					<p>上海堡垒</p>
					<div><img src="img/zhuye/jietu07.png"  class="c2"/></div>
				</div>
			</a>
			<a href="#">
				<div class="film" id="fi6"><img src="img/zhuye/jietu26.png"  class="c1"/>
					<p>古田军号</p>
					<div><img src="img/zhuye/jietu07.png"  class="c2"/></div>
				</div>
			</a>	
				<hr />
			</div>
			<div id="s3">
				<table  id="t6">
					<tr>
						<td id="t611">休闲娱乐</td>
						<td id="t612"><span><a href="#">KTV</a></span>/
							<span><a href="#">足浴按摩</a></span>/
							<span><a href="#">轰趴馆</a></span>/
							<span><a href="#">运动健身</a></span> 
							<a href="#">查看全部&nbsp;<img src="img/zhuye/jietu21.png"></a>
						</td>
					</tr>
				</table>
			<a href="#">
				<div class="xiuxian">
					<img src="img/zhuye/jietu28.png" class="c1">
					<p class="p1">DTZ健身工作室<div class="d2">1条评论</div></p>
					<p class="p2"><img src="img/zhuye/jietu35.png"><div class="d2">已售2</div></p>
					<p class="p3">运动健身&nbsp;|&nbsp;甸柳新村</p>
					<p class="p4">暂无</p>
				</div>
			</a>
			<a href="#">
				<div class="xiuxian">
					<img src="img/zhuye/jietu29.png" class="c1">
					<p class="p1">好声音量贩KTV(解放东路店)<div class="d2">94条评论</div></p>
					<p class="p2"><img src="img/zhuye/jietu34.png" ><div class="d2">已售161</div></p>
					<p class="p3">KTV&nbsp;|&nbsp;解放东路</p>
					<p class="p4">￥60/人</p>
				</div>
			</a>
			<a href="#">
				<div class="xiuxian">
					<img src="img/zhuye/jietu30.png" class="c1">
					<p class="p1">美斯足浴<div class="d2">暂无评论</div></p>
					<p class="p2"><img src="img/zhuye/jietu34.png" ></p>
					<p class="p3">足疗按摩&nbsp;|&nbsp;联四路</p>
					<p class="p4">暂无</p>
				</div>
			</a>
			<a href="#">
				<div class="xiuxian">
					<img src="img/zhuye/jietu31.png" class="c1">
					<p class="p1">迷城真人密室逃脱<div class="d2">149条评论</div></p>
					<p class="p2"><img src="img/zhuye/jietu34.png" ><div class="d2">已售75</div></p>
					<p class="p3">&nbsp;|&nbsp;泉城广场</p>
					<p class="p4">￥61/人</p>
				</div>
			</a>	
			<a href="#">
				<div class="xiuxian">
					<img src="img/zhuye/jietu32.png" class="c1">
					<p class="p1">都唛KTV(长清店)<div class="d2">70条评论</div></p>
					<p class="p2"><img src="img/zhuye/jietu33.png" ><div class="d2">已售785</div></p>
					<p class="p3">KTV&nbsp;|&nbsp;长清大学城</p>
					<p class="p4">￥59/人</p>
				</div>
			</a>	
				<hr />
			</div>
			<div id="s4">
				<table id="t7"><tr><td>热门商场</td></tr></table>
				<table id="t8" width="1212px">
					<tr>
						<td class="L1"><a href="#">恒隆广场</a></td>
						<td class="L2"><a href="#">美莲广场</a></td>
						<td class="L3"><a href="#">泉城广场</a></td>
						<td class="L4"><a href="#">贵和商厦</a></td>
						<td class="L5"><a href="#">优品汇奥特莱斯购物广场</a></td>
					</tr>
					<tr>
						<td class="L1"><a href="#">贵和购物中心(泉城路店)</a></td>
						<td class="L2"><a href="#">世茂国际广场</a></td>
						<td class="L3"><a href="#">联荷雨滴商业广场</a></td>
						<td class="L4"><a href="#">丁豪广场</a></td>
						<td class="L5"><a href="#">振华商厦</a></td>
					</tr>
					<tr>
						<td class="L1"><a href="#">万达广场</a></td>
						<td class="L2"><a href="#">银座商城(玉函店)</a></td>
						<td class="L3"><a href="#">和谐广场</a></td>
						<td class="L4"><a href="#">嘉华购物商场</a></td>
						<td class="L5"></td>
					</tr>
				</table>
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
					<td><a href="#"><img src="img/zhuye/jietu10.png"></a></td>
				</tr>
				<tr>
					<td colspan="5">
						<a href="#">
						<img src="img/zhuye/jietu17.png">
						京公网安备 11000002000001号
						</a>
					</td>
				</tr>
			</table>
		</footer>
	</body>
	
	
	<script type="text/javascript">
			var iniTop;//初始高度
		window.onload=function()
		{
			var divad=document.getElementById("hd0");
			iniTop=divad.offsetTop;
//			alert("iniTop="+iniTop);
		}
//		给window对象绑定onscroll事件 
//		匿名函数
		window.onscroll=function()
		{
			var divad=document.getElementById("hd0");
			var scorllTop=document.documentElement.scrollTop || document.body.scrollTop;
			divad.style.top=iniTop+scorllTop+"px";
//			alert(scorllTop);
		}
		
		
		
		
		$("#t31,#t37,#t38").mouseenter(function(){
			$("iframe")[1].src="ifream/moren.html"
		})//悬浮酒店
		$("#t32").mouseenter(function(){
			$("iframe")[1].src="ifream/2.DianYing.html"
		})//悬浮电影
		$("#t33").mouseenter(function(){
			$("iframe")[1].src="ifream/3.MeiShi.html"
		})//悬浮美食
		$("#t34").mouseenter(function(){
			$("iframe")[1].src="ifream/4.XiuXianYuLe.html"
		})//悬浮休闲娱乐
		$("#t35").mouseenter(function(){
			$("iframe")[1].src="ifream/5.ShengHuoFuWu.html"
		})//悬浮生活服务
		$("#t36").mouseenter(function(){
			$("iframe")[1].src="ifream/6.LiRen.html"
		})//悬浮丽人
		$("section>div").mouseleave(function(){
			$("iframe")[1].src="ifream/moren.html"
		})//离开悬浮酒店
		
	</script>
</html>
