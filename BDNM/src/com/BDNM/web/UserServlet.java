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
 * 用户表数据操作层
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
		
		//用户注销账户的方法
		if(userSign.equals("delUser")){
			out.print("<script>alert('注销');</script>");
		}
		
		//后台用户登录的方法
		if(userSign.equals("adminUserLogin")){
			this.adminUserLogin(request, out, session);
			return;
		}
		
		//后台用户退出登录的方法
		if(userSign.equals("adminUserLogout")){
			this.adminUserlogout(session, out);
			return;
		}
		
		//前台用户登录的方法
		if(userSign.equals("userlogin")){  
			this.userlogin(request, out, session);
			return;
		}
		
		//前台用户退出登录
		if(userSign.equals("userlogout")){
			this.userlogout(session,out);
			return;
		}
		
		//普通用户注册
		if(userSign.equals("userEnroll")){  
			this.userEnroll(request, response, out);
			return;
		};
		
		//校验用户名是否重复
		if(userSign.equals("userNameFind")){  
			this.findUserName(request, out);
			return;
		}
		
		//修改账户余额
				if("upBalance".equals(userSign)){
					int userId=Integer.parseInt(request.getParameter("userId"));//获取用户Id
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
					out.print("<script>alert('充值完成');location.href='front/price.jsp';</script>");
					
				}
		
				//删除用户
				if("deleteUser".equals(userSign)){
					int userId=Integer.parseInt(request.getParameter("userId"));
					int rel=userService.delUserById(userId);
					out.print(rel);
				    out.flush();
				    out.close();
					return;
					}
				
				UserDao userDao=new UserDaoImpl();
				//分页查询数据
				if("getUserPaging".equals(userSign)){
					//获取用户总条数
					int totalCount=userDao.findUserCount();
					PageSurpport<User> pageSurpport=new PageSurpport<User>();
					int pageIndex=1;
					if(request.getParameter("curPage")!=null && !request.getParameter("curPage").equals("")){
						pageIndex=Integer.parseInt(request.getParameter("curPage"));
					}
					pageSurpport.setPageSize(3);
					pageSurpport.setTotalCount(totalCount);
					//处理页异常
					if(pageIndex<1){
						pageIndex=1;
					}
					if(pageIndex>pageSurpport.getPageCount()){
						pageIndex=pageSurpport.getPageCount();
					}
					pageSurpport.setPageIndex(pageIndex);
					//分页数据
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
							out.print("<script>alert('用户名重复，不可用');location.href='after/addUser.jsp'</script>");
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
						out.print("<script>alert('添加成功');location.href='after/addUser.jsp'</script>");
					}else{
						out.print("<script>alert('添加失败');location.href='after/addUser.jsp'</script>");
					}
					
				}
			
	}//doGet
	
	
	
	//后台管理员用户登录的方法    adminUser
	public void adminUserLogin(HttpServletRequest request,PrintWriter out,HttpSession session){
		String username = request.getParameter("userNameSign");
		String pwd = request.getParameter("pwdSign");
		if(username ==null || username.equals("") || pwd==null || pwd.equals("") ){
			out.print("<script>alert('请正确填写');location.href='after/adminLogin.jsp'</script>");
		}else{
			User user = userService.findUserLogin(username, pwd);
			if(user==null){
				out.print("<script>alert('用户名或密码错误');location.href='after/adminLogin.jsp'</script>");
			}else{
				int userType = user.getUserTypeId();
				if(userType==3){
					session.setAttribute("adminUser", user);
					out.print("<script>alert('成功登录');location.href='after/adminIndex.jsp'</script>");
				}else{
					out.print("<script>alert('您不是管理员');location.href='after/adminLogin.jsp'</script>");
				}
			}
		}
	}
	
	//后台管理员用户退出登录的方法  adminUser
	public void adminUserlogout(HttpSession session,PrintWriter out){
		User theUser = (User)session.getAttribute("adminUser");
		if(theUser!=null){
			session.removeAttribute("adminUser");
			out.print("<script>alert('注销成功');location.href='after/adminIndex.jsp'</script>");
		}
	}
	
	//前台普通用户登录的方法   user
	public void userlogin(HttpServletRequest request,PrintWriter out,HttpSession session){
		String username = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		if(username ==null || username.equals("") || pwd==null || pwd.equals("") ){
			out.print("<script>alert('请正确填写');location.href='front/denglu.jsp'</script>");
		}else{
			User user = userService.findUserLogin(username, pwd);
			if(user==null){
				out.print("<script>alert('用户名或密码错误');location.href='front/denglu.jsp'</script>");
			}else{
				int userType = user.getUserTypeId();
				if(userType==1){
					session.setAttribute("user", user);
					out.print("<script>alert('成功登录');location.href='front/index.jsp'</script>");
				}else{
					out.print("<script>alert('只适用于普通用户登录');location.href='front/denglu.jsp'</script>");
				}
			}
		}
		
			
	}
	
	//用户退出的方式   user
	public void userlogout(HttpSession session,PrintWriter out){
		User theUser = (User)session.getAttribute("user");
		if(theUser!=null){
			session.removeAttribute("user");
			out.print("<script>alert('注销成功');location.href='front/index.jsp'</script>");
		}
	}
	

	//用户注册的方法（注册得到为普通用户账户）
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
				out.print("<script>alert('注册成功');location.href='front/index.jsp';</script>");
		}else{
				out.print("<script>alert('注册失败');location.href='front/index.jsp';</script>");
		}
	}
	
	//校验用户名是否重复的方法
	public void findUserName(HttpServletRequest request,PrintWriter out){
		String user = request.getParameter("user");
		int cot = userService.findUserName(user);
		out.print(cot);
		out.flush();
		out.close();
	}
	
	//根据用户ID查找用户的方法
	public  User findUserById(int userid){
		User user = userService.findUserById(userid);
		return user;
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
