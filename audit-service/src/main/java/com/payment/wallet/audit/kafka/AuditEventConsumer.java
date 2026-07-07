package com.payment.wallet.audit.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import com.payment.wallet.common.events.AuditEvent;

public class AuditEventConsumer {

    @KafkaListener(topics = "audit-event", groupId = "audit-service-group")
    public void consume(AuditEvent event) {

        System.out.println("Audit event received: " + event.getAction());
    }
}
