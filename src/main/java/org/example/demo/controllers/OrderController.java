package org.example.demo.controllers;

import org.example.demo.models.Order;
import org.example.demo.repositories.OrderRepository;
import org.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @PutMapping("/mark-as-packed/{orderId}")
    public void markOrderAsPacked(@PathVariable String orderId) {
        orderService.markOrderAsPacked(orderId);
    }
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        orderRepository.deleteById(orderId);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.findOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }



    // Dodatkowe metody, np. dla trybu pakowania Standard i Express
}
