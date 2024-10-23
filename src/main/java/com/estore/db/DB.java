package com.estore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
	
	
	//Method To Close Connection
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("[DB] Connection to DB Closed");
		}catch (Exception e){
			
		}
	}
	
	
	
}
