package br.com.gabrielsucena.payments.dtos;

import java.math.BigDecimal;

public record OrderItemsDto(
        String product,
        Integer quantity,
        BigDecimal price
) {
}
