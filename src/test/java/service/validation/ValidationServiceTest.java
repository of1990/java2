package service.validation;

import domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.ProductRepository;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ValidationServiceTest {

    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ValidationService victim;
    private Product product = product();

    private Product product() {
        Product product = new Product();
        product.setName("apple");
        product.setDiscount(new BigDecimal(35));
        product.setPrice(new BigDecimal(40));
        product.setCategory("fruits");
        product.setDescription("tasty");
        product.setId(1L);
        return product;
    }


    @Test
    public void validateUniqueProductName() {
        when(repository.findByName(product.getName())).thenReturn(product);
        assertThatThrownBy(() -> victim.validateUniqueProductName(product)).
                isInstanceOf(ProductValidationException.class).hasMessage("Product with this name already exists!");
    }

    @Test
    public void validateProduct() {
        when(repository.addProduct(product)).thenReturn(product);
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The name must be no shorter than 3 characters and no longer than 32 characters");
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Price must be greater than 0");
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The discount cannot be less than 0 and more than 100");


    }

    @Test
    public void validateId() {


    }


}