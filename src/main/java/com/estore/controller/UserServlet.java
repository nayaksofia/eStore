package com.estore.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StringBuffer responseText = new StringBuffer();
		responseText.append("<center>");
		
		ServletConfig config = getServletConfig();
		String appName =  config.getInitParameter("appName");
		//String memoryUsageThreshold = config.getInitParameter("memoryUsageThreshold");
		
		responseText.append("<h3>" + appName + "</h3>");

		
		Enumeration<String> paramNames = config.getInitParameterNames();
		while(paramNames.hasMoreElements()) {
			String name = paramNames.nextElement(); //parameter name
			String value = config.getInitParameter(name);
			responseText.append("<p>" + name + " " + value +  "</p> <br> <br>");
		}
		
		
		responseText.append("</center>");
		
		
		out.print(responseText.toString());
		
		
	}

}
