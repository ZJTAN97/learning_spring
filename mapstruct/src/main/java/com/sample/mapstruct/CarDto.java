package com.sample.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private String make;

    private int numberOfSeats;

    private String name;

    private String driverName;

    private int age;

    private String additionalField1;

    private String additionalField2;
}
