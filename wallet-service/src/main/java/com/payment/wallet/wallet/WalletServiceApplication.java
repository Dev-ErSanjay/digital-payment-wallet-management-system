package com.payment.wallet.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.payment.wallet")
public class WalletServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(WalletServiceApplication.class, args);
        System.out.println("Wallet service running ... ");
    }

}