<%@page import="java.net.URLDecoder"%>
<%@page import="com.BDNM.entity.OrdercopView"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

String orderid = request.getParameter("orderID");
String htname = request.getParameter("htname");
String ordid = "0";
if(orderid!=null && !orderid.equals("")){
		ordid=orderid;
}
request.setAttribute("ordid", ordid);
request.setAttribute("htname", htname);
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>百度糯米</title>
		<link rel="stylesheet" href="css/orderDetails.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
	</head>
	<body>
		<div id="headerBuy">
			<h2>订单详情</h2>
			<a href="groupBuy.jsp" id="buyA">返回订单列表</a>
			<hr align="left"/>
		</div>
		<input type="hidden"  name="ordeID" value="${ordid }"  id="ids" />
		<input type="hidden"  name="htname"  value="<%=htname %>"  id="ht"  />
		<div id="buyMain1" >
		
		</div>
		<div id="buyMain2">
			
		</div>
		
		<div id="buyMain3">
			
		</div>
		<div id="footerBuy">
			<!-- <p>糯米券</p>
			<hr />
			<p>糯米券密码：9848 1246 2618 已使用</p> -->
		</div>
		<script type="text/javascript">
		
		
		
		var bydiv=$("#buyMain1");
		var diyB = $("#buyMain2");
		var diyC=$("#buyMain3");
		$(function(){
				var orid = $("#ids").val();
						bydiv.html("");
						diyB.html("");
						diyC.html("");
				if(orid==0){
						bydiv.html("<p>没有该订单</p>");
				}else{
						 getOrd(orid);
						 getOrdDet(orid);
				}
		});
				
				
				function getOrd(obj){
						var data="orderSign=theOrder&ordid="+obj;
						$.post("../OrderServlet",data,function(ord){
								var StrA ="";
								var StrB = "";
								if(ord!=null){
										StrA="<p>当前状态：<span>"+ord.state+"</span>&nbsp;&nbsp;&nbsp;"
										+"<img src='img/zhuce/jietu113.png'/></p><p>温馨提示：百度糯米独家诚信担保"
										+"，未消费，<a>随便退</a></p>";
										StrB="<p>订单信息</p><hr /><table><tr><td>订单编号："+ord.orderNum+"</td>"
										+"<td>下单时间："+ord.subtime+"</td></tr><tr><td>付款方式：余额支付</td>"
										+"<td>付款时间："+ord.checkTime+"</td></tr></table>";
										bydiv.html(StrA);
										diyB.html(StrB);
								}else{
										bydiv.html("<p>没有该订单</p>");
								}
						},"json");
				}
				
				function getOrdDet(obj){
						var hotelname = $("#ht").val();
						var data="ordDetSign=showOrdDet&orderNum="+obj;
						var StrC="";
						$.post("../OrderDetailsServlet",data,function(ordDetList){
								if(ordDetList==null){
										diyC.html("<p>没有订房间</p>");
								}else{
										StrC +="<p>订单信息</p><table id='table1'><tr><td>房间类型</td>"
												+"<td>价格（元）</td><td>数量</td><td>小计</td></tr></table>";
										for(var i=0;i<ordDetList.length;i++){
										
												StrC +="<table id='table2'><tr><td><p>"+hotelname +"</p><a>"+ordDetList[i].rmTypeName +"</a></td>"
												+"<td>¥<span>"+ordDetList[i].rmTypePrice +"</span></td><td>"+ordDetList[i].num +"</td>"
												+"<td>¥<span>"+ordDetList[i].money +"</span></td></tr></table>";
										}
										StrC +="<table id='table3'><tr><td>总计（含优惠）<span>&nbsp;¥"+ordDetList[ordDetList.length-1].moneyCot+"</span></td></tr></table>";
										diyC.html(StrC);
								}
						},"json");
				}
		</script>
	</body>
</html>
