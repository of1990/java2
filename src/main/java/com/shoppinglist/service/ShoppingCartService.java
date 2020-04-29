package com.shoppinglist.service;

import com.shoppinglist.domain.ShoppingCart;
import com.shoppinglist.repository.ShoppingCartRepository;
import com.shoppinglist.service.validation.ProductValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @javax.transaction.Transactional

    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.addShoppingCart(shoppingCart);
    }

    public Optional<ShoppingCart> findShoppingCartById(Long id) {
        if (!shoppingCartRepository.findShoppingCartById(id).isPresent()) {
            throw new ProductValidationException("Id not found or entered incorrectly");
        }
        return shoppingCartRepository.findShoppingCartById(id);
    }

    public void deleteShoppingCart(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartById(id)
                .orElseThrow(() -> new ProductValidationException("Id not found or entered incorrectly"));
        shoppingCartRepository.deleteShoppingCart(shoppingCart);
    }
}

