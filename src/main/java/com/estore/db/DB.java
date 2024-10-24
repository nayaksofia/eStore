package com.estore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.estore.model.Product;

/*
 * Implement Data Access Object [DAO] 
 */

public class DB {

	Connection connection;
	PreparedStatement preparedStatement;
	
	
	
	//Method to Create Connection with Database
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("[DB] Driver Loaded!!!");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/estore","root","root");
			System.out.println("[DB] Connection Created!!!");
			
		}catch(Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		
	}
	
	//Method To write mySQL statement : To AddProduct
	public int addProduct(Product product) {
		int result = 0;
		
		try {
			
			String sql = "insert into Product values(null, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setInt(1, product.code);
			preparedStatement.setString(2, product.name);
			preparedStatement.setInt(3, product.price);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("Something went wrong!!! "+e);
		}
		
		return result;
		
	}
	
	
	//Method To[mySQL statement]: Fetch Data From Database 
	 public ArrayList<Product> fetchAllProduct(){
		
		 ArrayList<Product> products = new ArrayList<Product>();
		 
		 try {
			 String sql1 = "select * from Product";
			 preparedStatement = connection.prepareStatement(sql1);
			 
			 ResultSet set = preparedStatement.executeQuery();
			 
			 while(set.next()) {
				 
				 Product product = new Product();
				 product.id = set.getInt(1);  //Column 1
				 product.code = set.getInt(2);  //Column 2
				 product.name = set.getString(3); //Column 3
				 product.price = set.getInt(4);  //Column 4
				 
				 products.add(product);
			 }
			 
			 
		 }catch(Exception e) {
			 System.out.println("Something Went Wrong: " +e);
		 }
		 
		 return products;
	 }
	
	 
	 
	//Method To Close Connection
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("[DB] Connection to DB Closed");
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
}
