/**
 * 
 */
package com.guet.qa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet Filter implementation class LoginFilter
 */
/**
 * @author sean
 * @version 2018-04-04 11:22:03
 *
 */
public class LoginFilter implements Filter{
	 /**
     * 默认构造器 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * 过滤器被销毁的时候触发一次
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 每次请求服务器的时候触发一次
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Object o = req.getSession().getAttribute("loginUser");
		if(o == null) {
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("<script>alert('请先登录');location='/ImageQA/index';</script>");
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * 创建过滤器对象的时候，自动触发一次
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
