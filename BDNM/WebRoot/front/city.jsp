<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			#main{width: 210px;}
			#t1{width: 210px; border: 1px solid lightgrey;border-style: none none solid none;}
			#t1 td{line-height: 40px; font-size: 15px;}
			
			#t2 {width: 210px;line-height: 30px;}
			#td4{text-align: right;}
			a:link{color: lightgrey;text-decoration: none;}
			a:hover{color: #C9A156;}
		</style>
	</head>
	<body>
		<div id="main">
			<table id="t1" >
				<tr>
					<td>热门城市</td>
				</tr>
			</table>
			<table id="t2"  >
				<tr>
					
							<td><a href="#">北京</a></td>
							<td><a href="#">上海</a></td>
							<td><a href="#">广州</a></td>
							<td><a href="#">深圳</a></td>
				</tr>
				<tr>
					
							<td><a href="#">天津</a></td>
							<td><a href="#">杭州</a></td>
							<td><a href="#">西安</a></td>
							<td><a href="#">成都</a></td>
					
				</tr>
				<tr>
					
							<td><a href="#">郑州</a></td>
							<td><a href="#">厦门</a></td>
							<td><a href="#">青岛</a></td>
							<td><a href="#">太原</a></td>
					
				</tr>
				<tr>
					
							<td><a href="#">重庆</a></td>
							<td><a href="#">武汉</a></td>
							<td><a href="#">南京</a></td>
							<td><a href="#">沈阳</a></td>
					
				</tr>
				<tr>
					
							<td><a href="#">济南</a></td>
							<td colspan="3"><a href="#">哈尔滨</a></td>
					
				</tr>
				<tr>
					<td colspan="4" id="td4">
						<a href="#">更多城市&gt;</a>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
