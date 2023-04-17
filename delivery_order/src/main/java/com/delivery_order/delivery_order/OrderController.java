package com.delivery_order.delivery_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
public class OrderController {

    private List<Food> menu = new ArrayList<>();

    public OrderController() {
        menu.add(new Food("Hamburguesa", "Deliciosa hamburguesa con carne y queso", 10.99));
        menu.add(new Food("Pizza", "Pizza recién horneada con tus ingredientes favoritos", 12.99));
        menu.add(new Food("Pollo a la brasa", "Pollo a la brasa con papas fritas y ensalada", 8.99));
    }

    @Autowired
    private OrderService orderService;

    @GetMapping("/menu")
    public List<Food> getMenu() {
        return menu;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrderStatus(@PathVariable long id, @RequestBody boolean status) {
        return orderService.updateOrderStatus(id, status);
    }
}

