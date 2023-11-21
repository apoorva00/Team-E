package com.project.Customer.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
	 
	@Entity
	 
	@Table(name = "Customer")
	 
	public class Customer {
	 
		@Id
	 
		//@GeneratedValue(strategy = GenerationType.AUTO)
	 
		int customer_id;
	 
		@NotBlank(message = "name is mandatory")
	 
		@Size(min = 4, max = 15)
	 
		String customer_name;
	 
		@NotBlank(message = "Address is mandatory")
	 
		String customer_address;
	 
		@NotBlank(message = "Email is mandatory")
	 
		@Email
	 
		@Column(unique = true)
	 
		String email;
	 
		@NotBlank(message = "Phone number is mandatory")
	 
		@Size(min = 10, max = 10)
	 
		String phone_no;
	 
		@NotBlank(message = "Password is mandatory")
	 
		@Size(min = 8, max = 15)
	 
		String password;
	 
		int pincode;
	 
//	    @OneToMany
	 
//	    private Orders orders;
	 
		public int getCustomer_id() {
	 
			return customer_id;
	 
		}
	 
		public void setCustomer_id(int customer_id) {
	 
			this.customer_id = customer_id;
	 
		}
	 
		public String getCustomer_name() {
	 
			return customer_name;
	 
		}
	 
		public void setCustomer_name(String customer_name) {
	 
			this.customer_name = customer_name;
	 
		}
	 
		public String getCustomer_address() {
	 
			return customer_address;
	 
		}
	 
		public void setCustomer_address(String customer_address) {
	 
			this.customer_address = customer_address;
	 
		}
	 
		public String getEmail() {
	 
			return email;
	 
		}
	 
		public void setEmail(String email) {
	 
			this.email = email;
	 
		}
	 
		public String getPhone_no() {
	 
			return phone_no;
	 
		}
	 
		public void setPhone_no(String phone_no) {
	 
			this.phone_no = phone_no;
	 
		}
	 
		public String getPassword() {
	 
			return password;
	 
		}
	 
		public void setPassword(String password) {
	 
			this.password = password;
	 
		}
	 
		public int getPincode() {
	 
			return pincode;
	 
		}
	 
		public void setPincode(int pincode) {
	 
			this.pincode = pincode;
	 
		}
	 
//	    public Orders getOrders() {
	 
//	        return orders;
	 
//	    }
	 
	//
	 
//	    public void setOrders(Orders orders) {
	 
//	        this.orders = orders;
	 
//	    }
	 
		public Customer() {
	 
			super();
	 
		}
	 
		public Customer(int customer_id,
	 
				@NotBlank(message = "name is mandatory") @Size(min = 4, max = 15) String customer_name,
	 
				@NotBlank(message = "Address is mandatory") String customer_address,
	 
				@NotBlank(message = "Email is mandatory") @Email String email,
	 
				@NotBlank(message = "Phone number is mandatory") @Size(min = 10, max = 10) String phone_no,
	 
				@NotBlank(message = "Password is mandatory") @Size(min = 8, max = 15) String password,
	 
				@NotEmpty(message = "Please enter the pincode!!!") int pincode) {
	 
			super();
	 
			this.customer_id = customer_id;
	 
			this.customer_name = customer_name;
	 
			this.customer_address = customer_address;
	 
			this.email = email;
	 
			this.phone_no = phone_no;
	 
			this.password = password;
	 
			this.pincode = pincode;
	 
//	        this.orders = orders;
	 
		}
	 
		@Override
	 
		public String toString() {
	 
			return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address="
	 
					+ customer_address + ", email=" + email + ", phone_no=" + phone_no + ", password=" + password
	 
					+ ", pincode=" + pincode + "]";
	 
		}
	 
	}


