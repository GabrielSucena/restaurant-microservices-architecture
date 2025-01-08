package br.com.gabrielsucena.orders.dtos;

import br.com.gabrielsucena.orders.domain.enums.Status;

public record StatusDto(
        Status status
) {
}
