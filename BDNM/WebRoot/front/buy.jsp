<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String hotelId = request.getParameter("hotelid");
String roomId = request.getParameter("roomid");
int hotelid = 1;
int roomid = 1;
if(hotelId==null || hotelId.equals("")){
		hotelid = 1;
}else{
		hotelid = Integer.parseInt(hotelId);
}
if(roomId==null || roomId.equals("")){
		roomid = 1;
}else{
		roomid = Integer.parseInt(roomId);
}
request.setAttribute("hotelid", hotelid);
request.setAttribute("roomid", roomid);
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<link rel="stylesheet" type="text/css" href="css/header.css"/>
		<link rel="stylesheet" type="text/css" href="css/footer.css"/>
		<link rel="stylesheet" type="text/css" href="css/buy.css"/>
		<link rel="stylesheet" type="text/css" href="css/section/section.css"/>
       <script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
		<style>
			
		</style>
	</head>
	<body>
		<div>
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
				<table id="t1">
					<tr id="t11">
						<td id="t111">
							<a href="#">
							<img src="img/zhuye/re-logo_7c90a10.png" width="158px" height="47px">
							</a>
						</td>
						<td id="t112"><img src="img/zhuye/截图16.png">济南<img src="img/zhuye/截图18.png">
						<iframe src="city.html">
							
						</iframe>
							</td>
						<td id="t113">
							<input type="text" name="sousuo" value="搜索商家/地点" />
							<input type="image" src="img/zhuye/QQ图片20190724162410.png" 
								name="sousuo" value="sousuo" />
						</td>
						<td id="t114">
							<div>
							<a href="#"><img src="img/zhuye/截图13.png" id="im1"/></a>
							<img src="img/zhuye/截图23.png" id="im4"/>
							<a href="#"><img src="img/zhuye/截图12.png" id="im2"/></a>
							<img src="img/zhuye/截图23.png" id="im5"/>
							<a href="#"><img src="img/zhuye/截图14.png" id="im3"></a>
							</div>
						</td>
					</tr>
					<tr id="t12">
						<td colspan="4">
							<ul>
								<li><a href="#">推拿按摩全身</a><li>
								<li><a href="#">聚优惠餐饮</a><li>
								<li><a href="#">自助</a><li>
								<li><a href="#">儿童摄影</a><li>
								<li><a href="#">海鲜烧烤</a><li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<div id="hd3">
				<table id="t2" >
					<tr>
						<td id="td1"><p>全部分类<img src="img/zhuye/截图19.png"></p></td>
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
		<section>
		<input type="hidden"  name="htID"  value="${hotelid }"  id="htID" />
		<input type="hidden"  name="rmID" value="${roomid }"  id="rmID"  />
		        <div id="div1">
					
					<table border="0" cellpadding="0" cellspacing="0" style="color: red;font-family: '微软雅黑';font-weight: bold;">
						<tr>
							<td>请创建订单>></td>
							<td></td>
						</tr>
					</table>
		        </div>
			 		<hr style="height:1px;border:none;border-top:1px dashed darkgray;;" />
			 <div id="roomdiv">
			 
			 </div>
					
					<hr />
					<br />
					<div id="div9" >
					<table width="950px" height="150px">
						<tr>
							<td rowspan="2" width="210px"></td>
							<td rowspan="2"width="400px"><span style="font-size: 30px; color: #999999;" id="comCount">暂无会员评价</span></td>
							<td rowspan="2" width="20px"><img src="img/buy/QQ20190830103543.png"/></td>
							<td><span style="color: #999999;">我在百度糯米买过此单</span></td>
						</tr>
						<tr>
							<td style="vertical-align: top;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="addCommen.jsp?htId=${hotelid }">
							<img src="img/buy/QQ20190830103805.png"/></a></td>
						</tr>
					</table>
					</div>
					<br />
		</section>	
	
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
					<td><a href="#"><img src="img/zhuye/截图10(1).png"></a></td>
				</tr>
				<tr>
					<td colspan="5">
						<a href="#">
						<img src="img/zhuye/截图17(1).png">
						京公网安备 11000002000001号
						</a>
					</td>
				</tr>
			</table>
		</footer>
		</div>
	</body>
	<script>
	getRoom();
	getComCount();
	function getRoom(){
			var divA = $("#roomdiv");
			var hotelid = $("#htID").val();
			var roomid = $("#rmID").val();
			var data = "opt=findRoom&hotelid="+hotelid+"&roomid="+roomid+"";
			$.post("../HotelRoomServlet",data,function(room){
					divA.html("");
					var StrA = "<div id='div2'  style='margin-left: 150px;'><span style='font-size: 25px;'>"+room.htName+room.rmTypeName+"代金券</span>"
					+"</div><div id='div3' style='margin-left: 150px;'><span style='color: darkgray;;font-size: small;'>"+room.rmTypeIntro+"</span></div>"
					+"<div id='div4' style='margin-left: 150px;'><table height='270px'><tr><td width='350px' rowspan='3' style='vertical-align: top;'>"
					+"<img src='img/jiudian/470285.png'/> </td><td style='background-color: #FBFBFB;border-bottom: 1px solid gainsboro;'>"
					+"<table height='10px'><tr><td  rowspan='2' ></td><td rowspan='2' width='400px' ><span style='font-size: 40px; color: orangered;'>￥"
					+"<span id='price'>"+room.rmTypePrice+"</span></span></td><td rowspan='2'></td><td width='60px' style='vertical-align: bottom;'></td>"
					+"</tr></table></td></tr><tr><td width='400px' style='border-bottom: 1px solid gainsboro;'><div id='div7'>"
					+"<table><tr><td width='20px'></td><td width='100px'><a class='color'>安全</td><td width='70px'>"
					+"<img src='img/buy/QQ20190829183700.png'/></td><td width='90px'><a class='color'>舒适</a></td><td width='60px'>"
					+"<img src='img/buy/QQ20190829183700.png'/></td><td><a class='color'>干净</a></td></tr></table></div></td></tr><tr>"
					+"<td><p class='p1'></p><p class='p1'><a class='color'>数量</a><span><input type='submit' name='minus' value='-' id='minus' onclick='javascript:jian("+room.rmTypePrice+")' />"
					+"<input type='text' name='cot' value='1' id='cot' /><input type='submit' name='plus' value='+' id='plus' onclick='javascript:add("+room.rmTypePrice+")' /></span></p><p id='p2'></p>"
					+"<br /><a  id='dgjd' onclick='javascript:dingou()' >确认订购</a></td></tr></table></div><div id='divs'> "+/* (<img src='++' /> ) */" </div> ";
					divA.html(StrA);
			},"json");
	}
	
	function dingou(){
			var hotelid = $("#htID").val();
			var roomid = $("#rmID").val();
			var cot = $("#cot").val();
			location.href="../HotelRoomServlet?opt=willComOrd&hotelid="+hotelid+"&roomid="+roomid+"&cot="+cot+"";
	}
	
	function add(obj){
			var price = $("#price").html();
			var num = $("#cot").val();
			var tisi = $("#p2");
			num=eval(num+"+"+"1");
			if(num>5){
					num=5;
					tisi.html("最多订购5间");
					return;
				}else{
					tisi.html("");
				}
					$("#cot").val(num);
					$("#price").html(eval(price+"+"+obj));
			
	}
	
	function jian(obj){
			var price = $("#price").html();
			var num = $("#cot").val();
			var tisi = $("#p2");
			num=num-1;
			if(num<1){
				num=1;
				tisi.html("");
				tisi.html("最少订购1间");
				return;
			}else{
				tisi.html("");
			}
				$("#cot").val(num);
				$("#price").html(price-obj);
	}
			
			//显示评论总人数
			function getComCount(){
				var data="opt=getCount&htId="+$("#htID").val();
				$.post("../CommenServlet",data,function(relData){
					$("#comCount").html("已有"+relData+"人评论");
				},"json");
			}
			
					
	</script>
	
</html>
