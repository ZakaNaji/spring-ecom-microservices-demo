package com.znaji.ecom.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String description,
        Integer availableQuantity,
        BigDecimal price,
        CategoryResponse category
) {}
