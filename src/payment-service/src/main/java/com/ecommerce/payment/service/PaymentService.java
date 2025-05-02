package com.ecommerce.payment.service;

import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.model.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest paymentRequest) throws Exception;
    PaymentResponse retrievePayment(String paymentId) throws Exception;
}
