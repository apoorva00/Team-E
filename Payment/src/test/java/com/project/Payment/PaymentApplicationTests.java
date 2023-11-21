package com.project.Payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.project.Payment.entity.Payment;

@SpringBootTest
class PaymentApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetPayment() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9033"+ "/payment/pay";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
    public void testAddPayment() throws URISyntaxException

    {

    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9033"+"/payment/pay";

        URI uri = new URI(baseUrl);

        Payment user = new Payment(3, "123","11-10-23", 4500,"UPI");

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<Payment> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed

        assertEquals(200, result.getStatusCodeValue());
    }
	
	@Test
	public void testDeletePayment() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing product deletion");
		final String baseUrl = "http://localhost:9033/payment/pay/1"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
	
	@Test
	public void testUpdatePayment() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing product update");
		final String baseUrl = "http://localhost:9033/payment/pay/2"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		Payment productToUpdate = new Payment(2, "NEW123","22-9-23", 3000,"cash");
		restTemplate.put(uri, productToUpdate);
		// Optionally, verify that the update was successful.
		}
	
	

}
