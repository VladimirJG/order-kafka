package com.example.orderkafka.model.test;

import com.example.orderkafka.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderTestOptions {

    private int delayInSeconds;
    private Order.OrderStatus[] orderStatuses;
}
