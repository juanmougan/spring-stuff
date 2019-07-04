package com.github.juamougan.springstuff.data.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "INVOICE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "invoice", orphanRemoval = true)
  @EqualsAndHashCode.Exclude
  private Set<InvoiceDetail> details;

  public void addInvoiceDetail(InvoiceDetail detail) {
    if (details == null) details = new HashSet<>();
    details.add(detail);
    detail.setInvoice(this);
  }

  public void removeInvoiceDetail(InvoiceDetail detail) {
    detail.setInvoice(null);
    details.remove(detail);
  }

}
