package com.payment.wallet.wallet.entity;

import java.math.BigDecimal;

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
public class Wallet {

    private String walletId;
    private String userEmail;
    private BigDecimal balance;

    @DynamoDbPartitionKey
    public String getWalletId() {
        return walletId;
    }

}
