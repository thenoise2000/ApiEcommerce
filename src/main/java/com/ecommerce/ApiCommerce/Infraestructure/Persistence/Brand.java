package com.ecommerce.ApiCommerce.Infraestructure.Persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Price> prices = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Brand brand = (Brand) o;
    return Objects.equals(id, brand.id) && Objects.equals(name, brand.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}

