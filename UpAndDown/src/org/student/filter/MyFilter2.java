package org.student.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class MyFilter2 implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter2...destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("¿πΩÿ«Î«Û2...");
		chain.doFilter(request, response);
		System.out.println("¿πΩÿœÏ”¶2...");
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter2...init");
	}

}
