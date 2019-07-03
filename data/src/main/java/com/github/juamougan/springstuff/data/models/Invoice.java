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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "INVOICE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "invoice")
  private Set<InvoiceDetail> details;

}
