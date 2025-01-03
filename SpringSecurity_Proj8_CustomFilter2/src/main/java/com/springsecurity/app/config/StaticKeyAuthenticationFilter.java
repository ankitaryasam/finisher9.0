package com.springsecurity.app.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class StaticKeyAuthenticationFilter implements Filter{
	
	@Value("${authorization.key}")
	private String authorizationKey;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		String authKey = req.getHeader("Authorization");
		
	    if(authKey.equals(authorizationKey)) {
	    	chain.doFilter(req, res);
	    }
	    else {
	    	res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    }
		
		
	}

}
