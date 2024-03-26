package com.example.orderkafka.service;

import com.example.orderkafka.model.test.OrderTestOptions;

public interface TestOrderService {
    void sendMessages(OrderTestOptions orderTestOptions);
}
