package repository;

import com.shoppinglist.domain.Product;
import com.shoppinglist.repository.InMemoryProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

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
        Optional<Product> result = victim.findProductById(PRODUCT_ID);
        assertThat(Optional.ofNullable(product.getId())).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Optional<Product> result = victim.findByName(PRODUCT_NAME);
        assertThat(Optional.ofNullable(product.getName())).isEqualTo(result);
    }

    @Test
    public void deleteProduct() {
        Optional<Product> result = victim.deleteProduct(PRODUCT_ID);
        assertThat(Optional.empty()).isEqualTo(result);
    }

    @Test
    public void updateProduct() {
        Optional<Product> result = victim.updateProduct(PRODUCT_ID, product);
        assertThat(Optional.ofNullable(product)).isEqualTo(result);

    }

}