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

import com.lulu.project.Login.Entity.User;
import com.lulu.project.Login.Repository.UserRepository;

import jakarta.validation.Valid;

@RequestMapping("/api1/login")
@RestController
public class UserController{
	
	@Autowired
	private UserRepository userrepo;
	
	@GetMapping("/user")
	public List<User> getJPQL() {
		return userrepo.findAll();
	}
	
	@GetMapping("/valid/{username}/{password}")
	public List<User> getJPQL2(@PathVariable("username") String username ,@PathVariable("password") String password) {
		List<User> rec=	userrepo.findAll();  
		for(User u: rec) {
			System.out.println(u);

			if(u.getUsername().equals(username) && u.getPassword().equals(password)  ) {
				System.out.println(" Valid- Authenticated");
				break;
			}else {
				System.out.println("Not Valid");
			}

		}	
		return userrepo.findAll();
	}
 
	@PostMapping("/adduser")
	public User createuser(@Valid @RequestBody User prod) {
 
		return userrepo.save(prod);
 
	}
 
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
 
		userrepo.deleteById(id); 
 
	}
 
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") Integer id, @RequestBody User userBody) { // userbody - information
																							// comes from postman.
 
		// Optional<Users> user1 = ur.findById(id);
 
		User newUser = userrepo.findById(id) // old data
 
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
 
		newUser.setPassword(userBody.getPassword()); // the new data replaces the old data.
 
		newUser.setUsername(userBody.getUsername());
 
		return userrepo.save(newUser);
 
	}
 
	
	

}
