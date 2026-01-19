package com.znaji.ecom.exception;


public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Category not found: " + id);
    }
}