package com.github.juamougan.springstuff.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  private String name;

  private BigDecimal price;

}
