package service.validation;

import domain.Product;
import repository.ProductRepository;

import java.math.BigDecimal;

public class ValidationService {


    public void validateProduct(Product product) {
        if (product.getName().length() > 2 && product.getName().length() < 32) {
            product.setName(product.getName());
        } else {
            throw new RuntimeException("The name must be no shorter than 3 characters and no longer than 32 characters");
        }

        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Price must be greater than 0");
        } else {
            product.setPrice(product.getPrice());
        }

        if (product.getDiscount().compareTo(BigDecimal.ZERO) >= 0 && product.getDiscount().intValue() < 100) {
            product.setDiscount(product.getDiscount());
        } else {
            throw new RuntimeException("The discount cannot be less than 0 and more than 100");
        }
    }



}
