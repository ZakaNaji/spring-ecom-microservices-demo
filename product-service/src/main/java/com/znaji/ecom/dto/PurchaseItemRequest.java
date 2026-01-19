package com.znaji.ecom.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record PurchaseItemRequest(
        @NotNull Long productId,
        @NotNull @Min(1) Integer quantity
) {}
