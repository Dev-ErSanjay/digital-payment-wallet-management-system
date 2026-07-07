package com.payment.wallet.tansaction.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.payment.wallet.common.events.PaymentSuccessEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TransactionEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishSuccess(PaymentSuccessEvent event) {

        kafkaTemplate.send("payment-success", event);
        System.out.println("Payment success event sent");
    }
}
