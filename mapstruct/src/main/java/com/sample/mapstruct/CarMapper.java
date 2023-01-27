package com.sample.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    @Mapping(target = ".", source = "driver")
    CarDto toDto(Car car);

    void updateCarFromCarDto(CarDto carDto, @MappingTarget Car car);

}
