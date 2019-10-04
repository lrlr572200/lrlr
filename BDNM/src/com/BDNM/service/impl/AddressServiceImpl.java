package com.BDNM.service.impl;

import java.util.List;

import com.BDNM.dao.AddressDao;
import com.BDNM.dao.impl.AddressDaoImpl;
import com.BDNM.entity.Address;
import com.BDNM.service.AddressService;
/**
 *2、 地址表Address   数据操作
 * 
 *
 */
public class AddressServiceImpl implements AddressService {

	private AddressDao addressService = new AddressDaoImpl();
	
	@Override
	public int addAddress(Address address) {
		return addressService.addAddress(address);
	}

	@Override
	public List<Address> findAllAddress() {
		return addressService.findAllAddress();
	}

	@Override
	public List<Address> findAllAddressByAddId(int addressId) {
		return addressService.findAllAddressByAddId(addressId);
	}

	@Override
	public List<Address> findAllCity() {
		return addressService.findAllCity();
	}

	@Override
	public int findCountyCountByParentId(int id) {
		return addressService.findCountyCountByParentId(id);
	}

	@Override
	public int delAddressByAddId(int addId) {
		return addressService.delAddressByAddId(addId);
	}

	@Override
	public int delAllCountyByParentId(int parentId) {
		return addressService.delAllCountyByParentId(parentId);
	}

	@Override
	public int updateCityByAddId(Address address) {
		return addressService.updateCityByAddId(address);
	}

	@Override
	public int findAddIdByAddName(String AddName) {
		return addressService.findAddIdByAddName(AddName);
	}

	@Override
	public String findCountyNameByCountyId(int countyId) {
		return addressService.findCountyNameByCountyId(countyId);
	}

}
