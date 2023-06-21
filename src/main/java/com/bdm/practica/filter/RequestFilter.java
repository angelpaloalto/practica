package com.bdm.practica.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements Filter {
	
	private static final Logger LOG = LoggerFactory.getLogger(RequestFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		Cookie[] cookies = httpServletRequest.getCookies();
		LOG.info("cookie: {}: {}", cookies[0].getName(), cookies[0].getValue());
		
		chain.doFilter(httpServletRequest, httpServletResponse);
		
	}

}
