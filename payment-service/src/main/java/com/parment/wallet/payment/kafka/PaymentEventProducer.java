package com.parment.wallet.payment.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.payment.wallet.common.events.PaymentCreatedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publish(PaymentCreatedEvent event) {

        kafkaTemplate.send(
                "payment-created",
                event.getPaymentId(),
                event);

        System.out.println("Payment event published: " + event.getPaymentId());
    }
}
