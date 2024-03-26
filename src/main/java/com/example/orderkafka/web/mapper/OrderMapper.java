package com.example.orderkafka.web.mapper;

import com.example.orderkafka.model.Order;
import com.example.orderkafka.web.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper extends Mappable<Order, OrderDto> {

}
