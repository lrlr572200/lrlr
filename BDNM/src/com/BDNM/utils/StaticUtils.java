package com.BDNM.utils;
/*
 * ��̬������
 * 
 * */
public  class StaticUtils {
	
	//Stringת��int�ķ���
	public static int StringToInt(String str){
		int number = -1;
		if(str==null || str.equals("")){
			number = -1;
		}else{
			number = Integer.parseInt(str);
		}
		return number;
	}
	
	

}
