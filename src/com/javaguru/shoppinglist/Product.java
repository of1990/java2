package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal discount;
    private String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) throws Exception {
        if (discount.intValue() < 100) {
            this.discount = discount.setScale(2,RoundingMode.HALF_EVEN);
        } else {
            throw new Exception("The discount cannot be more than 100");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() > 3 && name.length() < 32) {
            this.name = name;
        } else {
            throw new Exception ("The name must be no shorter than 3 characters and no longer than 32 characters");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws Exception {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Price must be greater than 0");
        } else {
            this.price = price.setScale(2,RoundingMode.HALF_EVEN);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
