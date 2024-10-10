package com.estore.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {

	
	public void destroy() {
	 System.out.println("[Login Filter] - destroy executed.");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("<h3>Pre-Processing</h3>");
		
		//Pre-Processing (Filtering Request from Client to Servlet)
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		//Post-Processing (Filtering Response from the Servlet to the client)
		out.print("<h3>Post-Processing</h3>");
		out.print("</center>");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("[LoginFilter] - init executed. ");
	}

}
