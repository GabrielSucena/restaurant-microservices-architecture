package br.com.gabrielsucena.orders.httpClients;

import br.com.gabrielsucena.orders.dtos.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("payments-ms")
public interface PaymentsClient {

    @RequestMapping(method = RequestMethod.POST, value = "/payments")
    void createPayment(PaymentDto dto);

}
