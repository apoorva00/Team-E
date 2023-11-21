package com.go.GreatOutdoor_Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.go.GreatOutdoor_Order.Entity.Orders;

@SpringBootTest
class GreatOutdoorOrderApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testgetOrders() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="8080";
	    System.out.println("Testcase is going on");
	    final String baseUrl = "http://localhost:9035"+ "/GreatOutdoors/getorders";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
 
 
	@Test
	public void testAddOrders() throws URISyntaxException
 
	{
 
		RestTemplate restTemplate = new RestTemplate();
 
	    final String baseUrl = "http://localhost:9035"+"/GreatOutdoors/addorders";
 
	    URI uri = new URI(baseUrl);
 
	    Orders user = new Orders(4, "pune", "savya","2024-11-24","2024-12-23");//constrcutor
 
	    HttpHeaders headers = new HttpHeaders();
 
	    headers.set("X-COM-PERSIST", "true");      
 
	    HttpEntity<Orders> request = new HttpEntity<>(user, headers);
 
	  
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
 
	    //Verify request succeed
 
	    assertEquals(200, result.getStatusCodeValue());
	    
	
	}
	// Delete operation
	@Test
	public void testDeleteOrder() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing employee deletion");
		final String baseUrl = "http://localhost:9035"+"/GreatOutdoors/deleteorder/1";
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
//Put Operation
	@Test
	public void testUpdateOrders() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing employee update");
		final String baseUrl = "http://localhost:9035/GreatOutdoors/updateorder/3"; // Replace with your actual update endpoint
		URI uri = new URI(baseUrl);
		Orders ordersToUpdate = new Orders(3, "Blr", "siya","2023-14-22","2023-01-22");
		restTemplate.put(uri, ordersToUpdate);
		// Optionally, verify that the update was successful.
	}

}
