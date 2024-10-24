package com.estore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.estore.db.DB;
import com.estore.model.Product;



public class AllProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<center>");
		
		DB db = new DB();
		ArrayList<Product> products = db.fetchAllProduct();
		db.closeConnection();
		StringBuffer buffer = new StringBuffer(); 
		
		
		if(products.size() > 0) {
			
			//Create Table In This Buffer
			buffer.append("<table>");
			
			buffer.append("<tr>");
			buffer.append("<td>ID </td>");
			buffer.append("<td>CODE </td>");
			buffer.append("<td>NAME </td>");
			buffer.append("<td>PRICE </td>");
			buffer.append("</tr>");
			
			
			for(Product product : products) {
				buffer.append("<tr>");
				buffer.append("<td>"+ product.id+ "</td>");
				buffer.append("<td>" + product.code + "</td>");
				buffer.append("<td>" + product.name + "</td>");
				buffer.append("<td>" +product.price + " </td>");
				buffer.append("</tr>");
				
			}
			
			buffer.append("</table");
			
		}else {
			
			buffer.append("<h3>No Product Found.");
		}
		
		out.print(buffer.toString());
		

		out.print("<h3><a href='Home'>Back To Home</a></h3> <br> <br>");
		
		out.print("</center>");
		
	}

}
