package com.lulu.project.Product.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prod_id;
	
	@Size(min = 3, max = 15)
	String prod_name;
	String prod_type;
	float prod_price;
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_type() {
		return prod_type;
	}
	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}
	public float getProd_price() {
		return prod_price;
	}
	public void setProd_price(float prod_price) {
		this.prod_price = prod_price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int prod_id, String prod_name, String prod_type, float prod_price) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_type = prod_type;
		this.prod_price = prod_price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(prod_id, prod_name, prod_price, prod_type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return prod_id == other.prod_id && Objects.equals(prod_name, other.prod_name)
				&& Float.floatToIntBits(prod_price) == Float.floatToIntBits(other.prod_price)
				&& Objects.equals(prod_type, other.prod_type);
	}
	
	

	

}
