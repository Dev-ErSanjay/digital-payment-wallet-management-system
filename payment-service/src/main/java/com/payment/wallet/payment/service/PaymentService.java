package com.payment.wallet.payment.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.payment.wallet.common.events.PaymentCreatedEvent;
import com.payment.wallet.payment.dto.PaymentRequest;
import com.payment.wallet.payment.dto.PaymentResponse;
import com.payment.wallet.payment.entity.Payment;
import com.payment.wallet.payment.kafka.PaymentEventProducer;
import com.payment.wallet.payment.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentEventProducer paymentEventProducer;

    public PaymentResponse createPayment(PaymentRequest request) {

        String paymentId = UUID.randomUUID().toString();

        Payment payment = Payment.builder()
                .paymentId(paymentId)
                .idempotencyKey(request.getIdempotencyKey())
                .fromWallet(request.getFromWallet())
                .toWallet(request.getToWallet())
                .amount(request.getAmount())
                .status("CREATED")
                .timestamp(Instant.now())
                .build();

        paymentRepository.save(payment);

        paymentEventProducer.publish(
                PaymentCreatedEvent.builder()
                        .paymentId(paymentId)
                        .fromWallet(request.getFromWallet())
                        .toWallet(request.getToWallet())
                        .amount(request.getAmount())
                        .status("CREATED")
                        .build());

        return PaymentResponse.builder()
                .paymentId(paymentId)
                .status("CREATED")
                .message("Payment initiated successfully")
                .build();
    }

}
