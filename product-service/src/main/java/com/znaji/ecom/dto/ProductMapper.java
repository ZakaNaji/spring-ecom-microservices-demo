package com.znaji.ecom.dto;

import com.znaji.ecom.model.Category;
import com.znaji.ecom.model.Product;

import java.math.BigDecimal;

public final class ProductMapper {

    private ProductMapper() {}

    public static ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getAvailableQuantity(),
                p.getPrice(),
                toCategoryResponse(p.getCategory())
        );
    }

    public static CategoryResponse toCategoryResponse(Category c) {
        return new CategoryResponse(c.getId(), c.getName(), c.getDescription());
    }

    public static PurchaseItemResponse toPurchaseItemResponse(Product p, int qty) {
        BigDecimal lineTotal = p.getPrice().multiply(BigDecimal.valueOf(qty));
        return new PurchaseItemResponse(p.getId(), p.getName(), p.getPrice(), qty, lineTotal);
    }
}
