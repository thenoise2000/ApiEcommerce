package com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse;

public class PriceExceptions extends RuntimeException {
    
    public PriceExceptions(String message) {
        super(message);
    }

    public PriceExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
