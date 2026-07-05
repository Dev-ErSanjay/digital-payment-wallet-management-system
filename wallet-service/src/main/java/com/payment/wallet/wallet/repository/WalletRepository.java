package com.payment.wallet.wallet.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.payment.wallet.wallet.entity.Wallet;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class WalletRepository {

    private final DynamoDbTable<Wallet> table;

    public WalletRepository(DynamoDbEnhancedClient client) {
        this.table = client.table("Wallets", TableSchema.fromBean(Wallet.class));
    }

    public void save(Wallet wallet) {
        table.putItem(wallet);
    }

    public Optional<Wallet> findById(String walletId) {
        
        Wallet wallet = table.getItem(r -> r.key(
                k -> k.partitionValue(walletId)));

        return Optional.ofNullable(wallet);
    }

}
