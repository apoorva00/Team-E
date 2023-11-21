package com.example.demo.entity;

import java.time.LocalDate;
//import org.antlr.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table
 
public class Returns {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int return_id;
	//@NotBlank(message = "Please spesify the reason!!!")
	String reason;
	//@NotBlank(message = "Please select the date")
	//@NotNull
	String return_date;

	public Returns() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public Returns(int return_id, String reason, String return_date) {
		super();
		this.return_id = return_id;
 
		this.reason = reason;
		this.return_date = return_date;
	}
 
	
 
	public int getReturn_id() {
		return return_id;
	}
 
	public void setReturn_id(int return_id) {
		this.return_id = return_id;
	}
 
	public String getReason() {
		return reason;
	}
 
	public void setReason(String reason) {
		this.reason = reason;
	}
 
	public String getReturn_date() {
		return return_date;
	}
 
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
 
	@Override
	public String toString() {
		return "Returns [r_id=" + return_id + ", reason=" + reason + ", return_date=" + return_date + "]";
	}
}