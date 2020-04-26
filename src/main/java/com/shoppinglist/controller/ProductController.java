package com.shoppinglist.controller;

import com.shoppinglist.domain.Product;
import com.shoppinglist.dto.ProductDTO;
import com.shoppinglist.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id).orElse(null);
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory(), product.getDiscount(), product.getDescription());

    }
}
