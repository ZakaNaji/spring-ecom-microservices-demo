package com.znaji.ecom.dto;

import com.znaji.ecom.model.Customer;

public final class CustomerMapper {
    private CustomerMapper() {}

    public static Customer toEntity(CreateCustomerRequest req) {
        Customer c = new Customer();
        c.setFirstName(req.firstName());
        c.setLastName(req.lastName());
        c.setEmail(req.email());
        c.setPhone(req.phone());
        return c;
    }

    public static CustomerResponse toResponse(Customer c) {
        return new CustomerResponse(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhone()
        );
    }
}
