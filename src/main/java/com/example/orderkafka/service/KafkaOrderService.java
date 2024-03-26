package com.example.orderkafka.service;

import com.example.orderkafka.model.Order;

public interface KafkaOrderService {
    void send(Order order);
}
