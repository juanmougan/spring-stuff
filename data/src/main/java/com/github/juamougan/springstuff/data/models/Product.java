package com.github.juamougan.springstuff.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

import lombok.Value;

@Entity
@Table(name = "PRODUCT")
@Value
public class Product {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  private final String name;

  private final BigDecimal price;

}
