package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.Commen;
import com.BDNM.utils.ShowCommen;

/*
 * 
 * 9、用户评论表Commen    数据操作接口
 * 
 * */
public interface CommenDao {
	
	//增加评论
	int addCommen(Commen commen);
	
	//删除评论
	int delCommenById(int comId);
	
	//修改评论
	int updateCommen(Commen commen);
	
	//根据酒店查找全部评论---分页
	List<Commen> findCommenByHtIdPaging(int htId,int pageIndex,int pageSize);
	
	//根据用户查找全部评论---分页
	List<Commen> findCommenByUserIdPaging(int userId,int pageIndex,int pageSize);
	
	//查寻酒店的评分
		int findCommenGradeById(int id);
	
		public List<Commen> findCommenByHtId(int htId);

		//刘仁，查询酒店的平均分
		int findCommenAvgGradeByHtId(int htId);
		
		//查询酒店评论总数量
		int findCommenCountByHtId(int htId);
				
			/**
			 * 分页查询评论界面所需信息
			 * @param htId
			 * @return
			 */
			List<ShowCommen> findHHUCGCByHtId(int htId,int pageIndex,int pageSize);


		
}
