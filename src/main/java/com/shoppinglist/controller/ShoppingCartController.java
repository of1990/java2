package com.shoppinglist.controller;

import com.shoppinglist.domain.ShoppingCart;
import com.shoppinglist.dto.ShoppingCartDTO;
import com.shoppinglist.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    public final ShoppingCartService shoppingCartService;


    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{id}")
    public ShoppingCartDTO findShoppingCartById(@PathVariable Long id) {
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(id).orElse(null);
        return new ShoppingCartDTO(shoppingCart.getId(), shoppingCart.getName());
    }

    @PostMapping
    public ShoppingCartDTO addShoppingCart(@RequestBody ShoppingCartDTO request) {
        System.out.println("Received request: " + request);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName(request.getName());
        ShoppingCart addShoppingCart = shoppingCartService.addShoppingCart(shoppingCart);
        return new ShoppingCartDTO(addShoppingCart.getId(), addShoppingCart.getName());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteShoppingCart(@PathVariable Long id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}
