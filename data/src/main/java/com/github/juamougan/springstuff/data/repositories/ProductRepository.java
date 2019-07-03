package com.github.juamougan.springstuff.data.repositories;

import com.github.juamougan.springstuff.data.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {    // So far, CrudRepository is enough

  @Override <S extends Product> S save(S entity);

  Product findByName(String name);

}
