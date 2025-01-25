package br.com.gabrielsucena.payments.service;

import br.com.gabrielsucena.payments.domain.entities.Payment;
import br.com.gabrielsucena.payments.domain.enums.Status;
import br.com.gabrielsucena.payments.dtos.PaymentDto;
import br.com.gabrielsucena.payments.httpClients.OrdersClient;
import br.com.gabrielsucena.payments.mapper.PaymentMapper;
import br.com.gabrielsucena.payments.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    private final OrdersClient ordersClient;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper, OrdersClient ordersClient, RabbitTemplate rabbitTemplate) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.ordersClient = ordersClient;
    }

    public Page<PaymentDto> getAllPayments(Pageable pageable){
        return paymentRepository.findAll(pageable)
                .map(paymentMapper::toPaymentDto);
    }

    public PaymentDto getPaymentById(Long id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return paymentMapper.toPaymentDto(payment);
    }

    public PaymentDto createPayment(PaymentDto paymentDto){
        Payment payment = paymentMapper.toPaymentEntity(paymentDto);
        payment.setStatus(Status.CREATED);
        paymentRepository.save(payment);

        return paymentMapper.toPaymentDto(payment);
    }

    public PaymentDto updatePayment(Long id, PaymentDto dto){
        Payment payment = paymentMapper.toPaymentEntity(dto);
        payment.setId(id);
        payment = paymentRepository.save(payment);

        return paymentMapper.toPaymentDto(payment);
    }

    public void deletePayment(Long id){
        paymentRepository.deleteById(id);
    }

    public void confirmPayment(Long id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        payment.setStatus(Status.CONFIRMED);
        paymentRepository.save(payment);

        ordersClient.confirmPayment(payment.getOrderId());

    }

}
