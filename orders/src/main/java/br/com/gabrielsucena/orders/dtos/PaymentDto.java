package br.com.gabrielsucena.orders.dtos;

import br.com.gabrielsucena.orders.domain.enums.Status;

import java.math.BigDecimal;

public record PaymentDto(
        BigDecimal value,
        Status status,
        String orderId,
        Long paymentMethodId
) {
}
