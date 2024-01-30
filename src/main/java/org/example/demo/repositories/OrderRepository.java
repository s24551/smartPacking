package org.example.demo.repositories;


import org.example.demo.models.Order;
import org.example.demo.models.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByStatus(OrderStatus orderStatus);
    // Tutaj możesz dodać własne metody zapytań, np. wyszukiwanie zamówień po statusie
    // List<Order> findByStatus(OrderStatus status);
}
