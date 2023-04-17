package com.delivery_order.delivery_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private List<Food> menu = new ArrayList<>();

    public OrderController() {
      // Agregamos algunos platos al menú para probar
      menu.add(new Food("Hamburguesa", "Deliciosa hamburguesa con carne y queso", 10.99));
      menu.add(new Food("Pizza", "Pizza recién horneada con tus ingredientes favoritos", 12.99));
      menu.add(new Food("Ensalada", "Ensalada fresca con lechuga, tomate y otros vegetales", 6.99));
    }
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/menu")
    public List<Food> getMenu() {
      return menu;
    }

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

