package com.rmeunier.hotelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication(
        scanBasePackages = {
                "com.rmeunier.hotelapp.*"
        }
)
public class HotelAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAppApplication.class, args);
    }

}
