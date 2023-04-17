package com.delivery_order.delivery_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    // Endpoint para crear un nuevo pedido
    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    // Endpoint para obtener el estado de un pedido por su ID
    @GetMapping("/{orderId}/status")
    public String getOrderStatus(@PathVariable String orderId) {
        return orderService.getOrderStatus(orderId);
    }

    // Endpoint para obtener el estado de todos los pedidos
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{orderId}/update")
    public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
        Order order_obj = orderService.findOrderById(orderId);
        if (order_obj == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            order_obj.setStatus(order.getStatus());
            return ResponseEntity.ok().body(order_obj);
        }
    }
}

