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

import com.lulu.project.Login.Entity.Admin;
import com.lulu.project.Login.Entity.User;
import com.lulu.project.Login.Repository.AdminRepository;

import jakarta.validation.Valid;


@RequestMapping("/api1/admin1")
@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository adminrepo;
	
	@GetMapping("/admin")
	public List<Admin> getJPQL() {
		return adminrepo.findAll();
	}
 
	@PostMapping("/admin")
	public Admin createuser(@Valid @RequestBody Admin prod) {
 
		return adminrepo.save(prod);
 
	}
	
	@PostMapping("/admin2")
	public String createAdmin2(@Valid @RequestBody Admin admin) {
		Admin existingAdmin = null;
		existingAdmin = adminrepo.findByNameLike(admin.getUsername());	
		if (existingAdmin == null) {
			adminrepo.save(admin);
			return "Admin added successfully";
		}
		else
		{
			return "Admin already exist!";
		}

		
	}
	
	@GetMapping("/valid/{username}/{password}")
	public List<Admin> getJPQL2(@PathVariable("username") String username ,@PathVariable("password") String password) {
		List<Admin> rec=	adminrepo.findAll();  
		for(Admin u: rec) {
			System.out.println(u);

			if(u.getUsername().equals(username) && u.getPassword().equals(password)  ) {
				System.out.println(" Valid- Authenticated");
				break;
			}else {
				System.out.println("Not Valid");
			}

		}	
		return adminrepo.findAll();
	}
 
	@DeleteMapping("/admin/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
 
		adminrepo.deleteById(id); // select * from <TableName>;
 
	}
 
	@PutMapping("/admin/{id}")
	public Admin updateUser(@PathVariable("id") Integer id, @RequestBody Admin userBody) { // userbody - information
																							// comes from postman.
 
		// Optional<Users> user1 = ur.findById(id);
 
		Admin newUser = adminrepo.findById(id) // old data
 
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
 
		newUser.setPassword(userBody.getPassword()); // the new data replaces the old data.
 
		newUser.setUsername(userBody.getUsername());
 
		return adminrepo.save(newUser);
 
	}
 

}
