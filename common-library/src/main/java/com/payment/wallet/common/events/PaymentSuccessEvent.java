package com.payment.wallet.common.events;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSuccessEvent {

    private String paymentId;
    private String transactionId;
    private String message;
}
