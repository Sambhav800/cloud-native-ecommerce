package com.ecommerce.order.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String userId;
    private List<OrderItem> items = new ArrayList<>();
    private BigDecimal totalAmount;
    private String shippingAddress;
    private OrderStatus status;
    private PaymentDetails paymentDetails;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public enum OrderStatus {
        CREATED, PAYMENT_PENDING, PAID, PROCESSING, SHIPPED, DELIVERED, CANCELLED
    }
}
