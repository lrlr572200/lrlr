package ssmCHp02.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import ssmCHp02.entity.User;

public interface UserDao {
	int findUserCount();
	
	User findUserByID(int id);
	/**
	 * 1.��ѯ�����û�
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * 2.ģ����ѯ�û���Ϣ
	 * @return
	 */
	List<User> findUserByName(String userName);
	/**
	 * 3.�����û����ͽ�ɫ��ѯ�û���������� �������һ���ӱ���
	 * @param userName
	 * @param roleId
	 * @return
	 */
	List<User> findUserByNameRole(@Param("userName") String userName, @Param("roleID") int roleID);
	
	/**
	 * 4.�����û����ͽ�ɫ��ѯ�û���������� ��������������������װ��ʵ��
	 */
	List<User> findUserByNameRolePOJO(User user);
	
	/**
	 * 5.�����û����ͽ�ɫ��ѯ�û���������� �������������װΪMap����
	 */
	List<User> findUserByNameRoleMap(Map map);
	
	/**
	 * 6.��ȡ�����û���������н�ɫ���ƣ��û����Ӳ�ѯ 
	 */
	List<User> findAllUser_RoleName();
	/**
	 * 7.����ID��ȡ�û���Ϣ�ͽ�ɫ��Ϣ
	 * @param userID
	 * @return
	 */
	User findUserByID_user_role(int userID);
	
	/**
	 * 8.����ID��ȡ�û���Ϣ�͵�ַ��Ϣ
	 * @param userID
	 * @return
	 */
	User findUserByID_user_Address(int userID);
	/**
	 * 9.����û�
	 * @return
	 */
	int addUser(User user);
}
