package com.payment.wallet.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.payment.wallet.common.events.PaymentFailedEvent;
import com.payment.wallet.common.events.PaymentSuccessEvent;

@Service
public class PaymentNotificationConsumer {

    @KafkaListener(topics = "payment-success", groupId = "notification-service-group")
    public void success(PaymentSuccessEvent event) {
        System.out.println("Payment success notification sent for: " + event.getPaymentId());
    }

    @KafkaListener(topics = "payment-failed", groupId = "notification-service-group")
    public void failed(PaymentFailedEvent event) {
        System.out.println("Payment failed notification sent for: " + event.getPaymentId());
    }
}
