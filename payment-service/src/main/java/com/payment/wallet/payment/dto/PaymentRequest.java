package com.payment.wallet.payment.dto;

import lombok.Data;

@Data
public class PaymentRequest {

    private String fromWallet;
    private String toWallet;
    private Double amount;
    private String idempotencyKey;
}
