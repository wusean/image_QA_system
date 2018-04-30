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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理admin登录的触发器
 * @author sean
 * @version 2018-04-04 14:34:13
 */
public class AdminLoginFilter implements Filter {

    public AdminLoginFilter() {
        // TODO Auto-generated constructor stub
    }
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Object o = req.getSession().getAttribute("adminLoginUser");
		if(o == null) {
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("<script>alert('请先登录');location='/ImageQA/manage';</script>");
		} else {
			chain.doFilter(request, response);
		}		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
