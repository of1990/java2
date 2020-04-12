package com.shoppinglist.console.action;

import org.springframework.stereotype.Component;

@Component
public class Exit implements Action {
    private static final String ACTION_NAME = "Exit";

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
