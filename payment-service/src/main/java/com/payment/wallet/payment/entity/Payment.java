package com.payment.wallet.payment.entity;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Payment {

    private String paymentId;
    private String idempotencyKey;
    private String fromWallet;
    private String toWallet;
    private Double amount;
    private String status;
    private Instant timestamp;

    @DynamoDbPartitionKey
    public String getPaymentId() {
        return paymentId;
    }
}
