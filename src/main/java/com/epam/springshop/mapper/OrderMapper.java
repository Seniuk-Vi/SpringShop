package com.epam.springshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


}
