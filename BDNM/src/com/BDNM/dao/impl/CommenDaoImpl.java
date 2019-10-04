package com.BDNM.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.BDNM.dao.BaseDao;
import com.BDNM.dao.CommenDao;
import com.BDNM.entity.Commen;
import com.BDNM.utils.ShowCommen;

public class CommenDaoImpl extends BaseDao implements CommenDao{
	
	
	/**
	 * 添加评论
	 */
	@Override
	public int addCommen(Commen commen) {
		int rel=-1;
		String sql="INSERT INTO commen(htId,userId,grade,commen,commenTime) VALUES(?,?,?,?,now())";
		List<Object> psList=new ArrayList<Object>(); 
		psList.add(commen.getHtId());
		psList.add(commen.getUserId());
		psList.add(commen.getGrade());
		psList.add(commen.getCommen());
		try {
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	/**
	 * 删除评论
	 */
	@Override
	public int delCommenById(int comId) {
		int rel=-1;
		String sql="DELETE from commen where comId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(comId);
		try {
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	/**
	 * 修改评论
	 */
	@Override
	public int updateCommen(Commen commen) {
		int rel=-1;
		String sql="UPDATE commen set htId=?,userId=?,grade=?,commen=?,commenTime=now() "
				+ "where comId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(commen.getHtId());
		psList.add(commen.getUserId());
		psList.add(commen.getGrade());
		psList.add(commen.getCommen());
		psList.add(commen.getComId());
		try {
			rel=this.executeUpdate(sql, psList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	/**
	 * 分页查询
	 * 根据酒店查找全部评论
	 */
	@Override
	public List<Commen> findCommenByHtIdPaging(int htId, int pageIndex,
			int pageSize) {
		List<Commen> comList=new ArrayList<Commen>();
		String sql="select * from commen where htId=? LIMIT ?,? ";
		List<Object> psList=new ArrayList<Object>();
		psList.add(htId);
		psList.add((pageIndex-1)*pageSize);
		psList.add(pageSize);
		try {
			rs=this.executeQuery(sql, psList);
			Commen coms=null; 
			while(rs.next()){
				coms=new Commen();
				coms.setComId(rs.getInt("comId"));
				coms.setCommen(rs.getString("commen"));
				coms.setCommenTime(rs.getTimestamp("commenTime"));
				coms.setGrade(rs.getInt("grade"));
				coms.setHtId(rs.getInt("htId"));
				coms.setUserId(rs.getInt("userId"));
				comList.add(coms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return comList;
	}
	
	/**
	 * 根据酒店查找全部评论
	 */
	@Override
	public List<Commen> findCommenByHtId(int htId) {
		List<Commen> comList=new ArrayList<Commen>();
		String sql="select * from commen where htId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(htId);
		try {
			rs=this.executeQuery(sql, psList);
			Commen coms=null; 
			while(rs.next()){
				coms=new Commen();
				coms.setComId(rs.getInt("comId"));
				coms.setCommen(rs.getString("commen"));
				coms.setCommenTime(rs.getTimestamp("commenTime"));
				coms.setGrade(rs.getInt("grade"));
				coms.setHtId(rs.getInt("htId"));
				coms.setUserId(rs.getInt("userId"));
				comList.add(coms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return comList;
	}
	
	/**
	 * 分页查询
	 * 根据用户查找全部评论
	 */
	@Override
	public List<Commen> findCommenByUserIdPaging(int userId, int pageIndex,
			int pageSize) {
		List<Commen> comList=new ArrayList<Commen>();
		String sql="select * from commen where userId=? LIMIT ?,?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(userId);
		psList.add((pageIndex-1)*pageSize);
		psList.add(pageSize);
		try {
			rs=this.executeQuery(sql, psList);
			Commen coms=null;
			while(rs.next()){
				coms=new Commen();
				coms.setComId(rs.getInt("comId"));
				coms.setCommen(rs.getString("commen"));
				coms.setCommenTime(rs.getTimestamp("commenTime"));
				coms.setGrade(rs.getInt("grade"));
				coms.setHtId(rs.getInt("htId"));
				coms.setUserId(rs.getInt("userId"));
				comList.add(coms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return comList;
	}

	/**
	 * 查询酒店的评分
	 */
	@Override
	public int findCommenGradeById(int id) {
		List<Commen> comList=new ArrayList<Commen>();
		String sql="select * from commen where htId=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(id);
		int rel=0;//评分
		int count=0;//记录数
		try {
			Commen com=null;
			rs=this.executeQuery(sql, psList);
			while(rs.next()){
				com=new Commen();
				count++;
				rel+=rs.getInt("grade");
				com.setComId(rs.getInt("comId"));
				com.setCommen(rs.getString("commen"));
				com.setCommenTime(rs.getTimestamp("commenTime"));
				com.setGrade(rs.getInt("grade"));
				com.setHtId(rs.getInt("htId"));
				com.setUserId(rs.getInt("userId"));
				comList.add(com);
			}
			if(count!=0){
				rel=rel/count;
			}
			else{
				rel=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	/**
	 * 刘仁，查询酒店的平均评分
	 */
	@Override
	public int findCommenAvgGradeByHtId(int htId) {
		int rel=-1;
		String sql="select sum(grade)/count(0) from commen where htid=?";
		List<Object> psList=new ArrayList<Object>();
		psList.add(htId);
		try {
			rs=this.executeQuery(sql, psList);
			if(rs.next()){
				rel=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return rel;
	}
	
	//查询酒店评论总数量
		@Override
		public int findCommenCountByHtId(int htId) {
			int rel=-1;
			String sql="select count(0) from commen where htId=?";
			List<Object> psList=new ArrayList<Object>();
			psList.add(htId);
			try {
				rs=this.executeQuery(sql, psList);
				if(rs.next()){
					rel=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				this.closeAll();
			}
			return rel;
		}
		/**
		*分页显示评论界面所需信息
		*/
		@Override
		public List<ShowCommen> findHHUCGCByHtId(int htId,int pageIndex,int pageSize) {
			List<ShowCommen> showList=new ArrayList<ShowCommen>();
			String sql="SELECT c.htId,commenTime,commen,grade,htName,userName from "
					+ "commen c join hoteldetails d on c.htId=d.htId join `user` u on c.userId=u.userId"
					+ " where c.htId=?  ORDER BY commenTime DESC  LIMIT ?,?";
			List<Object> psList=new ArrayList<Object>();
			psList.add(htId);
			psList.add((pageIndex-1)*pageSize);
			psList.add(pageSize);
			try {
				rs=this.executeQuery(sql, psList);
				ShowCommen show=null;
				while(rs.next()){
					show=new ShowCommen();
					show.setCommen(rs.getString("commen"));
					show.setCommenTime(rs.getTimestamp("commenTime"));
					show.setGrade(rs.getInt("grade"));
					show.setHtId(rs.getInt("htId"));
					show.setHtName(rs.getString("htName"));
					show.setUserName(rs.getString("userName"));
					showList.add(show);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				this.closeAll();
			}
			return showList;
		}
}
