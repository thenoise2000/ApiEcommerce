package com.ecommerce.ApiCommerce.Application.Services;

import org.springframework.stereotype.Service;

import com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse.ProductExceptions;
import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Product;
import com.ecommerce.ApiCommerce.Infraestructure.Repository.ProductRepository;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    public ProductServices(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> createProductException(id));
    }

    private ProductExceptions createProductException(Long id) {
        return new ProductExceptions("Product with ID " + id + " not found.");
    }
    
}
