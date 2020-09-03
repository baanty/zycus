package com.example.demo;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Long>{
	
	public CustomerModel findByCustomerId(long id);
}
