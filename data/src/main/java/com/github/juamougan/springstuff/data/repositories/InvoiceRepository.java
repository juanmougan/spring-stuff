package com.github.juamougan.springstuff.data.repositories;

import com.github.juamougan.springstuff.data.models.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
