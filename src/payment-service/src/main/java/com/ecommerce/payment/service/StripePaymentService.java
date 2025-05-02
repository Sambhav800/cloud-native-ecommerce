package com.ecommerce.payment.service;

import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.model.PaymentResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripePaymentService implements PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(StripePaymentService.class);

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeApiKey;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) throws Exception {
        try {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(paymentRequest.getAmount().multiply(new java.math.BigDecimal(100)).longValue())
                    .setCurrency(paymentRequest.getCurrency().toLowerCase())
                    .setPaymentMethod(paymentRequest.getPaymentMethodId())
                    .setConfirm(true)
                    .putMetadata("orderId", paymentRequest.getOrderId())
                    .putMetadata("customerId", paymentRequest.getCustomerId())
                    .build();

            PaymentIntent paymentIntent = PaymentIntent.create(params);

            return new PaymentResponse(
                    paymentIntent.getId(),
                    paymentRequest.getOrderId(),
                    paymentRequest.getCustomerId(),
                    paymentRequest.getAmount(),
                    paymentRequest.getCurrency(),
                    paymentIntent.getStatus(),
                    paymentIntent.getCharges().getData().get(0).getReceiptUrl()
            );
        } catch (StripeException e) {
            logger.error("Error processing payment", e);
            throw new Exception("Payment processing failed: " + e.getMessage());
        }
    }

    @Override
    public PaymentResponse retrievePayment(String paymentId) throws Exception {
        try {
            PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentId);

            return new PaymentResponse(
                    paymentIntent.getId(),
                    paymentIntent.getMetadata().get("orderId"),
                    paymentIntent.getMetadata().get("customerId"),
                    new java.math.BigDecimal(paymentIntent.getAmount()).divide(new java.math.BigDecimal(100)),
                    paymentIntent.getCurrency(),
                    paymentIntent.getStatus(),
                    paymentIntent.getCharges().getData().isEmpty() ? null : 
                            paymentIntent.getCharges().getData().get(0).getReceiptUrl()
            );
        } catch (StripeException e) {
            logger.error("Error retrieving payment", e);
            throw new Exception("Payment retrieval failed: " + e.getMessage());
        }
    }
}
