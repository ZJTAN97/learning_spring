package com.learning.springprofiles;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class LoadValues {

    @Value("${app.test_value}")
    private String testValue;
}
