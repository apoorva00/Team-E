package com.project.Customer.repo;


	 
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;

import com.project.Customer.entity.Customer;
	 
	
	 
	public interface CustomerRepo extends JpaRepository<Customer, Integer> {
		@Query(value = "SELECT * FROM customer WHERE customer_name  LIKE(:letter)", nativeQuery = true)
		Customer findByNameLike(@Param("letter") String letter);
		// TODO Auto-generated method stub
		// is is the customized method
	}
	
	

