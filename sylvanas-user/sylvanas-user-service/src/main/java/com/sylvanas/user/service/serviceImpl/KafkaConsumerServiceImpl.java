package com.sylvanas.user.service.serviceImpl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author xiong
 */
@Component
public class KafkaConsumerServiceImpl {
    @KafkaListener(topics = {"hello2"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional.ofNullable(record.value())
                .ifPresent(message -> {
                    System.out.println("【+++++++++++++++++ record = {} 】"+ record);
                    System.out.println("【+++++++++++++++++ message = {}】"+ message);
                });
    }
}
