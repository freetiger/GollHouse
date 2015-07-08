package cn.goll.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest request=(HttpServletRequest) servletRequest;
		 HttpServletResponse response=(HttpServletResponse) servletResponse;
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 HttpSession session=request.getSession(false);
		 if(session!=null&&session.getAttribute("manager")!=null){
			 chain.doFilter(servletRequest,servletResponse);
		 }else{
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		 }
		
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
	
}
