/*package com.lulu.project.Login.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lulu.project.Login.Entity.User;
import com.lulu.project.Login.Repository.UserRepository;

@Component
public class UserImplementation {
	@Autowired
	private UserRepository loginrepository;
	public User login(String username,String password) {
		User u=loginrepository.findByUsernameAndPassword(username, password);
		//System.err.println(u.getId());
		return u;
	}

}*/
