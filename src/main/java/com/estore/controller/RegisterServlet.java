package com.estore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  String name = request.getParameter("textName");
		  String email = request.getParameter("textEmail");
		  String password = request.getParameter("textPassword");
		  
		  System.out.println("[RegisterServlet]User Details : " + name + " " + email + " " + password);
		  
		  response.setContentType("text/html");
		  
		  String registerTimeStamp = new Date().toString();
		  String htmlResponse = "<center><h3>Thank you "+ name +"</h3><p> You are Registered with email "+ email +" at " + registerTimeStamp+ "</p></center>";
		  
		  PrintWriter out = response.getWriter();
		  out.print(htmlResponse);
	}

}
