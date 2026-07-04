package com.payment.wallet.common.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreatedEvent {

    private String paymentId;
    private String senderWallet;
    private String receiverWallet;
    private Double amount;
    
}
