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


public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//GET Request to display the update
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		int id = Integer.parseInt(request.getParameter("id")); // Get product ID from URL
		
		Product product = new Product();
		DB db = new DB();
		product = db.fetchProductById(id);
		
		db.closeConnection();
		out.print("<center>");
		
		if(product != null) {
			out.println("<form action='Update' method ='post'>");
			out.println("ID: <input type='text' name='id' value='" + product.id + "' readonly><br> <br>");
            out.println("Code: <input type='text' name='code' value='" + product.code + "'><br><br> ");
            out.println("Name: <input type='text' name='name' value='" + product.name + "'><br> <br>");
            out.println("Price: <input type='text' name='price' value='" + product.price + "'><br><br>");
            out.println("<input type='submit' value='Update Product'>");
            out.println("</form>");
		}else {
			out.println("<h3>Product Not Found!!! </h3>");
		}

		
	}
	
	
	
	//POST REQUEST to update product details
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
	     // Get form data
        int id = Integer.parseInt(request.getParameter("id"));
        int code = Integer.parseInt(request.getParameter("code"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
		
		
				
	   //Update Product
        Product product = new Product(id, code , name, price);
		
		DB db =new DB();
		int result = db.updateProduct(product);
		db.closeConnection();
		
		
		out.print("<center>");
		
		String message = " ";
		
		if (result > 0) {
		    System.out.println("Product updated successfully!");
		    message = "ID- " + product.id + " Product:: " + product.name + " Updated Successfully!!!";
		   
		} else {
		    System.out.println("Failed to update product.");
		    message = "ID- " + product.id + " Product:: " + product.name + " Failed to Update.";
		 
		}
	    
		out.print("<h3>" + message + "</h3><br><br>");
		out.print("<h2><a href='ViewProducts'>VIEW PRODUCT </a> </h2>");
		out.print("</center>");
		
	}

}
