package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.InMemoryProductRepository;
import com.shoppinglist.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Service {
    private final InMemoryProductRepository repository;
    private final ValidationService validation;

    @Autowired
    public Service(InMemoryProductRepository repository, ValidationService validation) {
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

    public Optional<Product> findByName(Product product, String name) {
        validation.validateUniqueProductName(product);
        return repository.findByName(name);
    }

    public void deleteProduct(Long id) {
        validation.validateId(repository.findProductById(id).orElse(null));
        repository.deleteProduct(id);
    }

    public void updateProduct(Long id, Product product) {
        validation.validateId(repository.findProductById(id).orElse(null));
        validation.validateProduct(product);
        validation.validateUniqueProductName(product);
        repository.updateProduct(id, product);
    }
}


