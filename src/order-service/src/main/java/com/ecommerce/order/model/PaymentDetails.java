package com.ecommerce.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDetails {
    private String paymentId;
    private String paymentMethod;
    private BigDecimal amount;
    private String currency;
    private String status;
    private LocalDateTime paymentDate;
}
