package br.com.gabrielsucena.payments.domain.entities;

import br.com.gabrielsucena.payments.domain.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    @Column(name = "payment_value")
    private BigDecimal value;

    private String name;

    @Size(min = 13, max = 16)
    private String cardNumber;

    @Size(min = 7, max = 7)
    private String expiryDate;

    @Size(min = 3, max = 3)
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private String orderId;

    @NotNull
    private Long paymentMethodId;

    public Payment() {
    }

    public Payment(Long id, BigDecimal value, String name, String cardNumber, String expiryDate, String code, Status status, String orderId, Long paymentMethodId) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.code = code;
        this.status = status;
        this.orderId = orderId;
        this.paymentMethodId = paymentMethodId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Positive BigDecimal getValue() {
        return value;
    }

    public void setValue(@NotNull @Positive BigDecimal value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @Size(min = 13, max = 16) String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(@Size(min = 13, max = 16) String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public @Size(min = 7, max = 7) String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(@Size(min = 7, max = 7) String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public @Size(min = 3, max = 3) String getCode() {
        return code;
    }

    public void setCode(@Size(min = 3, max = 3) String code) {
        this.code = code;
    }

    public @NotNull Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull Status status) {
        this.status = status;
    }

    public @NotNull String getOrderId() {
        return orderId;
    }

    public void setOrderId(@NotNull String orderId) {
        this.orderId = orderId;
    }

    public @NotNull Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(@NotNull Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
