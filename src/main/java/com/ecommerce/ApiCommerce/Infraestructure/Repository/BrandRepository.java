package com.ecommerce.ApiCommerce.Infraestructure.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    
}
