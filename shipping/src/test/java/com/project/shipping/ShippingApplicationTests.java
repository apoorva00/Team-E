package com.project.shipping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.project.shipping.Entity.Shipping;

@SpringBootTest
class ShippingApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetShipping() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9098";
	    final String baseUrl = "http://localhost:9038"+ "/ship/getshipping";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
    public void testAddShipping() throws URISyntaxException
    {
    	RestTemplate restTemplate = new RestTemplate();
 
        final String baseUrl = "http://localhost:9038/ship/addshipping";
        URI uri = new URI(baseUrl);
        Shipping user = new Shipping(2345,"gowri","#23 kuvempunagar mysore");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");     
        HttpEntity<Shipping> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
	
	@Test
	public void testUpdateShipping() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing shipping update");
		final String baseUrl = "http://localhost:9038/ship/updateadd/1"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		Shipping shippingToUpdate = new Shipping(1, "Monika HR", "manglore");
		restTemplate.put(uri, shippingToUpdate);
		// Optionally, verify that the update was successful.
		}

}
