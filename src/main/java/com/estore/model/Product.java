package com.estore.model;

/*
 * create table Product(
 *    id int primary key auto_increment,
 *    code int,
 *    name varchar(256),
 *    price int
 * )
 * 
 */

public class Product {
	
	//Field Declaration / Attributes 
	public int id;
	public int code;
	public String name;
	public int price;
	
	
	//Generate Non-parameterised constructor
	public Product() {
		
	}



	//Generate Parameterized Constructor 
	public Product(int id, int code, String name, int price) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
	}


	
	//Generate toString Method. 
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	

}
