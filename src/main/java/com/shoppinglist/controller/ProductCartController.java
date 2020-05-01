package com.shoppinglist.controller;


import com.shoppinglist.dto.ProductCartDTO;
import com.shoppinglist.service.ProductCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productcart")
public class ProductCartController {
    public final ProductCartService productCartService;

    public ProductCartController(ProductCartService productCartService) {
        this.productCartService = productCartService;
    }

    @PutMapping
    public void assingProductToCart(@RequestBody ProductCartDTO dto) {
        Long product_id = dto.getProduct_id();
        Long shopping_cart_id = dto.getShopping_cart_id();
        productCartService.assignProductToCart(shopping_cart_id, product_id);
    }

    @DeleteMapping
    public void DeleteProductAndCart(@RequestBody ProductCartDTO dto) {
        Long product_id = dto.getProduct_id();
        Long shopping_cart_id = dto.getShopping_cart_id();
        productCartService.deleteProductFromCart(product_id, shopping_cart_id);
    }
}
