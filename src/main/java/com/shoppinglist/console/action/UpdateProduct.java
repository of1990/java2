package com.shoppinglist.console.action;

import com.shoppinglist.domain.Product;
import com.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class UpdateProduct implements Action {
    private static final String ACTION_NAME = "UpdateProduct";

    private final ProductService productService;

    public UpdateProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        System.out.println("Enter product discount");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product description");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setDiscount(discount);
        product.setDescription(description);
        productService.updateProduct(id, product);
        System.out.println("Product updated");

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
