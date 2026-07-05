package com.payment.wallet.wallet.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.payment.wallet.wallet.concurrency.WalletLockManager;
import com.payment.wallet.wallet.dto.WalletResponse;
import com.payment.wallet.wallet.entity.Wallet;
import com.payment.wallet.wallet.metrics.WalletMetrics;
import com.payment.wallet.wallet.repository.WalletRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletLockManager walletLockManager;
    private final WalletMetrics walletMetrics;

    public WalletResponse createWallet(String email) {

        Wallet wallet = Wallet.builder()
                .walletId(UUID.randomUUID().toString())
                .userEmail(email)
                .balance(BigDecimal.ZERO)
                .build();

        walletRepository.save(wallet);

        return response(wallet);
    }

    public WalletResponse credit(String walletId, BigDecimal amount) {

        var lock = walletLockManager.getLock(walletId);
        lock.lock();

        try {
            Wallet wallet = walletRepository.findById(walletId).orElseThrow();
            wallet.setBalance(wallet.getBalance().add(amount));
            walletRepository.save(wallet);

            walletMetrics.success();

            return response(wallet);
        } catch (Exception e) {
            walletMetrics.failure();
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public WalletResponse debit(String walletId, BigDecimal amount) {

        var lock = walletLockManager.getLock(walletId);
        lock.lock();

        try {
            Wallet wallet = walletRepository.findById(walletId).orElseThrow();
            if (wallet.getBalance().compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient balance");
            }

            wallet.setBalance(wallet.getBalance().subtract(amount));
            walletRepository.save(wallet);

            walletMetrics.success();

            return response(wallet);
        } catch (Exception e) {
            walletMetrics.failure();
            throw e;
        } finally {
            lock.unlock();
        }
    }

    private WalletResponse response(Wallet wallet) {

        return WalletResponse.builder()
                .walletId(wallet.getWalletId())
                .balance(wallet.getBalance())
                .build();
    }

}
