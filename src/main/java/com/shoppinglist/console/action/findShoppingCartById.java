package com.shoppinglist.console.action;

import com.shoppinglist.domain.ShoppingCart;
import com.shoppinglist.service.ShoppingCartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class findShoppingCartById implements Action {
    private static final String ACTION_NAME = "Find Shopping cart by ID";

    private final ShoppingCartService shoppingCartService;

    public findShoppingCartById(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Shopping cart id: ");
        Long id = scanner.nextLong();
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(id).orElse(null);
        System.out.println(shoppingCart);

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}

