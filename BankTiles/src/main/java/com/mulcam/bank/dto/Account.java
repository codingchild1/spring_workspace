package com.mulcam.bank.dto;

public class Account {
	String id;//10001
	String name;
	int balance;//155000+50000=205000
	String type;
	String grade;
	public Account() {}
	public Account(String id, String name, int balance, String type, String grade) {
		this.id=id;
		this.name=name;
		this.balance=balance;
		this.type=type;
		this.grade=grade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public void deposit(int money) {
		this.balance+=money;
	}
	public void withdraw(int money) {
		this.balance-=money;
	}
}
