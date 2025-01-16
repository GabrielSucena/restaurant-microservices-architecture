package br.com.gabrielsucena.payments.controller;

import br.com.gabrielsucena.payments.dtos.PaymentDto;
import br.com.gabrielsucena.payments.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public Page<PaymentDto> getAllPayments(@PageableDefault(size = 10) Pageable pageable){
        return paymentService.getAllPayments(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long id){
        PaymentDto paymentDto = paymentService.getPaymentById(id);

        return ResponseEntity.ok(paymentDto);
    }

    @PostMapping
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto dto, UriComponentsBuilder uriComponentsBuilder){
        PaymentDto paymentDto = paymentService.createPayment(dto);

        URI uri = uriComponentsBuilder.path("/payments/{id}").buildAndExpand(paymentDto.id()).toUri();

        return ResponseEntity.created(uri).body(paymentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable Long id, @RequestBody PaymentDto dto){
        PaymentDto paymentDto = paymentService.updatePayment(id, dto);

        return ResponseEntity.ok(paymentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDto> deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/confirm")
    public void confirmPayment(@PathVariable Long id){
        paymentService.confirmPayment(id);
    }

}
