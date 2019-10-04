package com.BDNM;

import java.util.List;

import org.junit.Test;

import com.BDNM.dao.AddressDao;
import com.BDNM.dao.ComTypeDao;
import com.BDNM.dao.HotelDetailsDao;
import com.BDNM.dao.HotelTypeDao;
import com.BDNM.dao.RoomTypeDao;
import com.BDNM.dao.impl.AddressDaoImpl;
import com.BDNM.dao.impl.ComTypeDaoImpl;
import com.BDNM.dao.impl.HotelDetailsDaoImpl;
import com.BDNM.dao.impl.HotelTypeDaoImpl;
import com.BDNM.dao.impl.RoomTypeDaoImpl;
import com.BDNM.entity.Address;
import com.BDNM.entity.ComType;
import com.BDNM.entity.HotelDetails;
import com.BDNM.entity.HotelType;
import com.BDNM.entity.RoomType;

public class bdnmtest {
	
	
	AddressDao ada = new AddressDaoImpl();
	
	
	public void a(){
		List<Address> adlist = ada.findAllAddressByAddId(1);
		String st="";
		for(Address aa: adlist ){
			st = aa.getMunicipalAddId()+"--"+aa.getMunicipalAddName()+"--"+aa.getMunicipalParentId()+"--"+aa.getRegionalAddId()+"-"
					+ "-"+aa.getRegionalAddName()+"--"+aa.getRegionalParentId();
			System.out.println(st);
		}
	}
	
	
	public void b(){
		Address ad = new Address();
		ad.setMunicipalAddName("钢城区");
		ad.setMunicipalParentId(58);
		int aa = ada.addAddress(ad);
		System.out.println(aa);
	}
	
	ComTypeDao cty = new ComTypeDaoImpl();
	
	
	public void c(){
		List<ComType> ctlist = cty.findAllComType();
		String stc="";
		for(ComType cc: ctlist ){
			stc = cc.getComId()+"**"+cc.getComName();
			System.out.println(stc);
		}
		
	}
	
	
	public void d(){
		ComType ctt = new ComType();
		ctt.setComName("图书");
		cty.addComType(ctt);
		this.c();
	}
	
	
	public void e(){
		ComType ctt = new ComType();
		ctt.setComId(4);
		ctt.setComName("书籍");
		cty.updateComTypeById(ctt);
		this.c();
	}
	
	
	public void f(){
		cty.delComTypeById(4);
		this.c();
	}
	
	HotelDetailsDao hdd = new HotelDetailsDaoImpl();
	
	
	public void g(){
		List<HotelDetails> hdlist = hdd.findAllHotelDetails();
		String stg = "";
		for(HotelDetails gh:hdlist){
			stg = gh.getHtId()+"--"+gh.getHtName()+"--"+gh.getHtAddress()+"--"+gh.getHtTypeId();
			System.out.println(stg);
		}
	}
	
	
	public void h(){
		HotelDetails hh = hdd.findHotelDetailsById(1);
		System.out.println(hh.getHtId()+"--"+hh.getHtName()+"--"+hh.getHtAddress());
	}
	

	public void i(){
		List<HotelDetails> hdlist = hdd.findHotelDetailsByTypeOrName(0, "家");
		String stg = "";
		for(HotelDetails gh:hdlist){
			stg = gh.getHtId()+"--"+gh.getHtName()+"--"+gh.getHtAddress()+"--"+gh.getHtTypeId();
			System.out.println(stg);
		}
	}
	
	
	public void j(){
		HotelDetails hj = new HotelDetails();
		hj.setHtAddress("北京市东城区伊春路333号");
		hj.setHtId(4);
		hj.setHtIntro("经济舒适");
		hj.setHtName("北京东城区格林豪泰酒店");
		hj.setHtPhone("12341234");
		hj.setHtPictrue("");
		hj.setHtTypeId(1);
		hdd.updateHotelDetails(hj);
		this.h();
	}
	

	public void k(){
		HotelDetails hj = new HotelDetails();
		hj.setHtAddress("济南市历城区山大路52号");
		hj.setHtIntro("经济舒适");
		hj.setHtName("济南市历城区格林豪泰商务酒店");
		hj.setHtPhone("15341238");
		hj.setHtPictrue("");
		hj.setHtTypeId(2);
		hdd.addHotelDetails(hj);
		this.g();
	}
	
	HotelTypeDao htd = new HotelTypeDaoImpl();
	

	public void l(){
		List<HotelType> htList = htd.findAllHotelType();
		String stl="";
		for(HotelType htl : htList){
			stl = htl.getHtTypeId()+"--"+htl.getHtTypeName();
			System.out.println(stl);
		}
	}
	
	
	public void m(){
		HotelType ht = new HotelType();
		ht.setHtTypeName("民宿");
		htd.addHotelType(ht);
		this.l();
	}
	
	
	public void n(){
		HotelType ht = new HotelType();
		ht.setHtTypeId(13);
		ht.setHtTypeName("民宿公寓");
		htd.updateHotelTypeById(ht);
		this.l();
	}

	
	RoomTypeDao rmd = new RoomTypeDaoImpl();
	
}
