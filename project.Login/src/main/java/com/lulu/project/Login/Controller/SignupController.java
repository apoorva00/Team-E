package com.lulu.project.Login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu.project.Login.Entity.Signup;
import com.lulu.project.Login.Repository.SignupRepository;
import jakarta.validation.Valid;

@RequestMapping("/api1/signup1")
@RestController
public class SignupController {
	
	@Autowired
	private SignupRepository signuprepo;
	
	@GetMapping("/getsignup")
	public List<Signup> getJPQL() {
		return signuprepo.findAll();
	}
 
	@PostMapping("/signup")
	public Signup createsignup(@Valid @RequestBody Signup sign) {
 
		return signuprepo.save(sign);
 
	}
	
	@PostMapping("/signup2")
	public String createuser2(@Valid @RequestBody Signup signup) {
		Signup existinguser = null;
//      Customer
		existinguser = signuprepo.findByNameLike(signup.getUsername());	
		if (existinguser == null) {
			signuprepo.save(signup);
			return "user added successfully";
		}
		else
		{
			return "user already exist!";
		}

		
	}
 
	@DeleteMapping("/signup/{id}")
	public void deletesignup(@PathVariable("id") Integer id) {
 
		signuprepo.deleteById(id); 
 
	}
 
	@PutMapping("/signup/{id}")
	public Signup updatesignup(@PathVariable("id") Integer id, @RequestBody Signup userBody) { // userbody - information
																							// comes from postman.
 
		// Optional<Users> user1 = ur.findById(id);
 
		Signup newUser = signuprepo.findById(id) // old data
 
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
		
		newUser.setUsername(userBody.getUsername());
 
		newUser.setPassword(userBody.getPassword()); // the new data replaces the old data.
 
		newUser.setEmail(userBody.getEmail());
		
		newUser.setPh(userBody.getPh());
 
		return signuprepo.save(newUser);
 
	}
 
}
