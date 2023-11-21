package com.lulu.project.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu.project.Login.Entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query(value = "SELECT * FROM admin WHERE username  LIKE(:letter)", nativeQuery = true)
	Admin findByNameLike(@Param("letter") String letter);

}
