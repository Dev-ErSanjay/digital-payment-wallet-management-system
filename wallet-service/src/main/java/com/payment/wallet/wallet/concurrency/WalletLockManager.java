package com.payment.wallet.wallet.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Component;

@Component
public class WalletLockManager {

    private final ConcurrentHashMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

    public ReentrantLock getLock(String walletId) {

        return locks.computeIfAbsent(walletId, id -> new ReentrantLock());
    }

    public void removeLock(String walletId) {

        locks.remove(walletId);
    }

}
