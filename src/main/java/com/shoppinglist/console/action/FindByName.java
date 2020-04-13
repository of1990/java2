package com.shoppinglist.console.action;

import com.shoppinglist.domain.Product;
import com.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindByName implements Action {
    private static final String ACTION_NAME = "Find by Name";
    private final ProductService productService;

    public FindByName(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Product product;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        product = productService.findByName(name).orElse(null);
        System.out.println(product);

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
