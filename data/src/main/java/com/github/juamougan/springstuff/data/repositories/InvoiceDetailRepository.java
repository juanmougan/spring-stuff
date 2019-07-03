package com.github.juamougan.springstuff.data.repositories;

import com.github.juamougan.springstuff.data.models.InvoiceDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceDetailRepository extends PagingAndSortingRepository<InvoiceDetail, Long> {    // Let's assume we'll have way more InvoiceDetails than Invoices or Products
}
