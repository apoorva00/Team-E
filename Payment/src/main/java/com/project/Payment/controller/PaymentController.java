package com.project.Payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Payment.entity.Payment;
import com.project.Payment.repo.PaymentRepo;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentRepo repo;
	
	
	@GetMapping("/pay")
	public List<Payment> getJPQL() {
		return repo.findAll();	
	}
	
	@PostMapping("/pay")
	public Payment createuser(@RequestBody Payment payment) {
		return repo.save(payment);
	}
	
	@DeleteMapping("/pay/{id}")
	public void deletUser(@PathVariable("id") Integer id  ) {
		repo.deleteById(id); 
	}
	
	@PatchMapping("/pay/{id}")

	public Payment updateUserInfo (@PathVariable ("id") Integer id) {  
		Payment newpayment = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		newpayment.setPaymethod("amit!1233");
		return repo.save(newpayment);
	}
	
	@PutMapping("/pay/{id}")

	public Payment updateUserInfo (@PathVariable ("id") Integer id, @RequestBody Payment userBody) {  //userBody-information from user through postman 
		Payment newpayment = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
	newpayment.setPaymethod(userBody.getPaymethod());
	newpayment.setPaycoupon(userBody.getPaycoupon());
	
		return repo.save(newpayment);
	}
	
	
//	@PatchMapping("/user/{id}/{newInfo}")
//	public Login updateUser2patch (@PathVariable ("id") Integer id, @PathVariable ("newInfo") String newInfo) {
//		Login newLogin = repo.findById(id)
//				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
//		newLogin.setPassword(newInfo);
//		return repo.save(newLogin);
//	}

	
	
}



