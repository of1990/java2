package com.shoppinglist.console.action;

import com.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteProduct implements Action {
    private static final String ACTION_NAME = "Delete Product";
    private final ProductService productService;

    public DeleteProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        productService.deleteProduct(id);
        System.out.println("Product has been removed!");
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
