package com.estore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;




public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Hard-coded authentication : EMAIL and PASSWORD
	private final String EMAIL = "admin@estore.com";
	private final String PASSWORD = "admin@123";
	private final String NAME = "Sofia";
	private final int TOTAL_SALES = 30000;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    //Service Method: get and post method , both handled by service method 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String email = request.getParameter("textEmail");
	    String password = request.getParameter("textPassword");
	  
	  //System.out.println("[LoginServlet]User Details : " + email + " " + password);
	  
	  response.setContentType("text/html");
	  PrintWriter out = response.getWriter();
	  out.print("<center>");
	  out.print("<p> Welcome To eShop !!! <br> <a href='Home' >Click Here to Navigate to Home. </a></p>");
	  
	  /*
	  String message = " ";
	  
	  if(email.equals(EMAIL) && password.equals(PASSWORD)) {
		  
		  //1. 1st Session Tracking with Cookies 
		  //A. Creating Cookies [Object]
		  Cookie cookie1 = new Cookie("KEY_NAME",NAME);
		  Cookie cookie2 = new Cookie("KEY_SALES",String.valueOf(TOTAL_SALES));
		  
		  //B. Writing Cookies 
		  response.addCookie(cookie1);
		  response.addCookie(cookie2);
		  
		  //****************************************************************************
		  
		  //2. 2nd Session Tracking Technique With URL ReWriting
		  //A. Writing Data in URL directly 
		  
		  String url = "Home?name=" + NAME + "&sales="+ TOTAL_SALES;
		  
		 //message = "<p> Welcome to Home <br> <a href='Home' >Click to navigate to Home. </a> </p>";
		  
		 message = "<p> Welcome to Home <br> <a href='"+ url +"' >Click to navigate to Home. </a> </p>";
		  
		 //*****************************************************************************
		  
		  //3. Session Tracking with Hidden Form Fields 
		  // Writing the data in the form as hidden fields
		  
		  String form = "<form action='Home' method ='post'>"
				  + "<input type='hidden' value='"+ NAME +"' name='txtName' />"
				  + "<input type='hidden' value='"+ TOTAL_SALES +"' name='txtSales' />"
				  + "<input type='submit' value='NAVIGATE TO HOME' />"
				  + "</form><br><br>";
		  
		  out.print(form);
		  
		  
		  //4. Session Tracking With HTTP Session
		  // Writing Data in the session object
		  
		  HttpSession session = request.getSession();
		  
		  HashMap<String,String> data = new HashMap<String,String>();
		  
		  data.put("name", NAME);
		  data.put("sales", String.valueOf(TOTAL_SALES));
		  
		  session.setAttribute("key_data", data); // Store HashMap in session

		  out.print("<p><a href='Home'>Click to Navigate to Home with HTTP SESSION</a></p>");
		  
	  }else {
		  message ="<b>Invalid Username or Password </b> ";
	  }
	  
	  String loginTimeStamp = new Date().toString();
	  String htmlResponse = "<h3>Welcome"+ email 
			  +"</h3><p> You Attempted LogIn at" 
			  + loginTimeStamp + "</p><br><br>"
			  +message;
	  
	 
	  out.print(htmlResponse);
	  
	  */
	  
	  out.print("</center>");
	  
	}

  //doGet is not reliable to use 
   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
      String email = request.getParameter("textEmail");
  	  String password = request.getParameter("textPassword");
  	  
  	  System.out.println("[LoginServlet:doGet Method ]User Details : " + email + " " + password);
  	  
  	  response.setContentType("text/html");
  	  
  	  String loginTimeStamp = new Date().toString();
  	  String htmlResponse = "<center><h3>Welcome "+ email +"</h3><p> You LoggedIn at  " + loginTimeStamp + "<br>Handled By doGet Method</p></center>";
  	  
  	  PrintWriter out = response.getWriter();
  	  out.print(htmlResponse);
    	
    	
    }
    */
    
  /*  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
          String email = request.getParameter("textEmail");
    	  String password = request.getParameter("textPassword");
    	  
    	  System.out.println("[LoginServlet:doPost Method ]User Details : " + email + " " + password);
    	  
    	  response.setContentType("text/html");
    	  
    	  String loginTimeStamp = new Date().toString();
    	  String htmlResponse = "<center><h3>Welcome "+ email +"</h3><p> You LoggedIn at  " + loginTimeStamp + "<br>Handled By doPost Method</p></center>";
    	  
    	  PrintWriter out = response.getWriter();
    	  out.print(htmlResponse);
      	
      	
      }
  */
}


/*Notes: 

>> What is Session  and Cookie? 

> Session is a time interval in which the user is connected to the server.
The very first session tracking technique is known as cookies. 

> [Once you have logged in successfully , you can implement session tracking with cookies.] 

> Cookies are the piece of key value pairs, which gets stored on the client’s local machine 
in the browser application. They are going to be persisted in the browser. This means if we disable the cookies, 
we can't perform operation. 

*/