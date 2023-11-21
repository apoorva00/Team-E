package com.project.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.project.inventory.entity.InventoryEntity;

@SpringBootTest
class InventoryApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testGetInventory() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    //String randomServerPort="9031";
	    final String baseUrl = "http://localhost:9037"+ "/GreatOutdoors/Inventory/getInventoryProductList";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());

}
	@Test
    public void testAddInventory() throws URISyntaxException
    {
    	RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9037"+"/GreatOutdoors/Inventory/addInventoryProducts";
        URI uri = new URI(baseUrl);
        InventoryEntity user = new InventoryEntity(3243, LocalDate.of(2023, 11, 12), LocalDate.of(2023, 11, 24));
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");     
        HttpEntity<InventoryEntity> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
	@Test
	public void testDeleteInvrntory() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing Inventory deletion");
		final String baseUrl = "http://localhost:9037/GreatOutdoors/Inventory/deleteInventory/6"; // Replace with your actual delete endpoint
		URI uri = new URI(baseUrl);
		restTemplate.delete(uri);
		// Optionally, verify that the delete was successful.
	}

	@Test
	public void testUpdateInventory() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Testing Inventory update");
		final String baseUrl = "http://localhost:9037/GreatOutdoors/Inventory/updateinventory/3126"; // Replace with your actual update endpoint			
		URI uri = new URI(baseUrl);
		InventoryEntity productToUpdate = new InventoryEntity(3126, LocalDate.of(2023, 12, 12), LocalDate.of(2023, 12, 23));
		restTemplate.put(uri, productToUpdate);
		// Optionally, verify that the update was successful.
		}
	
}
