package com.ecommerce.ApiCommerce.Infraestructure.Persistence;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Objects;

@Entity
@Table(name = "prices")
@Getter
@Setter
public class Price {
    
    @JoinColumn(name = "brand_id", nullable = false)
    @ManyToOne(targetEntity = Brand.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @NonNull
    private Brand brand;

    @Column(name = "curr")    
    private Currency currency;

    @Column(name = "end_date")    
    private LocalDateTime endDate;

    @Column(name = "price")    
    private BigDecimal pvp;

    @Column(name = "price_list")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long priceLists;

    @Column(name = "priority")    
    private Integer priority;

    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @NonNull
    private Product product;

    @Column(name = "start_date")    
    private LocalDateTime startDate;

    public Price() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price prices = (Price) o;
        return Objects.equals(brand, prices.brand)
                && Objects.equals(currency, prices.currency)
                && Objects.equals(endDate, prices.endDate)
                && Objects.equals(pvp, prices.pvp)
                && Objects.equals(priceLists, prices.priceLists)
                && Objects.equals(priority, prices.priority)
                && Objects.equals(product, prices.product)
                && Objects.equals(startDate, prices.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, currency, endDate, pvp, priceLists, priority, product, startDate);
    }

    @Override
    public String toString() {
        return "Price{" +
                "brand=" + brand +
                ", currency=" + currency +
                ", endDate=" + endDate +
                ", pvp=" + pvp +
                ", priceLists=" + priceLists +
                ", priority=" + priority +
                ", product=" + product +
                ", startDate=" + startDate +
                '}';
    }

}

