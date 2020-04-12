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

        @Autowired
        public ConsoleUIConfiguration(Action addProduct,
                                      Action findProductById,
                                      Action findByName,
                                      Action updateProduct,
                                      Action deleteProduct,
                                      Action exit) {
            this.addProduct = addProduct;
            this.findProductById = findProductById;
            this.findByName = findByName;
            this.updateProduct = updateProduct;
            this.deleteProduct = deleteProduct;
            this.exit = exit;
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
            return new ConsoleUI(actions);
        }
    }
}