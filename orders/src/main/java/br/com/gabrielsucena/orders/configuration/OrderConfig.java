package br.com.gabrielsucena.orders.configuration;

import br.com.gabrielsucena.orders.mapper.OrderMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    OrderMapper orderMapper(){
        return new OrderMapper();
    }

}
