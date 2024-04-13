package com.ecommerce.ApiCommerce.Application.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse.PriceExceptions;
import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Price;
import com.ecommerce.ApiCommerce.Infraestructure.Repository.PriceRepository;

@Service
public class PriceServices {
    private final PriceRepository priceRepository;

    public PriceServices(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> findAll() {
        return priceRepository.findAll();
    }

    public Price getPrices(Long brandId, Long productId, LocalDateTime date) {
        Price price = findPriceByBrandAndProductAndDate(brandId, productId, date);
        return price != null ? price : handlePriceNotFound();
    }

    private Price findPriceByBrandAndProductAndDate(Long brandId, Long productId, LocalDateTime date) {
        return priceRepository.findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(            
                brandId,
                productId,
                date,
                date);
    }

    private Price handlePriceNotFound() {
        throw new PriceExceptions("Not found price specified");
    }
}
