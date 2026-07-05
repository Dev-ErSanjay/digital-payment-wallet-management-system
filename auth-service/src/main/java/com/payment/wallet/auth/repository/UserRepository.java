package com.payment.wallet.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.payment.wallet.auth.entity.User;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class UserRepository {

    private final DynamoDbTable<User> table;

    public UserRepository(DynamoDbEnhancedClient dbEnhancedClient) {

        this.table = dbEnhancedClient.table("Users", TableSchema.fromBean(User.class));
    }

    public void save(User user) {
        table.putItem(user);
    }

    public Optional<User> findById(String id) {
        User user = table.getItem(r -> r.key(k -> k.partitionValue(id)));

        return Optional.ofNullable(user);
    }

}
