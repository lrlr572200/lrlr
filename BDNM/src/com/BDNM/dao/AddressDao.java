package com.BDNM.dao;

import java.util.List;

import com.BDNM.entity.Address;

/*
 *   2、 地址表Address   数据操作接口类
 * 
 * */
public interface AddressDao {
	
	//增加一条
	int addAddress(Address address);
	
	//查找全部
	List<Address> findAllAddress();
	
	//查找全部某属地及其行政区，根据属地编号
	List<Address> findAllAddressByAddId(int addressId);
	

//查询所有的市
	List<Address> findAllCity();


	//根据市ID查询区县总数量
	int findCountyCountByParentId(int id);
	
	//删除一个市
	int delAddressByAddId(int addId);
	
	//删除市管辖的所有区县
	int delAllCountyByParentId(int parentId);
	
	//修改一个市名
	int updateCityByAddId(Address address);
	
	//根据城市名查询城市ID
	int findAddIdByAddName(String AddName);
	
	//通过区县ID查询区县名
	String findCountyNameByCountyId(int countyId);
}
