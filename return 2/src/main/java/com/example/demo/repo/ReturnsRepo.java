package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Returns;

 
public interface ReturnsRepo extends JpaRepository<Returns, Integer> {
 
}