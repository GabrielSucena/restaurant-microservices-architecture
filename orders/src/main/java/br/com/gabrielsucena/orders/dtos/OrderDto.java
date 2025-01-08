package br.com.gabrielsucena.orders.dtos;

import br.com.gabrielsucena.orders.domain.enums.Status;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
        String id,
        LocalDateTime dateTime,
        Long customerId,
        BigDecimal total,
        Status status,
        List<OrderItemsDto> items
) {
}
