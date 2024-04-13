package com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse;

public class BrandExceptions extends RuntimeException {
    
    public BrandExceptions(String message) {
        super(message);
    }

    public BrandExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
