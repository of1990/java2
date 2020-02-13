package console;

import domain.Product;
import service.Service;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    private final Service service;

    public ConsoleUI(Service service) {
        this.service = service;
    }

    public void execute() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Update product");
                System.out.println("4. Delete product");
                System.out.println("5. Find by name");
                System.out.println("6. Exit");
                int userInput = Integer.parseInt(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProductById();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        deleteProduct();
                        break;
                    case 5:
                        findByName();
                        break;
                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again. " + e.getMessage());
            }
        }
    }

    private void findByName() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        product = service.findByName(product, name);
        System.out.println(product);

    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
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
        Long id = service.createProduct(product);
        System.out.println("Product ID:" + id);
    }

    private void findProductById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Product product = service.findProductById(id);
        System.out.println(product);
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        service.deleteProduct(id);
        System.out.println("Product has been removed!");
    }

    private void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
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
        service.updateProduct(id, product);
        System.out.println("Product updated");

    }
}

