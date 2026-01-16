package com.znaji.ecom.repository;

import java.util.Optional;

import com.znaji.ecom.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);
}