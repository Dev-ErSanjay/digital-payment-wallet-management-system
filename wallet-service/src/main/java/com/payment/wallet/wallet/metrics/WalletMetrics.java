package com.payment.wallet.wallet.metrics;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class WalletMetrics {

    private final AtomicLong successCounter = new AtomicLong();
    private final AtomicLong failureCounter = new AtomicLong();
    private final AtomicLong transactionCounter = new AtomicLong();

    public void success() {
        successCounter.incrementAndGet();
    }

    public void failure() {
        failureCounter.incrementAndGet();
    }

    public void transaction() {
        transactionCounter.incrementAndGet();
    }

}
