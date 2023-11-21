package com.go.GreatOutdoor_Order.Controller;

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

import com.go.GreatOutdoor_Order.Entity.Orders;
import com.go.GreatOutdoor_Order.Repository.OrdersRepo;


@CrossOrigin
 
@RestController
 
@RequestMapping("/GreatOutdoors")
 
public class ControllerOrders {
 
	@Autowired
 
	OrdersRepo ordersRepo;
 
//	@PostMapping("/addorders")
// 
//	public Orders createorders(@RequestBody Orders orders) {
// 
//		return ordersRepo.save(orders);
// 
//	}

	@PostMapping("/addorders")
	public Orders createorders(@RequestBody Orders orders) {
		return ordersRepo.save(orders);
	}

	@PutMapping("/gift/{order_id}")

	public ResponseEntity<Orders> updateAddress(@PathVariable("order_id") int order_id,

			@RequestBody Orders ordersbypostman) {
 
		Orders orders = ordersRepo.findById(order_id)

				.orElseThrow(() -> new RuntimeException("Order details not exist with id :" + order_id));
 
		System.out.println("Is it to Gift?");

		String a = orders.getGift();

//        Scanner sc=new Scanner(System.in);

//        int flag=sc.nextInt();

		if (a.equals("Yes")) {

			System.out.println("Update Address\n");

		} else {

			System.out.println("Retain the previous address!!!!\n");

		}

		orders.setOrder_address(ordersbypostman.getOrder_address());
 
		Orders updateAddress = ordersRepo.save(orders);

		return ResponseEntity.ok(updateAddress);
 
	}
 
	@GetMapping("/getorders")
 
	public List<Orders> getorders() {
 
		return ordersRepo.findAll(); // select * from product;
 
	}
 
	@DeleteMapping("/deleteorder/{order_id}")
	public String get(@PathVariable("order_id") int order_id)
 
	{
 
		ordersRepo.deleteById(order_id);
 
		System.out.println("orders details deleted\n");
 
		return "Is deleted";
 
	}
 
	@DeleteMapping("/deleteorderss/{order_id1}/{order_id2}")
 
	public String get(@PathVariable("order_id1") int order_id1, @PathVariable("order_id2") int order_id2)
 
	{

		ordersRepo.deleteById(order_id1);
 
		System.out.println("Order 1 got deleted");
 
		ordersRepo.deleteById(order_id2);
 
		System.out.println("Order 2 got deleted");
 
		return "Is deleted";

	}
 
	@PutMapping("/updateorder/{order_id}") //
 
	public ResponseEntity<Orders> updateOrders(@PathVariable("order_id") int order_id,

			@RequestBody Orders ordersbypostman) {
 
		Orders orders = ordersRepo.findById(order_id)
 
				.orElseThrow(() -> new RuntimeException("Order details not exist with id :" + order_id));
 
		orders.setOrder_id(ordersbypostman.getOrder_id());
 
		//orders.setProducts(ordersbypostman.getProducts());
 
		orders.setOrder_address(ordersbypostman.getOrder_address());
 
		orders.setGift(ordersbypostman.getGift());
 
//		orders.setCustomer(ordersbypostman.getCustomer());
// 
		orders.setPurchase_date(ordersbypostman.getPurchase_date());
 
		orders.setDelivery_date(ordersbypostman.getDelivery_date());
 
		Orders updatedOrders = ordersRepo.save(orders);
 
		return ResponseEntity.ok(updatedOrders);
 
	}
 
}