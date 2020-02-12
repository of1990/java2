package service.validation;

import domain.Product;
import repository.ProductRepository;

import java.math.BigDecimal;

public class ValidationService {
    private static final int MIN_NAME_LENGHT = 2;
    private static final int MAX_NAME_LENGHT = 32;
    private ProductRepository repository;

    public ValidationService(ProductRepository repository) {
        this.repository = repository;
    }

    public void validateUniqueProductName(Product product) {
        if (repository.findByName(product.getName()) != null) {
            throw new ProductValidationException("Product with this name already exists!");
        }
    }

    public void validateProduct(Product product) {

        if (product.getName().length() < MIN_NAME_LENGHT || product.getName().length() > MAX_NAME_LENGHT) {
            throw new ProductValidationException("The name must be no shorter than 3 characters and no longer than 32 characters");
        }

        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price must be greater than 0");
        }

        if (product.getDiscount().compareTo(BigDecimal.ZERO) < 0 || product.getDiscount().intValue() > 100) {
            throw new ProductValidationException("The discount cannot be less than 0 and more than 100");
        }
    }

    public void validateId(Product product) {
        if (product == null) {
            throw new ProductValidationException("Id not found or entered incorrectly");
        }


    }

}
