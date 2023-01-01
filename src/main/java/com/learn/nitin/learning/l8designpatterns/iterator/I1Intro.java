package com.learn.nitin.learning.l8designpatterns.iterator;

import java.util.List;

public class I1Intro {
    public static void main(String ...args) {
        List<Integer> numbers =  List.of(1,2,3,4,5,6);//Arrays.asList()
        Integer sum = 0;//Integer.MIN_VALUE;

        //Declarative Style === what to do, delegate how to do to Java
        int sumTotal = numbers.stream().parallel()
                .mapToInt(number -> number)
                .sum();

        numbers.forEach(System.out::println);//Which one is better

    }
}
