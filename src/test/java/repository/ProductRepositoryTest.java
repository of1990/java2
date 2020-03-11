package repository;

import domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)

public class ProductRepositoryTest {

    private static final long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "apple";
    private ProductRepository victim = new ProductRepository();
    private Product product = new Product();

    @Test
    public void addProduct() {
        Product result = victim.addProduct(product);
        assertThat(product).isEqualTo(result);
    }

    @Test
    public void findProductById() {
        Product result = victim.findProductById(PRODUCT_ID);
        assertThat(product.getId()).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Product result = victim.findByName(PRODUCT_NAME);
        assertThat(product.getName()).isEqualTo(result);
    }

    @Test
    public void deleteProduct() {
        Product result = victim.deleteProduct(PRODUCT_ID);
        assertThat(product = null).isEqualTo(result);
    }

    @Test
    public void updateProduct() {
        Product result = victim.updateProduct(PRODUCT_ID, product);
        assertThat(product).isEqualTo(result);

    }

}