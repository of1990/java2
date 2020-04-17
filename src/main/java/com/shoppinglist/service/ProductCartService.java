package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.domain.ShoppingCart;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductCartService {
    private final ShoppingCartService shoppingCartService;
    private final ProductService service;

    public ProductCartService(ShoppingCartService shoppingCartService, ProductService service) {
        this.shoppingCartService = shoppingCartService;
        this.service = service;
    }

    @Transactional
    public void assignProductToCart(Long productId, Long shoppingCartId) {
        Product product = service.findProductById(productId).orElse(null);
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(shoppingCartId).orElse(null);
        shoppingCart.getProducts().add(product);


    }
}
