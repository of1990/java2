package com.shoppinglist.console;

import com.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


public class ConsoleUIConfig {
    @Configuration
    class ConsoleUIConfiguration {

        private final Action addProduct;
        private final Action findProductById;
        private final Action findByName;
        private final Action deleteProduct;
        private final Action updateProduct;
        private final Action exit;
        private final Action addShoppingCart;
        private final Action findShoppingCartById;
        private final Action deleteShoppingCart;
        private final Action assignProductToCart;
        private final Action deleteProductFromCart;

        @Autowired
        public ConsoleUIConfiguration(Action addProduct,
                                      Action findProductById,
                                      Action findByName,
                                      Action updateProduct,
                                      Action deleteProduct,
                                      Action exit,
                                      Action addShoppingCart,
                                      Action findShoppingCartById,
                                      Action deleteShoppingCart,
                                      Action assignProductToCart, Action deleteProductFromCart) {
            this.addProduct = addProduct;
            this.findProductById = findProductById;
            this.findByName = findByName;
            this.updateProduct = updateProduct;
            this.deleteProduct = deleteProduct;
            this.exit = exit;
            this.addShoppingCart = addShoppingCart;
            this.findShoppingCartById = findShoppingCartById;
            this.deleteShoppingCart = deleteShoppingCart;

            this.assignProductToCart = assignProductToCart;
            this.deleteProductFromCart = deleteProductFromCart;
        }


        @Bean
        ConsoleUI consoleUI() {
            List<Action> actions = new ArrayList<>();
            actions.add(addProduct);
            actions.add(findProductById);
            actions.add(findByName);
            actions.add(updateProduct);
            actions.add(deleteProduct);
            actions.add(exit);
            actions.add(addShoppingCart);
            actions.add(findShoppingCartById);
            actions.add(deleteShoppingCart);
            actions.add(assignProductToCart);
            actions.add(deleteProductFromCart);

            return new ConsoleUI(actions);
        }
    }
}