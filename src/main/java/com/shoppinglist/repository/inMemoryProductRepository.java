package com.shoppinglist.repository;

import com.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile({"inMDB"})
public class InMemoryProductRepository implements ProductRepository {

    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product addProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(productRepository.get(id));

    }

    public Optional<Product> findByName(String name) {
        for (Product product : productRepository.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return Optional.ofNullable(product);
            }
        }
        return null;
    }

    public void deleteProduct(Long id) {

        productRepository.remove(id);
    }

    public void updateProduct(Long id, Product product) {
        productRepository.replace(id, product);

    }

}
