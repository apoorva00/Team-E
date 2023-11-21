package com.lulu.project.Login.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="signup")
public class Signup {
	
	@Id
	int id;
	String username;
	@Size(min = 8, max = 30, message = "employee name must be at least 8 characters long and less than 30 characters")
	String password;
	String email;
	int ph;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Signup(int id, String username, String password, String email, int ph) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ph = ph;
	}
	
	

}
