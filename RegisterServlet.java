package com.guet.qa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guet.qa.dao.UserDao;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
        UserDao userdao=new UserDao();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String rpwd = request.getParameter("rpwd");
        
         /** 对用户注册servlet完整性改进
         *  @version 2018-04-09 10:22:20
         */
        if(userdao.validateUserName(username))
        	out.write("<script>alert('请勿重复注册！');history.back()</script>");
        else if(username==null||username.trim().isEmpty())
        	out.write("<script>alert('用户名不能为空！');history.back()</script>");
        else if(password==null||password.trim().isEmpty())
        	out.write("<script>alert('密码不能为空！');history.back()</script>");
        else if(!password.equals(rpwd))
        	out.write("<script>alert('两次密码输入不一致！');history.back()</script>");
        else
        {
		userdao.addUser(username, password);
		out.write("<script>alert('注册成功！');history.back()</script>");
        }  	
	}
}
