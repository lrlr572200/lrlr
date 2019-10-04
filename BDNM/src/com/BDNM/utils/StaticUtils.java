package com.BDNM.utils;
/*
 * 静态方法类
 * 
 * */
public  class StaticUtils {
	
	//String转换int的方法
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
