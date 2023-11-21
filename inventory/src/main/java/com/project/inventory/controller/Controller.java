package com.project.inventory.controller;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.inventory.entity.InventoryEntity;
import com.project.inventory.repo.InventoryRepo;

@CrossOrigin

@RestController
@RequestMapping("/GreatOutdoors/Inventory/")

public class Controller {

	@Autowired

	InventoryRepo inventoryRepo;

	@PostMapping("/addInventoryProducts") // End Point

	public InventoryEntity createinventory(@RequestBody InventoryEntity inventory) {

		return inventoryRepo.save(inventory);

	}

	@PostMapping("/addInventoryColor") // End Point

	public InventoryEntity createinventoryColor(@RequestBody InventoryEntity inventory) {

		return inventoryRepo.save(inventory);

	}

	@GetMapping("/getInventoryColor/{id}")

	public List<InventoryEntity> getinventoryColor() {

		return inventoryRepo.findAll();

	}

	@GetMapping("/getInventoryProductList")

	public List<InventoryEntity> getinventory() {

		return inventoryRepo.findAll();

	}

	// DeLETE data //

	@DeleteMapping("/deleteInventory/{id}")

	public String get(@PathVariable("id") int id) {

		inventoryRepo.deleteById(id);

		System.out.println("Record 1 got deleted");

		return "Is deleted"; // select * from Order;

	}

	// Update data//


	@PutMapping("/updateinventory/{id}") //

	public ResponseEntity<InventoryEntity> updateInventory(@PathVariable("id") int id,

			@RequestBody InventoryEntity inventorybypostman) {

		InventoryEntity inventory = inventoryRepo.findById(id)

				.orElseThrow(() -> new RuntimeException("User not exist with id :" + id));

		inventory.setInventory_id(inventorybypostman.getInventory_id());

		inventory.setStart_date(inventorybypostman.getStart_date());

		inventory.setEnd_date(inventorybypostman.getEnd_date());

		InventoryEntity updatedInventory = inventoryRepo.save(inventory);

		return ResponseEntity.ok(updatedInventory);

	}
//
	@GetMapping("/shelflife/{id}")

	public String shelflife(@PathVariable("id") int id)

	{

		InventoryEntity inventory = inventoryRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));

		LocalDate startDate = inventory.getStart_date();

		LocalDate endDate = inventory.getEnd_date();

		ZoneId default_ZoneId = ZoneId.systemDefault();

		Date s_date = Date.from(startDate.atStartOfDay(default_ZoneId.systemDefault()).toInstant());

	Date e_date = Date.from(endDate.atStartOfDay(default_ZoneId.systemDefault()).toInstant());

	long difference_In_Time = e_date.getTime() - s_date.getTime();

	long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

		System.out.println(difference_In_Days);

		if (difference_In_Days <= 5)

		{

			return "Green";

		}

		else if (difference_In_Days <= 10)

		{

			return "Amber";

		}

		return "Red";

	}

}
