package com.lulu.project.Login.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
@Id
private int id;
private String username;
private String password;
public User() {
}
public User(String userName, String password, int id) {
	this.id=id;
    this.username = userName;
    this.password = password;
}
public int getId() {
    return id;
}

public void setId(int ID) {
    this.id = ID;
}

public String getUsername() {
    return username;
}
public void setUsername(String userName) {
    this.username = userName;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
}