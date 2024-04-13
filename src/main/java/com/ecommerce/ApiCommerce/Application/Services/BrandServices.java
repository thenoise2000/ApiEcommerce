package com.ecommerce.ApiCommerce.Application.Services;

import org.springframework.stereotype.Service;

import com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse.BrandExceptions;
import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Brand;
import com.ecommerce.ApiCommerce.Infraestructure.Repository.BrandRepository;

@Service
public class BrandServices {
    private final BrandRepository brandRepository;

    public BrandServices(final BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand getBrand(Long id) {
        return brandRepository.findById(id)
            .orElseThrow(() -> createBrandException(id));
    }

    private BrandExceptions createBrandException(Long id) {
        return new BrandExceptions("Brand with ID " + id + " not found.");
    }
}
