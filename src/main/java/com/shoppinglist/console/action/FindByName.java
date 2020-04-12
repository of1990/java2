package com.shoppinglist.console.action;

import com.shoppinglist.domain.Product;
import com.shoppinglist.service.Service;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindByName implements Action {
    private static final String ACTION_NAME = "Find by Name";
    private final Service service;

    public FindByName(Service service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Product product;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        product = service.findByName(name).orElse(null);
        System.out.println(product);

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
