package repository;

import domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.validation.ValidationService;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)

public class ProductRepositoryTest {

    @Mock
    private ValidationService validation;
    @InjectMocks
    private ProductRepository victim;

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
    public void addProduct() {
       

    }

    @Test
    public void findProductById() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void deleteProduct() {
    }

    @Test
    public void updateProduct() {
    }
}