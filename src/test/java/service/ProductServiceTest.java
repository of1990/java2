package service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.ProductRepositoryHibernate;
import com.shoppinglist.service.ProductService;
import com.shoppinglist.service.validation.ValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ProductServiceTest {

    @Mock
    private ProductRepositoryHibernate repository;
    @Mock
    private ValidationService validation;
    @Captor
    private ArgumentCaptor<Product> productCaptor;
    @InjectMocks
    private ProductService victim;

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
        Product result = victim.addProduct(product);
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
        when(repository.findProductById(1L)).thenReturn(Optional.of(product));
        Optional<Product> result = victim.findProductById(1L);
        assertEquals(Optional.ofNullable(product), result);

    }

    @Test
    public void findByName() {
        Product product = product();
        when(repository.findByName("apple")).thenReturn(Optional.of(product));
        Optional<Product> result = victim.findByName("apple");
        assertEquals(Optional.ofNullable(product), result);
    }

    @Test
    public void deleteProduct() {
        Product product = product();
        when(repository.findProductById(1L)).thenReturn(Optional.of(product));
        victim.deleteProduct(product.getId());
        verify(repository).deleteProduct(product);
    }


    @Test
    public void updateProduct() {
        Product product = product();
        when(repository.findProductById(1L)).thenReturn(Optional.of(product));
        when(repository.updateProduct(product)).thenReturn(Optional.of(product));
        Optional<Product> result = victim.updateProduct(1L, product);
        assertEquals(Optional.ofNullable(product), result);


    }
}
