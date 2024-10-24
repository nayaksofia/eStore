package com.estore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.estore.db.DB;


public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<center>");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Create the instance of DB() to generate connection
		DB db = new DB();
		int result = db.deleteProduct(id);  //deleteProduct() is declared in DB Servlet
		
		if(result > 0) {
			out.print("<h3>Product Deleted Successfully!!! </h3>");
		}else {
			out.print("<h3> Product Not Deleted Successfully!!!  </h3>");
	    }
		
		out.print("<h3><a href='ViewProducts'>VIEW PRODUCT </a> </h3>");
		
		out.print("</center>");
	}

}
