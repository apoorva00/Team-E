package com.project.Customer.controller;


	import java.util.List;
	 
	
	 
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	 
	
	 
	
import com.project.Customer.entity.Customer;
import com.project.Customer.exception.CustomerAlreadyExistsException;
import com.project.Customer.repo.CustomerRepo;

import jakarta.validation.Valid;
	 
	@CrossOrigin
	@RestController
	@RequestMapping("/GreatOutdoors/Customer/")
	 
	public class ControllerCustomer {
		@Autowired
		CustomerRepo cr;
	 
		// Create/Insert data
		@PostMapping("/register")
		public Customer createCustomer(@RequestBody Customer customer) {
			return cr.save(customer);
		}
	 
		@PostMapping("/register2")
		public String createCustomer2(@Valid @RequestBody Customer customer) {
			Customer existingCustomer = null;
//	      Customer
			existingCustomer = cr.findByNameLike(customer.getCustomer_name());	
			if (existingCustomer == null) {
				cr.save(customer);
				return "Customer added successfully";
			}
			else
			{
				return "Customer already exist!";
			}
 
			
		}
	 
		// Read data
		@GetMapping("/getcustomer")
		public List<Customer> getCustomer() {
			return cr.findAll();
		}
	 
		@GetMapping("/login/{customer_id}/{password}")
		public String login(@PathVariable("customer_id") int customer_id, @PathVariable("password") String password,
				@RequestBody Customer customer) {
			Customer user = cr.findById(customer_id)
					.orElseThrow(() -> new RuntimeException("Customer does not exist with id :" + customer_id));
			int id = user.getCustomer_id();
			String password1 = user.getPassword();
			if ((customer_id == id) && (password.equals(password1))) {
				return "Login Successful";
			}
	 
			return "Login UnSuccessful";
		}
		// Delete data
	 
		@DeleteMapping("/deletecustomer/{customer_id}")
	 
		public String getCustomer(@PathVariable("customer_id") int customer_id) {
	 
			cr.deleteById(customer_id);
	 
			System.out.println("Record got deleted");
	 
			return "Is deleted";
	 
		}
	 
	//Delete multiple data
	 
		@DeleteMapping("/deletecustomers/{customer_id1}/{customer_id2}")
		public String deleteCustomers(@PathVariable("customer_id") int customer_id1,
				@PathVariable("customer_id2") int customer_id2) {
			cr.deleteById(customer_id1);
			cr.deleteById(customer_id2);
			System.out.println("Customer 1 got Deleted");
			System.out.println("Customer 2 got Deleted");
			return "Is deleted";
	 
		}
	 
		// Update data
	 
		@PutMapping("/updatecustomer/{customer_id}")
	 
		public ResponseEntity<Customer> updateCustomer(@PathVariable("customer_id") int customer_id,
				@RequestBody Customer customerbypostman) {
	 
			Customer customer = cr.findById(customer_id)
					.orElseThrow(() -> new RuntimeException("Customer does not exist with id :" + customer_id));
	 
			customer.setCustomer_id(customerbypostman.getCustomer_id());
	 
			customer.setCustomer_name(customerbypostman.getCustomer_name());
	 
			customer.setCustomer_address(customerbypostman.getCustomer_address());
	 
			customer.setEmail(customerbypostman.getEmail());
	 
			customer.setPhone_no(customerbypostman.getPhone_no());
	 
			customer.setPassword(customerbypostman.getPassword());
	 
			customer.setPincode(customerbypostman.getPincode());
	 
			Customer updatedCustomer = cr.save(customer);
	 
			return ResponseEntity.ok(updatedCustomer);
	 
		}
	}

