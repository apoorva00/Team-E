package com.example.demo.controller;
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

import com.example.demo.entity.Returns;
import com.example.demo.repo.ReturnsRepo;
 
@CrossOrigin
@RestController
@RequestMapping("/api2")
public class ControllerReturns {
 
	@Autowired
 
	ReturnsRepo returnsRepo;
 
	@PostMapping("/addreturns") // End Point
 
	public Returns createReturns(@RequestBody Returns returns) {
 
		return returnsRepo.save(returns);
 
	}
 
	@GetMapping("/getreturns")
 
	public List<Returns> getreturns() {
 
		return returnsRepo.findAll();
 
	}
 
	@DeleteMapping("/deletereturns/{return_id}")
 
	public String get(@PathVariable("return_id") int return_id)
 
	{
 
		returnsRepo.deleteById(return_id);
 
		System.out.println("Returns details deleted\n");
 
		return "Is deleted";
 
	}
 
	@DeleteMapping("/deletereturnss/{return_id1}/{return_id2}")
 
	public String get(@PathVariable("return_id1") int return_id1, @PathVariable("return_id2") int return_id2)
 
	{
 
		returnsRepo.deleteById(return_id1);
 
		System.out.println("Returns 1 got deleted");
 
		returnsRepo.deleteById(return_id2);
 
		System.out.println("Returns 2 got deleted");
 
		return "Is deleted";
 
	}
 
	@PutMapping("/updatereturns/{return_id}") //
 
	public ResponseEntity<Returns> updateReturns(@PathVariable("return_id") int return_id,
 
			@RequestBody Returns returnsbypostman) {
 
		Returns returns = returnsRepo.findById(return_id)
 
				.orElseThrow(() -> new RuntimeException("Return details not exist with id :" + return_id));
 
		returns.setReturn_id(returnsbypostman.getReturn_id());
 
		returns.setReason(returnsbypostman.getReason());
 
		returns.setReturn_date(returnsbypostman.getReturn_date());
 
		Returns updatedReturns = returnsRepo.save(returns);
 
		return ResponseEntity.ok(updatedReturns);
 
	}
 
	@GetMapping("/returnReport")
 
	public String list()
 
	{
 
		float r = (float) returnsRepo.count();
		float result = ((r) * 100); 
		System.out.println("Number of returns = " + r);
 
		System.out.println("Percentage of return = " + result + "%");
 
		if (result <= 10)
 
		{
 
			return "Green";
 
		}
 
		else if ((result > 10) && (result <= 20))
 
		{
 
			return "Amber";
 
		}
 
		else
 
		{
 
			return "Red";
 
		}
 
	}
 
}