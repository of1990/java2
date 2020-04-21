package com.shoppinglist.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productsCart")

public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;
    @Column(name = "product_id")
    private Long productId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id", insertable = false, updatable = false)
    private ShoppingCart shoppingCart;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCart that = (ProductCart) o;
        return Objects.equals(shoppingCartId, that.shoppingCartId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(shoppingCart, that.shoppingCart) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartId, productId, shoppingCart, product);
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "shoppingCartId=" + shoppingCartId +
                ", productId=" + productId +
                ", shoppingCart=" + shoppingCart +
                ", product=" + product +
                '}';
    }
}
