package com.javaguru.shoppinglist;

import domain.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Update product");
                System.out.println("4. Delete product");
                System.out.println("5. Exit");
                int userInput = Integer.parseInt(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        Product product = new Product();
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        if (name.length() > 3 && name.length() < 32) {
                            product.setName(name);
                        } else {
                            throw new RuntimeException("The name must be no shorter than 3 characters and no longer than 32 characters");
                        }
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        if (price.compareTo(BigDecimal.ZERO) <= 0) {
                            throw new RuntimeException("Price must be greater than 0");
                        } else {
                            product.setPrice(price);
                        }
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        product.setCategory(category);
                        System.out.println("Enter product discount");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        if (discount.compareTo(BigDecimal.ZERO) >= 0 && discount.intValue() < 100){
                            product.setDiscount(discount);
                        } else {
                            throw new RuntimeException("The discount cannot be less than 0 and more than 100");
                        }
                        System.out.println("Enter product description");
                        String description = scanner.nextLine();
                        product.setDescription(description);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Product ID:" + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        if (productRepository.containsKey(id)) {
                            Product findProductResult = productRepository.get(id);
                            System.out.println(findProductResult);
                        } else {
                            throw new RuntimeException("id not found or entered incorrectly");
                        }
                        break;
                    case 3:
                        Product findProductResult;
                        System.out.println("Enter product id: ");
                        id = scanner.nextLong();
                        scanner.nextLine();
                        if (productRepository.containsKey(id)) {
                        findProductResult = productRepository.get(id);
                        System.out.println("Enter product name: ");
                        name = scanner.nextLine();
                        if (name.length() > 3 && name.length() < 32) {
                            findProductResult.setName(name);
                        } else {
                            throw new RuntimeException("The name must be no shorter than 3 characters and no longer than 32 characters");
                        }
                        System.out.println("Enter product price: ");
                        price = new BigDecimal(scanner.nextLine());
                        if (price.compareTo(BigDecimal.ZERO) <= 0) {
                            throw new RuntimeException("Price must be greater than 0");
                        } else {
                            findProductResult.setPrice(price);
                        }
                        System.out.println("Enter product category: ");
                        category = scanner.nextLine();
                        findProductResult.setCategory(category);
                        System.out.println("Enter product discount");
                        discount = new BigDecimal(scanner.nextLine());
                        if (discount.compareTo(BigDecimal.ZERO) >= 0 && discount.intValue() < 100) {
                            findProductResult.setDiscount(discount);
                        } else {
                            throw new RuntimeException("The discount cannot be less than 0 and more than 100");
                        }
                        System.out.println("Enter product description");
                        description = scanner.nextLine();
                        findProductResult.setDescription(description);
                        System.out.println("product updated!");}
                        else {
                            throw new RuntimeException("id not found or entered incorrectly");
                        }
                        break;
                    case 4:
                        System.out.println("Enter product id: ");
                        id = scanner.nextLong();
                        if (productRepository.containsKey(id)) {
                            productRepository.remove(id);
                            System.out.println("Product has been removed!");
                        } else {
                            throw new RuntimeException("id not found or entered incorrectly");
                        }
                        break;

                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again. " + e.getMessage());
            }
        }
    }
}
