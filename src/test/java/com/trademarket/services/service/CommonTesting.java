package com.trademarket.services.service;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CommonTesting {


    @Test
    void optionalTest(){
        Optional<String> nonEmpty=Optional.of("New York");
        String square= nonEmpty.orElse(iAmStillExecuted());
    }

    public static String iAmStillExecuted(){
        System.out.println("nonEmptyOptional is not NULL,still I am being executed");
        return "I got executed";
    }
}
