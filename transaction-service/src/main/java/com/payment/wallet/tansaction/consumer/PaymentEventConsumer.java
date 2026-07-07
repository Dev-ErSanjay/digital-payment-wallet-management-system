package com.payment.wallet.tansaction.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.payment.wallet.common.events.PaymentCreatedEvent;
import com.payment.wallet.tansaction.worker.TransactionWorker;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentEventConsumer {

    private final ExecutorService executorService;
    private final TransactionWorker transactionWorker;

    @KafkaListener(topics = "payment-created", groupId = "transaction-service-group")
    public void consume(PaymentCreatedEvent event) {
        try {
            Future<Boolean> result = executorService.submit(() -> transactionWorker.process(event));
            System.out.println("Task submitted : " + event.getPaymentId() + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
