package com.shoppinglist.console.action;

import com.shoppinglist.domain.ShoppingCart;
import com.shoppinglist.service.ShoppingCartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class AddShoppingCart implements Action {
    private static final String ACTION_NAME = "Add ShoppingCart";
    private final ShoppingCartService shoppingCartService;

    public AddShoppingCart(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Shopping cart name: ");
        String name = scanner.nextLine();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName(name);
        Long id = shoppingCartService.addShoppingCart(shoppingCart);
        System.out.println("Shopping cart ID:" + id);

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}

