package br.com.gabrielsucena.payments.configuration;

import br.com.gabrielsucena.payments.mapper.PaymentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    PaymentMapper paymentMapper(){
        return new PaymentMapper();
    }

}
