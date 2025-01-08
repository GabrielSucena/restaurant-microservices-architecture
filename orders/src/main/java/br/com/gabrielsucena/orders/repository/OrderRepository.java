package br.com.gabrielsucena.orders.repository;

import br.com.gabrielsucena.orders.domain.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}
