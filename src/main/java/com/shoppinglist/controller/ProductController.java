package com.shoppinglist.controller;

import com.shoppinglist.domain.Product;
import com.shoppinglist.dto.ProductDTO;
import com.shoppinglist.service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO request) {
        System.out.println("Received request: " + request);
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setDiscount(request.getDiscount());
        product.setDescription(request.getDescription());
        Product addProduct = productService.addProduct(product);
        return new ProductDTO(addProduct.getId(), addProduct.getName(), addProduct.getPrice(), addProduct.getCategory(), addProduct.getDiscount(), addProduct.getDescription());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public ProductDTO findProductByName(@RequestParam(name = "name") String name) {
        Product product = productService.findByName(name).orElse(null);
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory(), product.getDiscount(), product.getDescription());
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }
}