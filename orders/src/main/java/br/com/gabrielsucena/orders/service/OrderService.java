package br.com.gabrielsucena.orders.service;

import br.com.gabrielsucena.orders.domain.entities.Order;
import br.com.gabrielsucena.orders.domain.enums.Status;
import br.com.gabrielsucena.orders.dtos.OrderDto;
import br.com.gabrielsucena.orders.dtos.StatusDto;
import br.com.gabrielsucena.orders.mapper.OrderMapper;
import br.com.gabrielsucena.orders.repository.OrderRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final RabbitTemplate rabbitTemplate;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, RabbitTemplate rabbitTemplate) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<OrderDto> getAllOrders(){
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
    }

    public OrderDto getOrderById(String id){
        Order order = orderRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        return orderMapper.toOrderDto(order);
    }

    public OrderDto createOrder(OrderDto orderDto){
        Order order = orderMapper.toOrder(orderDto);

        order.setDateTime(LocalDateTime.now());
        order.setStatus(Status.CREATED);
        order.setTotal(getTotal(orderDto));

        orderRepository.save(order);

        OrderDto mapperOrderDto =  orderMapper.toOrderDto(order);

        // Create payment asynchronously - RabbitMQ
        rabbitTemplate.convertAndSend("payments.pending", mapperOrderDto);

        return mapperOrderDto;
    }

    public OrderDto updateStatus(String id, StatusDto statusDto){
        Order order = orderRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        order.setStatus(statusDto.status());
        orderRepository.save(order);

        return orderMapper.toOrderDto(order);
    }

    public void approvePaymentOrder(String id){
        Order order = orderRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        order.setStatus(Status.PAID);
        orderRepository.save(order);
    }

    private @NotNull BigDecimal getTotal(OrderDto orderDto) {
        return orderDto.items().stream()
                .map(item -> item.price().multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
