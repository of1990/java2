package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.ProductRepository;
import com.shoppinglist.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Product findProductById(Long id) {
        validation.validateId(repository.findProductById(id));
        return repository.findProductById(id);
    }

    public Product findByName(Product product, String name) {
        validation.validateUniqueProductName(product);
        return repository.findByName(name);
    }

    public Product deleteProduct(Long id) {
        validation.validateId(repository.findProductById(id));
        return repository.deleteProduct(id);
    }

    public Product updateProduct(Long id, Product product) {
        validation.validateId(repository.findProductById(id));
        validation.validateProduct(product);
        validation.validateUniqueProductName(product);
        return repository.updateProduct(id, product);
    }
}


