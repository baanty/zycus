package com.example.demo;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Autowired
	CustomerRepo customerRepo;

    @GetMapping("/api/customer")
    public List<CustomerModel> getAllCustomers() {
    	return customerRepo.findAll();
    }
    
    @GetMapping("/api/customer/{customerId}")
    public CustomerModel getCustomerDetails(@PathVariable long customerId) {
    	return customerRepo.findOne(customerId);
    }
    
	  @PostMapping("/api/customer")
	     public Response saveAllDetails(@RequestBody CustomerModel  model){
		  customerRepo.save(model);
		  return Response.created(URI.create("/" + model.getCustomerId())).build();
	  }

}