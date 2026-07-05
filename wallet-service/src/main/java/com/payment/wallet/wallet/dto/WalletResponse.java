package com.payment.wallet.wallet.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletResponse {
    
    private String walletId;
    private BigDecimal balance;
}
