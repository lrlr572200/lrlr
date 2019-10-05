package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.Commen;
import com.BDNM.utils.ShowCommen;

/*
 * 
 * 9���û����۱�Commen    ���ݲ����ӿ�
 * 
 * */
public interface CommenDao {
	
	//��������
	int addCommen(Commen commen);
	
	//ɾ������
	int delCommenById(int comId);
	
	//�޸�����
	int updateCommen(Commen commen);
	
	//���ݾƵ����ȫ������---��ҳ
	List<Commen> findCommenByHtIdPaging(int htId,int pageIndex,int pageSize);
	
	//�����û�����ȫ������---��ҳ
	List<Commen> findCommenByUserIdPaging(int userId,int pageIndex,int pageSize);
	
	//��Ѱ�Ƶ������
		int findCommenGradeById(int id);
	
		public List<Commen> findCommenByHtId(int htId);

		//���ʣ���ѯ�Ƶ��ƽ����
		int findCommenAvgGradeByHtId(int htId);
		
		//��ѯ�Ƶ�����������
		int findCommenCountByHtId(int htId);
				
			/**
			 * ��ҳ��ѯ���۽���������Ϣ
			 * @param htId
			 * @return
			 */
			List<ShowCommen> findHHUCGCByHtId(int htId,int pageIndex,int pageSize);


		
}
