package com.payment.wallet.common.logging;

public class CorrelationId {

    private static ThreadLocal<String> id = new ThreadLocal<>();

    public static void set(String value) {
        id.set(value);
    }

    public static String get() {
        return id.get();
    }

    public static void clear() {
        id.remove();
    } 
}
