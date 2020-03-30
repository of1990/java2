package repository;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.InMemoryProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)

public class inMemoryProductRepositoryTest {

    private static final long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "apple";
    private InMemoryProductRepository victim = new InMemoryProductRepository();
    private Product product = new Product();

    @Test
    public void addProduct() {
        Product result = victim.addProduct(product);
        assertThat(product).isEqualTo(result);
    }

    @Test
    public void findProductById() {
        Product result = victim.findProductById(PRODUCT_ID).orElse(null);
        assertThat(product.getId()).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Product result = victim.findByName(PRODUCT_NAME).orElse(null);
        assertThat(product.getName()).isEqualTo(result);
    }
/*
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


 */
}