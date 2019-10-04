<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/pay.css"/>
		 <script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
		<style type="text/css">
			#div1{
				margin-top: 0px;
				
				border-bottom: 1px solid #999999;
			}
			#s1{
				font-size: 13px;
				color: #999999;
			}
			.s1{
				font-size: 13px;
				color: #73ABC9;
				text-decoration: none;
				font-weight: 100;
			}
			#div2{
				margin-left: 110px;
				margin-top: 30px;
			}
			#div3{
				margin-left: 130px;
				margin-top: 20px;
			}
			.go{
				font-size: 16px;
				font-weight: bold;
			}
			#div4{
				margin-left: 120px;
				border: 1px solid #F0F0F0;
				width: 950px;
				background-color: #FAFAFA;
			}
			#div5{
				margin-top: 15px;
				margin-left: 120px;
				border-bottom: 1px solid #F0F0F0;
				width: 950px;
			}
			.size{
				font-size: 13px;
				color: #666666;
			}
			#div6{
				margin-top: 80px;
				margin-left: 870px;
			}
			#div7{
				margin-top: 40px;
				margin-left: 840px;
			}
			
			#tab1{
				text-align: center;
			}
			.imgs{
				height: 100px;
				width: 200px;
				margin: 4px 0px 0px 0px;
				padding: 0px 0px;
			}
			#tab2{background-color: white;}
		</style>
	</head>
	<body>
		<input type="hidden"   name="userId"  value="${user.userId }"  id="userId"  />
		<input type="hidden"  name="balance"  value="" id="balance"  />
		<input type="hidden"  name="htID"  value="${hotelid }"  id="htID" />
		<input type="hidden"  name="rmID" value="${roomid }"  id="rmID"  />
		<input type="hidden"  name="cot" value="${cot }"  id="cott"  />
		<c:if test="${user==null }">
					<script>
					alert("请先登录！");
					location.replace("index.jsp");
					</script>
					</c:if>
		<div id="div2">
			<img src="img/pay/QQ20190830120705.png" />
		</div>
		<div id="div3">
			<span style="font-size: 13px; color: #666666;">尊敬的用户：${user.userName }您好</span>
			<span style="color: deeppink; font-size: 13px;">请确认订单</span>
		</div>
		<div id="div4">
			<table  align="center">
				<tr height="50px" id="tab1">
					<td width="350px" colspan="2">商品</td>
					<td width="200px">单价</td>
					<td width="200px">数量</td>
					<td width="200px">优惠</td>
					<td width="200px">小计</td>
				</tr>
				<tr id="tab2">
					<%-- <td width="100px" ><img src="../upload/${ordc.rmTypePictrue }" class="imgs"/></td> --%>
					<td width="100px" ><img src="img/jiudian/470285.png" width="130px" height="79px" class="imgs"/></td>
					<td width="250px" >
					<p>${ordc.htName }</p>
					<p>${ordc.rmTypeName }</p>
					</td>
					<td width="200px">${ordc.rmTypePrice }</td>
					<td width="200px">${ordc.num }</td>
					<td width="200px">${ordc.nominal }</td>
					<td width="200px">${ordc.money }</td>
				</tr>
				
			</table>
		</div>
		<div id="div5">
		</div>
		<div id="div6">
			<span style="font-size: 18px;">应付总额：</span><span style="font-size:30px ; color: deeppink;">￥${ordc.money }</span>
		</div>
		<div id="div7">
			<table>
				<tr>
					<td><a  style="color: #73ABC9; text-decoration: none;"  onclick="togos()">返回上一步</a>&nbsp;&nbsp;&nbsp;</td>
					<td><img src="img/pay/jietu113.png"  onclick="payment(${ordc.money})"/></td>
				</tr>
			</table>
		</div>
		<div>
			<hr style="border-bottom: 10px;" />
		</div>
	</body>
	 <script type="text/javascript"  >
	 $(function(){
	 	getBalance();
	 })
	 function togos(){
	 		history.go(-1);
	 }
	 
	 function payment(obj){
	 var balance = $("#balance").val();
	 var data = "../OrderServlet?orderSign=addOrder&tape=";
	 if(confirm("是否确定提交订单？如果提交金额将直接从余额中扣除。")){
	 		var mony = balance-obj;
	 		if(mony<0){
	 				alert("余额不足请充值！");
	 				data+="1";
	 		}else{
	 				alert("订单已经生成！");
	 				data+="2";
	 		}
	 }else{
	 		data+="3";
	 }
	 		location.href=data;
	 		
	 }
	 //查询余额
	 quan();
					function quan(){
							var userId = $("#userId").val();
							var data = "opt=findUserCoupon&userid="+userId;
							var spanB = $("#balance");
							$.post("../CouponServlet",data,function(numArr){
									spanB.val("");
									spanB.val(numArr[1]);
							},"json");
					}
	 
	 </script>
</html>
