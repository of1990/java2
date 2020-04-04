package com.shoppinglist.repository;

import com.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;


@Component
@Profile({"local"})
public class ProductRepositoryMySQL implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepositoryMySQL(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Product addProduct(Product product) {
        String query = "insert into product (name, price, category, discount, description) values (" +
                "?, ?, ?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setString(3, product.getCategory());
            ps.setBigDecimal(4, product.getDiscount());
            ps.setString(5, product.getDescription());
            return ps;
        }, keyHolder);

        product.setId(keyHolder.getKey().longValue());
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        String query = "select * from product where id=" + id;
        List<Product> products = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class));
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String name) {
        String query = "select * from product p where p.name=?";
        List<Product> products = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class), name);
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();

    }



    @Override
    public Optional<Product> deleteProduct(Long id) {
        String query = "delete from product where id=" + id;
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection
                            .prepareStatement(query);
                    ps.execute();
                    return ps;
                }
        );
        return Optional.empty();
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product product) {
        String query = "UPDATE products SET name = ?, category = ?, price = ?, discount = ?, description = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(query);
        product.getName();
        product.getPrice();
        product.getCategory();
        product.getDiscount();
        product.getDescription();
        return Optional.ofNullable(product);

    }

    }



