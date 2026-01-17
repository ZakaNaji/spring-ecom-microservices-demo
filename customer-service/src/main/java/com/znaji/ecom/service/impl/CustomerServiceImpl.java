package com.znaji.ecom.service.impl;

import com.znaji.ecom.dto.CreateCustomerRequest;
import com.znaji.ecom.dto.CustomerMapper;
import com.znaji.ecom.dto.CustomerResponse;
import com.znaji.ecom.dto.UpdateCustomerRequest;
import com.znaji.ecom.exception.CustomerNotFoundException;
import com.znaji.ecom.exception.EmailAlreadyExistsException;
import com.znaji.ecom.repository.CustomerRepository;
import com.znaji.ecom.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new EmailAlreadyExistsException(request.email());
        }
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public CustomerResponse getById(String id) {
        return repo.findById(id)
                .map(CustomerMapper::toResponse)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public List<CustomerResponse> getAll() {
        return repo.findAll().stream()
                .map(CustomerMapper::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse update(String id, UpdateCustomerRequest request) {
        var customer = repo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));

        // Email uniqueness rule:
        // If email is changing, ensure new email isn't used by someone else.
        if (!customer.getEmail().equals(request.email())) {
            if (repo.existsByEmail(request.email())) {
                throw new EmailAlreadyExistsException(request.email());
            }
        }

        applyUpdate(customer, request);
        return toResponse(repo.save(customer));
    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
        repo.deleteById(id);
    }
}