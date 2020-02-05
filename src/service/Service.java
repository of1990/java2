package service;

import domain.Product;
import repository.ProductRepository;
import service.validation.ValidationService;

public class Service {
    private ProductRepository repository = new ProductRepository();
    private ValidationService validation = new ValidationService();

    public Long createProduct(Product product) {
        validation.validateProduct(product);
        Product createdProduct = repository.createProduct(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        validation.validateId(repository.findProductById(id));
        return repository.findProductById(id);
    }

    public Product deleteProduct(Long id) {
        return repository.deleteProduct(id);
    }

    public Product updateProduct(Long id, Product product) {
        validation.validateProduct(product);
        return repository.updateProduct(id, product);
    }
}

