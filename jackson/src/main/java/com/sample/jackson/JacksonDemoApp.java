package com.sample.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonDemoApp {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Black", "Tesla");

        objectMapper.writeValue(new File("car.json"), car);

    }
}
