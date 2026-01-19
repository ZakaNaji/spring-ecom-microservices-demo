package com.znaji.ecom.dto;

import java.math.BigDecimal;

public record PurchaseItemResponse(
        Long productId,
        String name,
        BigDecimal price,
        Integer quantityPurchased,
        BigDecimal lineTotal
) {}