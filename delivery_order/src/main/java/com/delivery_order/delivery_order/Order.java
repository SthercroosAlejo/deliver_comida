package com.delivery_order.delivery_order;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private String customerName;
    private String customerEmail;
    private boolean status;
    private LocalDateTime creationTime;
    private LocalDateTime estimatedDeliveryTime;
    private List<Food> items;

    public Order(long id, String customerName, String customerEmail, List<Food> items) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
        this.status = true;
        this.creationTime = LocalDateTime.now();
        this.estimatedDeliveryTime = this.creationTime.plusMinutes(30);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public List<Food> getItems() {
        return items;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }

    public double getTotal() {
        double total = 0;
        for (Food item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

