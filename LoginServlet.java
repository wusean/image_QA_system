package com.guet.qa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guet.qa.beans.User;
import com.guet.qa.dao.UserDao;
/**
 * 用户登录servlet
 * @author sean
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao userDao = new UserDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	
	//利用javabean传数据到user_function.jsp页面
	//更新时间 2018-04-30 10:21:15
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		boolean isSucc = userDao.validateUser(userName,userPass);
		User user = new User();
		user.setUsername(userName);
		user.setPassword(userPass);
		request.setAttribute("user", user);
		if(isSucc) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userName);
			request.getRequestDispatcher("/user_function.jsp").forward(request, response);
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('用户名或密码不正确！');history.back()</script>");
		}
	}
}
