

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import ssmCHp01.dao.RoleDao;
import ssmCHp01.dao.UserDao;
import ssmCHp01.dao.impl.RoleDaoImpl;
import ssmCHp01.dao.impl.UserDaoImpl;
import ssmCHp01.entity.Role;
import ssmCHp01.entity.User;


public class TextMybatis {
	//ʵ����־����
	Logger log=Logger.getLogger(TextMybatis.class);
	UserDao userDao=new UserDaoImpl();
	@Test
		public void text1(){
			
			int count=userDao.findUserCount();
			//System.out.println("�û���"+count);
			log.info("信息"+count);
			log.debug("�û���"+count);
			
		}
	@Test
	public void text2(){
	 User user=	userDao.findUserByID(5);
	 System.out.println(user.getUserName());
	}
	RoleDao roleDao=new RoleDaoImpl();
	
	@Test
	public void text3(){
		Role role=new Role();
		role.setRoleCode("SMBMS_AYWQ");
		role.setRoleName("��ѽ��ȥ");
		role.setCreatedBy(1);
		role.setCreationDate(new Date());
		int rel=roleDao.addRole(role);
		System.out.println(rel);
	}
	@Test
	public void text4(){
		Role role=new Role();
		role.setRoleCode("SMBMS_LR");
		role.setRoleName("���³�");
		role.setId(4);
		int rel=roleDao.updateRoleById(role);
		System.out.println(rel);
	}
	@Test
	public void text5(){
		Role role=new Role();
		role.setId(4);
		int rel=roleDao.delRoleById(role.getId());
		System.out.println(rel);
	}
	@Test
	public void text6(){
		List<Role> roList=roleDao.findAllRole();
		for(Role role:roList){
			System.out.println(role.getId()+"-"+role.getRoleName());
		}
	}
}
