package com.javaguru.shoppinglist;

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
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        Product product = new Product();
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        product.setName(name);
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        product.setPrice(price);
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        product.setCategory(category);
                        System.out.println("Enter product discount");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        product.setDiscount(discount);
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
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        id = scanner.nextLong();
                        findProductResult = productRepository.get(id);
                        System.out.println("Enter product name: ");
                        name = scanner.next();
                        findProductResult.setName(name);
                        System.out.println("Enter product price: ");
                        price = new BigDecimal(scanner.next());
                        findProductResult.setPrice(price);
                        System.out.println("Enter product category: ");
                        category = scanner.next();
                        findProductResult.setCategory(category);
                        System.out.println("Enter product discount");
                        discount = new BigDecimal(scanner.next());
                        findProductResult.setDiscount(discount);
                        System.out.println("Enter product description");
                        description = scanner.next();
                        findProductResult.setDescription(description);
                        break;
                    case 4:
                        System.out.println("Enter product id: ");
                        id = scanner.nextLong();
                        if (productRepository.containsKey(id)) {
                            productRepository.remove(id);
                            System.out.println("Product has been removed!");
                        } else {
                            throw new Exception("id not found or entered incorrectly");
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
