package com.shoppinglist.dto;

import java.util.Objects;

public class ProductCartDTO {
    private Long shopping_cart_id;
    private Long product_id;

    public ProductCartDTO() {
    }

    public ProductCartDTO(Long shopping_cart_id, Long product_id) {
        this.shopping_cart_id = shopping_cart_id;
        this.product_id = product_id;
    }

    public Long getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(Long shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCartDTO that = (ProductCartDTO) o;
        return Objects.equals(shopping_cart_id, that.shopping_cart_id) &&
                Objects.equals(product_id, that.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopping_cart_id, product_id);
    }

    @Override
    public String toString() {
        return "ProductCartDTO{" +
                "shopping_cart_id=" + shopping_cart_id +
                ", product_id=" + product_id +
                '}';
    }
}
