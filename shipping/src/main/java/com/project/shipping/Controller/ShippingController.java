package com.project.shipping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.shipping.Entity.Shipping;
import com.project.shipping.Repo.ShippingRepo;

@RestController
@RequestMapping("/ship")
public class ShippingController {
	@Autowired
	ShippingRepo shiprepo;
	@PostMapping("/addshipping") // End Point
	 
	public Shipping createShipping(@RequestBody Shipping shipping) {
 
		return shiprepo.save(shipping);
 
	}
 
	@GetMapping("/getshipping")
 
	public List<Shipping> getreturns() {
 
		return shiprepo.findAll();
 
	}
	@PutMapping("/updateadd/{id}")  //userbody - information comes from postman.
	
	//Optional<Users> user1 = ur.findById(id);
     public Shipping updaterc(@PathVariable ("id") int id, @RequestBody Shipping userBody) { //userbody - information comes from postman.
	Shipping newUser = shiprepo.findById(id) //old data
			.orElseThrow(() -> new RuntimeException("Inventory not exist with id :" + id));
	
		
     	//newUser.setChangeid(userBody.getChangeid()); //the new data replaces the old data.
		newUser.setAddress(userBody.getAddress());
		  return  shiprepo.save(newUser);		
		
}
 
	//RabbitTemplateConfigurer rabbitTemplate;

//    @RequestMapping(value = "/shipping", method = RequestMethod.GET)
//	public List<Shipping> getreturns() {
//		 
//		return shiprepo.findAll();
//    }
//
//    @RequestMapping(value = "/shipping/{id}", method = RequestMethod.GET)
//   public String getShippingById(@PathVariable String id) {
//        return "GET Shipping Resource with id: " + id;
//    }
//  
//    @RequestMapping(value = "/shipping", method = RequestMethod.POST)
//    public
//    @ResponseBody
//    Shipping postShipping(@RequestBody Shipping shipping) {
//        System.out.println("Adding shipment to queue...");
//        return shipping;
//    }
}
//
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(method = RequestMethod.GET, path = "/health")
//    public
//    @ResponseBody
//    Map<String, List<HealthCheck>> getHealth() {
//        Map<String, List<HealthCheck>> map = new HashMap<String, List<HealthCheck>>();
//        List<HealthCheck> healthChecks = new ArrayList<HealthCheck>();
//        Date dateNow = Calendar.getInstance().getTime();
//
//        HealthCheck rabbitmq = new HealthCheck("shipping-rabbitmq", "OK", dateNow);
//        HealthCheck app = new HealthCheck("shipping", "OK", dateNow);
//
//        try {
//            this.rabbitTemplate.execute(new ChannelCallback<String>() {
//                @Override
//                public String doInRabbit(Channel channel) throws Exception {
//                    Map<String, Object> serverProperties = channel.getConnection().getServerProperties();
//                    return serverProperties.get("version").toString();
//                }
//            });
//        } catch ( AmqpException e ) {
//            rabbitmq.setStatus("err");
//        }
//
//        healthChecks.add(rabbitmq);
//        healthChecks.add(app);
//
//        map.put("health", healthChecks);
//        return map;
//    }


