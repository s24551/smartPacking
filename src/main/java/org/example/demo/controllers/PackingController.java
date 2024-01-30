package org.example.demo.controllers;

import org.example.demo.models.Order;
import org.example.demo.models.OrderStatus;
import org.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/packing")
public class PackingController {
    @Autowired
    private OrderService orderService; //
    @GetMapping("/startPacking")
    public String showStartPackingPage() {
        return "startPacking";
    }

    @PostMapping("/startPacking")
    public String startPacking() {
        // Tutaj dodaj logikę związana z rozpoczęciem pakowania
        // Przykładowa logika: zapisz informacje o rozpoczęciu pakowania do bazy danych, wywołaj odpowiednie usługi itp.

        // Przekieruj na inną stronę po zakończeniu pakowania (możesz dostosować według potrzeb)
        return "redirect:/packingCompleted";
    }

    @GetMapping("/standard")
    public String standardPacking(Model model) {
        List<Order> activeOrders = orderService.findAllOrders().stream()
                .filter(order -> order.getStatus() != OrderStatus.COMPLETED)
                .collect(Collectors.toList());

        model.addAttribute("orders", activeOrders);
        return "standardPacking";
    }

    @PostMapping("/completeOrder")
    public String completeOrder(@RequestParam("orderId") String orderId) {
        // Znajdź zamówienie po ID i zmień jego status na COMPLETED
        Order order = orderService.findOrderById(orderId);
        if (order != null) {
            order.setStatus(OrderStatus.COMPLETED);
            orderService.saveOrder(order); // Zakładając, że metoda saveOrder zapisuje aktualizacje zamówienia
        }

        // Przekieruj z powrotem do listy zamówień w trybie standardowym
        return "redirect:/packing/standard";
    }

    @GetMapping("/express")
    public String packingExpress() {
        // Podobnie jak wyżej, logika dla trybu ekspresowego pakowania
        return "expressPacking"; // Odnosi się do widoku, który będzie wyświetlał tryb ekspresowy pakowania
    }

    @GetMapping("/packingCompleted")
    public String showPackingCompletedPage() {
        // Tutaj możesz wyświetlić odpowiednią stronę po zakończeniu pakowania
        return "packingCompleted";
    }
}
