package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.ComTypeDao;
import com.BDNM.dao.impl.ComTypeDaoImpl;
import com.BDNM.entity.ComType;
import com.BDNM.service.ComTypeService;

/**
 *1、商品类别表ComType   数据操作接口类
 * 
 *
 */
public class ComTypeServiceImpl implements ComTypeService {

	private ComTypeDao comTypeService = new ComTypeDaoImpl();
	
	@Override
	public int addComType(ComType comType) {
		return comTypeService.addComType(comType) ;
	}

	@Override
	public int delComTypeById(int comId) {
		return comTypeService.delComTypeById(comId) ;
	}

	@Override
	public int updateComTypeById(ComType comType) {
		return comTypeService.updateComTypeById(comType) ;
	}

	@Override
	public List<ComType> findAllComType() {
		return comTypeService.findAllComType() ;
	}
	

}
