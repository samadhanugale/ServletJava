package com.neosoft;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = {"/*"}, //Applied filter for all
		initParams = {
				@WebInitParam(name="LogParameter",value="LoginInfo")
		}
			)
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(filterConfig.getInitParameter("LogParameter"));
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Log some info on console
		System.out.println("New Request time : "+new Date().toString());
		System.out.println("Remote Address : "+request.getRemoteAddr());
		System.out.println("Remote Host : "+request.getRemoteHost());
		System.out.println("LocalHost : "+request.getLocalName());
		System.out.println("Local Port : "+request.getLocalPort());
		System.out.println("Protocol : "+request.getProtocol());
		
		
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

}
