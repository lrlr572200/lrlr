package ssmCHp01.dao;

import java.util.List;

import ssmCHp01.entity.Role;



public interface RoleDao {
		//Ìí¼Ó
		int addRole(Role role);
		//ÐÞ¸Ä
		int updateRoleById(Role role);
		//É¾³ý
		int delRoleById(int Id);
		//²éÑ¯
		List<Role> findAllRole();
}
