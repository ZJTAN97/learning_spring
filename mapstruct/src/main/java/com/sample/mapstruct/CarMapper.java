package com.sample.mapstruct;

import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    @Mapping(target = ".", source = "driver")
    CarDto toDto(Car car);

    void updateCarFromCarDto(CarDto carDto, @MappingTarget Car car);

    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
