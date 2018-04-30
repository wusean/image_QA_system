package com.guet.qa.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guet.qa.dao.UserDao;

/**
 * 删除用户的servlet类
 * @author sean
 * @version 1.0 2018-04-24 11:24:14
 */


public class DelUserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String username=request.getParameter("username");
        UserDao dao=new UserDao();
        dao.delUser(username);
        //转到主页--重定向
        response.sendRedirect("/ImageQA/admin_home.jsp");
	}

}
