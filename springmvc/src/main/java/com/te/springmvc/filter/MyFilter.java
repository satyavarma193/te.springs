package com.te.springmvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		System.out.println("Inside doFilter");
		System.out.println("Url: " + servletRequest.getRequestURL());
		System.out.println("Uri: " + servletRequest.getRequestURI());
		System.out.println("Method: " + servletRequest.getMethod());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
