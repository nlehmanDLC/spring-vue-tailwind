package com.nlehman.vuetailwind.services;

import com.nlehman.vuetailwind.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("h2")
public class H2ProductService implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Object getProducts() {
        return repository.findAll();
    }

    @Override
    public Object getProduct(long id) {
        return repository.findById(id);
    }

}
