package com.example.orderkafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private String name;
    private LocalDateTime timestamp;
    private OrderStatus orderStatus;

    public enum OrderStatus {
        SENT, RECEIVED, DELIVERY
    }

}
