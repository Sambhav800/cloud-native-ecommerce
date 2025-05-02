package com.ecommerce.order.event;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    private static final Logger logger = LoggerFactory.getLogger(EventPublisher.class);
    
    @Value("${azure.servicebus.connection-string}")
    private String connectionString;
    
    @Value("${azure.servicebus.queue.orders}")
    private String queueName;
    
    private final ObjectMapper objectMapper;
    
    public EventPublisher(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    
    public void publishOrderCreatedEvent(OrderCreatedEvent event) {
        try {
            String eventJson = objectMapper.writeValueAsString(event);
            
            // Create a ServiceBusSenderClient
            ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                    .connectionString(connectionString)
                    .sender()
                    .queueName(queueName)
                    .buildClient();
            
            // Create a message to send
            ServiceBusMessage message = new ServiceBusMessage(eventJson);
            message.setContentType("application/json");
            message.setSubject("OrderCreated");
            
            // Send the message
            senderClient.sendMessage(message);
            senderClient.close();
            
            logger.info("Published OrderCreatedEvent: {}", event);
        } catch (Exception e) {
            logger.error("Error publishing OrderCreatedEvent", e);
        }
    }
}
