package com.znaji.ecom.dto;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        String phone,
        AddressDto address
) {}