package com.lulu.project.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lulu.project.Product.Entity.Product;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void testGetProduct() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9032"+ "/product1/prod";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
    public void testAddProduct() throws URISyntaxException

    {

    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9032"+"/product1/prod";

        URI uri = new URI(baseUrl);

        Product user = new Product(4, "hammer","equipments", 500);

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<Product> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed

        assertEquals(200, result.getStatusCodeValue());
    }
	
	@Test
	public void testDeleteProduct() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing product deletion");
		final String baseUrl = "http://localhost:9032/product1/prod/2"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
	
	@Test
	public void testUpdateProduct() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing product update");
		final String baseUrl = "http://localhost:9032/product1/prod/3"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		Product productToUpdate = new Product(3, "tent","safety equips", 7000);
		restTemplate.put(uri, productToUpdate);
		// Optionally, verify that the update was successful.
		}

}
