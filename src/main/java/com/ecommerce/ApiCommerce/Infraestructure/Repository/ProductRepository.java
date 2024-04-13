package com.ecommerce.ApiCommerce.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
