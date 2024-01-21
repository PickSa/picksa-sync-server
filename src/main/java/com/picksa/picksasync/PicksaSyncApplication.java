package com.picksa.picksasync;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PicksaSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicksaSyncApplication.class, args);
    }

}
