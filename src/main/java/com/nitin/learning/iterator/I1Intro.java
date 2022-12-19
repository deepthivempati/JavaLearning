package com.nitin.learning.iterator;

import java.util.List;

public class I1Intro {
    public static void main(String[] args) {
        List<Integer> numbers =  List.of(1,2,3,4,5,6);//Arrays.asList()

        //Imperative style === what to do + how to do
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        //For Each loop
        for (int i : numbers){
            System.out.println(i);
        }

        //Declarative Style === what to do, delegate how to do to Java
        numbers.stream().forEach(System.out::println);

        numbers.forEach(System.out::println);//Which one is better


    }
}
