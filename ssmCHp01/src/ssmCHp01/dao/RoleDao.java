package ssmCHp01.dao;

import java.util.List;

import ssmCHp01.entity.Role;



public interface RoleDao {
		//���
		int addRole(Role role);
		//�޸�
		int updateRoleById(Role role);
		//ɾ��
		int delRoleById(int Id);
		//��ѯ
		List<Role> findAllRole();
}
