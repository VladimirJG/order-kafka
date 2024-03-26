package com.example.orderkafka.service;

import com.example.orderkafka.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KafkaOrderServiceImpl implements KafkaOrderService {

    private final KafkaSender<String, Object> sender;

    @Override
    public void send(Order order) {
        String topic = "new-orders";
        sender.send(Mono.just(SenderRecord.create(topic,
                        0,
                        System.currentTimeMillis(),
                        String.valueOf(order.hashCode()),
                        order,
                        null)))
                .subscribe();
    }
}
