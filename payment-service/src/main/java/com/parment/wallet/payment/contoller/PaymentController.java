package com.parment.wallet.payment.contoller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parment.wallet.payment.kafka.PaymentEventProducer;
import com.payment.wallet.common.events.PaymentCreatedEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentEventProducer paymentEventProducer;

    @PostMapping("/test/payment")
    public String testPayment() {

        PaymentCreatedEvent event = PaymentCreatedEvent.builder()
                .paymentId(UUID.randomUUID().toString())
                .fromWallet("wallet-100")
                .toWallet("wallet-101")
                .amount(Double.valueOf(500))
                .status("CREATED")
                .build();

        paymentEventProducer.publish(event);

        return "Payment event sent";
    }

}
