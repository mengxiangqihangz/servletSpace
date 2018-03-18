package com.mvc.bean;

import java.util.HashMap;

public class BankCustomer {
	private String id,firstName,lastName;
	private double balance;
	
	public BankCustomer(String id,String firstName,String lastName,double balance){
		this.id 	= id;
		this.firstName 	= firstName;
		this.lastName	= lastName;
		this.balance 	= balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	private static HashMap customers;
	static{
		customers = new HashMap<>();
		customers.put("id001", new BankCustomer("id001", "John", "Hacker", -3456.78));
		customers.put("id002", new BankCustomer("id002", "Jane", "Hacker", 1234.56));
		customers.put("id003", new BankCustomer("id003", "Juan", "Hacker", 987654.32));
		
	}
	
	public static BankCustomer getCustomer(String id){
		return (BankCustomer)customers.get(id);
	}
}
