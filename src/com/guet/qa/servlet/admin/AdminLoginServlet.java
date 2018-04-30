package com.guet.qa.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guet.qa.dao.UserDao;

/**
 * Servlet implementation class AdminLoginServlet
 */

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("adminname");
		String password  = request.getParameter("password");
		
		boolean isSucc = userDao.validateAdminUser(name, password);
		if(isSucc) {
			request.getSession().setAttribute("adminLoginUser", name);
			response.sendRedirect("/ImageQA/admin_manage.jsp");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('用户名或密码不正确！');history.back()</script>");
		}
	}

}
