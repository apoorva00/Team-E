package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Returns;

@SpringBootTest
class ReturnApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetReturn() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9034"+ "/api2/getreturns";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
    public void testAddReturn() throws URISyntaxException

    {

    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9034"+"/api2/addreturns";

        URI uri = new URI(baseUrl);

        Returns user = new Returns(5, "damaged product","01-12-23");

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<Returns> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed

        assertEquals(200, result.getStatusCodeValue());
    }
	
	@Test
	public void testDeleteReturn() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing product deletion");
		final String baseUrl = "http://localhost:9034/api2/deletereturns/3"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
	
	@Test
	public void testUpdateReturn() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing product update");
		final String baseUrl = "http://localhost:9034/api2/updatereturns/4"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		Returns productToUpdate = new Returns(4, "size too tight","10-12-23");
		restTemplate.put(uri, productToUpdate);
		// Optionally, verify that the update was successful.
		}

}
