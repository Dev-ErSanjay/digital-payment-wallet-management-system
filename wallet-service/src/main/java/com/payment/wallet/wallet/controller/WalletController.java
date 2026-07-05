package com.payment.wallet.wallet.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.wallet.wallet.dto.WalletResponse;
import com.payment.wallet.wallet.dto.WalletTransactionRequest;
import com.payment.wallet.wallet.service.WalletService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
@RestController
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public WalletResponse create(@RequestHeader("X-User-Email") String email) {

        return walletService.createWallet(email);
    }

    @PostMapping("/{id}/credit")
    public WalletResponse credit(@PathVariable String id, @RequestBody WalletTransactionRequest request) {

        return walletService.credit(id, request.getAmount());
    }

    @PostMapping("/{id}/debit")
    public WalletResponse debit(@PathVariable String id, @RequestBody WalletTransactionRequest request) {

        return walletService.debit(id, request.getAmount());
    }

}
