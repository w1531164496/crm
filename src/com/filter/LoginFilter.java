package com.filter;

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
import javax.servlet.http.HttpSession;

import crm.model.Employee;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter",urlPatterns={"/*"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		Employee em=(Employee)session.getAttribute("curuser");
		String contextpath =req.getServletPath();  //获取请求的url	
		String path=req.getContextPath();
		
		
		
		if(em != null)
		{
			
			chain.doFilter(request, response);
		}	
		else if(contextpath.indexOf("/LoginServlet")>=0 || contextpath.indexOf("login")>=0 || contextpath.indexOf("/css/")>=0 || contextpath.indexOf("/images/")>=0 || contextpath.indexOf("/layui/")>=0 || contextpath.indexOf("/plugins/")>=0
				|| contextpath.indexOf("/CodeServlet")>=0)
		{
			chain.doFilter(request, response);
		}
		else
		{
			res.sendRedirect(path+"/static/login.html");
		}
		
		

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
