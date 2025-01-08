package br.com.gabrielsucena.orders.dtos;

import java.math.BigDecimal;

public record OrderItemsDto(
        String product,
        Integer quantity,
        BigDecimal price
) {
}
