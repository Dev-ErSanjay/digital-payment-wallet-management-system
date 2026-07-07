package com.payment.wallet.payment.repository;

import org.springframework.stereotype.Repository;

import com.payment.wallet.payment.entity.Payment;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@RequiredArgsConstructor
@Repository
public class PaymentRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    private DynamoDbTable<Payment> table() {
        return dynamoDbEnhancedClient.table("PaymentsTable", TableSchema.fromBean(
                Payment.class));
    }

    public void save(Payment payment) {

        table().putItem(payment);
    }

}