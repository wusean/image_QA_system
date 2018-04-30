package com.guet.qa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guet.qa.beans.User;
import com.guet.qa.dao.UserDao;


/**
 * @author sean
 * @version 1.0 2018-04-24 13:31:38
 */
public class ShowUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	int totalUser = 0;
	UserDao dao = new UserDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users=dao.queryAllUsers();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>首页</TITLE></HEAD>");
		out.println("  <BODY>");
        out.println("<table "
        		+ "cellspacing=0 border=1px><tr><th>操作</th><th>用户名</th></tr>");
        for(User u:users){
            out.println("<tr><th><a href='DelUserServlet?username="+u.getUsername()+"'>删除</a></th>");
            out.println("<th>"+u.getUsername()+"</th></tr>");
            totalUser++;
        }
        out.println("<tr>当前的注册用户有："+totalUser+"个</tr>");
        out.println("</table>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
