package br.com.gabrielsucena.payments.dtos;

import br.com.gabrielsucena.payments.domain.entities.Payment;
import br.com.gabrielsucena.payments.domain.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PaymentDto(
        Long id,
        BigDecimal value,
        String name,
        String cardNumber,
        String expiryDate,
        String code,
        Status status,
        Long orderId,
        Long paymentMethodId
) {
}
