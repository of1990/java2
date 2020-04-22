package com.shoppinglist.console.action;

import com.shoppinglist.domain.Product;
import com.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindProductById implements Action {

    private static final String ACTION_NAME = "Find by ID";

    private final ProductService productService;

    public FindProductById(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id).orElse(null);
        System.out.println(product);

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
