package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.HotelDetails;

/*
 *4、 酒店信息表HotelDetails   数据操作接口类
 * 
 * */
public interface HotelDetailsDao {
	
	//添加一条酒店信息
	int addHotelDetails(HotelDetails hotelDetails);
	
	//删除一条，根据编号
	int delHotelDetailsById(int htId);
	
	//修改酒店信息
	int updateHotelDetails(HotelDetails hotelDetails);
	
	//查找全部
	List<HotelDetails> findAllHotelDetails();
	
	//查找一条记录，根据编号
	HotelDetails findHotelDetailsById(int htId);
	
	//模糊查找，根据酒店类型或酒店名
	List<HotelDetails> findHotelDetailsByTypeOrName(int htTypeId,String htName);
	
	/**
	 * 查询酒店信息总数量
	 * @return
	 */
	int findHotelDetailsCount();
	
	/**
	 * 分页查询
	 */
	List<HotelDetails> findHotelDetailsPaging(int pageIndex,int pageSize);

	
	/**
	 * 过滤显示酒店信息
	 */
	List<HotelDetails> showHotelDetailsPCCT(String City,String countyName,int Type,int pageIndex,int pageSize);
	/**
	 * 过滤显示酒店总数
	 */
	int findHotelDetailsCountFive(String City,String countyName,int Type);

	
	
}
