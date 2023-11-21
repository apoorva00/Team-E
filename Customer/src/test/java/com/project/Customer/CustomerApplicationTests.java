package com.project.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.project.Customer.entity.Customer;

@SpringBootTest
class CustomerApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetCustomer() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9036"+ "/GreatOutdoors/Customer/getcustomer";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	/*@Test
    public void testAddCustomer() throws URISyntaxException
 
    {
    	RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:9036"+ "/GreatOutdoors/Customer/register";
        URI uri = new URI(baseUrl);
        Customer customer = new Customer(10, "jamesbondd", "#12,bond,manglore","bond@gmail.com","9901677707","bond@35176",738000);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
        HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        assertEquals(200, result.getStatusCodeValue());
    }*/
	 
	    
	
	@Test
	public void testDeleteCustomer() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing customer deletion");
		final String baseUrl = "http://localhost:9036/GreatOutdoors/Customer/deletecustomer/3"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
	
	@Test
	public void testUpdateCustomer() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing employee update");
		final String baseUrl = "http://localhost:9036/GreatOutdoors/Customer/updatecustomer/4"; // Replace with your actual update endpoint
		URI uri = new URI(baseUrl);
		Customer employeeToUpdate = new Customer(4,"ayeshakhann", "#65complex,mysore","anu2001@gmail.com","9901628307","anu@2123893",638000);
		restTemplate.put(uri, employeeToUpdate);
		// Optionally, verify that the update was successful.
	}

}
