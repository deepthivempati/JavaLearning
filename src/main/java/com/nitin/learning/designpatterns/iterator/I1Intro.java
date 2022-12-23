package com.nitin.learning.designpatterns.iterator;

import java.util.List;

public class I1Intro {
    public static void main(String ...args) {
        List<Integer> numbers =  List.of(1,2,3,4,5,6);//Arrays.asList()
        Integer sum = 0;//Integer.MIN_VALUE;

        //Imperative style === what to do + how to do
        for (int i = 0; i < numbers.size(); i++) { //a+ (b+c) = (a+b) + c --> Can be parallelized
               sum = sum + numbers.get(i);

        }
        System.out.println(sum);

        //For Each loop
        for (int num : numbers){
            sum = sum + num;
        }

        //Declarative Style === what to do, delegate how to do to Java
        int sumTotal = numbers.stream().parallel()
                .mapToInt(number -> number)
                .sum();

        numbers.forEach(System.out::println);//Which one is better


    }
}
