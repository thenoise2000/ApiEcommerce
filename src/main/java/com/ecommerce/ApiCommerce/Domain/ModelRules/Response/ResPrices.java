package com.ecommerce.ApiCommerce.Domain.ModelRules.Response;

import lombok.*;

import java.text.NumberFormat;
import java.time.LocalDateTime;

import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Price;

@Getter
@Setter
public class ResPrices {
    
    private final Long brandId;   
    private final LocalDateTime startDate; 
    private final LocalDateTime endDate;    
    private final String pvp;    
    private final Long priceLists;    
    private final Long productId;    
    

    public ResPrices(final Price price) {
        this.brandId = price.getBrand().getId();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();  
        this.productId = price.getProduct().getId();      
        this.priceLists = price.getPriceLists();              
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setCurrency(price.getCurrency());
        this.pvp = numberFormat.format(price.getPvp());
    }
    
}
