package com.payment.wallet.tansaction.worker;

import org.springframework.stereotype.Component;

import com.payment.wallet.common.events.PaymentCreatedEvent;
import com.payment.wallet.tansaction.service.TransactionProcessor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TransactionWorker {

    private final TransactionProcessor transactionProcessor;

    public boolean process(PaymentCreatedEvent event) {

        System.out.println("Processing payment on thread: " + Thread.currentThread().getName());

        transactionProcessor.execute(event);

        return true;
    }
}
