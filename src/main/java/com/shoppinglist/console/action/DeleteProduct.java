package com.shoppinglist.console.action;

import com.shoppinglist.service.Service;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteProduct implements Action {
    private static final String ACTION_NAME = "Delete Product";
    private final Service service;

    public DeleteProduct(Service service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        service.deleteProduct(id);
        System.out.println("Product has been removed!");
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
