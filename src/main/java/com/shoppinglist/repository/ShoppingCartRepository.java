package com.shoppinglist.repository;

import com.shoppinglist.domain.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class ShoppingCartRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public ShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ShoppingCart addShoppongCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart;
    }

    public Optional<ShoppingCart> findShoppingCartById(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(shoppingCart);
    }

    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().delete(shoppingCart);
    }

}


