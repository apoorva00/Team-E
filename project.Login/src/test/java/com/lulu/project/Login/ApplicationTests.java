package com.lulu.project.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lulu.project.Login.Entity.Admin;
import com.lulu.project.Login.Entity.Signup;
import com.lulu.project.Login.Entity.User;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetUser() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9031"+ "/api1/login/user";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	public void testGetAdmin() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9031"+ "/api1/admin1/admin";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void testGetSignup() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9031"+ "/api1/signup1/getsignup";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
    public void testAddUser() throws URISyntaxException

    {

    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9031"+"/api1/login/adduser";

        URI uri = new URI(baseUrl);

        User user = new User("ChaithraK","Chaithra@134", 2);

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed

        assertEquals(200, result.getStatusCodeValue());
    }
    
	@Test
    public void testAddAdmin() throws URISyntaxException

    {

    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9031"+"/api1/admin1/admin";

        URI uri = new URI(baseUrl);

        Admin admin = new Admin(2, "apoorva123", "apoorvaashok");

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<Admin> request = new HttpEntity<>(admin, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed

        assertEquals(200, result.getStatusCodeValue());
    }
	
	@Test
    public void testAddSignup() throws URISyntaxException

    {

    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9031"+"/api1/signup1/signup";

        URI uri = new URI(baseUrl);

        Signup signup = new Signup(2, "chaithrahok567", "Chaithrshok","chaita@12345",8979938);

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<Signup> request = new HttpEntity<>(signup, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed

        assertEquals(200, result.getStatusCodeValue());
    }
	
	@Test
	public void testDeleteUser() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing user deletion");
		final String baseUrl = "http://localhost:9031/api1/login/user/15"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
	
	@Test
	public void testDeleteAdmin() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing admin deletion");
		final String baseUrl = "http://localhost:9031/api1/admin1/admin/2"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}
	
	@Test
	public void testDeleteSignup() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing signup deletion");
		final String baseUrl = "http://localhost:9031/api1/signup1/signup/2"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}

	@Test
	public void testUpdateUser() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing user update");
		final String baseUrl = "http://localhost:9031/api1/login/user/2"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		User userToUpdate = new User("ashokapoorva", "ChaithraK",2);
		restTemplate.put(uri, userToUpdate);
		// Optionally, verify that the update was successful.
		}
	
	@Test
	public void testUpdateAdmin() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing admin update");
		final String baseUrl = "http://localhost:9031/api1/admin1/admin/1"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		Admin adminToUpdate = new Admin(1, "urssgowriiii", "Gowriurs567");
		restTemplate.put(uri, adminToUpdate);
		// Optionally, verify that the update was successful.
		}
	
	@Test
	public void testUpdateSignup() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing signup update");
		final String baseUrl = "http://localhost:9031/api1/signup1/signup/1"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		Signup signupToUpdate = new Signup(1, "keertanapandit", "Pandithkeertana","chaithra@12345",897993748);
		restTemplate.put(uri, signupToUpdate);
		// Optionally, verify that the update was successful.
		}
	
	

	
	

}
