package com.example.orderkafka.web.dto;

import com.example.orderkafka.model.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private int id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime timestamp;
    private Order.OrderStatus orderStatus;


}
