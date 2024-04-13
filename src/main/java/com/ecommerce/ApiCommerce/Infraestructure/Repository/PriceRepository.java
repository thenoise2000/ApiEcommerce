package com.ecommerce.ApiCommerce.Infraestructure.Repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
        @Query(value = "SELECT * FROM Prices WHERE brand_id = :brandId AND product_id = :productId AND :date BETWEEN start_date AND end_date ORDER BY priority DESC LIMIT 1", nativeQuery = true)
        Price get(@Param("date") LocalDateTime date,@Param("productId") Long productId,@Param("brandId") Long brandId);
                
        
        Price findTopByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
    }

