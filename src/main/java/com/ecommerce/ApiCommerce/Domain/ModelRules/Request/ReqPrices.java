package com.ecommerce.ApiCommerce.Domain.ModelRules.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReqPrices {
    
    private Long brandId;
    private Long productId;
    private LocalDateTime date;

public ReqPrices(Long brandId, Long productId, LocalDateTime date) {
    this.brandId = (brandId != null) ? brandId : 0L;
    this.productId = (productId != null) ? productId : 0L;
    this.date = (date != null) ? date : LocalDateTime.now();
}

    
}
