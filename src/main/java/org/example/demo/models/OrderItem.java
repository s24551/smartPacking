package org.example.demo.models;

public class OrderItem {
    private Product product; // Produkt
    private int quantity; // Ilość produktu w zamówieniu

    // Konstruktory, gettery i settery
    public OrderItem() {
        // Konstruktor bezparametrowy
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
