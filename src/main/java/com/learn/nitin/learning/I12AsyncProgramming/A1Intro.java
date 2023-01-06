package com.learn.nitin.learning.I12AsyncProgramming;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class A1Intro {
    public static void main(String[] args) {
        CompletableFuture<Double> completableFuture = getData();

       // completableFuture.thenAccept(x -> System.out.println(x));

        completableFuture
                //.thenApply(x ->  x.intValue() )
                .thenApply(x -> Integer.parseInt(String.valueOf(x)))
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return 0;//Default value to return if the
                })
                .thenApply(x -> 2/x)
                .thenAccept(x -> System.out.println(x))//Behaves like ForEach, but not a reduction operation.
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return null;
                })
                .thenRun(() -> System.out.println("Can continue"))
                .thenRun(() -> System.out.println("Even further"))
                .thenAccept(x -> System.out.println(x));


    }

    private static CompletableFuture<Double> getData(){
        return CompletableFuture.supplyAsync( () -> 3.14);
    }
}
