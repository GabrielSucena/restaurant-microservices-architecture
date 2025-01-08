package br.com.gabrielsucena.orders.mapper;

import br.com.gabrielsucena.orders.domain.entities.Order;
import br.com.gabrielsucena.orders.domain.entities.OrderItems;
import br.com.gabrielsucena.orders.dtos.OrderDto;
import br.com.gabrielsucena.orders.dtos.OrderItemsDto;

public class OrderMapper {

    public OrderDto toOrderDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getDateTime(),
                order.getCustomerId(),
                order.getTotal(),
                order.getStatus(),
                order.getItems().stream().map(this::toOrderItemDto).toList()
        );
    }

    public Order toOrder(OrderDto orderDto){
        return new Order(
                orderDto.id(),
                orderDto.dateTime(),
                orderDto.customerId(),
                orderDto.total(),
                orderDto.status(),
                orderDto.items().stream().map(this::toOrderItem).toList()
        );
    }

    private OrderItemsDto toOrderItemDto(OrderItems orderItem) {
        return new OrderItemsDto(
                orderItem.getProduct(),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }

    private OrderItems toOrderItem(OrderItemsDto orderItemDto) {
        return new OrderItems(
                orderItemDto.product(),
                orderItemDto.quantity(),
                orderItemDto.price()
        );
    }

}
