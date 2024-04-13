package com.ecommerce.ApiCommerce.Application.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse.BrandExceptions;
import com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse.PriceExceptions;
import com.ecommerce.ApiCommerce.Domain.ModelRules.ApiResponse.ProductExceptions;

@ControllerAdvice
public class ApiErrorExceptions extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler({BrandExceptions.class, PriceExceptions.class, ProductExceptions.class})
    public ResponseEntity<Object> handleNotFoundException(
            Exception e,
            WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = (e instanceof BrandExceptions) ? HttpStatus.NOT_FOUND : HttpStatus.INTERNAL_SERVER_ERROR;
        return this.handleExceptionInternal(e, null, headers, status, request);
    }
}
