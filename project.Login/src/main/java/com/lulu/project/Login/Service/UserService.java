package com.lulu.project.Login.Service;

import org.springframework.stereotype.Service;

import com.lulu.project.Login.Entity.User;
import com.lulu.project.Login.exception.UserNotFoundException;
@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}