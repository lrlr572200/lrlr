/*===================��������ҳ��JS�ļ�=======================*/

/*+++++++++++++++++++ jquery�¼� ++++++++++++++++++++++++*/
$(function(){
	
	/*-----------section����  perCen-secBottom���²��������-----------------*/
	//����۵��¼�
	$("#list1>dl>dt").click(function(){
		$(this).next("dd").toggle();
		
	});
	
	//��ർ�������liʱ��ɫ���л��м䲿�ֵ���ʾҳ��   �¼�
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
	
	//��ർ�������dtʱ��ɫ���л��м䲿�ֵ���ʾҳ��   �¼�
	$("#list1>dl>dt:nth-of-type(3)").click(function(){
		$(this).attr("class","menu0");
		$(this).siblings("dt").attr("class","menu");
		$(this).siblings("dd").find("li").attr("class","menuList");
		$("#perCen-secBot-right-page>#group-buy").hide();
		$("#perCen-secBot-right-page>#not-open").show();
	});
	
	//������ܲ��ֵ���ϲർ����ʱspan����ʽ  �л��²�����ҳ���¼�
	$("#groupBuy-Page>p>span").click(function(){
		$(this).attr("class","nav0");
		$(this).siblings().attr("class","nav");
		
	});
	
	
	
	
})

function outTo(){
	history.go(-1);
}
