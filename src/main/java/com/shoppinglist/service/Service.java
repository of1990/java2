package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.RepositoryHibernate;
import com.shoppinglist.service.validation.ProductValidationException;
import com.shoppinglist.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final RepositoryHibernate repository;
    private final ValidationService validation;

    @Autowired
    public Service(RepositoryHibernate repository, ValidationService validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Transactional
    public Long addProduct(Product product) {
        validation.validateProduct(product);
        validation.validateUniqueProductName(product);
        Product createdProduct = repository.addProduct(product);
        return createdProduct.getId();
    }

    public Optional<Product> findProductById(Long id) {
        if (!repository.findProductById(id).isPresent()) {
            throw new ProductValidationException("Id not found or entered incorrectly");
        }
        return repository.findProductById(id);
    }

    public Optional<Product> findByName(String name) {
        if (!repository.findByName(name).isPresent()) {
            throw new ProductValidationException("Product name not found or entered incorrectly");
        }
        return repository.findByName(name);
    }

    public void deleteProduct(Long id) {
        if (!repository.findProductById(id).isPresent()) {
            throw new ProductValidationException("Id not found or entered incorrectly");
        }
        repository.deleteProduct(id);
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        if (!repository.findProductById(id).isPresent()) {
            throw new ProductValidationException("Id not found or entered incorrectly");
        }
        validation.validateProduct(product);
        validation.validateUniqueProductName(product);
        return repository.updateProduct(product);
    }
}


