package br.com.gabrielsucena.payments.repository;

import br.com.gabrielsucena.payments.domain.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
