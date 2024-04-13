package com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse;

public class ProductExceptions extends RuntimeException {
    
    public ProductExceptions(String message) {
        super(message);
    }

    public ProductExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
