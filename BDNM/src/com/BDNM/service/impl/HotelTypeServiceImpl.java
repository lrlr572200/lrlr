package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.HotelTypeDao;
import com.BDNM.dao.impl.HotelTypeDaoImpl;
import com.BDNM.entity.HotelType;
import com.BDNM.service.HotelTypeService;

/*
 * 3、酒店类型表HotelType   数据操作接口类
 * 
 * */
public class HotelTypeServiceImpl implements HotelTypeService {

	private HotelTypeDao hotelTypeService = new HotelTypeDaoImpl();
	
	@Override
	public int addHotelType(HotelType hotelType) {
		return hotelTypeService.addHotelType(hotelType);
	}

	@Override
	public int delHotelTypeById(int htTypeId) {
		return hotelTypeService.delHotelTypeById(htTypeId);
	}

	@Override
	public int updateHotelTypeById(HotelType hotelType) {
		return hotelTypeService.updateHotelTypeById(hotelType);
	}

	@Override
	public List<HotelType> findAllHotelType() {
		return hotelTypeService.findAllHotelType();
	}

	@Override
	public String findHotelTypeNameById(int htTypeId) {
		return hotelTypeService.findHotelTypeNameById(htTypeId);
	}

}
