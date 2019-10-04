package com.BDNM.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CodeFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
		FilterChain arg2) throws IOException, ServletException {
		String CharCode =  arg0.getServletContext().getInitParameter("CharCode");
		arg0.setCharacterEncoding(CharCode);
		arg1.setContentType("text/html;charset="+CharCode);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
