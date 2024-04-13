package com.ecommerce.ApiCommerce.Infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ApiCommerce.Application.Services.PriceServices;
import com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse.PriceExceptions;
import com.ecommerce.ApiCommerce.Domain.ModelRules.Request.ReqPrices;
import com.ecommerce.ApiCommerce.Domain.ModelRules.Response.ResPrices;
import com.ecommerce.ApiCommerce.Infraestructure.Persistence.Price;

@RestController
@RequestMapping("/api")
public class MainController {

  private PriceServices priceService; 

  @Autowired
  public MainController(PriceServices priceService) {
    this.priceService = priceService;
  }

  @GetMapping("/findPrice")
  public ResPrices getPrice(@RequestBody ReqPrices getPriceRequest) {
    Price price = priceService.getPrices(getPriceRequest.getBrandId(), getPriceRequest.getProductId(), getPriceRequest.getDate());
    if (price == null) {
        throw new PriceExceptions(""); 
    }
    return new ResPrices(price);
}
}

