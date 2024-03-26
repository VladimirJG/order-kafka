package com.example.orderkafka.web.dto;

import com.example.orderkafka.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderTestOptionsDto {

    private int delayInSeconds;
    private Order.OrderStatus[] orderStatuses;
}
