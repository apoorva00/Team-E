package com.go.GreatOutdoor_Order.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
 
@Table(name="orders")
 
public class Orders {
 
	@Id
 
	// @GeneratedValue(strategy = GenerationType.AUTO)
 
	int order_id;
 
	@NotBlank(message = "Address can't be empty!!!")
 
	String order_address;
 
	@NotBlank(message = "This field cannot be empty. If it a Gift, enter Yes otherwise No?")
 
	String gift;
 
	@NotNull(message = "Please select the date")
 
	String purchase_date;
 
	@NotNull(message = "Please select the date")
 
	String delivery_date; 
	public int getOrder_id() {
 
		return order_id;
 
	}
 
	public void setOrder_id(int order_id) {
 
		this.order_id = order_id;
 
	}
 
	public String getOrder_address() {
 
		return order_address;
 
	}
 
	public void setOrder_address(String order_address) {
 
		this.order_address = order_address;
 
	}
 
	public String getGift() {
 
		return gift;
 
	}
 
	public void setGift(String gift) {
 
		this.gift = gift;
 
	}
 
	public String getPurchase_date() {
 
		return purchase_date;
 
	}
 
	public void setPurchase_date(String purchase_date) {
 
		this.purchase_date = purchase_date;
 
	}
 
	public String getDelivery_date() {
 
		return delivery_date;
 
	}
 
	public void setDelivery_date(String delivery_date) {
 
		this.delivery_date = delivery_date;
 
	}
 

	public Orders() {
 
		super();
 
		// TODO Auto-generated constructor stub
 
	}
 
	public Orders(int order_id, @NotBlank(message = "Address can't be empty!!!") String order_address,
 
			@NotBlank(message = "This field cannot be empty. If it a Gift, enter Yes otherwise No?") String gift,
 
			@NotBlank(message = "Please select the date") @NotNull(message = "Please select the date") String purchase_date,
 
			@NotBlank(message = "Please select the date") @NotNull(message = "Please select the date") String delivery_date) {
 
		super();
 
		this.order_id = order_id;
 
		this.order_address = order_address;
 
		this.gift = gift;
 
		this.purchase_date = purchase_date;
 
		this.delivery_date = delivery_date;
 
	
	}
 
	@Override
 
	public String toString() {
 
		return "Orders [order_id=" + order_id + ", order_address=" + order_address + ", gift =" + gift
 
				+ ", purchase_date=" + purchase_date + ", delivery_date=" + delivery_date + "]";
 
	}
 
}