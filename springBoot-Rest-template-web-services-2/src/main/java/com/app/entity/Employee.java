package com.app.entity;


public class Employee {


	private Integer id;
	
	private String name;
	
	private String address;

	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
