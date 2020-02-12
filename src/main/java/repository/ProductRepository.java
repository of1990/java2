package repository;

import domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product createProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findProductById(Long id) {
        return productRepository.get(id);

    }

    public Product findByName(String name) {
        for (Product product : productRepository.values()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Product deleteProduct(Long id) {
        return productRepository.remove(id);
    }

    public Product updateProduct(Long id, Product product) {
        productRepository.replace(id, product);
        return product;
    }
}
