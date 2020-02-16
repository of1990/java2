package service;

import domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.ProductRepository;
import service.validation.ValidationService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ServiceTest {

    @Mock
    private ProductRepository repository;
    @Mock
    private ValidationService validation;
    @Captor
    private ArgumentCaptor<Product> productCaptor;
    @InjectMocks
    private Service victim;

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
    public void shouldAddProduct() {
        Product product = product();
        when(repository.addProduct(product)).thenReturn(product);
        Long result = victim.addProduct(product);
        verify(validation).validateProduct(productCaptor.capture());
        Product captorResultProduct = productCaptor.getValue();
        assertEquals(captorResultProduct, product);
        verify(validation).validateUniqueProductName(productCaptor.capture());
        Product captorResultUniqueName = productCaptor.getValue();
        assertEquals(captorResultUniqueName, product);
        assertEquals(product.getId(), result);

    }

    @Test
    public void shouldFindProductById() {
        Product product = product();
        when(repository.findProductById(1L)).thenReturn(product);
        Product result = victim.findProductById(1L);
        verify(validation).validateId(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, product);
        assertEquals(product, result);

    }

    @Test
    public void findByName() {
        Product product = product();
        when(repository.findByName("apple")).thenReturn(product);
        Product result = victim.findByName(product, "apple");
        verify(validation).validateUniqueProductName(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, product);
        assertEquals(product(), result);
    }

    @Test
    public void deleteProduct() {
        when(repository.deleteProduct(0L)).thenReturn(null);
        Product result = victim.deleteProduct(0L);
        verify(validation).validateId(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, null);
        assertEquals(null, result);
    }

    @Test
    public void updateProduct() {
        Product product = product();
        when(repository.updateProduct(1L, product)).thenReturn(product);
        Product result = victim.updateProduct(1L, product);
        assertEquals(product, result);
        verify(validation).validateId(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, product);


    }

}