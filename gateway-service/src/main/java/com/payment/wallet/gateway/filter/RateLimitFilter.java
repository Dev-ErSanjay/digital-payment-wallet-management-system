package com.payment.wallet.gateway.filter;

import org.springframework.stereotype.Component;

@Component
public class RateLimitFilter {
    // private static final int LIMIT = 100;

    public boolean allowed() {
        return true;
    }
}
