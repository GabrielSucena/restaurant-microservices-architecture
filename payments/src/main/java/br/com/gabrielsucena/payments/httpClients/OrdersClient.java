package br.com.gabrielsucena.payments.httpClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("orders-ms")
public interface OrdersClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}/paid")
    void confirmPayment(@PathVariable String id);

}
