package com.lulu.project.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu.project.Login.Entity.Signup;

public interface SignupRepository extends JpaRepository<Signup, Integer>{
	
	@Query(value = "SELECT * FROM signup WHERE username  LIKE(:letter)", nativeQuery = true)
	Signup findByNameLike(@Param("letter") String letter);

}
