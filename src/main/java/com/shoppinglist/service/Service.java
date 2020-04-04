package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.ProductRepository;
import com.shoppinglist.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Service {
    private final ProductRepository repository;
    private final ValidationService validation;

    @Autowired
    public Service(ProductRepository repository, ValidationService validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public Long addProduct(Product product) {
        validation.validateProduct(product);
        validation.validateUniqueProductName(product);
        Product createdProduct = repository.addProduct(product);
        return createdProduct.getId();
    }

    public Optional<Product> findProductById(Long id) {
        validation.validateId(repository.findProductById(id).orElse(null));
        return repository.findProductById(id);
    }

    public Optional<Product> findByName(String name) {
        validation.validateName(repository.findByName(name).orElse(null));
        return repository.findByName(name);
    }

    public Optional<Product> deleteProduct(Long id) {
        validation.validateId(repository.findProductById(id).orElse(null));
        repository.deleteProduct(id);
        return Optional.empty();
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        validation.validateId(repository.findProductById(id).orElse(null));
        validation.validateProduct(product);
        validation.validateUniqueProductName(product);
        return repository.updateProduct(id, product);
    }
}


