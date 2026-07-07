package com.payment.wallet.payment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.wallet.payment.dto.PaymentRequest;
import com.payment.wallet.payment.dto.PaymentResponse;
import com.payment.wallet.payment.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public PaymentResponse pay(@RequestBody PaymentRequest request) {

        return paymentService.createPayment(request);
    }

}
