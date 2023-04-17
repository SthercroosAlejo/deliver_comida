package com.delivery_order.delivery_order;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();

    // Método para crear un nuevo pedido
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        // Asignar valores a las propiedades del pedido a partir de la solicitud del cliente
        order.setId(UUID.randomUUID().toString());
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("En proceso");
        order.setCreationTime(LocalDateTime.now());
        order.setEstimatedDeliveryTime(LocalDateTime.now().plusMinutes(30));
        order.setItems(orderRequest.getItems());
        orders.add(order);
        return order;
    }

    // Método para obtener el estado de un pedido por su ID
    public String getOrderStatus(String orderId) {
        Order order = findOrderById(orderId);
        if (order != null) {
            return order.getStatus();
        } else {
            throw new RuntimeException("Pedido no encontrado");
        }
    }

    // Método para obtener el estado de todos los pedidos
    public List<Order> getAllOrders() {
        return orders;
    }

    // Método privado para buscar un pedido por su ID
    Order findOrderById(String orderId) {
        return orders.stream().filter(order -> orderId.equals(order.getId())).findFirst().orElse(null);
    }
}