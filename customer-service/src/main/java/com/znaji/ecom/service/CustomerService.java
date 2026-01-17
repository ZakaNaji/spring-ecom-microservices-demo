package com.znaji.ecom.service;

import com.znaji.ecom.dto.CreateCustomerRequest;
import com.znaji.ecom.dto.CustomerResponse;
import com.znaji.ecom.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {
    CustomerResponse create(CreateCustomerRequest request);
    CustomerResponse getById(String id);
    List<CustomerResponse> getAll();
    CustomerResponse update(String id, UpdateCustomerRequest request);
    void delete(String id);
}