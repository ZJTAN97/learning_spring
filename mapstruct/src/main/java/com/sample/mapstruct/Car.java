package com.sample.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String make;

    private int numberOfSeats;

    private String name;

    private Driver driver;

    private String additionalField1;

}
