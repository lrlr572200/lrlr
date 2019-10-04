package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.HotelDetailsDao;
import com.BDNM.dao.impl.HotelDetailsDaoImpl;
import com.BDNM.entity.HotelDetails;
import com.BDNM.service.HotelDetailsService;

/*
 *4、 酒店信息表HotelDetails   数据操作接口类
 * 
 * */
public class HotelDetailsServiceImpl implements HotelDetailsService  {

	private HotelDetailsDao hotelDetailsService = new HotelDetailsDaoImpl();
	
	@Override
	public int addHotelDetails(HotelDetails hotelDetails) {
		return hotelDetailsService.addHotelDetails(hotelDetails);
	}

	@Override
	public int delHotelDetailsById(int htId) {
		return hotelDetailsService.delHotelDetailsById(htId);
	}

	@Override
	public int updateHotelDetails(HotelDetails hotelDetails) {
		return hotelDetailsService.updateHotelDetails(hotelDetails);
	}

	@Override
	public List<HotelDetails> findAllHotelDetails() {
		return hotelDetailsService.findAllHotelDetails();
	}

	@Override
	public HotelDetails findHotelDetailsById(int htId) {
		return hotelDetailsService.findHotelDetailsById(htId);
	}

	@Override
	public List<HotelDetails> findHotelDetailsByTypeOrName(int htTypeId,
			String htName) {
		return hotelDetailsService.findHotelDetailsByTypeOrName(htTypeId, htName);
	}

	@Override
	public int findHotelDetailsCount() {
		return hotelDetailsService.findHotelDetailsCount();
	}

	@Override
	public List<HotelDetails> findHotelDetailsPaging(int pageIndex, int pageSize) {
		return hotelDetailsService.findHotelDetailsPaging(pageIndex, pageSize);
	}
	
	@Override
	public List<HotelDetails> showHotelDetailsPCCT(String City,String countyName,int Type,int pageIndex,int pageSize) {
		return hotelDetailsService.showHotelDetailsPCCT(City, countyName, Type,pageIndex,pageSize); 
	}

	@Override
	public int findHotelDetailsCountFive(String City,String countyName, int Type) {
		return hotelDetailsService.findHotelDetailsCountFive(City, countyName, Type);
	}

}
