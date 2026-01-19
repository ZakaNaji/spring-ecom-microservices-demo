package com.znaji.ecom.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record UpdateProductRequest(
        @NotBlank String name,
        String description,
        @NotNull @Min(0) Integer availableQuantity,
        @NotNull @DecimalMin("0.00") BigDecimal price,
        @NotNull Long categoryId
) {}
