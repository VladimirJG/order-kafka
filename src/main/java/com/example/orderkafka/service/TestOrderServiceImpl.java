package com.example.orderkafka.service;

import com.example.orderkafka.model.Order;
import com.example.orderkafka.model.test.OrderTestOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService {

    private final ScheduledExecutorService executorService =
            Executors.newSingleThreadScheduledExecutor();
    private final KafkaOrderService kafkaOrderService;

    @Override
    public void sendMessages(OrderTestOptions orderTestOptions) {
        if (orderTestOptions.getOrderStatuses().length > 0) {
            executorService.scheduleAtFixedRate(() -> {
                        Order order = new Order();
                        order.setId((int) (Math.random() * 100));
                        order.setName("TestName" + (int) (Math.random() * 100));
                        order.setOrderStatus(getRandomOrderStatus(orderTestOptions.getOrderStatuses()));
                        order.setTimestamp(LocalDateTime.now());
                        kafkaOrderService.send(order);
                    },
                    0,
                    orderTestOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS);
        }
    }

    private Order.OrderStatus getRandomOrderStatus(Order.OrderStatus[] orderStatuses) {
        int randomTypeId = (int) (Math.random() * orderStatuses.length);
        return orderStatuses[randomTypeId];
    }
}
