package com.microservices.composite.model;

public class Product {
	
     private String id;
     private String upc;
     private String name;
     private String description;
     public Product(){}
	public Product(String id, String upc, String name, String description) {
		super();
		this.id = id;
		this.upc = upc;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
     

}
