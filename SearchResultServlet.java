package com.guet.qa.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.guet.qa.util.AipOcrUtil;
import com.guet.qa.util.FormatJsonUtil;
		/**
		 * 
		 * @author sean
		 * @version 16:58:33
		 */
public class SearchResultServlet extends HttpServlet {

	//在servlet中显示输出结果不便于格式的调整
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=utf-8");
		String path = request.getParameter("searchtext");
		request.setAttribute("mapPath", path);
		//通过request获取到的值是Object类型的需要强转，还有就是用这种方法不能用重定向到jsp页面，要用转发
		request.getRequestDispatcher("/ShowResult.jsp").forward(request, response);
	}
}
