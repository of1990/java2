package com.shoppinglist.repository;

import com.shoppinglist.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class RepositoryHibernate {

    private final SessionFactory sessionFactory;

    @Autowired
    public RepositoryHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    public Optional<Product> findProductById(Long id) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    public Optional<Product> findByName(String name) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    public void deleteProduct(Long product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

}
