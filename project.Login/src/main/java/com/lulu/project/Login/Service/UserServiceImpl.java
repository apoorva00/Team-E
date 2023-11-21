package com.lulu.project.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lulu.project.Login.Entity.User;
import com.lulu.project.Login.Repository.UserRepository;
import com.lulu.project.Login.exception.UserNotFoundException;;
@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  @Autowired
  public UserServiceImpl(UserRepository userRepository){
    this.userRepository=userRepository;
  }
  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }
  @Override
  public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
    User user = userRepository.findByUsernameAndPassword(name, password);
    if(user == null){
       throw new UserNotFoundException("Invalid id and password");
    }
    return user;
  }
}