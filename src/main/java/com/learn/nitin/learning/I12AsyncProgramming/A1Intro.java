package com.learn.nitin.learning.I12AsyncProgramming;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class A1Intro {
    public static void main(String[] args) {
        CompletableFuture<Double> completableFuture = getData();

       // completableFuture.thenAccept(x -> System.out.println(x));

        //If there is an exception, the future will go into REJECT state
        completableFuture
                //.thenApply(x ->  x.intValue() )
                .thenApply(x -> Double.parseDouble(String.valueOf(x))) //If there is an exception, handle with exceptionally
                .thenApply(x -> 2/x)
                .thenAccept(x -> System.out.println("rtr " + x))//Behaves like ForEach, but not a reduction operation.
                .thenRun(() -> System.out.println("Can continue"))
                .thenRun(() -> System.out.println("Even further"))
                .thenAccept(x -> System.out.println(x));
    }

    private static CompletableFuture<Double> getData(){
        return CompletableFuture.supplyAsync( () -> 3.14);
    }
}
