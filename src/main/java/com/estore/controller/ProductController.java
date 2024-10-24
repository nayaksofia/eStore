package com.estore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.estore.db.DB;
import com.estore.model.Product;



public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//create Instance of Product Class
		Product product = new Product();
		product.code = Integer.parseInt(request.getParameter("textCode"));
		product.name = request.getParameter("textName");
		product.price = Integer.parseInt(request.getParameter("textPrice"));
		
		System.out.println("[Product Servlet] Product Details: " + product);
		
		
		//Instance of DB Class
		DB db = new DB();
		int result = db.addProduct(product);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<center>");
		
		String message = " ";
		
		if(result > 0) {
			message = product.name + " Added in Database Successfully!!!";
		}else {
			message = product.name + " Not Added in the Database, Please Try Again";
		}
		
		out.print("<p>" + message + "</p><br><br>");
		out.print("<h3><a href='Home'>Back Home:Click  </a></h3>");
		
		out.print("</center>");
	}

}
