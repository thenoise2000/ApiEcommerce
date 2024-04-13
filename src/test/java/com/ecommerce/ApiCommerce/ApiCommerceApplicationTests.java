package com.ecommerce.ApiCommerce;

import com.ecommerce.ApiCommerce.Domain.ModelRules.Request.ReqPrices;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Currency;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc 
@SpringBootTest 
public class ApiCommerceApplicationTests { 
    @Autowired 
    private MockMvc mockMvc; 
     
    @Autowired 
    private ObjectMapper objectMapper; 
     
    private NumberFormat formatter; 
     
    @BeforeEach 
    public void setUp() { 
        formatter = NumberFormat.getCurrencyInstance(); 
        formatter.setCurrency(Currency.getInstance("EUR")); 
    } 
     
    @Test 
    public void testCaseOne() throws Exception { 
        testFindPrice(1L, 35455L, LocalDateTime.of(2020, 06, 14, 10, 00),"2020-12-31T23:59:59", 
        35.50, 1, "2020-06-14T00:00:00"); 
    } 
     
    @Test 
    public void testCaseTwo() throws Exception { 
        testFindPrice(1L, 35455L, LocalDateTime.of(2020, 06, 14, 16, 00), "2020-06-14T18:30:00", 
        25.45, 2, "2020-06-14T15:00:00"); 
    } 
     
    @Test 
    public void testCaseThree() throws Exception { 
        testFindPrice(1L, 35455L, LocalDateTime.of(2020, 06, 14, 21, 00), "2020-12-31T23:59:59", 
        35.50, 1, "2020-06-14T00:00:00"); 
    } 
     
    @Test 
    public void testCaseFour() throws Exception { 
        testFindPrice(1L, 35455L, LocalDateTime.of(2020, 06, 15, 10, 00), "2020-06-15T11:00:00", 
        30.50, 3, "2020-06-15T00:00:00"); 
    } 
     
    @Test 
    public void testCaseFive() throws Exception { 
        testFindPrice(1L, 35455L, LocalDateTime.of(2020, 06, 16, 21, 00), "2020-12-31T23:59:59", 
        38.95, 4, "2020-06-15T16:00:00"); 
    } 
     
    private void testFindPrice(Long brandId, Long productId, LocalDateTime dateTime, String endDate, double price, int priceList, String startDate) throws Exception { 
        ReqPrices testRequestPrice = new ReqPrices(brandId, productId, dateTime); 
         
        this.mockMvc.perform( 
            MockMvcRequestBuilders.get("/api/findPrice") 
                .contentType(MediaType.APPLICATION_JSON_VALUE) 
                .content(this.objectMapper.writeValueAsString(testRequestPrice)) 
            ) 
            .andExpect(status().isOk()) 
            .andExpect(jsonPath("$.brandId").value(brandId)) 
            .andExpect(jsonPath("$.endDate").value(endDate)) 
            .andExpect(jsonPath("$.pvp").value(formatter.format(price))) 
            .andExpect(jsonPath("$.priceLists").value(priceList)) 
            .andExpect(jsonPath("$.productId").value(productId)) 
            .andExpect(jsonPath("$.startDate").value(startDate)); 
    } 
}
