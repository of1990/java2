package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.ProductRepositoryHibernate;
import com.shoppinglist.service.validation.ProductValidationException;
import com.shoppinglist.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ProductService {
    private final ProductRepositoryHibernate repository;
    private final ValidationService validation;

    @Autowired
    public ProductService(ProductRepositoryHibernate repository, ValidationService validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Transactional
    public Product addProduct(Product product) {
        validation.validateProduct(product);
        validation.validateUniqueProductName(product);
        return repository.addProduct(product);

    }

    public Optional<Product> findProductById(Long id) {
        if (!repository.findProductById(id).isPresent()) {
            throw new ProductValidationException("Product Id not found or entered incorrectly");
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
        Product product = repository.findProductById(id)
                .orElseThrow(() -> new ProductValidationException("Product Id not found or entered incorrectly"));
        repository.deleteProduct(product);
    }

    public Optional<Product> updateProduct(Long id, Product newProduct) {
        Product product = repository.findProductById(id)
                .orElseThrow(() -> new ProductValidationException("Product Id not found or entered incorrectly"));

        validation.validateProduct(newProduct);
        validation.validateUniqueProductName(newProduct);
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setCategory(newProduct.getCategory());
        product.setDiscount(newProduct.getDiscount());
        product.setDescription(newProduct.getDescription());
        return repository.updateProduct(product);
    }
}


