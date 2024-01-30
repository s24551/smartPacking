package org.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Date;

@Document
public class Order {
    @Id
    private String id; // Unikalny identyfikator zamówienia
    private Date orderDate; // Data złożenia zamówienia
    private List<OrderItem> items; // Lista przedmiotów w zamówieniu
    private OrderStatus status; // Status zamówienia, np. NOWE, W TRAKCIE, ZAKOŃCZONE

    public Order() {
        // Konstruktor bezparametrowy
    }

    public Order(String id, Date orderDate, List<OrderItem> items, OrderStatus status) {
        this.id = id;
        this.orderDate = orderDate;
        this.items = items;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
