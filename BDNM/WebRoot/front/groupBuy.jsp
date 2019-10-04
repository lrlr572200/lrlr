<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>百度糯米——个人中心——团购订单数据页</title>
		<link rel="stylesheet" href="css/personalCenterCSS.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
	</head>
	<body>    
		
		<input type="hidden"   name="userId"  value="${user.userId }"  id="userId"  />
		<input type="hidden"  name="balance"  value="" id="balance"  />
		
		<!--订单信息数据页-->
		<section id="groupBuy-Page">
			<p><span class="nav0"  onclick="orderInfo('null')">全部</span><span class="nav" onclick="orderInfo('已付款')">已付款</span>
				<span class="nav" onclick="orderInfo('待付款')">待付款</span>
			</p>
			<input type="hidden"  name="pageindex"  value="${PageSurpport.pageIndex }"  id="pageindex"  />
			<input type="hidden"  name="userID" value="${user.userId }"  id="userid"  />
			<!--全部信息页面-->
			<div id="info-0">
			</div>
			<div id="info-outNav">
			</div>
			
<script type="text/javascript"  >
 //查询余额
	 findBala();
					function findBala(){
							var userId = $("#userId").val();
							var data = "opt=findUserCoupon&userid="+userId;
							var spanB = $("#balance");
							$.post("../CouponServlet",data,function(numArr){
									spanB.val("");
									spanB.val(numArr[1]);
							},"json");
					}


var divContent = $("#info-0");
		var valType = null;
	/* 过滤启动 */
	function orderInfo(obj){
			getPage($("#pageindex").val(),obj);
	}
	/*异步加载  */
	function getPage(pageIndex,obj){
			var str = obj;
			var data="orderSign=orderShow";
			if(pageIndex && pageIndex>0){
					data += "&index="+pageIndex;
			}
			var userid = $("#userid").val();
			data += "&userid="+userid+"&state="+str;
			$.post("../OrderServlet",data,function(orderlist){
					var outNav = $("#info-outNav");
					divContent.html("");
					var listStr = "";
					var ordData = orderlist.dataList;
					 if(ordData.length<=0){
							divContent.html("没有找到订单......");
					}else{ 
							listStr += "<table  border='0' cellpadding='0' cellspacing='0'><tr id='navBuy' height='35px'>";
							listStr +="<td width='260px'>团购信息</td><td width='90px'>应付金额</td><td width='80px'>数量</td>";
							listStr +="<td width='120px'>实付金额</td><td width='110px'>状态</td>";
							listStr +="<td width='90px'>操作</td></tr>";
							for(var i=0;i<ordData.length;i++){
									listStr +="<tr><td><div><img src='../upload/"+ordData[i].htPictrue+"'/></div>"
									+"<div><p>"+ordData[i].htname+"</p><p id='dels"+i+"'>"+ordData[i].orderNum+"</p></div></td>"
									+"<td id = monyss"+i+">"+ordData[i].ordMoney+"</td><td>"+ordData[i].count+"</td><td>"+ordData[i].payment+"</td>"
									+"<td><p>"+ordData[i].state+"</p><p>"
									+"<a href='orderDetails.jsp?orderID="+ordData[i].orderNum+"&htname="+ordData[i].htname+"'  target='mframe'>订单详情</a></p></td>"
									+"<td id='delete"+i+"'>"
									+"<span  class='delment'  onclick='del("+i+")'>删除</span></td></tr>";
							}
							listStr +="</table>";
							divContent.html(listStr);
							//添加导航条
							
							var navStr = "";
							navStr += "[当前第&nbsp;"+orderlist.pageIndex+"&nbsp;页/共&nbsp;"+orderlist.pageCount+"&nbsp;页]";
						 
							if(orderlist.pageIndex>1){
								navStr += "&nbsp;&nbsp;<a onclick='getPage(1,\""+str+"\")'>首页</a>"
								+ "&nbsp;&nbsp;<a onclick='getPage("+(orderlist.pageIndex-1)+",\""+str+"\")'>上一页</a>";
							}
							if(orderlist.pageIndex<orderlist.pageCount){
								navStr += "&nbsp;&nbsp;<a onclick='getPage("+(orderlist.pageIndex+1)+",\""+str+"\")'>下一页</a>"
								+ "&nbsp;&nbsp;<a onclick='getPage("+(orderlist.pageCount)+",\""+str+"\")'>末页</a>";
							} 
							
						outNav.html("");
						outNav.html(navStr); 
					} 
			},"json");
	}
	$(function(){
			orderInfo(null);
	});
	
	function del(obj){
			if(confirm("是否确认删除?")){
					var remTable = $("#delete"+obj+"");
					var num = $("#dels"+obj).html();
					var data="orderSign=delOrder&orderNum="+num;
					$.post("../OrderServlet",data,function(delnum){
							if(delnum>0){
									remTable.parent().remove();
									alert("删除成功！");
									location.reload();
							}else{
									alert("删除失败！");
							}
					},"json");
					
			}
	}


function  pay(obj){
		 var balance = $("#balance").val();
		 var many = $("#monyss"+obj+"").html();
		 var num = $("#dels"+obj).html();
		 var moneyS = balance-many;
		 if(confirm("如果提交支付金额将直接从余额中扣除")){
		 		if(moneyS<0 ||balance<0 ){
		 				alert("余额不足，请充值！");
		 		}else{
		 				location.href="../OrderServlet?orderSign=updOrder&orderNum="+num;
		 		}
		 }
}


	
	</script>
					
								
			
		</section>
		
	</body>
	<script type="text/javascript" src="js/personalCenterJS.js" ></script>
	
</html>
