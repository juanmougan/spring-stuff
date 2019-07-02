package com.github.juamougan.springstuff.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.Value;

@Entity
@Table(name = "INVOICE")
@Value
public class Invoice {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(name = "CREATED_AT")
  private final LocalDateTime createdAt;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
  private final Set<InvoiceDetail> details;

}
