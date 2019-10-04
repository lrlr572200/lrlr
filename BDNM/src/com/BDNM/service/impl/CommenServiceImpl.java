package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.CommenDao;
import com.BDNM.dao.impl.CommenDaoImpl;
import com.BDNM.entity.Commen;
import com.BDNM.service.CommenService;
import com.BDNM.utils.ShowCommen;
/**
 * 9、用户评论表Commen    数据操作
 *
 *
 */
public class CommenServiceImpl implements CommenService {

	private CommenDao commenService = new CommenDaoImpl();
	
	@Override
	public int addCommen(Commen commen) {
		return commenService.addCommen(commen) ;
	}

	@Override
	public int delCommenById(int comId) {
		return commenService.delCommenById(comId) ;
	}

	@Override
	public int updateCommen(Commen commen) {
		return commenService.updateCommen(commen) ;
	}

	@Override
	public List<Commen> findCommenByHtIdPaging(int htId, int pageIndex,
			int pageSize) {
		return commenService.findCommenByHtIdPaging(htId, pageIndex, pageSize) ;
	}

	@Override
	public List<Commen> findCommenByUserIdPaging(int userId, int pageIndex,
			int pageSize) {
		return commenService.findCommenByUserIdPaging(userId, pageIndex, pageSize);
	}
	
	@Override
	public int findCommenGradeById(int id) {
		return commenService.findCommenGradeById(id);
	}

	@Override
	public List<Commen> findCommenByHtId(int htId) {
		return commenService.findCommenByHtId(htId);
	}

	@Override
	public int findCommenAvgGradeByHtId(int htId) {
		return commenService.findCommenAvgGradeByHtId(htId);
	}

	@Override
	public int findCommenCountByHtId(int htId) {
		return commenService.findCommenCountByHtId(htId);
	}

	@Override
	public List<ShowCommen> findHHUCGCByHtId(int htId, int pageIndex,
			int pageSize) {
		return commenService.findHHUCGCByHtId(htId, pageIndex, pageSize);
	}

}
