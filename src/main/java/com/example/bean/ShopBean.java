package com.example.bean;

public class ShopBean {
	
	public ShopBean() {}
	 
	public int id;
	public String name;
	
	public ShopBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}