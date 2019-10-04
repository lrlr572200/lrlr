/*===================个人中心页面JS文件=======================*/

/*+++++++++++++++++++ jquery事件 ++++++++++++++++++++++++*/
$(function(){
	
	/*-----------section部分  perCen-secBottom【下部】左侧栏-----------------*/
	//点击折叠事件
	$("#list1>dl>dt").click(function(){
		$(this).next("dd").toggle();
		
	});
	
	//左侧导航栏点击li时变色、切换中间部分的显示页的   事件
	$("#personal-center-section li").click(function(){
		$(this).attr("class","menuList0");
		$(this).siblings().attr("class","menuList");
		$(this).parents("dd").prev("dt").attr("class","menu0");
		$(this).parents("dd").prev("dt").siblings().attr("class","menu");
		$(this).parents("dd").siblings("dd").find("li").attr("class","menuList");
		var indexLi = $(this).index();
		var indexDd = $(this).parents("dd").index();
		if(indexDd==1 && indexLi==0){
			$("#perCen-secBot-right-page>#group-buy").show();
			$("#perCen-secBot-right-page>#not-open").hide();
			$("#perCen-secBot-right-page>#show-price").hide();
		}else if(indexDd==6 && indexLi==1){
			$("#perCen-secBot-right-page>#show-price").show();
			$("#perCen-secBot-right-page>#group-buy").hide();
			$("#perCen-secBot-right-page>#not-open").hide();
		}else{
			$("#perCen-secBot-right-page>#group-buy").hide();
			$("#perCen-secBot-right-page>#not-open").show();
			$("#perCen-secBot-right-page>#show-price").hide();
		}

	});
	
	//左侧导航栏点击dt时变色、切换中间部分的显示页的   事件
	$("#list1>dl>dt:nth-of-type(3)").click(function(){
		$(this).attr("class","menu0");
		$(this).siblings("dt").attr("class","menu");
		$(this).siblings("dd").find("li").attr("class","menuList");
		$("#perCen-secBot-right-page>#group-buy").hide();
		$("#perCen-secBot-right-page>#not-open").show();
	});
	
	//内联框架部分点击上侧导航栏时span变样式  切换下侧详情页的事件
	$("#groupBuy-Page>p>span").click(function(){
		$(this).attr("class","nav0");
		$(this).siblings().attr("class","nav");
		
	});
	
	
	
	
})

function outTo(){
	history.go(-1);
}
