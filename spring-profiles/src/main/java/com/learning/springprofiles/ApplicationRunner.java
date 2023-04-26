package com.learning.springprofiles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ApplicationRunner implements CommandLineRunner {

    private final LoadValues loadValues;

    @Override
    public void run(String... args) throws Exception {

        log.info(loadValues.getTestValue());
    }
}
