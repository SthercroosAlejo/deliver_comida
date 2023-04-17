package com.delivery_order.delivery_order;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(long id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    public Order createOrder(Order order) {
        order.setId(orders.size() + 1);
        orders.add(order);
        return order;
    }

    public Order updateOrderStatus(long id, Boolean status) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setStatus(status);
            return order;
        }
        return null;
    }
}
