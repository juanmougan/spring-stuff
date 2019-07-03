package com.github.juamougan.springstuff.data.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Value;

@Entity
@Table(name = "INVOICE_DETAIL")
@Value
public class InvoiceDetail {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(name = "QUANTITY")
  private final int quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  private final Product product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT")
  private final Invoice invoice;

}
