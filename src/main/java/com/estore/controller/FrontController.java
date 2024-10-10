package com.estore.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		
		out.print("<h3>Welcome to FrontController</h3>");
		
		String typeOfRequest = request.getParameter("txtType");
		
		String url = " ";
		
		if( typeOfRequest.equals("login")) {
			
			url = "Login"; //for the LoginServlet
			
		}else if(typeOfRequest.equals("register")) {
			
			url ="Register"; //for the Register Servlet 
			
		}else {
			
			out.print("<h3>Sorry!!! Request Can Not Be Processed....  </h3>");
			
		}
		
		if(!url.isEmpty()) {
		
		RequestDispatcher  dispatcher = request.getRequestDispatcher(url);
//		 dispatcher.forward(request, response);  //This skip the portion written in line no:25 of FrontController
		
		dispatcher.include(request, response);  //Responses Included whatever written for browser 
		}
		
		
		out.print("</center>");
	
	}

}
