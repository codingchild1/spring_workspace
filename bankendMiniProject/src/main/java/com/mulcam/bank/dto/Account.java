package com.mulcam.bank.dto;

public class Account {
	String id;
	String password;
	String name1;
	String name;
	int balance;
	String type;
	String grade;
	String bank;
	public Account() {}
	public Account(String id, String password,String name1, String name, int balance, String type, String grade, String bank) {
		this.id=id;
		this.password=password;
		this.name1=name1;
		this.name=name;
		this.balance=balance;
		this.type=type;
		this.grade=grade;
		this.bank=bank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}

	public void deposit(int money) {
		this.balance += money;
	}

	public void withdraw(int money) {
		this.balance -= money;
	}
	public void tax() {
		this.balance -=500;
	}

}
