package com.lulu.project.Login.Authorization;

import java.util.Map;

import com.lulu.project.Login.Entity.User;
public interface JwtGenerator {
Map<String, String> generateToken(User user);
}