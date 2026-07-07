

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.payment.wallet.common.events.PaymentCreatedEvent;

@Service
public class PaymentEventConsumer {
    
    @KafkaListener(topics = "payment-created", groupId = "transaction-service-group")
    public void consume(PaymentCreatedEvent event){

        System.out.println("Transaction received payment: " + event.getPaymentId());
    }
}
