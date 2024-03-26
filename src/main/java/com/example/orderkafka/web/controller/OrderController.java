package com.example.orderkafka.web.controller;

import com.example.orderkafka.model.Order;
import com.example.orderkafka.model.test.OrderTestOptions;
import com.example.orderkafka.service.KafkaOrderService;
import com.example.orderkafka.service.TestOrderService;
import com.example.orderkafka.web.dto.OrderDto;
import com.example.orderkafka.web.dto.OrderTestOptionsDto;
import com.example.orderkafka.web.mapper.OrderMapper;
import com.example.orderkafka.web.mapper.OrderTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final KafkaOrderService kafkaOrderService;
    private final TestOrderService testOrderService;
    private final OrderMapper orderMapper;
    private final OrderTestOptionsMapper orderTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        kafkaOrderService.send(order);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody OrderTestOptionsDto testOptionsDto) {
        OrderTestOptions orderTestOptions = orderTestOptionsMapper.toEntity(testOptionsDto);
        testOrderService.sendMessages(orderTestOptions);
    }
}
