package com.example.kas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KasApplicationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(KasApplicationTest.class);

    public static void main(String[] args) {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Start KasApplicationTest");
        }

        SpringApplication.run(KasApplicationTest.class, args);
    }
}
