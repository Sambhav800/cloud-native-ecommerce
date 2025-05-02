package com.ecommerce.payment.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private String orderId;
    private String customerId;
    private BigDecimal amount;
    private String currency;
    private String paymentMethodId;
}
