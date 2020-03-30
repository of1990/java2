package com.shoppinglist.repository;

import com.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {
    Product addProduct(Product product);

    Optional<Product> findProductById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> deleteProduct(Long id);

    Optional<Product> updateProduct(Long id, Product product);

}

