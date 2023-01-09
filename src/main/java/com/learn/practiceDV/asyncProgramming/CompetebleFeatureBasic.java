package com.learn.practiceDV.asyncProgramming;

import com.google.common.base.Strings;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.learn.nitin.utilities.MultiThreadUtility.delay;
import static java.util.Collections.max;

public class CompetebleFeatureBasic {
    public static void main(String[] args) {
       // example1();
       // example2();
          example3();
    }

    private static void example3() {
        CompletableFuture<Integer> future = new CompletableFuture<>(); //pipeline created
        future                                                         // pipeline started
            //  .thenApply(x -> 9)
                .thenApply(integer -> integer/0)
                .exceptionally(throwable -> handleException(throwable))  //does not give exception on the console log since its not a main thread. its a inner pipeline/child thread. here we can write exception explicitly.
                .thenAccept(x -> System.out.println(x));
            //   future.complete(6/0); // pipeline starts executing after hitting this line. If Exception happens here it shows the exception in the console log. But exceptions associated with child or pipeline does not show in the console but still the code executes and does not get any result in output where the exception occurred. Need to write exception explicitly for better understanding of what is happening.
                 future.complete(0); // pipeline starts executing after hitting this line.
    }

    private static int handleException(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return 6;
    }

    private static void example2() {
        CompletableFuture<List<String>> future = new CompletableFuture<>(); // pipeline is defined. its an empty pileline.
        future                                                             // Pipeline Started
                .thenApply(strings -> strings
                        .stream()
                        .map(word -> getTransformedString(word))
                        .collect(Collectors.toList()))
                .thenAccept(s -> s.forEach(longstr -> System.out.println("LargeString is :: " + longstr)));
        System.out.println("pipeline did not trigger yet");
        future.complete(LargeString()); // Pipeline triggering point. This is the main thread.

    }

    private static String getTransformedString(String word) {
        delay(3000);
        return word.toUpperCase();
    }


    private static List<String> LargeString() {
        List<String> strings = List.of("Deepthi", "Divya", "Jyothirmaie", "Veeranna", "Vijaykumar", "Somalaxmi");
        int  maxLength = 0;
        String largeString = new String(); // instead of declaring as null declare this way(good practise)
        for (String str : strings){
            if(str.length() > maxLength){
                maxLength = str.length();
                largeString = str;
            }
        }
        return Arrays.asList(largeString);
    }

    private static void example1() {
        CompletableFuture<List<Integer>> competebleFuture = getData(); // pipeline is created & built
        competebleFuture
                .thenApply(List::size)
                .exceptionally(throwable -> exception1(throwable))
                .thenAccept(x -> System.out.println(16/x))// Here x is 8 which accepts the value of thenApply method.thenAccept accepts consumer which returns void.
                .exceptionally(throwable -> exception2(throwable))
                .thenAccept(x-> System.out.println(x)) // The size of array is 8 which is consumed by above statement. so here it returns null since x holds nothing.
                .thenRun(() -> System.out.println("thenRun method accepts Runnable Interface & returns new CompletableFuture"));
    }

    private static Void exception2(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return null;
    }

    private static int exception1(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return 0;
    }

    private static CompletableFuture<List<Integer>> getData(){
        return CompletableFuture.supplyAsync(()-> List.of(1,2,3,4,5,6,7,8));
    }
}
// exceptions will not be thrown in functional programming so here in this code if any exception is occurred the code simply does not give any output.
// We should explicitly write the exceptions to handle exceptions.
