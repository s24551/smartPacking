package org.example.demo.services;


import org.example.demo.models.Order;
import org.example.demo.models.OrderStatus;
import org.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            // Obsługa błędu, np. rzucenie wyjątku
            throw new RuntimeException("Order not found for id: " + id);
        }
    }

    public Order createOrder(Order order) {
        // Tutaj można dodać logikę walidacji lub inną logikę biznesową przed zapisaniem
        return orderRepository.save(order);
    }

    public Order updateOrder(String id, Order updatedOrder) {
        if (orderRepository.existsById(id)) {
            updatedOrder.setId(id); // Upewnij się, że aktualizowany obiekt ma prawidłowe ID
            return orderRepository.save(updatedOrder);
        } else {
            // Obsługa błędu, np. rzucenie wyjątku
            throw new RuntimeException("Order not found for id: " + id);
        }
    }
    public List<Order> findOrdersForStandardPacking() {
        // Przykład: zwróć wszystkie zamówienia z statusem NEW
        return orderRepository.findByStatus(OrderStatus.NEW);
    }

    public void markOrderAsPacked(String orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(OrderStatus.COMPLETED);
            orderRepository.delete(order);
        } else {
            // Obsługa błędu, jeśli zamówienie nie zostało znalezione
        }
    }
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
    public Order saveOrder(Order order) {
        // Zapisz zamówienie w bazie danych i zwróć zaktualizowany obiekt
        return orderRepository.save(order);
    }
    // Dodatkowe metody specyficzne dla logiki biznesowej
}
