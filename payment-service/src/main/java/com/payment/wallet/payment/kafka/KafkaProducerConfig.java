package com.payment.wallet.payment.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public String kafkaStatus(KafkaTemplate<String, Object> kafkaTemplate) {

        return "Kafka Producer Ready";
    }
}
