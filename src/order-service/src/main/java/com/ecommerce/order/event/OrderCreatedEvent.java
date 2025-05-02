package com.ecommerce.order.event;

import com.ecommerce.order.model.Order;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderCreatedEvent {
    private String orderId;
    private String userId;
    private Order.OrderStatus status;
    private LocalDateTime timestamp;
    
    public OrderCreatedEvent(Order order) {
        this.orderId = order.getId();
        this.userId = order.getUserId();
        this.status = order.getStatus();
        this.timestamp = LocalDateTime.now();
    }
}
