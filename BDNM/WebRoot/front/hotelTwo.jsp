<%@page import="com.BDNM.service.impl.CommenServiceImpl"%>
<%@page import="com.BDNM.service.CommenService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
		String htID = request.getParameter("htId");
		int htId = 1;
		if(htID==null || htID.equals("")){
				htId = 1;
		}else{
				htId = Integer.parseInt(htID);
		}
		request.setAttribute("htId", htId);
		
		CommenService com=new CommenServiceImpl();
		int count=com.findCommenCountByHtId(htId);
		request.setAttribute("count",count);
		
 %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/header.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />
		<link rel="stylesheet" type="text/css" href="css/hotel.css" />
		<link rel="stylesheet" type="text/css" href="css/section/section.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
		<style type="text/css">
			#ul{margin-left: 35%}
			#ul li{list-style-type: none;display: inline-block;} 
		</style>
	</head>

	<body>
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
								<img src="img/jiudian/re-logo_7c90a10.png" width="158px" height="47px">
							</a>
						</td>
						<td id="t112"><img src="img/jiudian/截图16.png">济南<img src="img/jiudian/截图18.png">
							<iframe src="city.jsp">
							
						</iframe>
						</td>
						<td id="t113">
							<input type="text" name="sousuo" value="搜索商家/地点" />
							<input type="image" src="img/jiudian/QQ图片20190724162410.png" name="sousuo" value="sousuo" />
						</td>
						<td id="t114">
							<div>
								<a href="#"><img src="img/jiudian/截图13.png" id="im1" /></a>
								<img src="img/jiudian/截图23.png" id="im4" />
								<a href="#"><img src="img/jiudian/截图12.png" id="im2" /></a>
								<img src="img/jiudian/截图23.png" id="im5" />
								<a href="#"><img src="img/jiudian/截图14.png" id="im3"></a>
							</div>
						</td>
					</tr>
					<tr id="t12">
						<td colspan="4">
							<ul>
								<li>
									<a href="#">推拿按摩全身</a>
								</li>
								<li>
									<a href="#">聚优惠餐饮</a>
								</li>
								<li>
									<a href="#">自助</a>
								</li>
								<li>
									<a href="#">儿童摄影</a>
								</li>
								<li>
									<a href="#">海鲜烧烤</a>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<div id="hd3">
				<table id="t2">
					<tr>
						<td id="td1">
							<p>全部分类<img src="img/jiudian/截图19.png"></p>
						</td>
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
		<p></p>
		<p></p>
		<section>
			<input type="hidden" name="username" value="${user}" id="username1" />
			<input type="hidden" name="htId" value="${htId }" id="htId1" />
			<input type="hidden" name="curpage"  id="curpage" ><!-- 分页隐藏域 -->
			<div id="div2" style="border: 1px solid red;">
			
				
				
				
				
			</div>
			<div id="div3"><span style="font-size: 18px;">当前商家团购</span></div>
			<div class="div4">
			</div>

			<div id="div5">
				<table>
					<tr>
						<td></td>
					</tr>
				</table>
			</div>
			<div id="div6">
				<a>用户评价</a>
			</div>
			<div id="div7">
			<table id="table1">
					<tr>
						<td width="250px"></td>
						<td width="350px"><span style="font-size: 50px; color: deeppink;" id="avgGrade"></span></td>
						<td width="270px"><img src="img/jiudian/截图120.png" /></td>
						<td><span style="font-size: 17px; color: #A9A9A9;" id="comCount"></span></td>
					</tr>
				</table>

			</div>
			<div id="div8">
				<table id="table2">
					<tr>
						<td width="1212px" height="30px"><span style="color: deeppink; font-size: 16px;">全部（${count }）</span></td>
					</tr>
				</table>
			</div>
			<div class="div9">
				
			</div>
			
			<div id="div10">
			
			</div>
		</section>
		<footer>
			<table id="tf" width="1212px">
				<tr>
					<td>用户帮助</td>
					<td>手机百度助手</td>
					<td>商务合作</td>
					<td>公司信息</td>
					<td>400-9216-666</td>
				</tr>
				<tr>
					<td>
						<a href="#">常见团购问题</a>
					</td>
					<td>
						<a href="#">百度糯米触屏版</a>
					</td>
					<td>
						<a href="#">友情链接</a>
					</td>
					<td>
						<a href="#">关于百度糯米</a>
					</td>
					<td>周一至周日 9:00-22:00</td>
				</tr>
				<tr>
					<td>
						<a href="#">开放API</a>
					</td>
					<td>
						<a href="#">下载手机版</a>
					</td>
					<td>
						<a href="#">市场合作</a>
					</td>
					<td>
						<a href="#">百度糯米新浪微博</a>
					</td>
					<td>客服电话 免长途费</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<a href="#">业务投诉</a>
					</td>
					<td>
						<a href="#"><img src="img/jiudian/截图10(1).png"></a>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<a href="#">
							<img src="img/jiudian/截图17(1).png"> 京公网安备 11000002000001号
						</a>
					</td>
				</tr>
			</table>
		</footer>
	</body>
<script>
	
	function Sruplus(htId,rmTypeId){
		var data="opt=getSruplus&htId="+htId+"&rmTypeId="+rmTypeId;
		
		$.post("../HotelRoomServlet",data,function(relData){
			if(relData>0){
				$("#rm"+rmTypeId).html("剩余"+relData+"间");
			}else{
				$("#rm"+rmTypeId).html("剩余0间");
			}
			
		},"json");
	}
	
	//显示平均评分
	function getGrade(){
		var data="opt=getAvgGrade&htId="+$("#htId1").val();
		$.post("../CommenServlet",data,function(relData){
			$("#avgGrade").html(relData+".0");
		},"json");
	}
	
	//显示评论总人数
	function getComCount(){
		var data="opt=getCount&htId="+$("#htId1").val();
		$.post("../CommenServlet",data,function(relData){
			$("#comCount").html("共有"+relData+"人评论");
		},"json");
	}
	
	//显示评论信息
	function showCommen(curpage){
		var index;//定义页码
		var data="opt=showCommen&htId="+$("#htId1").val();//定义评论显示参数
		if(curpage&&curpage>0){
			data+="&curpage="+curpage;
		}
		//发送显示评论异步请求
		$.post("../CommenServlet",data,function(relData){
			index=relData.pageIndex;
			$("#curpage").val(index);
			var div= $(".div9");
			div.html("");//清空div中数据
			var st="";
			var comList=relData.dataList;//获取评论列表
			for(var i=0;i<comList.length;i++){
				//循环拼接串
			 	st+="<table class='table3'><tr><td rowspan='3' width='100px'><img src='img/jiudian/touxiang.png' /></td>"+
						"<td class='td1'>"+comList[i].commenTime+" 说：</td><td><span style='color: deeppink; font-size: 30px;'>"+comList[i].grade+".0</span></td></tr>"+
						"<tr><td width='1085px'><span style='font-size: small;'>"+comList[i].commen+"</span></td></tr>"+
						"<tr><td>&nbsp;</td></tr><tr><td class='td1'>"+comList[i].userName+"</td><td class='td1'>"+comList[i].htName+"</td></tr></table>" 						
				}//for循环
			div.html(st);
			//添加翻页
			var div1=$("#div10");
			var st1="<ul id='ul'><li><a>当前"+relData.pageIndex+"/"+relData.pageCount+"页&nbsp;&nbsp;&nbsp;&nbsp;</a></li>"+
						"<li><a href='javascript:getPage2(1)'>首页&nbsp;&nbsp;&nbsp;&nbsp;</a></li>"+
						"<li><a href='javascript:getPage2("+(relData.pageIndex-1)+")'>上一页&nbsp;&nbsp;&nbsp;&nbsp;</a></li>"+
						"<li><a href='javascript:getPage2("+(relData.pageIndex+1)+")'>下一页&nbsp;&nbsp;&nbsp;&nbsp;</a></li>"+
						"<li><a href='javascript:getPage2("+relData.pageCount+")'>尾页&nbsp;&nbsp;&nbsp;&nbsp;</a></li></ul>";
			div1.html(st1);			
		},"json");
			
	}//showCommen
	
	function getPage2(curpage){
			$("#curpage").val(curpage);
			var curpage=$("#curpage").val();
			showCommen(curpage);
		}
	
	
	
	function order(obj,opt){
		var user = $("#username1").val();
		var htId = $("#htId1").val();
		if(user==null || user==""){
			alert("请先登录！");
			location.replace("index.jsp");
		}else{
			if(opt<1){
					alert("房间已经客满！");
			}else{
					location.href="buy.jsp?hotelid="+htId+"&roomid="+obj+"";
			}
		}
	}
//异步加载酒店信息
				$(function(){
						getHotelDetails();
						getRoomInfo(); 
						getGrade();
						getComCount();
						showCommen(1);
						
				});
				var hotelid = $("#htId1").val();
				function getHotelDetails(){
						var divA = $("#div2");
						var data = "hotelid="+hotelid+"&opt=findHotelById";
						$.post("../HotelDetailsServlet",data,function(htDeCopy){
								if(htDeCopy==null || htDeCopy==""){
										divA.html("没有选中酒店！");
								}else{
										var strA = "<table id='table4'><tr><td width='850px'>"
										+"<span style='font-size: 25px;''>"+htDeCopy.htName+"（"+htDeCopy.htTypeName+"酒店）</span></td>"
										+"<td rowspan='6'><img src=../upload/"+htDeCopy.htPictrue+" width='305px' height='205px'/></td></tr>"
										+"<tr><td height='20px'>"+htDeCopy.avgGrade+"<a  id='href'>("+htDeCopy.gradeCot+"人评价)&nbsp;&nbsp;|&nbsp;"
										+"</a>人均：<span style='font-'>￥"+htDeCopy.avgMoney+"</span></td></tr><tr><td height='20px'>"
										+"地址:"+htDeCopy.htAddress+"</td></tr><tr><td height='20px'>电话："+htDeCopy.htPhone+"</td>"
										+"</tr><tr><td height='20px'>营业时间：全天</td></tr><tr><td height=''>&nbsp;</td></tr>"
										+"<tr><td height=''>&nbsp;</td></tr><tr><td height=''>&nbsp;</td></tr></table>";
										divA.html("");
										divA.html(strA);
								}
						},"json");
				}

//异步加载酒店房间信息
function getRoomInfo(){
		var data = "hotelid="+hotelid+"&opt=showRoomInfo";
		var divB = $(".div4");
		$.post("../HotelRoomServlet",data,function(rmList){
		
				var strB = "";
				if(rmList==null || rmList==""){
						strB="<p>该酒店暂未开启订购业务!</P>";
				}else{
				divB.html("");
				var strB ="";
				for(var i=0;i<rmList.length;i++){
						strB += "<table class='table'><tr><td rowspan='4'  width='150px'><img src='img/jiudian/L02.png' />"/* <img src=../upload"+rmList[i].rmTypePictrue+" />" */
						+"</td><td class='td3' width='350px'><a  class='href1'>"+rmList[i].htName+"</a><p class='td4'>"+rmList[i].rmTypeName+"</p>"
						+"<p class='td4'>共有"+rmList[i].rmTypeCount+"间</p></td><td width='350px' class='td4'>剩余"+rmList[i].rmTypeSruplus+"间</td>" 
						
						/* +"<p class='td4'>共有"+rmList[i].rmTypeCount+"间</p></td><td width='350px' class='td4' id='rm"+rmList[i].rmTypeId+"'></td>" */
						
						+"<td width='200px' class='td4'><span style='color: deeppink; font-size: 25px;''>￥"+rmList[i].rmTypePrice+"</span><br/>"
						+"</td><td><img src='img/jiudian/jietu119.png' onclick='javascript:order("+rmList[i].rmTypeId+","+rmList[i].rmTypeSruplus+")' /></td></tr></table>";
						/* Sruplus($("#htId1").val(),rmList[i].rmTypeId); */
				}
				divB.html(strB);
				}
				
				
		},"json");
		
}
				
				</script>
</html>
