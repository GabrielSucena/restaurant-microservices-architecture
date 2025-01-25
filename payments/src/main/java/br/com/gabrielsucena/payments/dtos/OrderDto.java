package br.com.gabrielsucena.payments.dtos;

import br.com.gabrielsucena.payments.domain.enums.StatusOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
        String id,
        LocalDateTime dateTime,
        Long customerId,
        BigDecimal total,
        StatusOrder status,
        List<OrderItemsDto> items
) {
}
