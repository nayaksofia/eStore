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
	
	
	//Method To AddProduct
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
			System.out.println("Something went wrong during adding product values!!! "+e);
		}
		
		return result;
		
	}
	
	
	//Method to : Fetch All Data From Database 
	 public ArrayList<Product> fetchAllProduct(){
		
		 ArrayList<Product> products = new ArrayList<Product>();
		 
		 try {
			 String sql = "select * from Product";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 
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
			 System.out.println("Something Went Wrong During Fetching All Data : " +e);
		 }
		 
		 return products;
	 }
	
	 
	 // Method to fetch product by Id 
	 public Product fetchProductById(int id) {
		
		 Product product = null;
		
		try {
			
			//SQL query to select a product by ID
			String sql = "select * from Product where id = ?  ";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			//Execute the query

			 ResultSet set = preparedStatement.executeQuery();
			 
			 //Check while a product was found 
			 while(set.next()) {
				product = new Product();
				
				product.id = set.getInt("id");
				product.code = set.getInt("code");
				product.name =set.getString("name");
				product.price = set.getInt("price");
				
			 }
			
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong while fetching product by ID: " + e);
		}
		
		return product; //Return the product object / null if not found 
	 }
	 
	 
	 
	 ///Method To Update the Product By Id
	 public int updateProduct(Product product) {
			int result = 0;
			
			try {
				
				String sql = "UPDATE Product SET code = ?, name = ?, price = ? WHERE id = ?";
				
				preparedStatement = connection.prepareStatement(sql);	
				
				preparedStatement.setInt(1, product.code); 
				preparedStatement.setString(2, product.name);
				preparedStatement.setInt(3, product.price); 
				preparedStatement.setInt(4,product.id); 
				
				//Execute the update query
				result = preparedStatement.executeUpdate();
				
			}catch (SQLException e) {
				System.out.println("Something went wrong during updater!!! "+e);
			}
			
			return result;
			
		}
	 
	 
	 //Method To Delete the Product
	 public int deleteProduct(int id) {
			int result = 0;
			
			try {
				
				String sql = "delete from Product where id=? ";
				
				preparedStatement = connection.prepareStatement(sql);	
				preparedStatement.setInt(1, id); //1st Column Id
				
				
				result = preparedStatement.executeUpdate();
				
			}catch (SQLException e) {
				System.out.println("Something went wrong!!! "+e);
			}
			
			return result;
			
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
