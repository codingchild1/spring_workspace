package com.mulcam.bank.dto;

public class Member {
	String id;
	String name;
	String password;
	String birth;
	String gender;
	String number;
	String email;
	public Member() {}
	public Member(String id, String name, String password,
			String birth, String gender, String number, String email) {
		this.id=id;
		this.name=name;
		this.password=password;
		this.birth=birth;
		this.gender=gender;
		this.number=number;
		this.email=email;
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
