package com.nlehman.vuetailwind.repositories;

import java.util.List;

import com.nlehman.vuetailwind.entities.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    Product findById(long id);
}
