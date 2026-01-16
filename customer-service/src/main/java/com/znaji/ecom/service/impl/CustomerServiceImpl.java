package com.znaji.ecom.service.impl;

import com.znaji.ecom.dto.CreateCustomerRequest;
import com.znaji.ecom.dto.CustomerResponse;
import com.znaji.ecom.repository.CustomerRepository;
import com.znaji.ecom.service.CustomerService;
import org.springframework.stereotype.Service;

import static com.znaji.ecom.dto.CustomerMapper.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public CustomerResponse create(CreateCustomerRequest request) {
        if (repo.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already exists: " + request.email());
        }
        var saved = repo.save(toEntity(request));
        return toResponse(saved);
    }

    @Override
    public CustomerResponse getById(String id) {
        var c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found: " + id));
        return toResponse(c);
    }
}