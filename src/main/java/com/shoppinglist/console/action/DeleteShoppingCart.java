package com.shoppinglist.console.action;


import com.shoppinglist.service.ShoppingCartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteShoppingCart implements Action {
    private static final String ACTION_NAME = "Delete Shopping cart";
    private final ShoppingCartService shoppingCartService;

    public DeleteShoppingCart(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Shopping cart id: ");
        Long id = scanner.nextLong();
        shoppingCartService.deleteShoppingCart(id);
        System.out.println("Shopping cart has been removed!");
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
