package com.shoppinglist.service;

import com.shoppinglist.domain.Product;
import com.shoppinglist.domain.ProductCart;
import com.shoppinglist.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductCartService {
    private final ShoppingCartService shoppingCartService;
    private final ProductService service;
    private final ProductCart productCart;

    @Autowired
    public ProductCartService(ShoppingCartService shoppingCartService, ProductService service, ProductCart productCart) {
        this.shoppingCartService = shoppingCartService;
        this.service = service;
        this.productCart = productCart;
    }

    @Transactional
    public void assignProductToCart(Long productId, Long shoppingCartId) {
        Product product = service.findProductById(productId).orElse(null);
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(shoppingCartId).orElse(null);
        productCart.setProduct(product);
        productCart.setShoppingCart(shoppingCart);


    }
}
