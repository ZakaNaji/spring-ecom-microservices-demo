package com.znaji.ecom.dto;

import com.znaji.ecom.model.Address;
import com.znaji.ecom.model.Customer;

public final class CustomerMapper {
    private CustomerMapper() {}

    public static Customer toEntity(CreateCustomerRequest req) {
        Customer c = new Customer();
        c.setFirstName(req.firstName());
        c.setLastName(req.lastName());
        c.setEmail(req.email());
        c.setPhone(req.phone());
        c.setAddress(toAddress(req.address()));
        return c;
    }

    public static CustomerResponse toResponse(Customer c) {
        return new CustomerResponse(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhone(),
                toDto(c.getAddress())
        );
    }

    private static Address toAddress(AddressDto dto) {
        if (dto == null) return null;
        Address a = new Address();
        a.setStreet(dto.street());
        a.setCity(dto.city());
        a.setZip(dto.zip());
        a.setCountry(dto.country());
        return a;
    }

    public static void applyUpdate(Customer c, UpdateCustomerRequest req) {
        c.setFirstName(req.firstName());
        c.setLastName(req.lastName());
        c.setEmail(req.email());
        c.setPhone(req.phone());
        c.setAddress(toAddress(req.address()));
    }

    private static AddressDto toDto(Address a) {
        if (a == null) return null;
        return new AddressDto(a.getStreet(), a.getCity(), a.getZip(), a.getCountry());
    }
}
