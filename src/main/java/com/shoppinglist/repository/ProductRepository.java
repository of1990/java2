package com.shoppinglist.repository;

import com.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {
    Product addProduct(Product product);

    Optional<Product> findProductById(Long id);

    Optional<Product> findByName(String name);

    void deleteProduct(Long id);

    void updateProduct(Long id, Product product);

}

