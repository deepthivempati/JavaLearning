package com.learn.nitin.learning.l10collectors.c6joining;

import java.util.List;
import java.util.stream.Collectors;

public class JoinTest {
    public static void main(String[] args) {
        List<String> strings = List.of("java", "is", "cool");
        String message = String.join(" ", strings);
        //message returned is: "Java is cool"

        System.out.println(message);

        String test = strings
                .stream()
                .collect(Collectors.joining(","));
        System.out.println(test);
    }
}