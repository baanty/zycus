package com.example.demo;

import java.net.URI;

import java.util.List;

import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class ProductCartController {

    @Autowired
	ProductCartRepo productCartRepo;
    
    
	  @GetMapping("/api/productcart")
	    public List<ProductCartModel> getAllDetails() {
	        return productCartRepo.findAll();
	    }
	  
	  @PostMapping("/api/productcart")
	     public Response saveAllDetails(@RequestBody ProductCartModel  model){
		  productCartRepo.save(model);
		  return Response.created(URI.create("/" + model.getCartId())).build();
	  }
	  
	  @DeleteMapping("/api/productcart/{cartId}")
	  public void deleteAllDetails(@PathVariable long cartId) {
		  productCartRepo.delete(cartId);
	  }
	  
	  @PutMapping("/api/productcart/{cartId}")
	  public void updateProduct(@RequestBody ProductCartModel productCartModel,@PathVariable long cartId) {
		  productCartModel.setCartId(cartId);
		  productCartRepo.save(productCartModel);
	  }

}







