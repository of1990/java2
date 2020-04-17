package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.domain.ShoppingCart;

import java.util.Optional;

public class ProductCartService {
    private final ShoppingCartService shoppingCartService;
    private final ProductService service;

    public ProductCartService(ShoppingCartService shoppingCartService, ProductService service) {
        this.shoppingCartService = shoppingCartService;
        this.service = service;
    }

    public void assignProductToCart(Long productId, Long shoppingCartId) {
        Optional<Product> product = service.findProductById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartService.findShoppingCartById(shoppingCartId);
        shoppingCart.g


    }
}
