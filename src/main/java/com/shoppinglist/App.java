package com.shoppinglist;

import com.shoppinglist.Config.ApplicationConfiguration;
import com.shoppinglist.console.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ConsoleUI console = context.getBean(ConsoleUI.class);
        console.start();

    }
}
