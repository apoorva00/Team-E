package com.lulu.project.Product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu.project.Product.Entity.Product;
import com.lulu.project.Product.Repository.ProductRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/product1")
public class ProductController {
	
	@Autowired
	private ProductRepository prodrepo;
	
	@GetMapping("/prod")
	public List<Product> getJPQL() {
		return prodrepo.findAll();
	}
 
	@PostMapping("/prod")
	public Product createuser(@RequestBody Product prod) {
 
		return prodrepo.save(prod);
 
	}
	
	@PostMapping("/prod2")
	public String createProduct2(@Valid @RequestBody Product product) {
		Product existingProduct = null;
		existingProduct = prodrepo.findByNameLike(product.getProd_name());	
		if (existingProduct == null) {
			prodrepo.save(product);
			return "Product added successfully";
		}
		else
		{
			return "Product already exist!";
		}

		
	}
	
	@DeleteMapping("/prod/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
 
		prodrepo.deleteById(id); 
 
	}
 
	@PutMapping("/prod/{id}")
	public Product updateUser(@PathVariable("id") Long id, @RequestBody Product userBody) { // userbody - information
																							// comes from postman.
 
		// Optional<Users> user1 = ur.findById(id);
 
		Product newProd = prodrepo.findById(id) // old data
 
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
 
		newProd.setProd_name(userBody.getProd_name()); // the new data replaces the old data.
 
		newProd.setProd_type(userBody.getProd_type());
		
		newProd.setProd_price(userBody.getProd_price());
 
		return prodrepo.save(newProd);
 
	}
 
    
 

}
