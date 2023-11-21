package com.project.Payment.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	int payid;
	String paymethod;
	String paycoupon;
	float payamt;
	String paydate;
	
	
	
	public Payment(int payid, String paymethod, String paycoupon, float payamt, String paydate) {
		super();
		this.payid = payid;
		this.paymethod = paymethod;
		this.paycoupon = paycoupon;
		this.payamt = payamt;
		this.paydate = paydate;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPayid() {
		return payid;
	}
	public void setPayid(int payid) {
		this.payid = payid;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getPaycoupon() {
		return paycoupon;
	}
	public void setPaycoupon(String paycoupon) {
		this.paycoupon = paycoupon;
	}
	public float getPayamt() {
		return payamt;
	}
	public void setPayamt(float payamt) {
		this.payamt = payamt;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	
	
	

}
