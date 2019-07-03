package com.github.juamougan.springstuff.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.github.juamougan.springstuff.data.models.Invoice;
import com.github.juamougan.springstuff.data.models.InvoiceDetail;
import com.github.juamougan.springstuff.data.models.Product;
import com.github.juamougan.springstuff.data.repositories.InvoiceRepository;
import com.github.juamougan.springstuff.data.repositories.ProductRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataApplication {

  private static final String BICYCLE = "Bicycle";
  private static final String CAR = "Car";
  private static ProductRepository productRepository;

  private static InvoiceRepository invoiceRepository;

  public static void main(String[] args) {
    SpringApplication.run(DataApplication.class, args);
    DataApplication application = new DataApplication();
    application.insertStuff();
    application.printStuff();
  }

  private void insertStuff() {
    insertProducts();
    Invoice i = insertInvoice();
    Set<InvoiceDetail> invoiceDetails = insertInvoiceDetails();
    updateInvoiceWithDetails(i, invoiceDetails);
  }

  private void updateInvoiceWithDetails(final Invoice i, final Set<InvoiceDetail> invoiceDetails) {
    i.setDetails(invoiceDetails);
    invoiceRepository.save(i);
  }

  private Set<InvoiceDetail> insertInvoiceDetails() {
    Product bicycle = productRepository.findByName(BICYCLE);
    Product car = productRepository.findByName(CAR);
    Invoice i = invoiceRepository.findById(1L).orElse(null);    // TODO this doesn't look good. Maybe receive Invoice as parameter, instead of fetching from DB
    InvoiceDetail bicycleInvoiceDetail = InvoiceDetail.builder().invoice(i).product(bicycle).build();
    InvoiceDetail carInvoiceDetail = InvoiceDetail.builder().invoice(i).product(car).build();
    return Sets.newHashSet(bicycleInvoiceDetail, carInvoiceDetail);
  }

  private void insertProducts() {
    Product p1 = Product.builder().name(BICYCLE).price(BigDecimal.valueOf(350)).build();
    Product p2 = Product.builder().name(CAR).price(BigDecimal.valueOf(10000)).build();
    productRepository.save(p1);
    productRepository.save(p2);
  }

  private Invoice insertInvoice() {
    Invoice i = Invoice.builder().createdAt(LocalDateTime.now()).build();
    return invoiceRepository.save(i);
  }

  private void printStuff() {
    System.out.println("Printing all stuff");
    System.out.println("Products: ");
    productRepository.findAll().forEach(System.out::println);
    System.out.println("Invoices: ");
    invoiceRepository.findAll().forEach(System.out::println);
  }

  // Autowire in the setter, because it's static
  @Autowired
  public void setProductRepository(final ProductRepository productRepository) {
    DataApplication.productRepository = productRepository;
  }

  @Autowired
  public void setInvoiceRepository(final InvoiceRepository invoiceRepository) {
    DataApplication.invoiceRepository = invoiceRepository;
  }
}
