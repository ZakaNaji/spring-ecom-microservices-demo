package com.znaji.ecom.service;

import com.znaji.ecom.dto.CreateCustomerRequest;
import com.znaji.ecom.dto.CustomerResponse;

public interface CustomerService {
    CustomerResponse create(CreateCustomerRequest request);
    CustomerResponse getById(String id);
}