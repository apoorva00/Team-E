package com.lulu.project.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lulu.project.Product.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM product WHERE prod_name  LIKE(:letter)", nativeQuery = true)
	Product findByNameLike(@Param("letter") String letter);

}
