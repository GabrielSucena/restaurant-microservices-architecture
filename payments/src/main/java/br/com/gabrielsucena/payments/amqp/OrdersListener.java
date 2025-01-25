package br.com.gabrielsucena.payments.amqp;

import br.com.gabrielsucena.payments.domain.entities.Payment;
import br.com.gabrielsucena.payments.domain.enums.Status;
import br.com.gabrielsucena.payments.dtos.OrderDto;
import br.com.gabrielsucena.payments.mapper.PaymentMapper;
import br.com.gabrielsucena.payments.repository.PaymentRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OrdersListener {

    private final PaymentRepository paymentRepository;

    public OrdersListener(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @RabbitListener(queues = "payments.pending")
    public void receiveAndSaveMessage(OrderDto orderDto){

        Random rand = new Random();
        long paymentMethodId = rand.nextInt(4) + 1;

        Payment payment = new Payment(null, orderDto.total(), null, null, null, null, Status.CREATED, orderDto.id(), paymentMethodId);

        paymentRepository.save(payment);

    }

}
