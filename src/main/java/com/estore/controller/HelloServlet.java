package com.estore.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

import jakarta.servlet.http.Cookie;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * constructor
     */
    public HelloServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
      super.init(config);
      
      System.out.println("[Hello Servlet] - init executed");
      
    }
    
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("[Hello Servlet] - service executed");
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String htmlResponse = "<center><h3>Welcome To Home Admin</h3>" 
	                 + "<p>Requested Served at  " 
			         +  new Date()+"</p> <br>"
			         + "<p><a href='add-products.html'> ADD PRODUCTS </a></p>"
			         + "<p><a href='ViewProducts'> VIEW PRODUCTS </a></p>";  //Provided the URL Pattern of AllProductsController.java servlet ,which include  UI format to fetch datails
	                
	out.print(htmlResponse);
	
	/*
	
	//1. Session Tracking With Cookies
	//Reading Cookies : In array  
	
	out.print("<p><b>Cookies Data</b></p>");
	Cookie[] array = request.getCookies();
	for(Cookie cookie : array) {
		out.print("<p>" + cookie.getName()+ "-"+cookie.getValue() + "</p>");
		
	}
	
	//2. Session Tracking With URL Rewriting 
	//Reading data from URL
	String name = request.getParameter("name");
	String sales = request.getParameter("sales");
	
	out.print("<p><b>URL Rewriting Data<b></p>");
	out.print("<p>NAME:"+ name +" | SALES: "+ sales +"</p>");
	
	
	//3. Session Tracking with hidden form fields 
	//Reading the data from the  form
	
	String hiddenName = request.getParameter("txtName");
	String hiddenSales = request.getParameter("txtSales");
	
	out.print("<p><b>Hidden Form Fields Data<b></p>");
	out.print("<p>NAME:  "+ hiddenName +" |  SALES: "+ hiddenSales + "</p>");
	
	//4. Session Tracking with HttpSession Object	
	//Read the data from HttpSession
	
	HttpSession session = request.getSession();
	HashMap<String, String> data = (HashMap<String, String>)session.getAttribute("key_data");
	
	out.print("<p><b>HttpSession Object Data<b></p>");
	out.print("<p>NAME:"+ data.get("name")+" |  SALES: "+ data.get("sales") + "</p>");
	
	*/
	
	out.print("</center>");
	
	

	

	}
	
	@Override
	public void destroy() {
		super.destroy();
		 System.out.println("[Hello Servlet] - destroy method executed");
	}

}
