package com.BDNM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BDNM.dao.UserDao;
import com.BDNM.dao.impl.UserDaoImpl;
import com.BDNM.entity.User;
import com.BDNM.service.UserService;
import com.BDNM.service.impl.UserServiceImpl;
import com.BDNM.utils.PageSurpport;
import com.BDNM.utils.StaticUtils;
/**
 * �û������ݲ�����
 */
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}
	
	UserService userService=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userSign = request.getParameter("userSign");
		
		//�û�ע���˻��ķ���
		if(userSign.equals("delUser")){
			out.print("<script>alert('ע��');</script>");
		}
		
		//��̨�û���¼�ķ���
		if(userSign.equals("adminUserLogin")){
			this.adminUserLogin(request, out, session);
			return;
		}
		
		//��̨�û��˳���¼�ķ���
		if(userSign.equals("adminUserLogout")){
			this.adminUserlogout(session, out);
			return;
		}
		
		//ǰ̨�û���¼�ķ���
		if(userSign.equals("userlogin")){  
			this.userlogin(request, out, session);
			return;
		}
		
		//ǰ̨�û��˳���¼
		if(userSign.equals("userlogout")){
			this.userlogout(session,out);
			return;
		}
		
		//��ͨ�û�ע��
		if(userSign.equals("userEnroll")){  
			this.userEnroll(request, response, out);
			return;
		};
		
		//У���û����Ƿ��ظ�
		if(userSign.equals("userNameFind")){  
			this.findUserName(request, out);
			return;
		}
		
		//�޸��˻����
				if("upBalance".equals(userSign)){
					int userId=Integer.parseInt(request.getParameter("userId"));//��ȡ�û�Id
					String str = request.getParameter("chongzhi");
					double chongzhi=0;
					if(str!=null && str.equals("")){
						 chongzhi=0;
					}else{
						chongzhi=Double.parseDouble(str);
					}
					UserService userService=new UserServiceImpl();
					User user=userService.findUserById(userId);
					double balance=user.getBalance()+chongzhi;
					System.out.println(balance);
					System.out.println(chongzhi);
					userService.updUserBalanceById(balance, userId);
					out.print("<script>alert('��ֵ���');location.href='front/price.jsp';</script>");
					
				}
		
				//ɾ���û�
				if("deleteUser".equals(userSign)){
					int userId=Integer.parseInt(request.getParameter("userId"));
					int rel=userService.delUserById(userId);
					out.print(rel);
				    out.flush();
				    out.close();
					return;
					}
				
				UserDao userDao=new UserDaoImpl();
				//��ҳ��ѯ����
				if("getUserPaging".equals(userSign)){
					//��ȡ�û�������
					int totalCount=userDao.findUserCount();
					PageSurpport<User> pageSurpport=new PageSurpport<User>();
					int pageIndex=1;
					if(request.getParameter("curPage")!=null && !request.getParameter("curPage").equals("")){
						pageIndex=Integer.parseInt(request.getParameter("curPage"));
					}
					pageSurpport.setPageSize(3);
					pageSurpport.setTotalCount(totalCount);
					//����ҳ�쳣
					if(pageIndex<1){
						pageIndex=1;
					}
					if(pageIndex>pageSurpport.getPageCount()){
						pageIndex=pageSurpport.getPageCount();
					}
					pageSurpport.setPageIndex(pageIndex);
					//��ҳ����
					List<User> userList=userDao.findAllUserPaging(pageSurpport.getPageIndex(), pageSurpport.getPageSize());
					pageSurpport.setDataList(userList);
					request.setAttribute("pageSurpport",pageSurpport);
					request.getRequestDispatcher("after/userList.jsp").forward(request, response);
				}
				
				if("adminAddUser".equals(userSign)){
					String userName=request.getParameter("userName");
					List<User> userList= userService.findAllUser();
					for(User u:userList){
						if(userName.equals(u.getUserName())){
							out.print("<script>alert('�û����ظ���������');location.href='after/addUser.jsp'</script>");
						}
					}
					String pwd=request.getParameter("pwd");
					int userTypeId=Integer.parseInt(request.getParameter("role"));
					User user=new User();
					user.setPassword(pwd);
					user.setUserName(userName);
					user.setUserTypeId(userTypeId);
					int rel=userService.adminAddUser(user);
					if(rel>0){
						out.print("<script>alert('��ӳɹ�');location.href='after/addUser.jsp'</script>");
					}else{
						out.print("<script>alert('���ʧ��');location.href='after/addUser.jsp'</script>");
					}
					
				}
			
	}//doGet
	
	
	
	//��̨����Ա�û���¼�ķ���    adminUser
	public void adminUserLogin(HttpServletRequest request,PrintWriter out,HttpSession session){
		String username = request.getParameter("userNameSign");
		String pwd = request.getParameter("pwdSign");
		if(username ==null || username.equals("") || pwd==null || pwd.equals("") ){
			out.print("<script>alert('����ȷ��д');location.href='after/adminLogin.jsp'</script>");
		}else{
			User user = userService.findUserLogin(username, pwd);
			if(user==null){
				out.print("<script>alert('�û������������');location.href='after/adminLogin.jsp'</script>");
			}else{
				int userType = user.getUserTypeId();
				if(userType==3){
					session.setAttribute("adminUser", user);
					out.print("<script>alert('�ɹ���¼');location.href='after/adminIndex.jsp'</script>");
				}else{
					out.print("<script>alert('�����ǹ���Ա');location.href='after/adminLogin.jsp'</script>");
				}
			}
		}
	}
	
	//��̨����Ա�û��˳���¼�ķ���  adminUser
	public void adminUserlogout(HttpSession session,PrintWriter out){
		User theUser = (User)session.getAttribute("adminUser");
		if(theUser!=null){
			session.removeAttribute("adminUser");
			out.print("<script>alert('ע���ɹ�');location.href='after/adminIndex.jsp'</script>");
		}
	}
	
	//ǰ̨��ͨ�û���¼�ķ���   user
	public void userlogin(HttpServletRequest request,PrintWriter out,HttpSession session){
		String username = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		if(username ==null || username.equals("") || pwd==null || pwd.equals("") ){
			out.print("<script>alert('����ȷ��д');location.href='front/denglu.jsp'</script>");
		}else{
			User user = userService.findUserLogin(username, pwd);
			if(user==null){
				out.print("<script>alert('�û������������');location.href='front/denglu.jsp'</script>");
			}else{
				int userType = user.getUserTypeId();
				if(userType==1){
					session.setAttribute("user", user);
					out.print("<script>alert('�ɹ���¼');location.href='front/index.jsp'</script>");
				}else{
					out.print("<script>alert('ֻ��������ͨ�û���¼');location.href='front/denglu.jsp'</script>");
				}
			}
		}
		
			
	}
	
	//�û��˳��ķ�ʽ   user
	public void userlogout(HttpSession session,PrintWriter out){
		User theUser = (User)session.getAttribute("user");
		if(theUser!=null){
			session.removeAttribute("user");
			out.print("<script>alert('ע���ɹ�');location.href='front/index.jsp'</script>");
		}
	}
	

	//�û�ע��ķ�����ע��õ�Ϊ��ͨ�û��˻���
	public void userEnroll(HttpServletRequest request,HttpServletResponse response,PrintWriter out){
		User users=new User();
		String user=request.getParameter("user");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pwd");
		users.setUserName(user);
		users.setPhone(phone);
		users.setPassword(pwd);
		boolean flag=userService.register(users);
		if(flag){
				out.print("<script>alert('ע��ɹ�');location.href='front/index.jsp';</script>");
		}else{
				out.print("<script>alert('ע��ʧ��');location.href='front/index.jsp';</script>");
		}
	}
	
	//У���û����Ƿ��ظ��ķ���
	public void findUserName(HttpServletRequest request,PrintWriter out){
		String user = request.getParameter("user");
		int cot = userService.findUserName(user);
		out.print(cot);
		out.flush();
		out.close();
	}
	
	//�����û�ID�����û��ķ���
	public  User findUserById(int userid){
		User user = userService.findUserById(userid);
		return user;
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
