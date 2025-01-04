package br.com.gabrielsucena.payments.mapper;

import br.com.gabrielsucena.payments.domain.entities.Payment;
import br.com.gabrielsucena.payments.dtos.PaymentDto;

public class PaymentMapper {

    public PaymentDto toPaymentDto(Payment payment){
        return new PaymentDto(
                payment.getId(),
                payment.getValue(),
                payment.getName(),
                payment.getCardNumber(),
                payment.getExpiryDate(),
                payment.getCode(),
                payment.getStatus(),
                payment.getOrderId(),
                payment.getPaymentMethodId());
    }

    public Payment toPaymentEntity(PaymentDto paymentDto){
        return new Payment(
                paymentDto.id(),
                paymentDto.value(),
                paymentDto.name(),
                paymentDto.cardNumber(),
                paymentDto.expiryDate(),
                paymentDto.code(),
                paymentDto.status(),
                paymentDto.orderId(),
                paymentDto.paymentMethodId()
        );
    }

}
