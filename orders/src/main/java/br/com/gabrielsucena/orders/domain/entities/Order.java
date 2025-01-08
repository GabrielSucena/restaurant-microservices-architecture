package br.com.gabrielsucena.orders.domain.entities;

import br.com.gabrielsucena.orders.domain.enums.Status;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @MongoId
    private String id;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    @Indexed(name = "customer_id_index")
    private Long customerId;

    @NotNull
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    @NotNull
    private Status status;

    private List<OrderItems> items = new ArrayList<>();

    public Order(String id, LocalDateTime dateTime, Long customerId, BigDecimal total, Status status, List<OrderItems> items) {
        this.id = id;
        this.dateTime = dateTime;
        this.customerId = customerId;
        this.total = total;
        this.status = status;
        this.items = items;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(@NotNull LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public @NotNull Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(@NotNull Long customerId) {
        this.customerId = customerId;
    }

    public @NotNull BigDecimal getTotal() {
        return total;
    }

    public void setTotal(@NotNull BigDecimal total) {
        this.total = total;
    }

    public @NotNull Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull Status status) {
        this.status = status;
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public void setItems(List<OrderItems> items) {
        this.items = items;
    }
}
