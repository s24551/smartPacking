//package org.example.demo;
//
//import org.example.demo.models.*;
//import org.example.demo.repositories.OrderRepository;
//import org.example.demo.repositories.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Date;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final OrderRepository orderRepository;
//    private final ProductRepository productRepository;
//
//    @Autowired
//    public DataLoader(OrderRepository orderRepository, ProductRepository productRepository) {
//        this.orderRepository = orderRepository;
//        this.productRepository = productRepository;
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        loadOrderData();
//    }

//    private void loadOrderData() {
////        if (orderRepository.count() == 7) {
//            // Załaduj przykładowe produkty, jeśli jeszcze nie istnieją w bazie danych
//            Product product1 = productRepository.findById("10").orElseGet(() ->
//                    productRepository.save(new Product("10", "Produkt 6", "Opis produktu 13333", "url_do_zdjecia_produktu_1", new Location("A4","P3","R1"))));
//            Product product2 = productRepository.findById("11").orElseGet(() ->
//                    productRepository.save(new Product("11", "Produkt 7", "Opis produktu 2333", "url_do_zdjecia_produktu_2", new Location("A3","P2","R3"))));
//
//            // Tworzenie i zapisywanie przykładowych zamówień
//            Order order1 = new Order();
//            order1.setOrderDate(new Date());
//            order1.setId("1");
//            order1.setItems(Arrays.asList(new OrderItem(product1, 2), new OrderItem(product2, 3)));
//            order1.setStatus(OrderStatus.NEW);
//
//            Order order2 = new Order();
//            order2.setOrderDate(new Date());
//            order2.setId("2");
//            order2.setItems(Arrays.asList(new OrderItem(product2, 1)));
//            order2.setStatus(OrderStatus.NEW);
//
//            orderRepository.save(order1);
//            orderRepository.save(order2);
//
//            System.out.println("Załadowano dane zamówień...");
////        } else {
//            System.out.println("Baza danych zamówień już zawiera dane.");
//        }
//    }
//}
