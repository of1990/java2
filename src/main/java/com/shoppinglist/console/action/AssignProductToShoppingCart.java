package com.shoppinglist.console.action;

import com.shoppinglist.service.ProductCartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AssignProductToShoppingCart implements Action {
    private static final String ACTION_NAME = "Assign Products to Shopping cart ";

    private final ProductCartService productCartService;

    public AssignProductToShoppingCart(ProductCartService productCartService) {
        this.productCartService = productCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long productId = scanner.nextLong();
        System.out.println("Enter shopping cart id: ");
        Long shoppingCartId = scanner.nextLong();

        productCartService.assignProductToCart(productId, shoppingCartId);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
