package com.payment.wallet.tansaction.service;

import org.springframework.stereotype.Service;

import com.payment.wallet.common.events.PaymentCreatedEvent;

@Service
public class TransactionProcessor {

    public void execute(PaymentCreatedEvent event) {

        // Debit
        // Credit
        // Save
        // Publish

        System.out.println("Debit wallet");
        System.out.println("Credit wallet");
        System.out.println("Transaction completed");
    }
}
