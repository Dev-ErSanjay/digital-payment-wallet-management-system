package com.payment.wallet.payment.exception;

public class DuplicatePaymentException extends RuntimeException {

    public DuplicatePaymentException() {
        super("Duplicate payment request");
    }
}
