package com.nitin.learning.l5lambda.session3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,6,8,9,7,5,3,2);

        //External Iterator
        for (int i = 0; i < list.size(); i = i+1) {
            System.out.println(i);
        }

        //For Each loop
        for (int i : list){//For each int i in list -> print i
            System.out.println(i);
        }

        //Internal iterators
        //Implemenation via anonymous inner class
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        });

        //Can be reduced by just keeping only the args and the method body
        list.forEach((Integer i) -> {
                System.out.println(i);
                return;
            });

        //Accepts Consumer (a functional interface) as a parameter
        //a function/method 4 parts -> name, return type, params/args list, BODY
        //i -> params/args & System.out.println(i) -> body


        //Can further be reduced by removing data type from argument, and removing unnecessasary return statement
        list.forEach(i -> System.out.println(i));

        //Can be further reduced with the usage of method reference
        list.forEach(System.out::println);

        //For better understanding, step by step declaration and usage can be tried.
        Consumer consumer = x -> System.out.println(x);//since for each accepts a consumer, declare it first
        //use the consumer with the method present in the Consumer interface
        list.forEach(val -> consumer.accept(val));
        //Or for simplicity just pass the consumer
        list.forEach(consumer);
        //or just replace the variable
        list.forEach(x -> System.out.println(x));


    }
}
