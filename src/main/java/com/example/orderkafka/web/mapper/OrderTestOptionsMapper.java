package com.example.orderkafka.web.mapper;

import com.example.orderkafka.model.test.OrderTestOptions;
import com.example.orderkafka.web.dto.OrderTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper
public interface OrderTestOptionsMapper extends Mappable<OrderTestOptions, OrderTestOptionsDto> {

}
