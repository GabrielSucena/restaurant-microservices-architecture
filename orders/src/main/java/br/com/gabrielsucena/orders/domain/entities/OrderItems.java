package br.com.gabrielsucena.orders.domain.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

public class OrderItems {

    @NotBlank
    private String product;

    @NotNull
    @Positive
    private Integer quantity;

    @NotNull
    @Positive
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;

    public OrderItems() {
    }

    public OrderItems(String product, Integer quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public @NotBlank String getProduct() {
        return product;
    }

    public void setProduct(@NotBlank String product) {
        this.product = product;
    }

    public @NotNull @Positive Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull @Positive Integer quantity) {
        this.quantity = quantity;
    }

    public @NotNull @Positive BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Positive BigDecimal price) {
        this.price = price;
    }
}
