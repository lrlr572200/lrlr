<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.BDNM.service.impl.CommenServiceImpl"%>
<%@page import="com.BDNM.service.CommenService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	CommenService comService=new CommenServiceImpl();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link type="text/css" rel="stylesheet" href="css/header.css" />
		<link type="text/css" rel="stylesheet" href="css/footer.css" />
		<link type="text/css" rel="stylesheet" href="css/hotel/hotel.css">
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<style>
			
		</style>
	</head>
	<body>
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
		<section>
<!--  <form action="#" method="post"> -->
			<div id="s1">
				<img src="img/hotel/jietu01.png" style="vertical-align: middle;"/>&nbsp;&nbsp;
				入住城市&nbsp;&nbsp;
				<input type="text" name="city" value="济南" id="city" />
				<input type="button" value="搜索"   onclick="show()" id="button">
			</div>
			<div id="s2">
				<table id="st1">
					<tr>
						<td>
							<table id="st11">	
							</table>
						</td>
					</tr>
				<tr><td colspan="3"><div class="s22"></div></td></tr>
					<tr>
						<td>
							<table id="st12">
							</table>
						</td>
					</tr>
			<tr><td colspan="3"><div class="s22"></div></td></tr>
					<tr>
						<td>
							<!-- <table id="st13">
								<tr>
									<td style="width: 50px;">价格</td>
									<td style="width: 50px;"><a href="#">全部</a></td>
									<td><a href="#">0-50元</a></td>
									<td><a href="#">50-100元</a></td>
									<td><a href="#">100-200元</a></td>
									<td><a href="#">200-300元</a></td>
									<td><a href="#">300元以上</a></td>
									<td></td>
									<td></td>
								</tr>
							</table> -->
						</td>
					</tr>
				</table>
			</div>
			<img src="img/hotel/jietu02.png" id="tu2"/>
			<div id="s3"></div>
<!-- </form>  -->
			<div class="s4"></div>
			<div id="s5"></div>
			<div id="s6"><ul></ul></div>		
		</section>
		<input type="hidden" name="curpage"  id="curpage" ><!-- 分页隐藏域 -->
		<input type="hidden" name="countyId"  id="countyId" ><!-- 区县隐藏域 -->
		<input type="hidden" name="typeId" id="typeId"> <!-- 类型隐藏域 -->
		<input type="hidden" name="avgGrade" id="avgGrade"/><!-- 酒店平均评分隐藏域 -->
		<input type="hidden" name="avgPrice" id="avgPrice"/><!-- 酒店平均消费隐藏域 -->
		<footer>
			<table id="tf"  width="1212px">
				<tr>
					<td >用户帮助</td>
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
	//显示平均消费
	function getPrice(htId){
		var data4="opt=getAvgPrice";
		if(htId&&htId>0){
			data4+="&htId="+htId;
		}
		$.post("../HotelRoomServlet",data4,function(relData4){
			$("#avgPrice").val(relData4);
			var avg=$("#avgPrice").val();
			if(avg==0){
				$("#avga"+htId).html("暂无信息");
			}else{
				$("#avga"+htId).html(avg);
			}
		},"json");
	}
	
	
	//显示平均评分
	function getGrade(htId){
		var data3="opt=getAvgGrade";
		if(htId&&htId>0){
		 	 data3+="&htId="+htId;
		}
		$.post("../CommenServlet",data3,function(relData3){
			$("#avgGrade").val(relData3);
			var avg=$("#avgGrade").val();
			if(avg==0){
				$("#avg"+htId).html("暂无评分");
			}else{
				$("#avg"+htId).html(avg+"分");
			}
		},"json");
	}
	
	//全部过滤显示酒店
		function typeId(typeId){
			$("#typeId").val(typeId);
			var typeId=$("#typeId").val();
			var curpage=$("#curpage").val();
			var countyId=$("#countyId").val();
			getPage(curpage, countyId, typeId);
		}	
	
		//区域过滤显示酒店
		function countyId(countyId){
			$("#countyId").val(countyId);
			var countyId=$("#countyId").val();
			var typeId=$("#typeId").val();
			var curpage=$("#curpage").val();
			getPage(curpage,countyId,typeId);
		}
		//区域过滤分页显示酒店
		function getPage2(curpage){
			$("#curpage").val(curpage);
			var curpage=$("#curpage").val();
			var countyId=$("#countyId").val();
			var typeId=$("#typeId").val();
			getPage(curpage,countyId,typeId);
		}
		function show(){
				getCounty();
				getPage(curpage,countyId,typeId);
				getHotelType();
		}
		
		function getPage(curpage,countyId,typeId){
					/* ------------------显示酒店---------------- */
			var index;//定义页码
			var data="opt=showHotelPaging";//定义酒店显示参数
			if(curpage&&curpage>0){
				data+="&curpage="+curpage;
			}
		  	if(countyId&&countyId>0){
				data+="&countyId="+countyId;
			}
			if(typeId&&typeId>0){
				data+="&typeId="+typeId;
			}  
			//添加搜索条件
			var city=$("#city").val();
			 if(city!=null && city!=""){
				data+="&city="+city;
			} 
			//发送显示酒店异步请求
			$.post("../HotelDetailsServlet",data,function(relData){
				index=relData.pageIndex;
				$("#curpage").val(index);
				var div=$(".s4");
				div.html("");//清空div中的数据
				var st="";
				var hotelList=relData.dataList;//获取酒店列表
				for(var i=0;i<hotelList.length;i++)
				{
					//循环拼接st串
					st+="<table  class='st2'><tr><td rowspan='4' width='180px'><img src='../upload/"+hotelList[i].htPictrue+"'></td>"+
						 "<td><a href='hotelTwo.jsp?htId="+hotelList[i].htId+"'><span class='sp1'>"+hotelList[i].htName+"</span></a></td>"+
						 "<td rowspan='4' width='180px'><span class='sp2'>￥人均</span><span class='sp3'  id='avga"+hotelList[i].htId+"'></span></td></tr>"+
						 "<tr><td><span class='sp4' id='avg"+hotelList[i].htId+"'></span></td></tr>"+
						 "<tr><td>"+hotelList[i].htIntro+"</td></tr>"+
						 "<tr><td>"+hotelList[i].htAddress+"</td></tr>"+
						 "</table>";
						 //根据酒店ID（hotelList[i].htId）查询酒店评分
						 getGrade(hotelList[i].htId);
						 //根据酒店ID（hotelList[i].htId）查询人均消费
						 getPrice(hotelList[i].htId);
				}//for循环
				div.html(st);//将表格添加到div中
				
				//添加翻页
				var div1=$("#s6");
			 	var st1="<ul>";
				//添加首页和上一页
				if(relData.pageIndex>1){
					st1+="<li><a href='javascript:getPage2(1)'>首页</a></li>";
					st1+="<li><a href='javascript:getPage2("+(relData.pageIndex-1)+")'>上一页</a></li>";
				}
				//添加末页和下一页
				if(relData.pageIndex<relData.pageCount){
					st1+="<li><a href='javascript:getPage2("+(relData.pageIndex+1)+")'>下一页</a></li>";
					st1+="<li><a href='javascript:getPage2("+relData.pageCount+")'>末页</a></li>";
				}
				st1+="</ul>";
				div1.html(st1); //将翻页添加到div中
				
				var div2=$("#s5");
				var st2="<ul><li>共<span class='sp4'>"+relData.totalCount+"</span>条</li>"+
							"<li>/</li><li>每页"+relData.pageSize+"条</li></ul>";
				div2.html(st2);
				
				var div3=$("#s3");
				var st3="<a href='javascript:getPage("+(relData.pageIndex-1)+")'>&lt;</a>&nbsp;"+relData.pageIndex+"/"+relData.pageCount+"&nbsp;<a href='javascript:getPage("+(relData.pageIndex+1)+")'>&gt;</a>";			
				div3.html(st3);
			},"json");//酒店显示	
		}//getPage结束
			
			
			
				function getCounty(){
							/* ------------------显示城市、区县---------------- */
					var cityName=$("#city").val();
					var data1="opt=showCounty&cityName="+cityName;//定义地址显示参数
					//发送地址显示异步请求
					$.post("../AddressServlet",data1,function(relData1){
							var table=$("#st11");//获取表格节点
							table.html("");//清空节点
							//拼接字符串
							var stc="<tr><td style='width: 50px;'>区域</td><td style='width: 50px;'><a href='javascript:countyId(0)' onclick='click1(0)' id='ct0'>全部</a></td>"+
										"<td>行政区</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>"+
										"<tr><td rowspan='3' style='width: 50px;'></td><td rowspan='3' style='width: 50px;'></td>";
							if(relData1.length>6){
									for(var i=1;i<relData1.length+1;i++){
									stc+="<td style='width: 100px;''><a href='javascript:countyId("+relData1[i-1].regionalAddId+")' onclick='click1("+relData1[i-1].regionalAddId+")' id='ct"+relData1[i-1].regionalAddId+"'>"+relData1[i-1].regionalAddName+"</a></td>";
											if(i%7==0){
												stc+="</tr><tr>";
											}
									}
									stc+="</tr>";
							}else{
									for(var i=0;i<relData1.length;i++){
										stc+="<td style='width: 100px;''><a href='javascript:countyId("+relData1[i].regionalAddId+")'>"+relData1[i].regionalAddName+"</a></td>"
									}
									stc+="</tr>";
							}
							table.html(stc);
							get();
						},"json");//地址显示
				}//getCounty
		
		
				function getHotelType(){
						/* ------------------显示酒店类型---------------- */
						var data2="opt=showHotelType";//定义显示酒店类型参数
						//发送酒店类型显示异步请求
						$.post("../HotelTypeServlet",data2,function(relData2){
							var table2=$("#st12");//获取表格节点
							table2.html("");//清空节点
							//链接JSON串
							var stt="<tr><td style='width: 50px;'>分类</td><td style='width: 50px;'><a href='javascript:typeId(0)' onclick='click2(0)' id='type0'>全部</a></td>"+
							"<td><a href='#'>酒店</a></td>";
							for(var i=0;i<relData2.length;i++){
								stt+="<td><a href='javascript:typeId("+relData2[i].htTypeId+")' onclick='click2("+relData2[i].htTypeId+")' id='type"+relData2[i].htTypeId+"'>"+relData2[i].htTypeName+"</a></td>";
								if(i==5){
									stt+="</tr><tr><td style='width: 50px;'></td><td style='width: 50px;'></td>";
								}
							}
							stt+="</tr>";
							table2.html(stt);//添加到表格中
							get();
						},"json");
				}
		
		function click1(ct){
			$("#st11 a").removeClass("click"); 
			$("#ct"+ct).addClass("click");
			$("#st11 a").removeAttr("style");
			$("#ct"+ct).attr("style","color:white");
		}
		
		function click2(typeId){
			$("#st12 a").removeClass("click"); 
			$("#type"+typeId).addClass("click");
			$("#st12 a").removeAttr("style");
			$("#type"+typeId).attr("style","color:white");
		}
		function get(){
			$("#ct0").addClass("click");
			$("#ct0").attr("style","color:white");
			$("#type0").addClass("click");
			$("#type0").attr("style","color:white");
		}
		$(function(){//加载页面
			
			getPage(1,0,0);
			getCounty();
			getHotelType();
		})
		
	</script>
</html>
