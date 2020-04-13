package service.validation;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.ProductRepositoryHibernate;
import com.shoppinglist.service.validation.ProductValidationException;
import com.shoppinglist.service.validation.ValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ValidationProductServiceTest {

    @Mock
    private ProductRepositoryHibernate repository;
    @InjectMocks
    private ValidationService victim;


    @Test
    public void shouldThrowExceptionIfNameIsNotUnique() {
        Product product = new Product();
        product.setName("apple");
        when(repository.findByName(product.getName())).thenReturn(java.util.Optional.of(product));
        assertThatThrownBy(() -> victim.validateUniqueProductName(product)).
                isInstanceOf(ProductValidationException.class).hasMessage("Product with this name already exists!");
    }

    @Test
    public void shouldReturnProductIfNameIsUnique() {
        Product product = new Product();
        product.setName("apple");
        when(repository.findByName(product.getName())).thenReturn(Optional.empty());
        victim.validateUniqueProductName(product);

    }


    @Test
    public void shouldThrowExceptionNameMustNotBeLessThan3() {
        Product product = new Product();
        product.setName("a");
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The name must be no shorter than 3 characters and no longer than 32 characters");

    }

    @Test
    public void shouldThrowExceptionNameMustNotBeMoreThan32() {
        Product product = new Product();
        product.setName("asdfdsfkeeefjjfkkekkdkkdkdkkekkdsdsdfkkwfrfrferfef");
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The name must be no shorter than 3 characters and no longer than 32 characters");

    }

    @Test
    public void shouldThrowExceptionPriceMustBeGreaterThan0() {
        Product product = new Product();
        product.setName("apple");
        product.setDiscount(new BigDecimal(1));
        product.setPrice(new BigDecimal(0));
        product.setCategory("fruits");
        product.setDescription("tasty");
        product.setId(1L);
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("Price must be greater than 0");
    }

    @Test
    public void shouldThrowExceptionPDiscountCannotBeLessThan0() {
        Product product = new Product();
        product.setName("apple");
        product.setDiscount(new BigDecimal(-1));
        product.setPrice(new BigDecimal(25));
        product.setCategory("fruits");
        product.setDescription("tasty");
        product.setId(1L);
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The discount cannot be less than 0 and more than 100");
    }

    @Test
    public void shouldThrowExceptionPDiscountCannotBeMoreThan100() {
        Product product = new Product();
        product.setName("apple");
        product.setDiscount(new BigDecimal(120));
        product.setPrice(new BigDecimal(25));
        product.setCategory("fruits");
        product.setDescription("tasty");
        product.setId(1L);
        assertThatThrownBy(() -> victim.validateProduct(product)).
                isInstanceOf(ProductValidationException.class).
                hasMessage("The discount cannot be less than 0 and more than 100");
    }

    @Test
    public void nameAndPriceAndDiscountIsOk() {
        Product product = new Product();
        product.setName("apple");
        product.setDiscount(new BigDecimal(1));
        product.setPrice(new BigDecimal(25));
        product.setCategory("fruits");
        product.setDescription("tasty");
        product.setId(1L);
        victim.validateProduct(product);
    }



}