package com.nitin.learning.lambda.predefinedFunctionalInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiconsumerUsage {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("test", "this", "is", "a", "test", "this", "test", "is", "not", "complex");

        Map<String,Integer> map = new HashMap<>();
        BiConsumer<String,Integer> biConsumer = (key,value) -> {
            map.put(key,value);
        };

        biConsumer.accept("Nitin",1);
        biConsumer.accept("Deepthi",1);

       // strList.stream().collect(,biConsumer);
        System.out.println(map);

    }
}