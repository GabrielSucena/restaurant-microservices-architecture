package br.com.gabrielsucena.orders.controller;

import br.com.gabrielsucena.orders.dtos.OrderDto;
import br.com.gabrielsucena.orders.dtos.StatusDto;
import br.com.gabrielsucena.orders.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String id){
        OrderDto orderDto = orderService.getOrderById(id);

        return ResponseEntity.ok(orderDto);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto dto, UriComponentsBuilder uriComponentsBuilder){
        OrderDto orderDto = orderService.createOrder(dto);

        URI uri = uriComponentsBuilder.path("/orders/{id}").buildAndExpand(orderDto.id()).toUri();

        return ResponseEntity.created(uri).body(orderDto);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderDto> updateStatus(@PathVariable String id, @RequestBody StatusDto statusDto){
        OrderDto orderDto = orderService.updateStatus(id, statusDto);

        return ResponseEntity.ok(orderDto);
    }

    @PatchMapping("/{id}/paid")
    public ResponseEntity<Void> approvePaymentOrder(@PathVariable String id){
        orderService.approvePaymentOrder(id);

        return ResponseEntity.ok().build();
    }

}
