package com.lulu.project.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lulu.project.Login.Authorization.JwtGenerator;
import com.lulu.project.Login.Entity.User;
import com.lulu.project.Login.Service.UserService;
import com.lulu.project.Login.exception.UserNotFoundException;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerAuth {
private UserService userService;
private JwtGenerator jwtGenerator;
  @Autowired
  public UserControllerAuth(UserService userService, JwtGenerator jwtGenerator){
    this.userService=userService;
    this.jwtGenerator=jwtGenerator;
  }
  @PostMapping("/register")
  public ResponseEntity<?> postUser(@RequestBody User user){
  try{
     userService.saveUser(user);
     return new ResponseEntity<>(user, HttpStatus.CREATED);
   } catch (Exception e){
     return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
   }
  }
  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody User user) {
    try {
      if(user.getUsername() == null || user.getPassword() == null) {
      throw new UserNotFoundException("UserName or Password is Empty");
    }
    User userData = userService.getUserByNameAndPassword(user.getUsername(), user.getPassword());
    if(userData == null){
       throw new UserNotFoundException("UserName or Password is Invalid");
    }
       return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
    } catch (UserNotFoundException e) {
       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }
}
