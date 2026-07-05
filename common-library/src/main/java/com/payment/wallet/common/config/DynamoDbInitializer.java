package com.payment.wallet.common.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.BillingMode;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ResourceInUseException;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;

@RequiredArgsConstructor
@Component
public class DynamoDbInitializer implements CommandLineRunner {

    private final DynamoDbClient dynamoDbClient;

    @Override
    public void run(String... args) {

        createTable("Users", "userId");
        createTable("Wallets", "walletId");
        createTable("Transactions", "transactionId");
    }

    private void createTable(String tableName, String key) {

        try {
            dynamoDbClient.createTable(CreateTableRequest.builder()
                    .tableName(tableName)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName(key)
                            .keyType(KeyType.HASH).build())
                    .attributeDefinitions(
                            AttributeDefinition.builder().attributeName(key).attributeType(ScalarAttributeType.S)
                                    .build())
                    .billingMode(BillingMode.PAY_PER_REQUEST).build());

            System.out.println("Created Table: " + tableName);
        } catch (ResourceInUseException e) {
            System.out.println(tableName + "Table already exist");
        }
    }

}
