package com.payment.wallet.wallet.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class WalletTransactionRequest {

    private BigDecimal amount;
    
}
