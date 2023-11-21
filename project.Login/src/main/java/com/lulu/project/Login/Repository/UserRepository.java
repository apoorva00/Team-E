package com.lulu.project.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu.project.Login.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	//User findByUsernameAndPassword(String username,String password);
	@Query(value = "SELECT * FROM user WHERE username  LIKE(:letter)", nativeQuery = true)
	User findByNameLike(@Param("letter") String letter);
	
	public User findByUsernameAndPassword(String username, String password);
    
}
