package com.ecommerce.order.service;

import com.ecommerce.order.event.OrderCreatedEvent;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final EventPublisher eventPublisher;
    
    @Autowired
    public OrderService(OrderRepository orderRepository, WebClient.Builder webClientBuilder, EventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;
        this.eventPublisher = eventPublisher;
    }
    
    public Order createOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setStatus(Order.OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        
        Order savedOrder = orderRepository.save(order);
        
        // Publish order created event
        eventPublisher.publishOrderCreatedEvent(new OrderCreatedEvent(savedOrder));
        
        return savedOrder;
    }
    
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }
    
    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
    
    public Optional<Order> updateOrderStatus(String id, Order.OrderStatus status) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(status);
                    order.setUpdatedAt(LocalDateTime.now());
                    return orderRepository.save(order);
                });
    }
    
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
